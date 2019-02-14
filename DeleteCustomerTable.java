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
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 382, 198);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteCustomerTable = new JLabel("Delete Customer Table");
		lblDeleteCustomerTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeleteCustomerTable.setBounds(102, 21, 199, 14);
		contentPane.add(lblDeleteCustomerTable);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(10, 49, 82, 14);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setToolTipText("Enter the Customer ID");
		textField.setBounds(102, 46, 250, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete the Customer Id");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\delete-icon.png"));
		btnDelete.setBackground(Color.WHITE);
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
		btnDelete.setBounds(10, 89, 134, 46);
		contentPane.add(btnDelete);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				HomePage HP = new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(154, 89, 59, 46);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmpHomePage EHP = new EmpHomePage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(223, 89, 59, 46);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("");
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Reset-icon.png"));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnReset.setBounds(293, 89, 59, 46);
		contentPane.add(btnReset);
	}

}
