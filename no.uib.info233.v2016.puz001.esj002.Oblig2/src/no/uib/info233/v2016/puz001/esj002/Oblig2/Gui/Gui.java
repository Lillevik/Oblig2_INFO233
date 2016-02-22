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
    
    //Jbuttons
    private JButton btnSearch;
    private JButton btnListAllIssues;
	private JButton btnListAllUsers;
	private JButton btnAddUser;
	private JButton btnAddIssue;
    
    //JTextFields 
    private JTextField txtSearch;
    
    //JLabels
    private JLabel searchLabel;
    
    //JTextPanes
    private JTextPane txtInfo;
    
    //Instance of the IssueTable class
    private IssueTable it = new IssueTable();
    
    //JTable
    private JTable qTable = new JTable(it.getModel());
    

    private CardLayout layout = new CardLayout();
    private AddIssue addissue = new AddIssue();
    
    
    /**
     * Constructor for the Gui class which extends from JFrame.
     * Creates the Gui and starts it up.
     */
    
    public Gui(){
    	super("Issue Tracker");
        spine = new JPanel(layout);
//        add(addissue, "add_issue");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spine.setLayout(new BorderLayout(0, 0));
		spine.setPreferredSize(new Dimension(700, 450));
		setContentPane(spine);
		setupComponents();
		pack();
		setVisible(true);
    }

	/**
     * Initializes components and
     * sets them up with custom designs.
     */
    public void setupComponents(){
    	//Sets up the JTable
    	qTable.setBackground(Color.white);
    	qTable.getAutoResizeMode();
    	qTable.setFillsViewportHeight(true);

    	//Initialize the JPanels
        panelBackLeft = new JPanel();
        panelBackRight = new JPanel();
        panelMidTopLeft = new JPanel();

        //Initialize the JLabels
        searchLabel = new JLabel();
        
        //Initialize the JTexFields
        txtSearch = new JTextField("Input username here");
        
        //Sets up the JPanel panelBackLeft
        panelBackLeft.setPreferredSize(new Dimension(200, 300));
        panelBackLeft.setBackground(Color.gray);

        //Sets up the JPanel panelBackRight
        panelBackRight.setPreferredSize(new Dimension(200, 50));
        panelBackRight.setBackground(Color.white);
   
        //Sets up the JLabel searchLabel
        searchLabel.setPreferredSize(new Dimension(190, 20));
        searchLabel.setText("Query here");
        
        //Sets up the JTextfield txtSearch
        txtSearch.setPreferredSize(new Dimension(190, 20));

        //Sets up the JButton btnSearch
        btnSearch = new JButton("Search");
        btnSearch.setSize(new Dimension( 20, 20));
        
        //Sets up the JButton listAll
        btnListAllIssues = new JButton("List Issues");
        btnListAllIssues.setSize(new Dimension( 20, 20));

        //Sets up the JButton btnListAllUsers
		btnListAllUsers = new JButton("List users");
		btnListAllUsers.setSize(new Dimension(20, 20));
		
		//Sets up the JButton btnAddUser
		btnAddUser = new JButton("Add user");
		btnAddUser.setSize(new Dimension(20, 20));
		
		//Sets up the JButton btnAddIssue
		btnAddIssue = new JButton("Add new issue");
		
		
		

        //Sets up the JLabel txtInfo
        txtInfo = new JTextPane();
        txtInfo.setText("Made by Puz001 and Esj002");
        txtInfo.setPreferredSize(new Dimension(190, 500));
        txtInfo.setBackground(Color.gray);

        //Adds the components to the Panels
        spine.add(panelBackRight, BorderLayout.CENTER);
        spine.add(panelBackLeft, BorderLayout.WEST);
        panelBackRight.add(panelMidTopLeft);
        panelBackLeft.add(searchLabel);
        panelBackLeft.add(txtSearch);
        panelBackLeft.add(btnSearch);
        panelBackLeft.add(btnAddUser);

		panelBackLeft.add(btnListAllUsers);
        panelBackLeft.add(btnListAllIssues);
        panelBackLeft.add(btnAddIssue);
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



	/**
	 * @return the it
	 */
	public IssueTable getIt() {
		return it;
	}



	/**
	 * @param it the it to set
	 */
	public void setIt(IssueTable it) {
		this.it = it;
	}



	/**
	 * @return the spine
	 */
	public JPanel getSpine() {
		return spine;
	}



	/**
	 * @return the panelMidTopLeft
	 */
	public JPanel getPanelMidTopLeft() {
		return panelMidTopLeft;
	}



	/**
	 * @return the btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}



	/**
	 * @return the txtSearch
	 */
	public JTextField getTxtSearch() {
		return txtSearch;
	}



	/**
	 * @return the searchLabel
	 */
	public JLabel getSearchLabel() {
		return searchLabel;
	}



	/**
	 * @return the btnListAllIssues
	 */
	public JButton getBtnListAllIssues() {
		return btnListAllIssues;
	}

	public JButton getBtnListAllUsers() {
		return btnListAllUsers;
	}



	/**
	 * @param btnListAllIssues the btnListAllIssues to set
	 */
	public void setListAllIssues(JButton btnListAllIssues) {
		this.btnListAllIssues = btnListAllIssues;
	}

	/**
	 * @return the btnAddUser
	 */
	public JButton getBtnAddUser() {
		return btnAddUser;
	}

	/**
	 * @param btnAddUser the btnAddUser to set
	 */
	public void setBtnAddUser(JButton btnAddUser) {
		this.btnAddUser = btnAddUser;
	}

	/**
	 * @param btnListAllIssues the btnListAllIssues to set
	 */
	public void setBtnListAllIssues(JButton btnListAllIssues) {
		this.btnListAllIssues = btnListAllIssues;
	}

	/**
	 * @param btnListAllUsers the btnListAllUsers to set
	 */
	public void setBtnListAllUsers(JButton btnListAllUsers) {
		this.btnListAllUsers = btnListAllUsers;
	}



	/**
	 * @return the layout
	 */
	public CardLayout getLayout() {
		return layout;
	}

	/**
	 * @param layout the layout to set
	 */
	public void setLayout(CardLayout layout) {
		this.layout = layout;
	}

	/**
	 * @return the addissue
	 */
	public AddIssue getAddissue() {
		return addissue;
	}

	/**
	 * @param addissue the addissue to set
	 */
	public void setAddissue(AddIssue addissue) {
		this.addissue = addissue;
	}

	/**
	 * @return the btnAddIssue
	 */
	public JButton getBtnAddIssue() {
		return btnAddIssue;
	}

	/**
	 * @param btnAddIssue the btnAddIssue to set
	 */
	public void setBtnAddIssue(JButton btnAddIssue) {
		this.btnAddIssue = btnAddIssue;
	}
}