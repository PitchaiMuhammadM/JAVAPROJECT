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
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;

public class AddEmployeePage extends JFrame {

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
					AddEmployeePage frame = new AddEmployeePage();
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
	public AddEmployeePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 409);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddEmployeePage = new JLabel("Add Employee Page");
		lblAddEmployeePage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddEmployeePage.setBounds(178, 11, 150, 25);
		contentPane.add(lblAddEmployeePage);
		
		JLabel lblNewUserId = new JLabel("Employee ID");
		lblNewUserId.setBounds(53, 50, 88, 14);
		contentPane.add(lblNewUserId);
		
		JLabel lblNewPassword = new JLabel("Employee Name");
		lblNewPassword.setBounds(53, 81, 135, 14);
		contentPane.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setToolTipText("Enter New Employee ID");
		textField.setBounds(198, 47, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Employee Name");
		textField_1.setBounds(198, 78, 254, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(53, 187, 60, 14);
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setToolTipText("Enter the Employee Address");
		textField_3.setBounds(198, 147, 255, 95);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhNo = new JLabel("Ph NO:");
		lblPhNo.setBounds(53, 267, 88, 14);
		contentPane.add(lblPhNo);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Enter the Employee Phone Number");
		textField_4.setBounds(198, 264, 255, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setToolTipText("Submit the DATA");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Login-in-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			private JComboBox comboBox;
			private JComboBox roleSelection;
			private JLabel chckbxEmployee;

			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
				String eid=textField.getText();
				String ename=textField_1.getText();
				
				String epwd=passwordField.getText();
				
				String eadd=textField_3.getText();
				
				String ERL="Employee";
				
				String eph=textField_4.getText();
				
				String str="insert into ADDEMPLOYEEPAGE values('"+eid+"','"+ename+"','"+epwd+"','"+eadd+"','"+eph+"','"+ERL+"')";
				
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
		btnNewButton.setBounds(53, 311, 112, 37);
		contentPane.add(btnNewButton);
		
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
		btnBack.setBounds(299, 311, 60, 37);
		contentPane.add(btnBack);
		
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
		btnHome.setBounds(198, 311, 60, 37);
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
				textField_3.setText("");
				textField_4.setText("");
				passwordField.setText("");
				
			}
		});
		btnReset.setBounds(393, 311, 60, 37);
		contentPane.add(btnReset);
		
		JLabel lblEmployeePassword = new JLabel("Employee Password");
		lblEmployeePassword.setBounds(53, 112, 135, 14);
		contentPane.add(lblEmployeePassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter New Employee Password");
		passwordField.setBounds(198, 109, 255, 20);
		contentPane.add(passwordField);
	}
}
