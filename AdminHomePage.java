import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage frame = new AdminHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminHomePage = new JLabel("Admin Home Page");
		lblAdminHomePage.setBounds(162, 11, 150, 14);
		contentPane.add(lblAdminHomePage);
		
		JButton btnNewButton = new JButton("View Employee And Customer Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EmployeePage EP=new EmployeePage();
				EP.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 50, 414, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search Employee Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SearchEmp SE = new SearchEmp();
				SE.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 98, 414, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Employee Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UpdateEmp UE= new UpdateEmp();
				UE.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 144, 414, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Employee Details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				DelEmp DE = new DelEmp();
				DE.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 191, 414, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPage AP=new AdminPage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				HomePage HP=new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(10, 227, 89, 23);
		contentPane.add(btnHome);
	}
}
