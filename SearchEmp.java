import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SearchEmp extends JFrame {

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
					SearchEmp frame = new SearchEmp();
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
	public SearchEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchEmployeeDetails = new JLabel("Search Employee Details");
		lblSearchEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchEmployeeDetails.setBounds(138, 11, 169, 29);
		contentPane.add(lblSearchEmployeeDetails);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(43, 54, 81, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(43, 91, 101, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(43, 130, 81, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhNo = new JLabel("Ph NO:");
		lblPhNo.setBounds(43, 222, 69, 14);
		contentPane.add(lblPhNo);
		
		textField = new JTextField();
		textField.setBounds(190, 51, 197, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 88, 197, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 130, 198, 79);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 219, 197, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String eid=textField.getText();
					String str1="select * from ADDEMPLOYEEPAGE where EMPID='"+eid+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(str1);
					rs.next();
					String pn=rs.getString(2);
					String pp=rs.getString(4);
					String pq=rs.getString(5);
					
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
		btnSearch.setBounds(78, 283, 143, 47);
		contentPane.add(btnSearch);
		
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
		btnReset.setBounds(284, 261, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminHomePage AP= new AdminHomePage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(284, 295, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPage AP=new AdminPage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(284, 329, 89, 23);
		contentPane.add(btnHome);
	}

}
