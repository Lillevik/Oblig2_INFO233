/**
 * 
 */
package no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling;

import java.util.*;
import java.io.File;
import java.util.ArrayList;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import no.uib.info233.v2016.puz001.esj002.Oblig2.Issue.Issues;

/**
 * @author mariuslillevik
 *
 */
public class IssueTable extends JTable{
	

	/**
	 * Fields for the IssueTable class
	 */
		private static final long serialVersionUID = 1L;
		private File file = new File("old_issues.xml");
		private DefaultTableModel model = new DefaultTableModel();
		private ArrayList<String> users = new ArrayList <String>(); 
		private ArrayList<Issues> issues = new ArrayList <Issues>();
		
		
		
		/**
		 * Constructor for the IssueTable class.
		 */
		public IssueTable(){
			fillIssues();
			tableForIssues();
			fillUsers();
		}
	    
	    /**
	     * This method takes all the assigned users from the 
	     * xml document "old_issues.xml" and places them into the ArrayList users. 
	     */
	    public void fillUsers(){
	      	try {
	    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    			Document doc = dBuilder.parse(file);
	    			doc.getDocumentElement().normalize();
	    	       
	    			NodeList nodelist = doc.getElementsByTagName("ISSUES");
					      for (int i = 0; i < nodelist.getLength(); i++)
					      {
					          Node node = nodelist.item(i);
					          Element eElement = (Element) node;
					        	  users.add(eElement.getAttribute("assigned_user"));
					      }
					      	}
					   			
					   		    catch (Exception e) {
					   			e.printStackTrace();
					   		    }
	    }
	    
	    
	    
	    

	    /**
	     * This method simply changes users to only contain 
	     * non duplicate employees, and represents this
	     * in the table model.
	     */
	    public void listUniqueUsers(){
	    	try {
		    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    			Document doc = dBuilder.parse(file);
		    			doc.getDocumentElement().normalize();
		    			model.setRowCount(0);
	    	model.setColumnCount(0);
	        model.addColumn("Users: ");
	    	Set<String> setUniqueNumbers = new LinkedHashSet<String>();
	    	for(String x : users) {
	    	    setUniqueNumbers.add(x);
	    	}
	    	for(String x : setUniqueNumbers) {
	    		model.addRow(new Object[]{x});
	    	}
	    	}

	   		    catch (Exception e) {
	   			e.printStackTrace();
	   		    }
	    }
	    
	    
	    
	    /**
	     * A method to fill the issues array with all the issues in old_issues.xml
	     */
	    public void tableForIssues(){
	    	
	      	try {
	    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    			Document doc = dBuilder.parse(file);
	    			doc.getDocumentElement().normalize();
	    			model.setRowCount(0);
	    		    model.setColumnCount(0);
	    			model.setColumnCount(0);
	    	        model.addColumn("Issue ID: ");
	    	        model.addColumn("Assigned to: ");
	    	        model.addColumn("Created: ");
	    	        model.addColumn("Issue: ");
	    	        model.addColumn("Priority: ");
	    	        model.addColumn("Location: ");

	      
	      for (Issues issue : issues) {
	    	  
	    	  model.addRow(new Object[]{issue.getId(),
	    			  issue.getAssigned(),
	    			  issue.getCreated(),
	    			  issue.getIssue(),
	    			  issue.getPriority(),
	    			  issue.getLocation()});
	     
	      }
	      	}
	   			
	   		    catch (Exception e) {
	   			e.printStackTrace();
	   		    }
	   	 
	   	}
	    
	    
	    
	    /**
	     * This method adds all the ISSUES elements in the old_issues.xml file
	     * as object of Issues into the issues ArrayList.
	     */
	    public void fillIssues(){
	    	
	    	try {
    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    			Document doc = dBuilder.parse(file);

      NodeList nodelist = doc.getElementsByTagName("ISSUES");
      for (int i = 0; i < nodelist.getLength(); i++)
      {
          Node node = nodelist.item(i);
          Element eElement = (Element) node;
          Issues issue = new Issues(eElement.getAttribute("id"), 
      		  eElement.getAttribute("assigned_user"), 
      		  eElement.getAttribute("created"),
      		  eElement.getAttribute("text"),
      		  eElement.getAttribute("priority"),
      		  eElement.getAttribute("location")
      		  );
          issues.add(issue);
      }
      	}
   			
   		    catch (Exception e) {
   			e.printStackTrace();
   		    }
	    	

	    }
	    
	    public void addUser(String user){
	    	users.add(user);
	    }
	    
	    
	    
	    /**
	     * 
	 * @return the model
	 */
	public DefaultTableModel getModel() {
		return model;
	}



	/**
	 * @param model the model to set
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}


	/**
	 * @return the users
	 */
	public ArrayList<String> getUsers() {
		return users;
	}


	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}


	/**
	 * @return the issues
	 */
	public ArrayList<Issues> getIssues() {
		return issues;
	}


	/**
	 * @param issues the issues to set
	 */
	public void setIssues(ArrayList<Issues> issues) {
		this.issues = issues;
	}

}
	


