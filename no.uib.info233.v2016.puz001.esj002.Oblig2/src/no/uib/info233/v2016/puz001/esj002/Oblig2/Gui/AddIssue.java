/**
 * 
 */
package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author mariuslillevik
 *
 */
public class AddIssue extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddIssue() {
        setBackground(Color.GREEN);
        add(new JLabel("Panel one"));
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
    
