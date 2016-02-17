/**
 * 
 */
package no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling;

import javax.swing.JTable;

/**
 * @author mariuslillevik
 *
 */
public class IssueTable extends JTable{
	
	
	
	


	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private JTable issues = new JTable();
		
		public IssueTable(){
		}
	


	/**
	 * @return the issues
	 */
	public JTable getIssues() {
		return issues;
	}



	/**
	 * @param issues the issues to set
	 */
	public void setIssues(JTable issues) {
		this.issues = issues;
	}







}
	



