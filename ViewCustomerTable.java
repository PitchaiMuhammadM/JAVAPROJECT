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

public class ViewCustomerTable extends JFrame {

	private JPanel contentPane;
	 JPanel panel=new JPanel();
	 JTable table=new JTable();
	 private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCustomerTable frame = new ViewCustomerTable();
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
	public ViewCustomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewdata = new JButton("ViewCustomerDetails");
		btnViewdata.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
		btnViewdata.setBackground(Color.WHITE);
		btnViewdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String eid=textField.getText();		
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
		btnViewdata.setBounds(98, 11, 205, 23);
		contentPane.add(btnViewdata);
		//Important code for view tables
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(26, 74, 398, 332);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 378, 310);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				textField = new JTextField();
				textField.setToolTipText("Enter CUSTOMER ID");
				textField.setBackground(Color.WHITE);
				textField.setBounds(26, 11, 62, 57);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JButton btnViewall = new JButton("ViewAll");
				btnViewall.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
				btnViewall.setBackground(Color.WHITE);
				btnViewall.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
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
				btnViewall.setBounds(98, 45, 205, 23);
				contentPane.add(btnViewall);
				
				JButton btnReset = new JButton("");
				btnReset.setToolTipText("Reset");
				btnReset.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Reset-icon.png"));
				btnReset.setBackground(Color.WHITE);
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("");
					}
				});
				btnReset.setBounds(313, 11, 49, 57);
				contentPane.add(btnReset);
				
				JButton btnBack = new JButton("");
				btnBack.setToolTipText("Back");
				btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
				btnBack.setBackground(Color.WHITE);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						EmpHomePage EHP=new EmpHomePage();
						EHP.setVisible(true);
						dispose();
					}
				});
				btnBack.setBounds(372, 11, 52, 57);
				contentPane.add(btnBack);
	}
}