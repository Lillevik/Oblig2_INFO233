package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.IssueTable;

import java.awt.*;

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
    private IssueTable it = new IssueTable();
//    private DefaultTableModel model;
    private JTable qTable = new JTable(it.getModel());
    
    /**
     * Constructor for the Gui class which extends from JFrame.
     */
    public Gui(){
    	super("Issue Tracker");
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
        	
        

        	qTable.setBackground(Color.white);
        	qTable.getAutoResizeMode();
        	qTable.setFillsViewportHeight(true);
        	


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
}