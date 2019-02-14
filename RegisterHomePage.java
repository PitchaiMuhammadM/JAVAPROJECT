import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class RegisterHomePage extends JFrame {

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
					RegisterHomePage frame = new RegisterHomePage();
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
	public RegisterHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterHomePage = new JLabel("Register Home Page");
		lblRegisterHomePage.setFont(new Font("Altenglisch MF", Font.PLAIN, 16));
		lblRegisterHomePage.setBounds(119, 11, 219, 24);
		contentPane.add(lblRegisterHomePage);
		
		JLabel lblUsername = new JLabel("ID");
		lblUsername.setBounds(169, 53, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(169, 90, 76, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setToolTipText("ADMIN OR EMPLOYEE OR CUSTOMER ID");
		textField.setBounds(244, 50, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setToolTipText("Select Role");
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Role", "Master", "Admin", "Employee"}));
		comboBox.setBounds(244, 125, 168, 20);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Register Login");
		btnLogin.setToolTipText("Register Login");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Login-in-icon.png"));
		btnLogin.addActionListener(new ActionListener() 
		{
			private JComboBox comboBox_1;

			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String u=textField.getText();
					String p=passwordField.getText();
					String r =(String) comboBox.getSelectedItem();
					
					String str=" select EMPID,EMPPWD,ROLL from ADDEMPLOYEEPAGE where EMPID ='"+u+"' and EMPPWD ='"+p+"' AND ROLL ='"+r+"'";
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
											case "Master" :
												JOptionPane.showMessageDialog(btnLogin, "Opening Admin add page!!!");
												AddAdminPage AAP = new AddAdminPage();
												AAP.setVisible(true);
												dispose();
												break;
											case "Admin" :
												JOptionPane.showMessageDialog(btnLogin, "Opening Employee add Page!!!");
												AddEmployeePage EoHP = new AddEmployeePage();
												EoHP.setVisible(true);
												dispose();
												break;
											case "Employee" :
												JOptionPane.showMessageDialog(btnLogin, "Opening Customer Add Page!!!");
												AddCustomerPage EHP = new AddCustomerPage();
												EHP.setVisible(true);
												dispose();
												break;
										}
								
								}
					
				}
				catch(Exception e)
				{
					System.out.println(e);
					JOptionPane.showMessageDialog(btnLogin, "Invalid Input...!");
				}
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(158, 169, 138, 32);
		contentPane.add(btnLogin);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Reset");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Reset-icon.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(310, 169, 53, 32);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				HomePage HP= new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(369, 169, 43, 32);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Document-Copy-icon.png"));
		label.setBounds(10, 21, 138, 152);
		contentPane.add(label);
		
		JLabel lblSelectRole = new JLabel("Select Role");
		lblSelectRole.setBounds(169, 128, 94, 14);
		contentPane.add(lblSelectRole);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(244, 87, 168, 20);
		contentPane.add(passwordField);
		
	}
}
