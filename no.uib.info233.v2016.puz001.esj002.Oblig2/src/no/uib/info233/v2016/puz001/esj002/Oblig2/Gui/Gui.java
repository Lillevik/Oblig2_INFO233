package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svimanet on 13/02/16.
 */
public class Gui extends JFrame {

    private JFrame spine;
    private JPanel panelBackRight;
    private JPanel panelBackLeft;
    private JPanel panelMidTopLeft;
    //private JPanel panelMidTopRight;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JLabel searchLabel;
    private JTextPane txtInfo;
    private JTable table1;

    public JFrame getSpine(){
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

    public Gui(){

    	
        spine = new JFrame();
        spine.setSize(800, 700);
        spine.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelBackLeft = new JPanel();
        panelBackLeft.setPreferredSize(new Dimension(200, 300));
        panelBackLeft.setBackground(Color.gray);

        panelBackRight = new JPanel();
        panelBackRight.setPreferredSize(new Dimension(200, 50));
        panelBackRight.setBackground(Color.white);

        panelMidTopLeft = new JPanel();
        panelMidTopLeft.setPreferredSize(new Dimension(550, 650));
        panelMidTopLeft.setBackground(Color.black);

        //panelMidTopRight = new JPanel();
        //panelMidTopRight.setPreferredSize(new Dimension(550, 650));
        //panelMidTopRight.setBackground(Color.gray);

        spine.add(panelBackRight, BorderLayout.CENTER);
        spine.add(panelBackLeft, BorderLayout.WEST);

        panelBackRight.add(panelMidTopLeft, BorderLayout.WEST);
        //panelBackRight.add(panelMidTopRight, BorderLayout.EAST);

        searchLabel = new JLabel();
        searchLabel.setPreferredSize(new Dimension(190, 20));
        searchLabel.setText("Querry here");

        txtSearch = new JTextField("Search");
        txtSearch.setPreferredSize(new Dimension(190, 20));

        btnSearch = new JButton("Search");
        btnSearch.setSize(new Dimension( 20, 20));

        txtInfo = new JTextPane();
        txtInfo.setText(" o o o o o oo o o o o oo o o o o oo o o o o oo o o o o oo o o o o oo o o o o oo o o o o o  ");
        txtInfo.setPreferredSize(new Dimension(190, 500));
        txtInfo.setBackground(Color.gray);

        panelBackLeft.add(searchLabel);
        panelBackLeft.add(txtSearch);
        panelBackLeft.add(btnSearch);
        panelBackLeft.add(txtInfo);

        table1 = new JTable();
        table1.setPreferredSize(new Dimension(540, 640));
        table1.setBackground(Color.white);
        table1.getAutoResizeMode();

        panelMidTopLeft.add(table1);


        spine.setVisible(true);
        spine.setResizable(true);

    }
}