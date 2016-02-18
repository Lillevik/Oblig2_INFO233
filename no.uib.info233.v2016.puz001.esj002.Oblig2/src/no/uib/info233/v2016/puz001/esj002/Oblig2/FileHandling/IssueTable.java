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

/**
 * @author mariuslillevik
 *
 */
public class IssueTable extends JTable{
	

	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private DefaultTableModel model = new DefaultTableModel();
		private ArrayList<String> users = new ArrayList <String>(); 
		
		
		/**
		 * Constructor for the IssueTable class.
		 */
		public IssueTable(){
			tableForIssues();
		}
	

		/**
		 * Creates a model containing all the 
		 * elements in the xml file old_issues.xml.
		 */
	    public void tableForIssues(){
	    	
	      	try {
	      	File fXmlFile = new File("old_issues.xml");
	    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    			Document doc = dBuilder.parse(fXmlFile);
	    			doc.getDocumentElement().normalize();
	    			model.setColumnCount(0);
	    	        model.addColumn("Issue ID: ");
	    	        model.addColumn("Assigned to: ");
	    	        model.addColumn("Created: ");
	    	        model.addColumn("Issue: ");
	    	        model.addColumn("Priority: ");
	    	        model.addColumn("Location: ");

	      NodeList nodelist1 = doc.getElementsByTagName("ISSUES");
	      for (int i = 0; i < nodelist1.getLength(); i++)
	      {
	          Node node = nodelist1.item(i);
	          Element eElement = (Element) node;
	          model.addRow(new Object[]{eElement.getAttribute("id"),
					  eElement.getAttribute("assigned_user"),
					  eElement.getAttribute("created"),
					  eElement.getAttribute("text"),
					  eElement.getAttribute("priority"),
					  eElement.getAttribute("location")});
	      }
	      	}
	   			
	   		    catch (Exception e) {
	   			e.printStackTrace();
	   		    }
	   	 
	   	}
	    
<<<<<<< HEAD
	    
	    
=======

	    public void employees(){
>>>>>>> origin/master

	    
	    public void fillUsers(){
	      	try {
	      	File fXmlFile = new File("old_issues.xml");
	    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    			Document doc = dBuilder.parse(fXmlFile);
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

<<<<<<< HEAD
	    
	    public void uniqueUsers(){

	    	model.setColumnCount(0);
	        model.addColumn("Users: ");
	    	Set<String> setUniqueNumbers = new LinkedHashSet<String>();
	    	for(String x : users) {
	    	    setUniqueNumbers.add(x);
	    	}
	    	for(String x : setUniqueNumbers) {
	    		model.addRow(new Object[]{x});
	    	}
=======
	      NodeList nodelist1 = doc.getElementsByTagName("ISSUES");
	      for (int i = 0; i < nodelist1.getLength(); i++)
	      {
	          Node node = nodelist1.item(i);
	          Element eElement = (Element) node;

	        	  model.addRow(new Object[]{eElement.getAttribute("assigned_user")});

	      }
	      	}
	   			
	   		    catch (Exception e) {
	   			e.printStackTrace();
	   		    }
>>>>>>> origin/master
	    }
	    
	    
	    
	
	
	    
	    
	    /**
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

}
	



