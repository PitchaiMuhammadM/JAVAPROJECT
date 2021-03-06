import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SearchCutomerTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCutomerTable frame = new SearchCutomerTable();
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
	public SearchCutomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 436);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchCustomerTable = new JLabel("Search Customer Table");
		lblSearchCustomerTable.setBounds(162, 11, 145, 14);
		contentPane.add(lblSearchCustomerTable);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(32, 53, 77, 14);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Customer ID");
		textField.setBounds(140, 50, 262, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(32, 93, 105, 14);
		contentPane.add(lblCustomerName);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setBounds(140, 90, 262, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(32, 150, 65, 14);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 146, 262, 113);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPhNo = new JLabel("Ph No:");
		lblPhNo.setBounds(32, 287, 46, 14);
		contentPane.add(lblPhNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(140, 284, 262, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setToolTipText("Search the Customer Details");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Loupe-icon.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String cid=textField.getText();
					String str1="select * from ADDCUSTOMERPAGE1 where CUSTOMERID='"+cid+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(str1);
					rs.next();
					String pn=rs.getString(2);
					String pp=rs.getString(3);
					String pq=rs.getString(4);
					
					textField_1.setText(pn);
					textField_2.setText(pp);
					textField_3.setText(pq);
					
					JOptionPane.showMessageDialog(btnSearch, "Searching...");
					
					
					
				}
				catch(Exception t)
				{
					System.out.println(t);
				}
			}
		});
		btnSearch.setBounds(29, 332, 119, 40);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmpHomePage EHP = new EmpHomePage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(173, 332, 57, 40);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("");
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Reset-icon.png"));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnReset.setBounds(345, 332, 57, 40);
		contentPane.add(btnReset);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPage EHP = new AdminPage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(263, 332, 44, 40);
		contentPane.add(btnHome);
	}

}
