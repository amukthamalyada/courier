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

public class EditUser extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditUser(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblEditOrderTaker = new JLabel("Edit Order Taker");
		lblEditOrderTaker.setBounds(12, 26, 123, 16);
		add(lblEditOrderTaker);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(59, 70, 56, 16);
		add(lblNewLabel);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(59, 113, 56, 16);
		add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Position:");
		lblNewLabel_1.setBounds(59, 161, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblPhoneNo = new JLabel("Phone no:");
		lblPhoneNo.setBounds(59, 219, 76, 16);
		add(lblPhoneNo);
		
		JTextField textField = new JTextField();
		textField.setBounds(137, 67, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblUserId = new JLabel("malya21");
		lblUserId.setBounds(135, 113, 56, 16);
		add(lblUserId);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(137, 158, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(137, 216, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query ="select * from userinfo where userid=? and userpassword=?";
					Main log= new Main();
					PreparedStatement pst= log.conn(query);
					System.out.println(lblUserId.getText());
					ResultSet rs=pst.executeQuery("select * from userinfo where userID ='"+lblUserId.getText()+"'");
				
			    while(rs.next()){
			    	
			    	String query1 = "Update userinfo set username='"+textField.getText()+"',  userposition='"+textField_1.getText()+"' , userphone='"+textField_2.getText()+"'  ";
					PreparedStatement pst1= log.conn(query1);
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "User Edits are updated");
					pst1.close();
			   
			    }
				
				}catch(Exception en){
					JOptionPane.showMessageDialog(null, en);
					
				}
			}
			
			
		});
		
		btnNewButton.setBounds(190, 264, 97, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(322, 264, 97, 25);
		add(btnNewButton_1);

	}

}
