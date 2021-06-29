package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentinstructions extends JFrame {
	public  String roll;

	private JPanel contentPane;
	private JTextArea txtrTheExamination;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentinstructions frame = new studentinstructions();
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
	public studentinstructions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(studentinstructions.class.getResource("/quizapplication/index student.png")));
		lblNewLabel.setBounds(0, 0, 68, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INSTRUCTIONS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(69, 0, 332, 68);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrTheExamination = new JTextArea();
		txtrTheExamination.setText("1. The examination will comprise of Objective type Multiple Choice Questions (MCQs)\r\n2. All questions are compulsory and each carries One mark.\r\n3. The total number of questions, duration of examination, will be different based on\r\nthe course, the detail is available on your screen.\r\n4. The Subjects or topics covered in the exam will be as per the Syllabus.\r\n5. There will be NO NEGATIVE MARKING for the wrong answers.\r\nNO OF QUESTIONS:10\r\nEACH QUESTION HAS MARKS:1\r\n");
		txtrTheExamination.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		txtrTheExamination.setBounds(28, 107, 867, 416);
		contentPane.add(txtrTheExamination);
		
		JButton btnNewButton = new JButton("START EXAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new quizexamstudent(roll).setVisible(true);
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(studentinstructions.class.getResource("/quizapplication/check-sm.png")));
		btnNewButton.setBounds(407, 557, 197, 47);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 65, 976, 2);
		contentPane.add(separator);
	}
	public studentinstructions(String rollno1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 651);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(studentinstructions.class.getResource("/quizapplication/index student.png")));
		lblNewLabel.setBounds(0, 0, 68, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INSTRUCTIONS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(69, 0, 332, 68);
		contentPane.add(lblNewLabel_1);
		JTextArea txtrTheExamination = new JTextArea();
		txtrTheExamination.setText("1. The examination will comprise of Objective type Multiple Choice Questions (MCQs)\r\n2. All questions are compulsory and each carries One mark.\r\n3. The total number of questions, duration of examination, will be different based on\r\nthe course, the detail is available on your screen.\r\n4. The Subjects or topics covered in the exam will be as per the Syllabus.\r\n5. There will be NO NEGATIVE MARKING for the wrong answers.\r\nNO OF QUESTIONS:10\r\nEACH QUESTION HAS MARKS:1\r\n");
		txtrTheExamination.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		txtrTheExamination.setBounds(28, 107, 867, 416);
		contentPane.add(txtrTheExamination);
		JButton btnNewButton = new JButton("START EXAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new quizexamstudent(roll).setVisible(true);
				
			}
		});
		
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(studentinstructions.class.getResource("/quizapplication/check-sm.png")));
		btnNewButton.setBounds(407, 557, 197, 47);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 65, 976, 2);
		contentPane.add(separator);
		txtrTheExamination.setEditable(false);
		roll=rollno1;
		
	}
}
