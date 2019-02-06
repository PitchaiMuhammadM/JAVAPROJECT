import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.h2.util.StatementBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class RegisterHomePage extends JFrame {

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
		setBounds(100, 100, 521, 313);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterhomepage = new JLabel("RegisterHomePage");
		lblRegisterhomepage.setBackground(new Color(0, 0, 0));
		lblRegisterhomepage.setForeground(new Color(0, 0, 0));
		lblRegisterhomepage.setFont(new Font("Altenglisch MF", Font.PLAIN, 16));
		lblRegisterhomepage.setBounds(170, 11, 192, 23);
		contentPane.add(lblRegisterhomepage);
		
		JLabel lblNewUserId = new JLabel("User ID");
		lblNewUserId.setForeground(Color.BLACK);
		lblNewUserId.setBounds(55, 60, 84, 14);
		contentPane.add(lblNewUserId);
		
		textField = new JTextField();
		textField.setBounds(149, 57, 240, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewpassword = new JLabel("Password");
		lblNewpassword.setForeground(Color.BLACK);
		lblNewpassword.setBounds(52, 109, 106, 14);
		contentPane.add(lblNewpassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 106, 240, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String u=textField.getText();
					String p=textField_1.getText();
					String str="select USERNAME,PASSWORD from UIDPSW1 where USERNAME='"+u+"'or PASSWORD='"+p+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm =conn.createStatement();
					ResultSet set= stm.executeQuery(str);
					set.next();
					String uname=set.getString(1);
					String pa=set.getString(2);
					if(u.equals(uname)&&p.equals(pa))
					{
						JOptionPane.showMessageDialog(btnNewButton, "LoginSucess!!!");
						CustomerHomePage CHP = new CustomerHomePage();
						CHP.setVisible(true);
						dispose();
					}
				}
				catch(Exception t)
				{
					System.out.println(t);
					JOptionPane.showMessageDialog(btnNewButton, "LoginFail!!!");
					
				}
			}
		});
		btnNewButton.setBounds(115, 166, 118, 56);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.DARK_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnReset.setBounds(289, 156, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				HomePage HP= new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(289, 210, 89, 23);
		contentPane.add(btnBack);
	}
}
