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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class AdminPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		
		setTitle("AdminPage");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPage = new JLabel("LOGIN PAGE");
		lblAdminPage.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAdminPage.setBounds(170, 11, 132, 14);
		contentPane.add(lblAdminPage);
		
		JLabel lblUser = new JLabel("ID");
		lblUser.setBounds(123, 50, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(123, 81, 72, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setToolTipText("Admin ID or Employee ID");
		textField.setBounds(223, 47, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(123, 112, 46, 14);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select your Role", "Master", "Admin", "Employee"}));
		comboBox.setToolTipText("Select your Role\r\nAdmin");
		comboBox.setBounds(223, 109, 183, 20);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Login");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Login-in-icon.png"));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String u=textField.getText();
					String p=passwordField.getText();
					String r =(String) comboBox.getSelectedItem();
					
					String str=" select EMPID,EMPPWD, ROLL from ADDEMPLOYEEPAGE where EMPID ='"+u+"' and EMPPWD ='"+p+"' and ROLL = '"+r+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm =conn.createStatement();
					ResultSet set= stm.executeQuery(str);
					set.next();
					String uname=set.getString(1);
					String pa=set.getString(2);
					
					if(u.equals(uname)&&p.equals(pa))
					{
							switch(r)
							{
							case "Master":
								JOptionPane.showMessageDialog(btnLogin, "Master Page Login Sucess!!!");
								MasterLogin MP = new MasterLogin();
								MP.setVisible(true);
								dispose();
								break;
							case "Admin" :
								JOptionPane.showMessageDialog(btnLogin, "Admin Page Login Sucess!!!");
								AdminHomePage EoHP = new AdminHomePage();
								EoHP.setVisible(true);
								dispose();
								break;
							case "Employee" :
								JOptionPane.showMessageDialog(btnLogin, "Employee Page LoginSucess!!!");
								EmpHomePage EHP = new EmpHomePage();
								EHP.setVisible(true);
								dispose();
								break;
							}
							
					}
					
				}
				catch(Exception t)
				{
					System.out.println(t);
					JOptionPane.showMessageDialog(btnLogin, "Invalid Input...!");
				}
			}
		});
		btnLogin.setBounds(123, 155, 129, 38);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				HomePage HP=new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(351, 155, 57, 38);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Laptop-icon.png"));
		label.setBounds(27, 50, 72, 83);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 78, 183, 20);
		contentPane.add(passwordField);
	}
}
