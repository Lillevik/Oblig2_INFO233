package no.uib.info233.v2016.puz001.esj002.Oblig2.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.IssueTable;
import no.uib.info233.v2016.puz001.esj002.Oblig2.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig2.Issue.Issues;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
		IssueTable it = new IssueTable();



		gui.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(it.getFile());
					doc.getDocumentElement().normalize();

					NodeList nodelist1 = doc.getElementsByTagName("ISSUES");

					it.getModel().setRowCount(0);
					it.getModel().setColumnCount(0);
					it.getModel().setColumnCount(0);
					it.getModel().addColumn("Issue ID: ");
					it.getModel().addColumn("Assigned to: ");
					it.getModel().addColumn("Created: ");
					it.getModel().addColumn("Issue: ");
					it.getModel().addColumn("Priority: ");
					it.getModel().addColumn("Location: ");

					if (nodelist1 != null && nodelist1.getLength() > 0) {
						for (int j = 0; j < nodelist1.getLength(); j++) {
							Node node = nodelist1.item(j);
							Element eElement = (Element) node;
							if (eElement.getAttribute("assigned_user").equals(gui.getTxtSearch().getText())) {

								System.out.println("ost");

								for(Issues searchTabel : it.getIssues()){
									

									it.getModel().addRow(new Object[]{searchTabel.getId(),
											searchTabel.getAssigned(),
											searchTabel.getCreated(),
											searchTabel.getIssue(),
											searchTabel.getPriority(),
											searchTabel.getLocation()});
								}
							}
						}
					}
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
				gui.getLayout().show(gui.getAddissue(), "Add issue");

				
			}
		});
		

}


}