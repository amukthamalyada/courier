import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateDT extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreateDT(JFrame currentFrame) {
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JTextField textField = new JTextField();
		textField.setBounds(203, 132, 114, 20);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(203, 174, 114, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDeliveryTicket = new JLabel("Delivery ticket");
		lblDeliveryTicket.setBounds(158, 28, 99, 16);
		add(lblDeliveryTicket);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(25, 62, 44, 16);
		add(lblNewLabel);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(322, 62, 55, 16);
		add(lblTime);
		
		JLabel lblPickup = new JLabel("Pickup");
		lblPickup.setBounds(25, 91, 55, 16);
		add(lblPickup);
		
		JLabel lblCustomer = new JLabel("Customer no:");
		lblCustomer.setBounds(69, 134, 89, 16);
		add(lblCustomer);
		
		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setBounds(69, 176, 108, 16);
		add(lblCustomerName);
		
		JLabel lblPickupTime = new JLabel("Pickup time:");
		lblPickupTime.setBounds(69, 217, 108, 16);
		add(lblPickupTime);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(203, 215, 114, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDelivery = new JLabel("Delivery");
		lblDelivery.setBounds(25, 269, 55, 16);
		add(lblDelivery);
		
		JLabel lblNewLabel_1 = new JLabel("Customer no:");
		lblNewLabel_1.setBounds(69, 302, 108, 16);
		add(lblNewLabel_1);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(203, 300, 114, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCustomerName_1 = new JLabel("Customer name:");
		lblCustomerName_1.setBounds(69, 350, 108, 16);
		add(lblCustomerName_1);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(203, 348, 114, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(405, 372, 98, 26);
		add(btnContinue);
		
		JLabel Date = new JLabel("--/--/----");
		Date.setBounds(69, 62, 55, 16);
		add(Date);
		
		JLabel Time = new JLabel("--:--:--");
		Time.setBounds(365, 62, 55, 16);
		add(Time);
 
	}

	}


