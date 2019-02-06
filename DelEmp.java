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
		setBounds(100, 100, 450, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteEmployeeDetails = new JLabel("Delete Employee Details");
		lblDeleteEmployeeDetails.setBounds(148, 11, 141, 14);
		contentPane.add(lblDeleteEmployeeDetails);
		
		JLabel lblEmpId = new JLabel("Emp ID");
		lblEmpId.setBounds(71, 70, 46, 14);
		contentPane.add(lblEmpId);
		
		textField = new JTextField();
		textField.setBounds(159, 67, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String EID=textField.getText();
					
					String Query=" DELETE FROM ADDEMPLOYEEPAGE where EMPID='"+EID+"'";
					
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
		btnDelete.setBounds(193, 122, 89, 51);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminHomePage HP=new AdminHomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(320, 136, 89, 23);
		contentPane.add(btnBack);
	}

}
