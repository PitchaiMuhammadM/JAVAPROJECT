import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPpmManufacturingCompany = new JLabel("PPM Manufacturing Company");
		lblPpmManufacturingCompany.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
		lblPpmManufacturingCompany.setBackground(Color.BLACK);
		lblPpmManufacturingCompany.setForeground(Color.WHITE);
		lblPpmManufacturingCompany.setBounds(119, 11, 335, 27);
		contentPane.add(lblPpmManufacturingCompany);
		
		JButton btnAdminLogin = new JButton("LOGIN PAGE");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage AP=new AdminPage();
				AP.setVisible(true);
				dispose();
			}
		});
		btnAdminLogin.setBackground(Color.WHITE);
		btnAdminLogin.setBounds(10, 81, 414, 23);
		contentPane.add(btnAdminLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterHomePage RHP = new RegisterHomePage();
				RHP.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(10, 141, 414, 23);
		contentPane.add(btnRegister);
		
		JButton btnHome = new JButton("Main Page");
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FirstPage FP=new FirstPage();
				FP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(157, 208, 121, 23);
		contentPane.add(btnHome);
	}

}
