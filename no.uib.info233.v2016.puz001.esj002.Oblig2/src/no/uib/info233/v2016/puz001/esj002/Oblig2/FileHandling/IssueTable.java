/**
 * 
 */
package no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling;

import java.io.File;

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
	    

	    public void employees(){

	    	
	      	try {
	      	File fXmlFile = new File("old_issues.xml");
	    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    			Document doc = dBuilder.parse(fXmlFile);
	    			doc.getDocumentElement().normalize();
	    			model.setColumnCount(0);
	    	        model.addColumn("User: ");
	    	       

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
	



