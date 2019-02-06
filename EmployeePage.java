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

public class EmployeePage extends JFrame {

	private JPanel contentPane;
	 JPanel panel=new JPanel();
	 JTable table=new JTable();
	 private JTextField txtEmpId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePage frame = new EmployeePage();
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
	public EmployeePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnViewdata = new JButton("View Employee Details");
		btnViewdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String eid=txtEmpId.getText();		
					String str="select * from ADDEMPLOYEEPAGE where EMPID ='"+eid+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm =conn.createStatement();
					ResultSet rs=stm.executeQuery(str);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					JOptionPane.showMessageDialog(btnViewdata, "Searching...");
					
				}
				catch(Exception Y)
				{
					
				}
			}
		});
		btnViewdata.setBounds(122, 11, 178, 23);
		contentPane.add(btnViewdata);
		//Important code for view tables
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(26, 108, 398, 298);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 378, 310);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				txtEmpId = new JTextField();
				txtEmpId.setToolTipText("EMP ID");
				txtEmpId.setBounds(26, 11, 86, 52);
				contentPane.add(txtEmpId);
				txtEmpId.setColumns(10);
				
				JButton btnViewdata_2 = new JButton("View Customer Details");
				btnViewdata_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							String eid=txtEmpId.getText();		
							String str="select * from ADDCUSTOMERPAGE1 where CUSTOMERID ='"+eid+"'";
							Class.forName("org.h2.Driver");
							Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
							Statement stm =conn.createStatement();
							ResultSet rs=stm.executeQuery(str);
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(btnViewdata, "Searching...");
							
						}
						catch(Exception Y)
						{
							
						}
					}
				});
				btnViewdata_2.setBounds(122, 40, 178, 23);
				contentPane.add(btnViewdata_2);
				
				JButton btnReset = new JButton("Reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						txtEmpId.setText("");
					}
				});
				btnReset.setBounds(166, 74, 89, 23);
				contentPane.add(btnReset);
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						AdminHomePage AP = new AdminHomePage();
						AP.setVisible(true);
						dispose();
					}
				});
				btnBack.setBounds(275, 74, 89, 23);
				contentPane.add(btnBack);
				
				JButton btnViewAllEmp = new JButton("View All EMP");
				btnViewAllEmp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							
							String str="select * from ADDEMPLOYEEPAGE";
							Class.forName("org.h2.Driver");
							Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
							Statement stm =conn.createStatement();
							ResultSet rs=stm.executeQuery(str);
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(btnViewdata, "Searching...");
							
						}
						catch(Exception Y)
						{
							
						}
					}
				});
				btnViewAllEmp.setBounds(310, 11, 114, 23);
				contentPane.add(btnViewAllEmp);
				
				JButton btnNewButton = new JButton("View All Cust");
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
							JOptionPane.showMessageDialog(btnViewdata, "Searching...");
							
						}
						catch(Exception Y)
						{
							
						}
					}
				});
				btnNewButton.setBounds(310, 40, 114, 23);
				contentPane.add(btnNewButton);
	}
}
