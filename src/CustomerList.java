import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerList extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerList(JFrame currentFrame) {

		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setBounds(159, 25, 81, 14);
		add(lblCustomerList);
		
		JLabel lblNewLabel = new JLabel("Select Customer");
		lblNewLabel.setBounds(55, 62, 92, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(58, 217, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(165, 217, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(274, 217, 89, 23);
		add(btnNewButton_2);

		
	}

}
