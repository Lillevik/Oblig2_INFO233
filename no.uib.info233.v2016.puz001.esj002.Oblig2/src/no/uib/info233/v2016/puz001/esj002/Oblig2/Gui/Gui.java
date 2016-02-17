package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.IssueTable;

import java.awt.*;
import java.io.File;

/**
 * Created by esj002 and puz001
 */
public class Gui extends JFrame {

    /**
	 * The fields of the Gui class
	 */
	private static final long serialVersionUID = 1L;
	private JPanel spine;
    private JPanel panelBackRight;
    private JPanel panelBackLeft;
    private JPanel panelMidTopLeft;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JLabel searchLabel;
    private JTextPane txtInfo;
    private DefaultTableModel model = new DefaultTableModel();
    private JTable qTable = new JTable(model);
    
    /**
     * Constructor for the Gui class which extends from JFrame.
     */
    public Gui(){
    	super("Issue Tracker");

		tableForIssues();
        spine = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spine.setLayout(new BorderLayout(500, 150));
		setContentPane(spine);
		setupComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		pack();
		setVisible(true);
    }
    
    
    
    public void setupComponents(){
    	//Initializes the JTables

        
    	
    	//Initialize the JPanels
        panelBackLeft = new JPanel();
        panelBackRight = new JPanel();
        panelMidTopLeft = new JPanel();

        //Initialize the JLabels
        searchLabel = new JLabel();
        
        //Initialize the JTexFields
        txtSearch = new JTextField("Search");
        
        panelBackLeft.setPreferredSize(new Dimension(200, 300));
        panelBackLeft.setBackground(Color.gray);

        panelBackRight.setPreferredSize(new Dimension(200, 50));
        panelBackRight.setBackground(Color.white);
        
//        panelMidTopLeft.setPreferredSize(new Dimension(550, 650));
//        panelMidTopLeft.setBackground(Color.gray);

        searchLabel.setPreferredSize(new Dimension(190, 20));
        searchLabel.setText("Query here");

        txtSearch.setPreferredSize(new Dimension(190, 20));

        btnSearch = new JButton("Search");
        btnSearch.setSize(new Dimension( 20, 20));

        txtInfo = new JTextPane();
        txtInfo.setText("info field");
        txtInfo.setPreferredSize(new Dimension(190, 500));
        txtInfo.setBackground(Color.gray);

        	qTable.setPreferredSize(new Dimension(540, 640));
        	qTable.setBackground(Color.white);
        	qTable.getAutoResizeMode();
        
//        qTable.setFillsViewportHeight(true);
//        JScrollPane scrollPane = new JScrollPane(qTable);
//        scrollPane.add(qTable);

        //Adds the components to the Panels
        spine.add(panelBackRight, BorderLayout.CENTER);
        spine.add(panelBackLeft, BorderLayout.WEST);
        panelBackRight.add(panelMidTopLeft);
        panelBackLeft.add(searchLabel);
        panelBackLeft.add(txtSearch);
        panelBackLeft.add(btnSearch);
        panelBackLeft.add(txtInfo);
        panelMidTopLeft.add(new JScrollPane(qTable));
    }
    
    
    
    public void tableForIssues(){
    	
      	try {
      	File fXmlFile = new File("old_issues.xml");
    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    			Document doc = dBuilder.parse(fXmlFile);
    			doc.getDocumentElement().normalize();
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
          model.addRow(new Object[]{eElement.getAttribute("id"), eElement.getAttribute("assigned_user"), eElement.getAttribute("created"), eElement.getAttribute("text"), eElement.getAttribute("priority"), eElement.getAttribute("location")});
          
          

      }
      	}
   			
   		    catch (Exception e) {
   			e.printStackTrace();
   		    }
   	 
   	}
    

	/**
	 * @return the panelBackRight
	 */
	public JPanel getPanelBackRight() {
		return panelBackRight;
	}



	/**
	 * @param panelBackRight the panelBackRight to set
	 */
	public void setPanelBackRight(JPanel panelBackRight) {
		this.panelBackRight = panelBackRight;
	}



	/**
	 * @return the panelBackLeft
	 */
	public JPanel getPanelBackLeft() {
		return panelBackLeft;
	}



	/**
	 * @param panelBackLeft the panelBackLeft to set
	 */
	public void setPanelBackLeft(JPanel panelBackLeft) {
		this.panelBackLeft = panelBackLeft;
	}



	/**
	 * @return the txtInfo
	 */
	public JTextPane getTxtInfo() {
		return txtInfo;
	}



	/**
	 * @param txtInfo the txtInfo to set
	 */
	public void setTxtInfo(JTextPane txtInfo) {
		this.txtInfo = txtInfo;
	}




	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @param spine the spine to set
	 */
	public void setSpine(JPanel spine) {
		this.spine = spine;
	}



	/**
	 * @param panelMidTopLeft the panelMidTopLeft to set
	 */
	public void setPanelMidTopLeft(JPanel panelMidTopLeft) {
		this.panelMidTopLeft = panelMidTopLeft;
	}



	/**
	 * @param btnSearch the btnSearch to set
	 */
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}



	/**
	 * @param txtSearch the txtSearch to set
	 */
	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}



	/**
	 * @param searchLabel the searchLabel to set
	 */
	public void setSearchLabel(JLabel searchLabel) {
		this.searchLabel = searchLabel;
	}



	/**
	 * @return the qTable
	 */
	public JTable getqTable() {
		return qTable;
	}



	/**
	 * @param qTable the qTable to set
	 */
	public void setqTable(JTable qTable) {
		this.qTable = qTable;
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
}