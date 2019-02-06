import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPage = new JLabel("LOGIN PAGE");
		lblAdminPage.setBounds(170, 11, 80, 14);
		contentPane.add(lblAdminPage);
		
		JLabel lblUser = new JLabel("User ID");
		lblUser.setBounds(50, 50, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 88, 72, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(129, 47, 277, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 85, 277, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(50, 133, 46, 14);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select your Role", "Admin", "Employee"}));
		comboBox.setToolTipText("Select your Role\r\nAdmin");
		comboBox.setBounds(129, 130, 277, 20);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Admin Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String u=textField.getText();
					String p=textField_1.getText();
					String r =(String) comboBox.getSelectedItem();
					
					String str="select USERNAME,PASSWORD,ROLE from UIDPSW1 where USERNAME='"+u+"'AND PASSWORD='"+p+"' and ROLE ='"+r+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm =conn.createStatement();
					ResultSet set= stm.executeQuery(str);
					set.next();
					String uname=set.getString(1);
					String pa=set.getString(2);
					if(u.equals(uname)&&p.equals(pa))
					{
						JOptionPane.showMessageDialog(btnLogin, "LoginSucess!!!");
						AdminHomePage CHP = new AdminHomePage();
						CHP.setVisible(true);
						dispose();
					}
				}
				catch(Exception t)
				{
					System.out.println(t);
					JOptionPane.showMessageDialog(btnLogin, "LoginFail!!!");
					
				}
			}
		});
		btnLogin.setBounds(50, 175, 149, 32);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				HomePage HP=new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(170, 218, 108, 32);
		contentPane.add(btnBack);
		
		JButton btnEmployeeLogin = new JButton("Employee Login");
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String u=textField.getText();
					String p=textField_1.getText();
					String r = (String) comboBox.getSelectedItem();
					String str=" select EMPID,EMPPWD ROLL from ADDEMPLOYEEPAGE where EMPID ='"+u+"' and EMPPWD ='"+p+"' and ROLL = '"+r+"' ";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm =conn.createStatement();
					ResultSet set= stm.executeQuery(str);
					set.next();
					String uname = set.getString(1);
					String pass = set.getString(2);
					if(u.equals(uname)&&p.equals(pass))
					{
						JOptionPane.showMessageDialog(btnEmployeeLogin, "LoginSucess!!!");
						EmpHomePage EHP = new EmpHomePage();
						EHP.setVisible(true);
						dispose();
					}	
				}
				catch(Exception t)
				{
					System.out.println(t);
					JOptionPane.showMessageDialog(btnEmployeeLogin, "LoginFail!!!");
					
				}
			}
		});
		btnEmployeeLogin.setBounds(252, 175, 154, 32);
		contentPane.add(btnEmployeeLogin);
	}
}
