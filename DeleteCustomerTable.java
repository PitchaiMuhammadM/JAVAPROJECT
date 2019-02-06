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

public class DeleteCustomerTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCustomerTable frame = new DeleteCustomerTable();
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
	public DeleteCustomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteCustomerTable = new JLabel("Delete Customer Table");
		lblDeleteCustomerTable.setBounds(147, 11, 134, 14);
		contentPane.add(lblDeleteCustomerTable);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(31, 49, 82, 14);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(127, 46, 178, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String CID=textField.getText();
					
					String Query=" DELETE FROM ADDCUSTOMERPAGE1 where CUSTOMERID='"+CID+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(Query);
					
					JOptionPane.showMessageDialog(btnDelete,"Deleted..");
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnDelete.setBounds(147, 107, 134, 63);
		contentPane.add(btnDelete);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				HomePage HP = new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(312, 89, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmpHomePage EHP = new EmpHomePage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(312, 146, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnReset.setBounds(31, 127, 89, 23);
		contentPane.add(btnReset);
	}

}
