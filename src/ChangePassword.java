import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePassword extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public ChangePassword(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblChange = new JLabel("Change  password");
		lblChange.setBounds(148, 36, 134, 23);
		add(lblChange);
		
		JLabel lblUserId = new JLabel("user id");
		lblUserId.setBounds(37, 82, 46, 14);
		add(lblUserId);
		
		JLabel lblCurrentPassword = new JLabel("current password");
		lblCurrentPassword.setBounds(37, 107, 103, 20);
		add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("new password");
		lblNewPassword.setBounds(37, 138, 79, 14);
		add(lblNewPassword);
		
		JTextField textField = new JTextField();
		textField.setBounds(188, 79, 131, 20);
		add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField1 = new JPasswordField();
		passwordField1.setBounds(188, 107, 131, 20);
		add(passwordField1);
	
		JPasswordField passwordField2 = new JPasswordField();
		passwordField2.setBounds(188, 138, 134, 20);
		add(passwordField2);
		
		
		
		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query ="select * from userinfo where userid=? and userpassword=?";
					Main log= new Main();
					PreparedStatement pst= log.conn(query);
					ResultSet rs=pst.executeQuery("select * from userinfo where userID='"+textField.getText()+"'and userPassword='"+passwordField1.getText()+"'");
			    while(rs.next()){
			    	
			    	String query1 = "Update userinfo set userPassword='"+passwordField2.getText()+"' ";
					PreparedStatement pst1= log.conn(query1);
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "Password is changed");
					pst1.close();
			   
			    }
				
				}catch(Exception en){
					JOptionPane.showMessageDialog(null, en);
					
				}
			}
			
		});
		btnContinue.setBounds(106, 213, 89, 23);
		add(btnContinue);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(230, 213, 89, 23);
		add(btnCancel);
		
		
 

		
	}
	}
