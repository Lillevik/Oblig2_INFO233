package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 * Created by svimanet on 13/02/16.
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
    
    //private JPanel panelMidTopRight;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JLabel searchLabel;
    private JTextPane txtInfo;
    private JTable table1;


    
    /**
     * Constructor for the Gui class which extends from JFrame.
     */
    public Gui(){
    	super("Issue Tracker");
        spine = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spine.setBorder(new EmptyBorder(5, 5, 5, 5));
		spine.setLayout(new BorderLayout(500, 150));
		setContentPane(spine);
		setupComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
		setVisible(true);
    }
    
    public void setupComponents(){
        
        
    	//Initialize the JPanels
        panelBackLeft = new JPanel();
        panelBackRight = new JPanel();
        panelMidTopLeft = new JPanel();
        
        
        //Initialize the JLabels
        searchLabel = new JLabel();
        
        //Initialize the JTexFields
        txtSearch = new JTextField("Search");
        
        //Initilizes the JTables
        table1 = new JTable();
        
       
        panelBackLeft.setPreferredSize(new Dimension(200, 300));
        panelBackLeft.setBackground(Color.gray);


        panelBackRight.setPreferredSize(new Dimension(200, 50));
        panelBackRight.setBackground(Color.white);

        
        panelMidTopLeft.setPreferredSize(new Dimension(550, 650));
        panelMidTopLeft.setBackground(Color.black);

        //panelMidTopRight = new JPanel();
        //panelMidTopRight.setPreferredSize(new Dimension(550, 650));
        //panelMidTopRight.setBackground(Color.gray);

        panelBackRight.add(panelMidTopLeft, BorderLayout.WEST);
        //panelBackRight.add(panelMidTopRight, BorderLayout.EAST);

        
        searchLabel.setPreferredSize(new Dimension(190, 20));
        searchLabel.setText("Querry here");

        
        txtSearch.setPreferredSize(new Dimension(190, 20));

        btnSearch = new JButton("Search");
        btnSearch.setSize(new Dimension( 20, 20));

        txtInfo = new JTextPane();
        txtInfo.setText(" o o o o o oo o o o o oo o o o o oo o o o o oo o o o o oo o o o o oo o o o o oo o o o o o  ");
        txtInfo.setPreferredSize(new Dimension(190, 500));
        txtInfo.setBackground(Color.gray);
        
        table1.setPreferredSize(new Dimension(540, 640));
        table1.setBackground(Color.white);
        table1.getAutoResizeMode();

        //Adds the components to the Panels
        spine.add(panelBackRight, BorderLayout.CENTER);
        spine.add(panelBackLeft, BorderLayout.WEST);
        panelBackLeft.add(searchLabel);
        panelBackLeft.add(txtSearch);
        panelBackLeft.add(btnSearch);
        panelBackLeft.add(txtInfo);
        panelMidTopLeft.add(table1);
        
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

   // public JPanel getPanelMidTopRight(){
   //     return panelMidTopRight;
   // }
    
    
}