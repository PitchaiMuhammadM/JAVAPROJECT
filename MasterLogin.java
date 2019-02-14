import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MasterLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterLogin frame = new MasterLogin();
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
	public MasterLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 428, 274);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeHomepage = new JLabel("Admin Page");
		lblEmployeeHomepage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmployeeHomepage.setBounds(142, 11, 187, 25);
		contentPane.add(lblEmployeeHomepage);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setToolTipText("ViewCustomerDetails");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\view-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AdminView VCT=new AdminView();
				VCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(189, 58, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setToolTipText("Search Customer Details");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Loupe-icon.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminSearch SCT=new AdminSearch();
				SCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(189, 103, 95, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setToolTipText("Update Customer Details");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\news-icon.png"));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminUpdate UCT=new AdminUpdate();
				UCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(189, 148, 95, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setToolTipText("Delete Customer Details");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\delete-icon.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminDel DCT= new AdminDel();
				DCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(189, 196, 95, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnHome = new JButton("");
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Very-Basic-Home-Filled-icon.png"));
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage EHP=new AdminPage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(301, 58, 85, 68);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("");
		btnBack.setToolTipText("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\Back-2-2-icon.png"));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminPage EHP=new AdminPage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(301, 148, 85, 71);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Pitchai Muhammad M\\Desktop\\icons\\users-icon.png"));
		label.setBounds(36, 25, 143, 210);
		contentPane.add(label);
	}

}
