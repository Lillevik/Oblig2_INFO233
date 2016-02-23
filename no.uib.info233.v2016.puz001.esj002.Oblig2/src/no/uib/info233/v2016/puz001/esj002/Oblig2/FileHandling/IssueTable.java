/**
 * 
 */
package no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling;

import java.util.*;
import java.io.File;

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
 * This is a class which deals with handling the xml files
 * and creating lists of strings and object from the xml file.
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
	private ArrayList<Integer> prio = new ArrayList<Integer>() ;
	
	
		/**
		 * Constructor for the IssueTable class.
		 */
		public IssueTable(){
			fillPrio();
			fillUsers();
			fillIssues();
			tableForIssues();
			
		}
	    
		
		public void fillPrio(){
			
			for (int a = 0; a < 101; a++) {
			    prio.add(a);
			}
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
					          if(!users.contains(eElement.getAttribute("assigned_user")))
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

	    	
	    	for(String x : users) {
	    		model.addRow(new Object[]{x});
	    	}
	    	}

	   		    catch (Exception e) {
	   			e.printStackTrace();
	   		    }
	    }
	    
	    /**
	     * Adds a user to the users ArrayList.
	     * @param user
	     */
	    
	    public void addUser(String user){
	    	users.add(user);
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
	    
	    
	    /**
	     * A method to represents all the Issues objects from
	     * the issues ArrayList and represent them in the JTable qTable.
	     */
	    public void tableForIssues(){
	    	
	      	try {
	    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    			Document doc = dBuilder.parse(file);
	    			doc.getDocumentElement().normalize();
	    			model.setRowCount(0);
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
	     * 
	     * @return The highest current Issue ID from the issues list.
	     */
	    public String maxIssueId(){
	    	Comparator<Issues> iss = Comparator.comparing(Issues::idInt);
	    	return Integer.toString(Collections.max(issues, iss).idInt() + 1);
	    }
	    
	    
	    public String currentDate(){
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		String date = month + "/" + day + "/" + year;
		return date;
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


	/**
	 * @return the prio
	 */
	public ArrayList<Integer> getPrio() {
		return prio;
	}


	/**
	 * @param prio the prio to set
	 */
	public void setPrio(ArrayList<Integer> prio) {
		this.prio = prio;
	}

}

	



