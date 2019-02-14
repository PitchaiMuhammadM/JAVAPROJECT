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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class AdminUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdate frame = new AdminUpdate();
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
	public AdminUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateemployeeDetails = new JLabel("Update Admin Details");
		lblUpdateemployeeDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUpdateemployeeDetails.setBounds(184, 11, 240, 14);
		contentPane.add(lblUpdateemployeeDetails);
		
		JLabel lblEmloyeeId = new JLabel("Admin ID");
		lblEmloyeeId.setBounds(43, 50, 82, 14);
		contentPane.add(lblEmloyeeId);
		
		JLabel lblNewLabel = new JLabel("Admin Name");
		lblNewLabel.setBounds(43, 81, 139, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(43, 154, 82, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhNo = new JLabel("Ph NO:");
		lblPhNo.setBounds(43, 247, 69, 14);
		contentPane.add(lblPhNo);
		
		textField = new JTextField();
		textField.setToolTipText("Enter the Admin ID");
		textField.setBounds(171, 47, 274, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Update Admin Name");
		textField_1.setBounds(171, 78, 274, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Update Address");
		textField_3.setBounds(171, 154, 274, 69);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Update Phone Number");
		textField_4.setBounds(171, 244, 274, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setToolTipText("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\news-icon.png"));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() 
		{

			private JComboBox comboBox;

			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					
					String ED=textField.getText();
					String EN=textField_1.getText();
					
					String EPWD=passwordField.getText();
					
					String EADD=textField_3.getText();
					
					String ERL="Admin";
					
					String EPH=textField_4.getText();
					
					
					
					String str="update ADDEMPLOYEEPAGE set EMPNAME='"+EN+"', EMPPWD='"+EPWD+"', EMPADD='"+EADD+"', EMPPH='"+EPH+"' where EMPID='"+ED+"'AND  ROLL='"+ERL+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(str);
					
					JOptionPane.showMessageDialog(btnUpdate,"Updated..");
					
					
				}
				catch(Exception t)
				{
					
				}
			}
		});
		btnUpdate.setBounds(43, 287, 116, 40);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MasterLogin AP= new MasterLogin();
				AP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(171, 287, 88, 41);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				HomePage HP=new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(269, 287, 88, 41);
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("");
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Reset-icon.png"));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
				passwordField.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnReset.setBounds(367, 286, 78, 41);
		contentPane.add(btnReset);
		
		JLabel lblEmployeePassword = new JLabel("Admin Password");
		lblEmployeePassword.setBounds(43, 117, 116, 14);
		contentPane.add(lblEmployeePassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Update Admin Password");
		passwordField.setBounds(171, 114, 274, 20);
		contentPane.add(passwordField);
	}
}
