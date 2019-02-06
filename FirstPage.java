import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class FirstPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToPpm = new JLabel("Welcome to PPM");
		lblWelcomeToPpm.setBackground(Color.WHITE);
		lblWelcomeToPpm.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblWelcomeToPpm.setForeground(Color.WHITE);
		lblWelcomeToPpm.setBounds(143, 30, 172, 34);
		contentPane.add(lblWelcomeToPpm);
		
		JButton btnTapToOpen = new JButton("Tap to Open Home Page Our PPM Company");
		btnTapToOpen.setForeground(Color.BLACK);
		btnTapToOpen.setIcon(null);
		btnTapToOpen.setBackground(Color.WHITE);
		btnTapToOpen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTapToOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				HomePage HP=new HomePage();
				HP.setVisible(true);
				dispose();
			}
			
		});
		btnTapToOpen.setBounds(10, 75, 414, 96);
		contentPane.add(btnTapToOpen);
		
		JButton btnClose = new JButton("Exit");
		btnClose.setForeground(Color.BLACK);
		btnClose.setBackground(Color.WHITE);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnClose.setBounds(10, 197, 414, 23);
		contentPane.add(btnClose);
	}
}
