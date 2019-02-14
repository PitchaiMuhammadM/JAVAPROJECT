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
import java.awt.Color;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchEmployeeDetails = new JLabel("Search Employee Details");
		lblSearchEmployeeDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
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
		textField.setToolTipText("Enter Employee ID");
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
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Loupe-icon.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String eid=textField.getText();
					String ro= "Employee";
					String str1="select * from ADDEMPLOYEEPAGE where EMPID='"+eid+"'and ROLL='"+ro+"'";
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
		btnSearch.setBounds(43, 271, 123, 39);
		contentPane.add(btnSearch);
		
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
		btnReset.setBounds(333, 271, 54, 39);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminHomePage AP= new AdminHomePage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(190, 271, 63, 39);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPage AP=new AdminPage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(264, 271, 59, 39);
		contentPane.add(btnHome);
	}

}
