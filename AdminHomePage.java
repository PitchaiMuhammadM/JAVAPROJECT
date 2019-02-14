import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

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
		setBounds(100, 100, 488, 273);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminHomePage = new JLabel("Admin Home Page");
		lblAdminHomePage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdminHomePage.setBounds(204, 11, 150, 14);
		contentPane.add(lblAdminHomePage);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setToolTipText("View Employee And Customer Details");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EmployeePage EP=new EmployeePage();
				EP.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(204, 52, 139, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setToolTipText("Search Employee Details");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Loupe-icon.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SearchEmp SE = new SearchEmp();
				SE.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(204, 98, 139, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setToolTipText("Update Employee Details");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\news-icon.png"));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UpdateEmp UE= new UpdateEmp();
				UE.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(204, 144, 139, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setToolTipText("Delete Employee Details");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\delete-icon.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				DelEmp DE = new DelEmp();
				DE.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(204, 191, 139, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPage AP=new AdminPage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(373, 144, 75, 70);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				HomePage HP=new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(373, 52, 75, 69);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\admin-icon.png"));
		label.setBounds(85, 22, 139, 183);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\administrator-icon.png"));
		label_1.setBounds(0, 11, 133, 128);
		contentPane.add(label_1);
	}
}
