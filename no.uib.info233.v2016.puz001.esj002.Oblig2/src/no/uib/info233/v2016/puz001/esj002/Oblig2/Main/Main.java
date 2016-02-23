package no.uib.info233.v2016.puz001.esj002.Oblig2.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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


					
					for(Issues issue : gui.getIt().getIssues()){
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

					
					for(Issues issue : gui.getIt().getIssues()){
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


					for(Issues issue : gui.getIt().getIssues()){
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
				System.out.println("Added the user " + gui.getTxtSearch().getText() + " to the list of users.");
				gui.getIt().listUniqueUsers();

				
			}
		});
		
		/**
		 * Method under construction. 
		 */
		gui.getBtnAddIssue().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year = cal.get(Calendar.YEAR);
				String date = month + "/" + day + "/" + year;
				System.out.println(d);
			    	Issues is = new Issues(gui.getIt().maxIssueId() , "dryan3", date, "Issue text", "99", "Norway");
			    	gui.getIt().getIssues().add(is);
			    	gui.getIt().tableForIssues();
				gui.getIt().fillUsers();
		};
	
  });
		

}
}