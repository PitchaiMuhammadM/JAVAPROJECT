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

public class DelEmp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelEmp frame = new DelEmp();
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
	public DelEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 206);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteEmployeeDetails = new JLabel("Delete Employee Details");
		lblDeleteEmployeeDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeleteEmployeeDetails.setBounds(80, 11, 179, 31);
		contentPane.add(lblDeleteEmployeeDetails);
		
		JLabel lblEmpId = new JLabel("Emp ID");
		lblEmpId.setBounds(28, 70, 46, 14);
		contentPane.add(lblEmpId);
		
		textField = new JTextField();
		textField.setToolTipText("Enter the Employee Id");
		textField.setBounds(84, 67, 188, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete the Employee Id");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\delete-icon.png"));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String EID=textField.getText();
					String R = "Employee";
					String Query=" DELETE FROM ADDEMPLOYEEPAGE where EMPID='"+EID+"'AND ROLL='"+R+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(Query);
					
					JOptionPane.showMessageDialog(btnDelete,"Deleted..");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}

			}
		});
		btnDelete.setBounds(30, 110, 188, 39);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminHomePage HP=new AdminHomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(228, 110, 46, 39);
		contentPane.add(btnBack);
	}

}
