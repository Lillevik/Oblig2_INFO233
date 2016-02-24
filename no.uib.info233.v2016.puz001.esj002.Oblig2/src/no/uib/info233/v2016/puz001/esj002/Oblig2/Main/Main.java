package no.uib.info233.v2016.puz001.esj002.Oblig2.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.uib.info233.v2016.puz001.esj002.Oblig2.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig2.Issue.Issues;

/**
 * This class only has one purpose, 
 * which is to start the program.
 * @author esj002 and puz001
 */
public class Main {

	
	
	

	
	/**
	 * This method starts the program and connects the different 
	 * instances together in one class.
	 * @param args
	 */

	public static void main(String[] args) {
		Gui gui = new Gui();

		/**
		 * This button lists all the issues from the user given
		 * in the textField and presents these in the JTable qtable.
		 */
		gui.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gui.getIt().getModel().setRowCount(0);
					gui.getIt().getModel().setColumnCount(0);
					gui.getIt().getModel().addColumn("Issue ID: ");
					gui.getIt().getModel().addColumn("Assigned to: ");
					gui.getIt().getModel().addColumn("Created: ");
					gui.getIt().getModel().addColumn("Issue: ");
					gui.getIt().getModel().addColumn("Priority: ");
					gui.getIt().getModel().addColumn("Location: ");


					
					for(Issues issue : gui.getIt().getIssueList()){
						if(issue.getAssigned().equals(gui.getTxtSearch().getText())){
						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
				    			  issue.getAssigned(),
				    			  issue.getCreated(),
				    			  issue.getIssue(),
				    			  issue.getPriority(),
				    			  issue.getLocation()});

							}
						}
					}

				catch (Exception f ){
					f.printStackTrace();
				}

			}
		});

		/**
		 * This method finds all the issues with 
		 * a priority higher than the user input from the textfield.
		 */
		gui.getBtnPrior().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					gui.getIt().getModel().setRowCount(0);
					gui.getIt().getModel().setColumnCount(0);
					gui.getIt().getModel().addColumn("Issue ID: ");
					gui.getIt().getModel().addColumn("Assigned to: ");
					gui.getIt().getModel().addColumn("Created: ");
					gui.getIt().getModel().addColumn("Issue: ");
					gui.getIt().getModel().addColumn("Priority: ");
					gui.getIt().getModel().addColumn("Location: ");

					
					for(Issues issue : gui.getIt().getIssueList()){
						int priorInt = Integer.parseInt(issue.getPriority().trim());
						int priorTxt = Integer.parseInt(gui.getTxtPriority().getText());
						if(priorInt >= priorTxt){
						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
				    			  issue.getAssigned(),
				    			  issue.getCreated(),
				    			  issue.getIssue(),
				    			  issue.getPriority(),
				    			  issue.getLocation()});
							}
						}
					}

				catch (Exception f ){
					f.printStackTrace();
				}
			}
		});
		
		
		/**
		 * This method tries to list the issues after a certain date.
		 * *****NOT COMPLETE*****
		 */
		gui.getBtnDate().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gui.getIt().getModel().setRowCount(0);
					gui.getIt().getModel().setColumnCount(0);
					gui.getIt().getModel().addColumn("Issue ID: ");
					gui.getIt().getModel().addColumn("Assigned to: ");
					gui.getIt().getModel().addColumn("Created: ");
					gui.getIt().getModel().addColumn("Issue: ");
					gui.getIt().getModel().addColumn("Priority: ");
					gui.getIt().getModel().addColumn("Location: ");


					for(Issues issue : gui.getIt().getIssueList()){
						int dateInt = Integer.parseInt(issue.getCreated().replaceAll("/", ""));
						int dateTxt = Integer.parseInt(gui.getTxtDate().getText().replaceAll("/", ""));
						if(dateInt >= dateTxt){
						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
				    			  issue.getAssigned(),
				    			  issue.getCreated(),
				    			  issue.getIssue(),
				    			  issue.getPriority(),
				    			  issue.getLocation()});
							}
						}
				}

				catch (Exception f ){
					f.printStackTrace();
				}
			}
		});

		/**
		 * This method lists all the uniqe users and
		 * presents them using a JTable
		 */
		gui.getBtnListAllUsers().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().listUniqueUsers();
				
			}
		});
		
		/**
		 * This method lists all the issues from the arrayList issues
		 * and presents them in the JTable qtable using methods from
		 * IssueTable.
		 */
		gui.getBtnListAllIssues().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableForIssues();
				
			}
		});
		
		/**
		 * This method simply adds a user to the arrayList users
		 * using methods from IssueTable.
		 */
		gui.getBtnAddUser().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					gui.getIt().addUser(gui.getTxtSearch().getText());
					gui.updateChooseUser();
					gui.getIt().listUniqueUsers();
			}
		});
		
		/**
		 * Adds an issue depending on the user input.
		 */
		gui.getBtnAddIssue().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			    	gui.setContentPane(gui.getIp());
			    	gui.pack();
		};

  });
		
		/**
		 * Adds an issue depending on the user input.
		 */
		gui.getIp().getCreateButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			    	Issues is = new Issues(gui.getIt().maxIssueId() ,
			    			gui.getChooseUser().getSelectedItem().toString(),
			    			gui.getIt().currentDate(),
			    			gui.getIp().getIssueText().getText(),
			    			gui.getChoosePriority().getSelectedItem().toString(),
			    			gui.getIp().getLocationText().getText());
			    	gui.getIt().getIssueList().add(is);
			    	gui.getIt().tableForIssues();
			    	gui.setContentPane(gui.getSpine());
			    	gui.pack();
		};

  });
		
		/**
		 * This actionslistener for the login button
		 * checks if the user input is in the list of users.
		 * If the user is not found, a textLabel is changed to "User not found."
		 * and if true Sets the user to logged in.
		 */
		gui.getLp().getLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.authenticateLogin();
				if(gui.authenticateLogin() == false){
					gui.getLp().getStatus().setText("Username or password is incorrect.");
				}
			}
		});
		
		gui.getBtnSwitchUser().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setContentPane(gui.getLp());
			}
		});
		
		
	}
}
