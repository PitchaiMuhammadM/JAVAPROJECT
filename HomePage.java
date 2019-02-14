import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 481, 333);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPpmManufacturingCompany = new JLabel("PPM Manufacturing Company");
		lblPpmManufacturingCompany.setFont(new Font("Altenglisch MF", Font.PLAIN, 16));
		lblPpmManufacturingCompany.setBackground(Color.BLACK);
		lblPpmManufacturingCompany.setForeground(Color.BLACK);
		lblPpmManufacturingCompany.setBounds(115, 11, 301, 27);
		contentPane.add(lblPpmManufacturingCompany);
		
		JButton btnAdminLogin = new JButton("LOGIN PAGE");
		btnAdminLogin.setToolTipText("Login Admin & Emp");
		btnAdminLogin.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Login-in-icon.png"));
		btnAdminLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage AP=new AdminPage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnAdminLogin.setBackground(Color.WHITE);
		btnAdminLogin.setBounds(277, 68, 166, 27);
		contentPane.add(btnAdminLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setToolTipText("Here can register the Emp  & Customer");
		btnRegister.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Notes-icon.png"));
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setForeground(Color.BLACK);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterHomePage RHP = new RegisterHomePage();
				RHP.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(277, 134, 166, 27);
		contentPane.add(btnRegister);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("You can go to the Home page");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FirstPage FP=new FirstPage();
				FP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(344, 213, 39, 27);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Apps-preferences-system-login-icon.png"));
		label.setBounds(10, 48, 272, 241);
		contentPane.add(label);
	}
}
