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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class UpdateCustomerTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtUpdateCustomerName;
	private JTextField txtUpdateCustomerAddress;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomerTable frame = new UpdateCustomerTable();
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
	public UpdateCustomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 366);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateCustomerDetails = new JLabel("Update Customer Details");
		lblUpdateCustomerDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUpdateCustomerDetails.setBounds(159, 11, 179, 14);
		contentPane.add(lblUpdateCustomerDetails);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(43, 45, 81, 14);
		contentPane.add(lblCustomerId);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(43, 80, 105, 14);
		contentPane.add(lblCustomerName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(43, 120, 81, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhNo = new JLabel("Ph NO:");
		lblPhNo.setBounds(43, 207, 46, 14);
		contentPane.add(lblPhNo);
		
		textField = new JTextField();
		textField.setToolTipText("Enter the Customer ID");
		textField.setBounds(159, 42, 251, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtUpdateCustomerName = new JTextField();
		txtUpdateCustomerName.setToolTipText("Update Customer  Name");
		txtUpdateCustomerName.setBounds(159, 77, 251, 20);
		contentPane.add(txtUpdateCustomerName);
		txtUpdateCustomerName.setColumns(10);
		
		txtUpdateCustomerAddress = new JTextField();
		txtUpdateCustomerAddress.setToolTipText("Update Customer Address");
		txtUpdateCustomerAddress.setBounds(159, 117, 251, 80);
		contentPane.add(txtUpdateCustomerAddress);
		txtUpdateCustomerAddress.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Update Phone Number");
		textField_3.setBounds(159, 204, 251, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setToolTipText("Update");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\news-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					
					String ED=textField.getText();
					String EN=txtUpdateCustomerName.getText();
					
					String EADD=txtUpdateCustomerAddress.getText();
					
					String EPH=textField_3.getText();
					
					String str="update ADDCUSTOMERPAGE1 set CUSTOMERNAME='"+EN+"', CUSTOMERADDRESS='"+EADD+"', PHNO	='"+EPH+"' where CUSTOMERID='"+ED+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(str);
					
					JOptionPane.showMessageDialog(btnNewButton,"Updated..");
					
					
				}catch(Exception t)
				{
					
				}
			}
		});
		btnNewButton.setBounds(43, 251, 105, 37);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmpHomePage EHP =new EmpHomePage();
				EHP.setVisible(true);
				dispose();
			}
			
		});
		btnBack.setBounds(159, 251, 75, 37);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				HomePage HP = new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(244, 251, 81, 37);
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("");
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Reset-icon.png"));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				txtUpdateCustomerName.setText("");
				txtUpdateCustomerAddress.setText("");
				textField_3.setText("");
			}
		});
		btnReset.setBounds(335, 251, 75, 37);
		contentPane.add(btnReset);
	}

}
