import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JFrame currentFrame;
	JMenuBar menuBar;
	JMenu mnMaintainance;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					Connection conn= null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Anurag@25");
						if(conn!=null)
					{
						System.out.println("Connected Succesfully");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("not connected");
				}
			}
		});
	}
public PreparedStatement conn(String s){
	PreparedStatement pst = null;
	try {
		Connection conn= null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Anurag@25");
			if(conn!=null)
		{
			System.out.println("Connected Succesfully");
		}
			pst = conn.prepareStatement(s);
			
	} catch (Exception e) {
		System.out.println("not connected");
	}
	return pst;
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		currentFrame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 318);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMaintainance = new JMenu("Maintainance");
		menuBar.add(mnMaintainance);
		
		JMenu mnCompanyInfo = new JMenu("Company Info");
		mnMaintainance.add(mnCompanyInfo);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new EditCompany(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCompanyInfo.add(mntmUpdate);
		
		JMenuItem mntmView = new JMenuItem("View");
		mntmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ViewCompany(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCompanyInfo.add(mntmView);
		
		JMenu mnOrderTaker = new JMenu("Order Taker");
		mnMaintainance.add(mnOrderTaker);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			getContentPane().removeAll();
				getContentPane().add(new AddUser(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnOrderTaker.add(mntmAdd);
		
		JMenuItem mntmOrderTakerList = new JMenuItem("Order Taker List");
		mntmOrderTakerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new UserList(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnOrderTaker.add(mntmOrderTakerList);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new EditUser(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnOrderTaker.add(mntmEdit);
		
		JMenu mnCustomer = new JMenu("Customer");
		mnMaintainance.add(mnCustomer);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new AddCustomer(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCustomer.add(mntmAdd_1);
		
		JMenuItem mntmCustomerList = new JMenuItem("Customer List");
		mntmCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CustomerList(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCustomer.add(mntmCustomerList);
		
		JMenuItem mntmEdit_1 = new JMenuItem("Edit");
		mntmEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new customerEdit(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCustomer.add(mntmEdit_1);
		
		JMenu mnCourier = new JMenu("Courier");
		mnMaintainance.add(mnCourier);
		
		JMenuItem mntmAdd_2 = new JMenuItem("Add");
		mntmAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new AddCourier(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCourier.add(mntmAdd_2);
		
		JMenuItem mntmEdit_2 = new JMenuItem("Edit");
		mntmEdit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new EditCourier(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCourier.add(mntmEdit_2);
		
		JMenuItem mntmCourierList = new JMenuItem("Courier List");
		mntmCourierList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CourierList(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnCourier.add(mntmCourierList);
		
		JMenu mnDeliveryTicket = new JMenu("Delivery Ticket");
		menuBar.add(mnDeliveryTicket);
		
		JMenuItem mntmCreate = new JMenuItem("Create");
		mnDeliveryTicket.add(mntmCreate);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mnDeliveryTicket.add(mntmSearch);
		
		JMenuItem mntmDeliveredTicket = new JMenuItem("Delivered ticket");
		mnDeliveryTicket.add(mntmDeliveredTicket);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		JMenuItem mntmClientBill = new JMenuItem("Client Bill");
		mnReport.add(mntmClientBill);
		
		JMenuItem mntmCourierPerformance = new JMenuItem("Courier Performance");
		mnReport.add(mntmCourierPerformance);
		
		JMenuItem mntmCompanyPerformance = new JMenuItem("Company Performance");
		mnReport.add(mntmCompanyPerformance);
		
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ChangePassword(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnAccount.add(mntmChangePassword);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainScreen(currentFrame));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		mnAccount.add(mntmLogOut);
		menuBar.setVisible(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		getContentPane().removeAll();
		getContentPane().add(new MainScreen(currentFrame));

		getContentPane().revalidate();
	}
}
