import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddUser extends JPanel {
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public AddUser(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		
		Main ms= new Main();
		JMenuBar menuBar = ms.menuBar;
		menuBar.setBounds(0, 0, 430, 20);
		
		add(menuBar);
		
		
		JLabel lblNewLabel = new JLabel("Add Order Taker");
		lblNewLabel.setBounds(140, 22, 116, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(66, 68, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id:");
		lblNewLabel_2.setBounds(66, 105, 56, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Position:");
		lblNewLabel_3.setBounds(66, 159, 56, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no:");
		lblNewLabel_4.setBounds(66, 188, 83, 16);
		add(lblNewLabel_4);
		
		JTextField textField = new JTextField();
		textField.setBounds(176, 65, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(176, 102, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(176, 156, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(176, 185, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query ="insert into userinfo (userID,username,userPassword,userphone,userposition) values (?,?,?,?,?)";
					Main log= new Main();
					PreparedStatement pst= log.conn(query);
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField.getText());
					pst.setString(3, passwordField.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_2.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Account Created. User ID ="+textField_1.getText()+" and password ="+passwordField.getText()+"");
					pst.close();
					
					} catch(Exception ex){
						ex.printStackTrace();
					}
				}

			
		});
		btnNewButton.setBounds(252, 238, 97, 25);
		add(btnNewButton);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(66, 132, 56, 16);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 130, 116, 20);
		add(passwordField);

		
	}
}
