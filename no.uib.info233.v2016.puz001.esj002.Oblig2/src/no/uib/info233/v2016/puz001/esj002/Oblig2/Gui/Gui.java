package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.IssueTable;

import java.awt.*;

/**
 * Created by esj002 and puz001
 * This class creates a graphical user interface and 
 * represents components there.
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
	private JPanel panelBackLeftTop;
	private JPanel panelBackLeftBot;

	//Jbuttons
	private JButton btnSearch;
	private JButton btnListAllIssues;
	private JButton btnListAllUsers;
	private JButton btnAddUser;
	private JButton btnAddIssue;
	private JButton btnDate;
	private JButton btnPrior;
	private JButton btnLogin;

	//JTextFields
	private JTextField txtSearch;
	private JTextField txtDate;
	private JTextField txtPriority;
	private JTextField txtAddIssue;
	private JTextField txtAddLocation;
	private JTextField txtLogin;


	//JLabels
	private JLabel searchLabel;

	//JTextPanes
	private JTextPane txtInfo;
	private JTextPane txtLoggedIn = new JTextPane();

	//Instance of the IssueTable class
	private IssueTable it = new IssueTable();

	//JTable
	private JTable qTable = new JTable(it.getModel());

	//passwordField
	private JPasswordField passwordField = new JPasswordField();

	private CardLayout layout = new CardLayout();

	
	
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
		spine.setPreferredSize(new Dimension(700, 600));
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
		panelBackLeftTop = new JPanel();
		panelBackLeftBot = new JPanel();

		//Initialize the JLabels
		searchLabel = new JLabel();

		//Initialize the JTexFields
		txtSearch = new JTextField("search/add User");
		txtDate = new JTextField("search/add Date");
		txtPriority = new JTextField("search/add Prior");
		txtAddIssue = new JTextField("add Issue");
		txtAddLocation = new JTextField("add Location");
		txtLogin = new JTextField("Username");

		//Sets up the JPanel panelBackLeft
		panelBackLeft.setPreferredSize(new Dimension(200, 300));
		panelBackLeft.setBackground(Color.gray);
		panelBackLeft.setLayout(new BorderLayout());

		//Sets up the JPanel panelBackRight
		panelBackRight.setPreferredSize(new Dimension(200, 50));
		panelBackRight.setBackground(Color.white);

		//sets panelBackLeftTop and bot
		panelBackLeftTop.setBackground(Color.GRAY);
		panelBackLeftBot.setBackground(Color.LIGHT_GRAY);
		panelBackLeftTop.setPreferredSize(new Dimension(100, 500));

		//Sets up the JLabel searchLabel
		searchLabel.setPreferredSize(new Dimension(190, 20));
		searchLabel.setText("Query here");

		//Sets up the JTextfiels
		txtSearch.setPreferredSize(new Dimension(190, 20));
		txtDate.setPreferredSize(new Dimension(190, 20));
		txtPriority.setPreferredSize(new Dimension(190, 20));
		txtAddIssue.setPreferredSize(new Dimension(190, 20));
		txtAddLocation.setPreferredSize(new Dimension(190, 20));
		txtLogin.setPreferredSize(new Dimension(90, 20));

		//password field setup
		passwordField.setPreferredSize(new Dimension(90, 20));


		//Sets up the buttons
		btnSearch = new JButton("Search User");
		btnListAllIssues = new JButton("List Issues");
		btnListAllUsers = new JButton("List users");
		btnAddUser = new JButton("Add user");
		btnAddIssue = new JButton("Add issue");
		btnDate = new JButton("Search Date");
		btnPrior = new JButton("Search Prior");
		btnLogin = new JButton("Login");

		//size the buttons
		btnSearch.setSize(new Dimension( 20, 20));
		btnListAllUsers.setSize(new Dimension(20, 20));
		btnAddUser.setSize(new Dimension(20, 20));
		btnListAllIssues.setSize(new Dimension( 20, 20));

		//Sets up the JLabels
		txtInfo = new JTextPane();
		txtInfo.setText("Fill a field and press the correct button to search. Date field -> Date btn etc");
		txtInfo.setPreferredSize(new Dimension(190, 100));
		txtInfo.setBackground(Color.gray);
		txtLoggedIn.setText("Not logged in");
		txtLoggedIn.setBackground(Color.LIGHT_GRAY);
		txtLoggedIn.setPreferredSize(new Dimension(190, 100));

		//Adds the components to the Panels
		spine.add(panelBackRight, BorderLayout.CENTER);
		spine.add(panelBackLeft, BorderLayout.WEST);

		panelBackRight.add(panelMidTopLeft);

		panelBackLeft.add(panelBackLeftTop, BorderLayout.NORTH);
		panelBackLeft.add(panelBackLeftBot, BorderLayout.CENTER);

		panelBackLeftTop.add(searchLabel);
		panelBackLeftTop.add(txtSearch);
		panelBackLeftTop.add(txtDate);
		panelBackLeftTop.add(txtPriority);
		panelBackLeftTop.add(txtAddLocation);
		panelBackLeftTop.add(txtAddIssue);
		panelBackLeftTop.add(btnSearch);
		panelBackLeftTop.add(btnDate);
		panelBackLeftTop.add(btnPrior);
		panelBackLeftTop.add(btnAddIssue);
		panelBackLeftTop.add(btnAddUser);
		panelBackLeftTop.add(btnAddIssue);
		panelBackLeftTop.add(btnListAllUsers);
		panelBackLeftTop.add(btnListAllIssues);
		panelBackLeftTop.add(txtInfo);

		panelBackLeftBot.add(txtLogin);
		panelBackLeftBot.add(passwordField);
		panelBackLeftBot.add(btnLogin);
		panelBackLeftBot.add(txtLoggedIn);

		panelMidTopLeft.add(new JScrollPane(qTable));
	}


	/**
	 * 
	 * @return boolean if authentication was successful or not
	 * Used to authenicate user logins.
	 */
	@SuppressWarnings("deprecation")
	public boolean authenticateLogin(){
		for(String s : getIt().getUsers()){
			if(s.equals(getTxtLogin().getText()) && !getPasswordField().getText().equals(null)){
				getTxtLoggedIn().setText("Logged in as: " + getTxtLogin().getText());
				return true;
			} 
		} 
		return false;
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

	/**
	 * @return the panelBackLeftTop
	 */
	public JPanel getPanelBackLeftTop() {
		return panelBackLeftTop;
	}

	/**
	 * @param panelBackLeftTop the panelBackLeftTop to set
	 */
	public void setPanelBackLeftTop(JPanel panelBackLeftTop) {
		this.panelBackLeftTop = panelBackLeftTop;
	}

	/**
	 * @return the panelBackLeftBot
	 */
	public JPanel getPanelBackLeftBot() {
		return panelBackLeftBot;
	}

	/**
	 * @param panelBackLeftBot the panelBackLeftBot to set
	 */
	public void setPanelBackLeftBot(JPanel panelBackLeftBot) {
		this.panelBackLeftBot = panelBackLeftBot;
	}

	/**
	 * @return the btnDate
	 */
	public JButton getBtnDate() {
		return btnDate;
	}

	/**
	 * @param btnDate the btnDate to set
	 */
	public void setBtnDate(JButton btnDate) {
		this.btnDate = btnDate;
	}

	/**
	 * @return the btnPrior
	 */
	public JButton getBtnPrior() {
		return btnPrior;
	}

	/**
	 * @param btnPrior the btnPrior to set
	 */
	public void setBtnPrior(JButton btnPrior) {
		this.btnPrior = btnPrior;
	}

	/**
	 * @return the btnLogin
	 */
	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @param btnLogin the btnLogin to set
	 */
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	/**
	 * @return the txtDate
	 */
	public JTextField getTxtDate() {
		return txtDate;
	}

	/**
	 * @param txtDate the txtDate to set
	 */
	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}

	/**
	 * @return the txtPriority
	 */
	public JTextField getTxtPriority() {
		return txtPriority;
	}

	/**
	 * @param txtPriority the txtPriority to set
	 */
	public void setTxtPriority(JTextField txtPriority) {
		this.txtPriority = txtPriority;
	}

	/**
	 * @return the txtAddIssue
	 */
	public JTextField getTxtAddIssue() {
		return txtAddIssue;
	}

	/**
	 * @param txtAddIssue the txtAddIssue to set
	 */
	public void setTxtAddIssue(JTextField txtAddIssue) {
		this.txtAddIssue = txtAddIssue;
	}

	/**
	 * @return the txtAddLocation
	 */
	public JTextField getTxtAddLocation() {
		return txtAddLocation;
	}

	/**
	 * @param txtAddLocation the txtAddLocation to set
	 */
	public void setTxtAddLocation(JTextField txtAddLocation) {
		this.txtAddLocation = txtAddLocation;
	}

	/**
	 * @return the txtLogin
	 */
	public JTextField getTxtLogin() {
		return txtLogin;
	}

	/**
	 * @param txtLogin the txtLogin to set
	 */
	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	/**
	 * @return the txtLoggedIn
	 */
	public JTextPane getTxtLoggedIn() {
		return txtLoggedIn;
	}

	/**
	 * @param txtLoggedIn the txtLoggedIn to set
	 */
	public void setTxtLoggedIn(JTextPane txtLoggedIn) {
		this.txtLoggedIn = txtLoggedIn;
	}

	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * @param passwordField the passwordField to set
	 */
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}


}