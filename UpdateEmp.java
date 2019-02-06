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

public class UpdateEmp extends JFrame {

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
					UpdateEmp frame = new UpdateEmp();
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
	public UpdateEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateemployeeDetails = new JLabel("UpdateEmployee Details");
		lblUpdateemployeeDetails.setBounds(185, 11, 144, 14);
		contentPane.add(lblUpdateemployeeDetails);
		
		JLabel lblEmloyeeId = new JLabel("Emloyee ID");
		lblEmloyeeId.setBounds(43, 39, 82, 14);
		contentPane.add(lblEmloyeeId);
		
		JLabel lblNewLabel = new JLabel("Employee Name");
		lblNewLabel.setBounds(43, 81, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(43, 154, 82, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhNo = new JLabel("Ph NO:");
		lblPhNo.setBounds(43, 275, 69, 14);
		contentPane.add(lblPhNo);
		
		textField = new JTextField();
		textField.setBounds(171, 36, 274, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 78, 272, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(171, 154, 274, 69);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(171, 272, 274, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					
					String ED=textField.getText();
					String EN=textField_1.getText();
					
					String EPWD=textField_2.getText();
					
					String EADD=textField_3.getText();
					
					String ERL=textField_5.getText(); 
					
					String EPH=textField_4.getText();
					
					
					
					String str="update ADDEMPLOYEEPAGE set EMPNAME='"+EN+"', EMPPWD='"+EPWD+"', EMPADD='"+EADD+"', EMPPH='"+EPH+"', ROLL='"+ERL+"' where EMPID='"+ED+"'";
					
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
		btnUpdate.setBounds(43, 315, 153, 63);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminHomePage AP= new AdminHomePage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(356, 315, 89, 23);
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
		btnHome.setBounds(240, 315, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnReset.setBounds(294, 355, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblEmployeePassword = new JLabel("Employee Password");
		lblEmployeePassword.setBounds(43, 117, 169, 14);
		contentPane.add(lblEmployeePassword);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setBounds(43, 237, 46, 14);
		contentPane.add(lblRollNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(171, 114, 274, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(171, 234, 272, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
