package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class successfullysubmitted extends JFrame {
	public String mark;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					successfullysubmitted frame = new successfullysubmitted();
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
	public successfullysubmitted() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MARKS OBTAINED:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(293, 292, 325, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("10");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel_1.setBounds(638, 292, 107, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSuccessfullySubmitted = new JLabel("SUCCESSFULLY SUBMITTED!");
		lblSuccessfullySubmitted.setForeground(Color.WHITE);
		lblSuccessfullySubmitted.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblSuccessfullySubmitted.setBounds(218, 195, 515, 59);
		contentPane.add(lblSuccessfullySubmitted);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new index().setVisible(true);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(successfullysubmitted.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_2.setBounds(909, 0, 78, 71);
		contentPane.add(lblNewLabel_2);
	}

	public successfullysubmitted(String marks) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MARKS OBTAINED:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(293, 292, 325, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("10");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel_1.setBounds(638, 292, 107, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSuccessfullySubmitted = new JLabel("SUCCESSFULLY SUBMITTED!");
		lblSuccessfullySubmitted.setForeground(Color.WHITE);
		lblSuccessfullySubmitted.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblSuccessfullySubmitted.setBounds(218, 195, 515, 59);
		contentPane.add(lblSuccessfullySubmitted);
		mark=marks;
		lblNewLabel_1.setText(mark);
	}
}
