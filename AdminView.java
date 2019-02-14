import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AdminView extends JFrame {

	private JPanel contentPane;
	 JPanel panel=new JPanel();
	 JTable table=new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Important code for view tables
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(26, 101, 352, 274);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 332, 253);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
			
				
				JButton btnBack = new JButton("");
				btnBack.setToolTipText("Back");
				btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
				btnBack.setBackground(Color.WHITE);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						MasterLogin AP = new MasterLogin();
						AP.setVisible(true);
						dispose();
					}
				});
				btnBack.setBounds(279, 53, 99, 37);
				contentPane.add(btnBack);
				
				JButton btnViewAllEmp = new JButton("View All Employee");
				btnViewAllEmp.setToolTipText("View All EMPLOYEE Details");
				btnViewAllEmp.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
				btnViewAllEmp.setBackground(Color.WHITE);
				btnViewAllEmp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							String r="Employee";
							String str="select * from ADDEMPLOYEEPAGE where ROLL ='"+r+"'";
							Class.forName("org.h2.Driver");
							Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
							Statement stm =conn.createStatement();
							ResultSet rs=stm.executeQuery(str);
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(btnViewAllEmp, "Searching...");
							
						}
						catch(Exception Y)
						{
							
						}
					}
				});
				btnViewAllEmp.setBounds(26, 39, 243, 23);
				contentPane.add(btnViewAllEmp);
				
				JButton btnNewButton = new JButton("View All Customer Details");
				btnNewButton.setToolTipText("View All Customer Details");
				btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							
							String str="select * from ADDCUSTOMERPAGE1";
							Class.forName("org.h2.Driver");
							Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
							Statement stm =conn.createStatement();
							ResultSet rs=stm.executeQuery(str);
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(btnNewButton, "Searching...");
							
						}
						catch(Exception Y)
						{
							
						}
					}
				});
				btnNewButton.setBounds(26, 67, 243, 23);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_2 = new JButton("View All Admin Details");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							String r="Admin";
							String str="select * from ADDEMPLOYEEPAGE where ROLL ='"+r+"'";
							Class.forName("org.h2.Driver");
							Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
							Statement stm =conn.createStatement();
							ResultSet rs=stm.executeQuery(str);
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(btnNewButton_2, "Searching...");
							
						}
						catch(Exception Y)
						{
							
						}
					}
				});
				btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
				btnNewButton_2.setBackground(Color.WHITE);
				btnNewButton_2.setBounds(26, 11, 243, 23);
				contentPane.add(btnNewButton_2);
	}
}
