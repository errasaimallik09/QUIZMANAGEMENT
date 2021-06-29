package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginadmin extends JFrame {

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
					loginadmin frame = new loginadmin();
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
	public loginadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(296, 64, 334, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 53, 149, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setBounds(20, 40, 102, 48);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 108, 149, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(30, 98, 92, 48);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.GRAY);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("SHOW PASSWORD");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(95, 186, 140, 21);
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setForeground(Color.GRAY);
		chckbxNewCheckBox.setFont(new Font("Verdana", Font.BOLD, 10));
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("admin") &&  passwordField.getText().equals("esm123456") ){
					setVisible(false);
					new adminhome().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Password or UserName","Title",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton.setIcon(new ImageIcon(loginadmin.class.getResource("/quizapplication/check-sm.png")));
		btnNewButton.setBounds(30, 296, 109, 48);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new index().setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(loginadmin.class.getResource("/quizapplication/goback.png")));
		btnBack.setFont(new Font("Verdana", Font.BOLD, 10));
		btnBack.setBounds(189, 296, 109, 48);
		panel.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(loginadmin.class.getResource("/quizapplication/login Background.PNG")));
		lblNewLabel_2.setBounds(0, 0, 976, 563);
		contentPane.add(lblNewLabel_2);
	}
}
