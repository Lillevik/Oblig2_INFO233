package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
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
    private JTable qTable;


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
    	
        Object rowData[][]= { { "Issue ID: ", "Assigned to: ", "Created: " },
 				   			{ "Row2-Colum", "Row2-Column2", "Row2-Column3" } };
        Object columnNames[] = { "Column One", "Column Two", "Column Three" };

        
    	//Initialize the JPanels
        panelBackLeft = new JPanel();
        panelBackRight = new JPanel();
        panelMidTopLeft = new JPanel();

        //Initialize the JLabels
        searchLabel = new JLabel();
        
        //Initialize the JTexFields
        txtSearch = new JTextField("Search");
        
        //Initializes the JTables
        qTable = new JTable(rowData, columnNames);
 
       

       
        panelBackLeft.setPreferredSize(new Dimension(200, 300));
        panelBackLeft.setBackground(Color.gray);

        panelBackRight.setPreferredSize(new Dimension(200, 50));
        panelBackRight.setBackground(Color.white);
        
        panelMidTopLeft.setPreferredSize(new Dimension(550, 650));
        panelMidTopLeft.setBackground(Color.gray);

        searchLabel.setPreferredSize(new Dimension(190, 20));
        searchLabel.setText("Querry here");

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

        JScrollPane scrollPane = new JScrollPane(qTable);
        scrollPane.add(qTable);

        //Adds the components to the Panels
        spine.add(panelBackRight, BorderLayout.CENTER);
        spine.add(panelBackLeft, BorderLayout.WEST);
        panelBackRight.add(panelMidTopLeft);
        panelMidTopLeft.add(qTable);
        panelBackLeft.add(searchLabel);
        panelBackLeft.add(txtSearch);
        panelBackLeft.add(btnSearch);
        panelBackLeft.add(txtInfo);
        panelMidTopLeft.add(qTable);
        

        



    }
    
    

	public JPanel getSpine(){
        return spine;
    }

    public JButton getBtnSearch(){
        return this.btnSearch;
    }

    public JTextField getTxtSearch(){
        return txtSearch;
    }

    public JLabel getSearchLabel(){
        return searchLabel;
    }

    public JPanel getPanelMidTopLeft(){
        return panelMidTopLeft;
    }
}