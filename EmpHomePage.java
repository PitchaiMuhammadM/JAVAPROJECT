import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpHomePage frame = new EmpHomePage();
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
	public EmpHomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeHomepage = new JLabel("Employee HomePage");
		lblEmployeeHomepage.setBounds(166, 11, 133, 14);
		contentPane.add(lblEmployeeHomepage);
		
		JButton btnNewButton = new JButton("ViewCustomerDetails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ViewCustomerTable VCT=new ViewCustomerTable();
				VCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(102, 46, 242, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search Customer Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SearchCutomerTable SCT=new SearchCutomerTable();
				SCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(102, 99, 242, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Customer Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateCustomerTable UCT=new UpdateCustomerTable();
				UCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(105, 149, 239, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Customer Details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DeleteCustomerTable DCT= new DeleteCustomerTable();
				DCT.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(102, 201, 242, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage EHP=new AdminPage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(47, 257, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminPage EHP=new AdminPage();
				EHP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(300, 257, 89, 23);
		contentPane.add(btnBack);
	}

}
