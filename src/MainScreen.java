import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainScreen extends JPanel {

	JTextField tfuserid;
	JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	
	
	public MainScreen(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JLabel lblUserId = new JLabel("User Id           :");
		lblUserId.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUserId.setBounds(84, 94, 106, 24);
		add(lblUserId);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLogIn.setBounds(189, 30, 64, 24);
		add(lblLogIn);
		
		tfuserid = new JTextField();
		tfuserid .setBounds(214, 96, 162, 24);
		add(tfuserid);
		tfuserid.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password      :");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(84, 131, 106, 24);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 131, 162, 24);
		add(passwordField);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String query ="select * from userinfo where userID=? and userPassword=?";
				Main log= new Main();
				PreparedStatement pst= log.conn(query);
				pst.setString(1,tfuserid.getText() );
				pst.setString(2, passwordField.getText());
				ResultSet rs = pst.executeQuery();
				int count =0;
				while(rs.next()){
					count =count+1;
				}
				if(count == 1){
					JOptionPane.showMessageDialog(null, "username and Pasword is correct");
					String query1 ="select * from userinfo where userID=? and userposition= 'admin' ";
					Main log1= new Main();
					PreparedStatement pst1= log1.conn(query1);
					pst1.setString(1,tfuserid.getText() );
					ResultSet rs1 = pst1.executeQuery();
					int count1 =0;
					while(rs1.next()){
						count1 =count1+1;
					}
					if(count1 == 1){
					currentFrame.getContentPane().removeAll();
					

					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new profile(currentFrame,tfuserid.getText(),passwordField.getText()));
					currentFrame.getContentPane().revalidate();
					}
					else {
						currentFrame.getContentPane().removeAll();
						

						currentFrame.getContentPane().removeAll();
						currentFrame.getContentPane().add(new profileOT(currentFrame,tfuserid.getText(),passwordField.getText()));
						currentFrame.getContentPane().revalidate();
					}
				}
				else if(count > 1){
					JOptionPane.showMessageDialog(null, "Duplicate username and Pasword");
				}
				else {
					JOptionPane.showMessageDialog(null, "username and Pasword is incorrect");
					
				}
				rs.close();
				pst.close();
				}
				catch(Exception en){
					JOptionPane.showMessageDialog(null, en);
					
				}
			}
			
		});
		btnContinue.setBounds(313, 203, 89, 23);
		add(btnContinue);
		
		
		
		
		
		
	}
	
}
