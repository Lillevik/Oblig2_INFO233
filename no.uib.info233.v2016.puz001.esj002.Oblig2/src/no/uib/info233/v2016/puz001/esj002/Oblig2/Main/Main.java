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




		gui.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

//					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//					Document doc = dBuilder.parse(gui.getIt().getFile());
//
//				NodeList nodelist1 = doc.getElementsByTagName("ISSUES");

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
					
//						for (int j = 0; j < nodelist1.getLength(); j++) {
//							Node node = nodelist1.item(j);
//							Element eElement = (Element) node;
//							if (eElement.getAttribute("assigned_user").equals(gui.getTxtSearch().getText())) {
//								gui.getIt().getModel().addRow(new Object[]{eElement.getAttribute("id"),
//										eElement.getAttribute("assigned_user"),
//										eElement.getAttribute("created"),
//										eElement.getAttribute("text"),
//										eElement.getAttribute("priority"),
//										eElement.getAttribute("location")});
//						}
//					}
				}

				catch (Exception f ){
					f.printStackTrace();
				}

			}
		});
		
		gui.getBtnListAllUsers().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().listUniqueUsers();
				
			}
		});
		
		gui.getBtnListAllIssues().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableForIssues();
				
			}
		});
		
		
		gui.getBtnAddUser().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().addUser(gui.getTxtSearch().getText());
				System.out.println("Added the user " + gui.getTxtSearch().getText() + " to the list of users.");
				gui.getIt().listUniqueUsers();

				
			}
		});
		
		gui.getBtnAddIssue().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getLayout().show(gui.getAddissue(), "add_issue");
		};
	
  });
}
}