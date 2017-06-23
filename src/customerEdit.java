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

public class customerEdit extends JPanel {

	/**
	 * Create the panel.
	 */
	public customerEdit(JFrame currentFrame) {

		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Edit Customer");
		lblNewLabel.setBounds(36, 33, 124, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name                    :");
		lblNewLabel_1.setBounds(46, 67, 114, 14);
		add(lblNewLabel_1);
		
		JLabel lblCustomerNo = new JLabel("Customer no         : ");
		lblCustomerNo.setBounds(45, 92, 135, 14);
		add(lblCustomerNo);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Address:");
		lblNewLabel_2.setBounds(46, 117, 105, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Email                     :");
		lblNewLabel_5.setBounds(46, 148, 96, 14);
		add(lblNewLabel_5);
		
		JLabel lblPhoneNo = new JLabel("Phone no              :");
		lblPhoneNo.setBounds(46, 173, 105, 14);
		add(lblPhoneNo);
		
		JTextField textField = new JTextField();
		textField.setBounds(142, 64, 124, 20);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(142, 117, 124, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(142, 148, 124, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JTextField textField_5 = new JTextField();
		textField_5.setBounds(142, 173, 124, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("1234");
		lblNewLabel_3.setBounds(152, 92, 46, 14);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query ="select * from customer where number=? ";
					Main log= new Main();
					PreparedStatement pst= log.conn(query);
					ResultSet rs=pst.executeQuery("select * from customer where number ='"+lblNewLabel_3.getText()+"'");
				
			    while(rs.next()){
			    	
			    	String query1 = "Update customer set customername='"+textField.getText()+"',  customeraddress='"+textField_2.getText()+"' , customeremail='"+textField_4.getText()+"', customerphoneno='"+textField_5.getText()+"'  ";
					PreparedStatement pst1= log.conn(query1);
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "Customer Details");
					pst1.close();
			   
			    }
				
				}catch(Exception en){
					JOptionPane.showMessageDialog(null, en);
					
				}
			
			
			
			}
		});
		
		btnNewButton.setBounds(125, 223, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(235, 223, 89, 23);
		add(btnNewButton_1);
		
		
 

		
	}

}
