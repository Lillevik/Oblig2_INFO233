package no.uib.info233.v2016.puz001.esj002.Oblig2.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.uib.info233.v2016.puz001.esj002.Oblig2.Gui.Gui;
/**
 * This class only has one purpose, 
 * which is to start the program.
 * @author esj002 and puz001
 */
public class Main {

	
	
	/**
	 * This method starts the program and connects the different 
	 * instances together in one class.
	 * @param args
	 */
	public static void main(String[] args) {

		
		Gui gui = new Gui();
		
		gui.getBtnListAllUsers().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().listUniqueUsers();
				
			}
		});
		
		gui.getBtnListAllIssues().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().fillIssues();
				gui.getIt().tableForIssues();
				
			}
		});
		

}
}