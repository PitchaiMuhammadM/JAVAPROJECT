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
		setBounds(100, 100, 490, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchCustomerTable = new JLabel("Search Customer Table");
		lblSearchCustomerTable.setBounds(162, 11, 145, 14);
		contentPane.add(lblSearchCustomerTable);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(43, 53, 77, 14);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(130, 50, 272, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(32, 93, 105, 14);
		contentPane.add(lblCustomerName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 90, 272, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(42, 149, 46, 14);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 146, 272, 113);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPhNo = new JLabel("Ph No:");
		lblPhNo.setBounds(43, 287, 46, 14);
		contentPane.add(lblPhNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 284, 272, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
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
		btnSearch.setBounds(177, 332, 110, 50);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmpHomePage EHP = new EmpHomePage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(326, 317, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnReset.setBounds(326, 359, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPage EHP = new AdminPage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(55, 359, 89, 23);
		contentPane.add(btnHome);
	}

}
