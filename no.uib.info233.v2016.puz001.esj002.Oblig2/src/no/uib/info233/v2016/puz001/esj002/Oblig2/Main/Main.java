package no.uib.info233.v2016.puz001.esj002.Oblig2.Main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import no.uib.info233.v2016.puz001.esj002.Oblig2.Gui.Gui;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/**
 * @author esj002 and puz001
 */
public class Main {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Gui();
		

	    try {

		File fXmlFile = new File("old_issues.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				
		//optional, but recommended
		doc.getDocumentElement().normalize();

		System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("ISSUES");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Issue ID: " + eElement.getAttribute("id"));
				System.out.println("Assigned to: " + eElement.getAttribute("assigned_user"));
				System.out.println("Created: " + eElement.getAttribute("created"));
				System.out.println("Issue: " + eElement.getAttribute("text"));
				System.out.println("Priority: " + eElement.getAttribute("priority"));
				System.out.println("Location: " + eElement.getAttribute("location"));
				
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }
}