import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCourier extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddCourier(JFrame currentFrame) {
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Add Courier");
		lblNewLabel.setBounds(37, 45, 87, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name                       :");
		lblNewLabel_1.setBounds(60, 80, 128, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Courier no           :");
		lblNewLabel_2.setBounds(60, 116, 146, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Courier Address  :");
		lblNewLabel_3.setBounds(60, 150, 194, 14);
		add(lblNewLabel_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number       :");
		lblPhoneNumber.setBounds(60, 216, 162, 14);
		add(lblPhoneNumber);
		
		JTextField textField = new JTextField();
		textField.setBounds(168, 77, 139, 20);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(168, 113, 139, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(168, 147, 139, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(168, 213, 139, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(168, 185, 139, 20);
		add(textField_4);

		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query ="insert into courier (number,couriername,courierphone,couriercol,courieremail) values (?,?,?,?,?)";
					Main log= new Main();
					PreparedStatement pst= log.conn(query);
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_2.getText());
					pst.setString(5, textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Account Created. User ID ="+textField.getText()+"");
					pst.close();
					
					} catch(Exception ex){
						ex.printStackTrace();
					}
				}

			
				
			
		});
		
		btnNewButton.setBounds(285, 244, 89, 23);
		add(btnNewButton);
		
		JLabel label = new JLabel("Email       :");
		label.setBounds(60, 188, 162, 14);
		add(label);
		
		
	}

}
