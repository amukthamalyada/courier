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

public class EditCompany extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditCompany(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Update Company Information");
		lblNewLabel.setBounds(40, 44, 188, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BillRate                   :");
		lblNewLabel_1.setBounds(69, 82, 139, 14);
		add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(213, 79, 102, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Bonus                     :");
		lblNewLabel_2.setBounds(69, 107, 139, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number       :");
		lblNewLabel_3.setBounds(69, 132, 139, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Address                 :");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBounds(69, 157, 111, 14);
		add(lblNewLabel_5);
		
		
		
		JButton btnNewButton_1 = new JButton("Cancel");
		
		btnNewButton_1.setBounds(334, 233, 89, 23);
		add(btnNewButton_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(213, 104, 102, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(213, 129, 102, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(213, 157, 102, 65);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("/block");
		lblNewLabel_6.setBounds(319, 82, 46, 14);
		add(lblNewLabel_6);
 
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query ="select * from company";
					Main log= new Main();
					PreparedStatement pst= log.conn(query);
					ResultSet rs=pst.executeQuery("select * from company");
			    while(rs.next()){
			    	
			    	String query1 = "Update company set companybillRate='"+textField.getText()+"', companybonus= '"+textField_1.getText()+"', companyphoneno='"+textField_2.getText()+"', companylocation='"+textField_4.getText()+"' ";
					PreparedStatement pst1= log.conn(query1);
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "company details are updated");
					pst1.close();
			   
			    }
				
				}catch(Exception en){
					JOptionPane.showMessageDialog(null, en);
					
				}
			}
				
			
		});
		
		btnNewButton.setBounds(223, 233, 89, 23);
		add(btnNewButton);

	}

}
