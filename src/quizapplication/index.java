package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index i=new index();
				i.setVisible(false);
				new loginadmin().setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(index.class.getResource("/quizapplication/index admin.png")));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(126, 339, 172, 68);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("STUDENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new studentdetails().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon(index.class.getResource("/quizapplication/index student.png")));
		btnNewButton_1.setBounds(602, 339, 180, 68);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(index.class.getResource("/quizapplication/Close.png")));
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_2.setBounds(906, 0, 80, 68);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(544, 137, 275, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(78, 34, 115, 152);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(index.class.getResource("/quizapplication/male-profile.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(73, 137, 275, 333);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Downloads\\administrator (1) (1).png"));
		lblNewLabel_2.setBounds(77, 46, 105, 148);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(index.class.getResource("/quizapplication/index background.png")));
		lblNewLabel.setBounds(0, 0, 986, 563);
		contentPane.add(lblNewLabel);
	}
}
