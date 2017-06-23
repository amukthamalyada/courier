import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class profileOT extends JPanel {

	/**
	 * Create the panel.
	 */
	public profileOT(JFrame currentFrame, String id, String pass) {
		
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		Main ms= new Main();

		ms.menuBar.setVisible(true);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(40, 68, 135, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(40, 93, 111, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(40, 128, 111, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(40, 170, 135, 14);
		add(lblNewLabel_3);
		
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new profile(currentFrame,id,pass));
				currentFrame.getContentPane().revalidate();
				currentFrame.getJMenuBar().remove(mntmHome);
			}
		});
		currentFrame.getJMenuBar().add(mntmHome);
		
		currentFrame.getJMenuBar().setVisible(true);
		currentFrame.getJMenuBar().getMenu(0).setVisible(false);
		try{
			String query ="select * from userinfo where userid=? and userpassword=?";
			Main log= new Main();
			PreparedStatement pst= log.conn(query);
			
			ResultSet rs=pst.executeQuery("select * from userinfo where userID='"+id+"'and userPassword='"+pass+"'");
	    while(rs.next()){
	    	lblNewLabel.setText(rs.getString("username"));
	    	lblNewLabel_1.setText(rs.getString("userposition"));
	    	lblNewLabel_2.setText(rs.getString("userphone"));
	    	lblNewLabel_3.setText(rs.getString("userID"));
	    	
	    }
		}catch(Exception en){
			JOptionPane.showMessageDialog(null, en);
			
		}
		
		
		
		
		
		
	
	}
	}


