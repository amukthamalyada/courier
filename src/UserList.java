import java.awt.Font;
import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UserList extends JPanel {
	DefaultListModel listModel;
	JList list;
	String[] lio;
	int rowCount = -1;
	
public int count(){
		
		try{
			String query ="select count(*) from userinfo";
			Main log= new Main();
			PreparedStatement pst= log.conn(query);
			
			ResultSet rs=pst.executeQuery("select count(*) from userinfo");
			
			 rs.next();
		      rowCount = rs.getInt(1);
		  
		    
		   
		}catch(Exception en){
			JOptionPane.showMessageDialog(null, en);
			
		}
		System.out.println(rowCount);
		return rowCount;
		}
		public String[] li(){
			int i=0;
			int n =i+1;
			String[] lis = new String[rowCount];
			
			try{
				for(i=0;i<rowCount;i++){
				String query ="select * from userinfo where number= "+n+"";
				Main log= new Main();
				PreparedStatement pst= log.conn(query);
				
				ResultSet rs=pst.executeQuery("select * from userinfo where number= '"+n+"'");
				System.out.println(n);
				 while(rs.next()){
					 System.out.println("doon");
					lis[i]= rs.getString("userID");	
					
				 }
				 n++;
			}
				lio= Arrays.copyOf(lis,lis.length);
			}
				 catch(Exception en){
				JOptionPane.showMessageDialog(null, en);
				
			}
			System.out.println(lis[1]);
			return lis;
			
		}
	
	/**
	 * Create the panel.
	 */
	public UserList(JFrame currentFrame) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		JLabel lblOrder = new JLabel("Order Taker List");
		lblOrder.setBounds(178, 5, 93, 16);
		add(lblOrder);
		
		JLabel lblNewLabel = new JLabel("Select Order Taker");
		lblNewLabel.setBounds(32, 42, 126, 16);
		add(lblNewLabel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(32, 245, 97, 25);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(164, 245, 97, 25);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(308, 245, 97, 25);
		add(btnDelete);
		
		
		listModel = new DefaultListModel();
		for(int i=0;i<rowCount;i++)
	listModel.addElement(lio[i]);
		
		list = new JList(listModel);
		list.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scroll2 = new JScrollPane (list, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue() != null) 
				{
					btnEdit.setEnabled(true);
				}
				
			}
		});
	
		scroll2.setBounds(164, 51, 179, 183);
		add(scroll2);
	
		
		
		
	
		
		
		

		
	}
}
