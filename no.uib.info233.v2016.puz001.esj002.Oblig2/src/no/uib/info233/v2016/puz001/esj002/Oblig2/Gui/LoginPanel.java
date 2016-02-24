package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class LoginPanel extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JLabel userLabel = new JLabel("User");
	private JLabel passwordLabel = new JLabel("Password");
	private JButton loginButton = new JButton("login");
	private JPasswordField passwordText = new JPasswordField(20);
	private JTextField userText = new JTextField(20);
	private JLabel status = new JLabel();
	
	
	
	public LoginPanel(){
		setPreferredSize(new Dimension(700, 600));
		placeComponents(this);
		setVisible(true);
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		
		userLabel.setBounds(200, 200, 80, 25);
		panel.add(userLabel);


		userText.setBounds(290, 200, 160, 25);
		panel.add(userText);

		
		passwordLabel.setBounds(200, 240, 80, 25);
		panel.add(passwordLabel);


		passwordText.setBounds(290, 240, 160, 25);
		panel.add(passwordText);


		loginButton.setBounds(200, 280, 80, 25);
		panel.add(loginButton);
		
		
		status.setBounds(200, 320, 300, 25);
		status.setText("Not logged in");	
		status.setPreferredSize(new Dimension(190, 100));
		panel.add(status);
		
	}

	/**
	 * @return the userLabel
	 */
	public JLabel getUserLabel() {
		return userLabel;
	}

	/**
	 * @param userLabel the userLabel to set
	 */
	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	/**
	 * @return the passwordLabel
	 */
	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	/**
	 * @param passwordLabel the passwordLabel to set
	 */
	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	/**
	 * @return the loginButton
	 */
	public JButton getLoginButton() {
		return loginButton;
	}

	/**
	 * @param loginButton the loginButton to set
	 */
	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	/**
	 * @return the passwordText
	 */
	public JPasswordField getPasswordText() {
		return passwordText;
	}

	/**
	 * @param passwordText the passwordText to set
	 */
	public void setPasswordText(JPasswordField passwordText) {
		this.passwordText = passwordText;
	}

	/**
	 * @return the userText
	 */
	public JTextField getUserText() {
		return userText;
	}

	/**
	 * @param userText the userText to set
	 */
	public void setUserText(JTextField userText) {
		this.userText = userText;
	}

	/**
	 * @return the status
	 */
	public JLabel getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(JLabel status) {
		this.status = status;
	}
}