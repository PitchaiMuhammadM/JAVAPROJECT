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

	
	public FirstPage() {
		
		setTitle("First Page");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 373, 310);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToPpm = new JLabel("Welcome");
		lblWelcomeToPpm.setToolTipText("Welcome to Our Manufacturing Company");
		lblWelcomeToPpm.setBackground(Color.WHITE);
		lblWelcomeToPpm.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblWelcomeToPpm.setForeground(Color.BLACK);
		lblWelcomeToPpm.setBounds(242, 40, 172, 34);
		contentPane.add(lblWelcomeToPpm);
		
		JButton btnTapToOpen = new JButton("PPM ");
		btnTapToOpen.setToolTipText("Tap to Open");
		btnTapToOpen.setSelectedIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Apps-preferences-system-login-icon.png"));
		btnTapToOpen.setForeground(Color.BLACK);
		btnTapToOpen.setIcon(null);
		btnTapToOpen.setBackground(Color.WHITE);
		btnTapToOpen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTapToOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				HomePage HP = new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnTapToOpen.setBounds(225, 98, 118, 34);
		contentPane.add(btnTapToOpen);
		
		JButton btnClose = new JButton("Exit");
		btnClose.setToolTipText("Exit Page");
		btnClose.setForeground(Color.BLACK);
		btnClose.setBackground(Color.WHITE);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnClose.setBounds(225, 186, 118, 23);
		contentPane.add(btnClose);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Company-icon.png"));
		label.setBounds(-15, 11, 247, 249);
		contentPane.add(label);
	}
}
