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

public class AddEmployeePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_5;

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
		setBounds(100, 100, 503, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddEmployeePage = new JLabel("Add Employee Page");
		lblAddEmployeePage.setBounds(178, 11, 150, 14);
		contentPane.add(lblAddEmployeePage);
		
		JLabel lblNewUserId = new JLabel("Employee ID");
		lblNewUserId.setBounds(53, 50, 88, 14);
		contentPane.add(lblNewUserId);
		
		JLabel lblNewPassword = new JLabel("Employee Name");
		lblNewPassword.setBounds(53, 75, 135, 14);
		contentPane.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setBounds(198, 47, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 78, 254, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(53, 187, 60, 14);
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(198, 182, 255, 95);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhNo = new JLabel("Ph NO:");
		lblPhNo.setBounds(53, 291, 88, 14);
		contentPane.add(lblPhNo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(198, 288, 255, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			private JComboBox comboBox;

			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
				String eid=textField.getText();
				String ename=textField_1.getText();
				
				String epwd=textField_2.getText();
				
				String eadd=textField_3.getText();
				
				String ERL=textField_5.getText();
				
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
		btnNewButton.setBounds(53, 338, 140, 55);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CustomerHomePage RHP=new CustomerHomePage();
				RHP.setVisible(true);
				dispose();
			}
			
		});
		btnBack.setBounds(364, 338, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				HomePage HP= new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(203, 336, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_2.setText("");
				textField_5.setText("");
			}
		});
		btnReset.setBounds(291, 370, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblEmployeePassword = new JLabel("Employee Password");
		lblEmployeePassword.setBounds(53, 112, 199, 14);
		contentPane.add(lblEmployeePassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 109, 255, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(53, 147, 46, 14);
		contentPane.add(lblRole);
		
		textField_5 = new JTextField();
		textField_5.setBounds(198, 144, 255, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
