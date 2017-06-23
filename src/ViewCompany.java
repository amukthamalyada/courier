import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewCompany extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewCompany(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JButton btnConfirm = new JButton("  Update");
		
		btnConfirm.setBounds(243, 202, 89, 23);
		add(btnConfirm);
		
		JLabel lblView = new JLabel("View Company Information");
		lblView.setBounds(36, 35, 198, 14);
		add(lblView);
		
		JLabel lblNewLabel = new JLabel("BillRate   ");
		lblNewLabel.setBounds(-169, 56, 218, 14);
		add(lblNewLabel);
		
		JLabel lblBillrate = new JLabel("BillRate        ");
		lblBillrate.setBounds(53, 102, 106, 14);
		add(lblBillrate);
		
		JLabel lblNewLabel_1 = new JLabel("Bonus      ");
		lblNewLabel_1.setBounds(53, 127, 106, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number    ");
		lblNewLabel_2.setBounds(53, 152, 106, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Company Name");
		lblNewLabel_3.setBounds(53, 77, 106, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Address    ");
		lblNewLabel_5.setBounds(53, 177, 95, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setBounds(172, 76, 160, 14);
		add(lblNewLabel_6);
		
		JLabel label = new JLabel();
		label.setBounds(172, 101, 160, 14);
		add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(172, 127, 160, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setBounds(172, 152, 160, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(172, 177, 160, 14);
		add(label_3);
		
		try{
			String query ="select * from company ";
			Main log= new Main();
			PreparedStatement pst= log.conn(query);
			
			ResultSet rs=pst.executeQuery("select * from company ");
	    while(rs.next()){
	    	lblNewLabel_6.setText(rs.getString("companyname"));
	    	label.setText(rs.getString("companybillRate"));
	    	label_1.setText(rs.getString("companybonus"));
	    	label_2.setText(rs.getString("companyphoneno"));
	    	label_3.setText(rs.getString("companylocation"));
	    	
	    }
		}catch(Exception en){
			JOptionPane.showMessageDialog(null, en);
			
		}
		
	}
}
