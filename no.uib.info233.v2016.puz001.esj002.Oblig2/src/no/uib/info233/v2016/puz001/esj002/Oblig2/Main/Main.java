package no.uib.info233.v2016.puz001.esj002.Oblig2.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.FileHandler;
import no.uib.info233.v2016.puz001.esj002.Oblig2.Gui.Gui;
/**
 * @author esj002 and puz001
 */
public class Main {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Gui();
		FileHandler fh = new FileHandler();
		
		fh.tableForIssues();
		
		

	   
	  }
}