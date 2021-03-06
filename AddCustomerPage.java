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
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class AddCustomerPage extends JFrame {

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
					AddCustomerPage frame = new AddCustomerPage();
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
	public AddCustomerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 316);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCustomerPage = new JLabel("Add Customer Page");
		lblAddCustomerPage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddCustomerPage.setBounds(236, 11, 138, 14);
		contentPane.add(lblAddCustomerPage);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(39, 42, 92, 14);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Customer ID");
		textField.setBounds(141, 36, 312, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(39, 70, 102, 14);
		contentPane.add(lblCustomerName);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Customer Name");
		textField_1.setBounds(141, 67, 312, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Enter Customer Address");
		textField_2.setBounds(141, 98, 312, 83);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(39, 116, 60, 14);
		contentPane.add(lblAddress);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setToolTipText("Submit the DATA");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Login-in-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
				String cid=textField.getText();
				String cname=textField_1.getText();
				
				String cadd=textField_2.getText();
				
				String cPH=textField_3.getText();
				
				
				
				String str="insert into ADDCUSTOMERPAGE1 values('"+cid+"','"+cname+"','"+cadd+"','"+cPH+"')";
				
				Class.forName("org.h2.Driver");
				Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement stm =conn.createStatement();
				stm.executeUpdate(str);
				
				JOptionPane.showMessageDialog(btnNewButton, "Inserted..");
				}
				catch(Exception t)
				{
					System.out.println(t);
				}
			}
		});
		btnNewButton.setBounds(39, 236, 102, 34);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				HomePage HP= new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(151, 236, 89, 34);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				RegisterHomePage RHP=new RegisterHomePage();
				RHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(250, 236, 89, 34);
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
		btnReset.setBounds(349, 236, 104, 34);
		contentPane.add(btnReset);
		
		JLabel lblPhNo = new JLabel("Ph No");
		lblPhNo.setBounds(39, 192, 46, 14);
		contentPane.add(lblPhNo);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Enter Customer Phone Number");
		textField_3.setBounds(141, 192, 312, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
