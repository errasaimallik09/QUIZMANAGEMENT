package quizapplication;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class quizexamstudent extends JFrame {
	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7_6;
	private JLabel lblNewLabel_7_5;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_7_8;
	private JLabel  lblNewLabel_7_9;
	public JRadioButton rdbtnNewRadioButton;
	public JRadioButton rdbtnOption,rdbtnOption_1,rdbtnOption_2;
	private  JButton btnNewButton_1,btnNewButton_1_1;
	public String quesid="1";
	public String ans;
	public int min=0;
	public int sec=0;
	public int marks=0;
	
	/**
	 * Launch the application.
	 */
	
	
	Connection conn;
	PreparedStatement pst;
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/quizsystem","root","");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(addquestion.class.getName()).log(Level.SEVERE,null,e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(addquestion.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	public void answerCheck() {
		String studentans="";
		if(rdbtnNewRadioButton.isSelected()) {
			studentans=rdbtnNewRadioButton.getText();
		}
		else if(rdbtnOption.isSelected()) {
			studentans=rdbtnOption.getText();
		}
		else if(rdbtnOption_1.isSelected()) {
			studentans=rdbtnOption_1.getText();
		}
		else  {
			studentans=rdbtnOption_2.getText();
		}
		if(studentans.equals(ans)) {
			marks=marks+1;
			String marks1=String.valueOf(marks);
			lblNewLabel_7_9.setText(marks1);
		}
		//question number change
		int quesid1=Integer.parseInt(quesid);
		quesid1=quesid1+1;
		quesid=String.valueOf(quesid1);
		
		
			rdbtnNewRadioButton.setSelected(false);
			rdbtnOption.setSelected(false);
			rdbtnOption_1.setSelected(false);
			rdbtnOption_2.setSelected(false);
		
		//last question
		if(quesid.equals("10")) {
			btnNewButton_1.setVisible(false);
		}
	}
	public void question() {
		try {
			Statement	st = conn.createStatement();
				 ResultSet rsl=st.executeQuery("select * from question where id='"+quesid+"'");
				 while(rsl.next()) {
					 lblNewLabel_7_8.setText(rsl.getString(1));
					 lblNewLabel_8.setText(rsl.getString(2));
					 rdbtnNewRadioButton.setText(rsl.getString(3));
					 rdbtnOption.setText(rsl.getString(4));
					 rdbtnOption_1.setText(rsl.getString(5));
					 rdbtnOption_2.setText(rsl.getString(6));
					 ans=rsl.getString(7);
				 }
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
	}
	public void submit() {
		String rollnum=lblNewLabel_7_5.getText();
		answerCheck();
		try {
			Statement st=conn.createStatement();
			st.executeUpdate("update student set marks='"+marks+"' where rollno='"+rollnum+"'");
			String marks1=String.valueOf(marks);
			setVisible(false);
			new successfullysubmitted(marks1).setVisible(true);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizexamstudent frame = new quizexamstudent();
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
	public quizexamstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1186, 121);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(quizexamstudent.class.getResource("/quizapplication/index student.png")));
		lblNewLabel.setBounds(0, 0, 68, 82);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(73, 0, 242, 82);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL TIME:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(827, 10, 166, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("10 MIN");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(1022, 10, 68, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("TIME TAKEN:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(827, 62, 146, 32);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("00");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setBounds(985, 66, 36, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("00");
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(1031, 66, 36, 25);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("DATE:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(434, 31, 74, 37);
		panel.add(lblNewLabel_5);
		
		 lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(538, 25, 124, 49);
		panel.add(lblNewLabel_6);
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(0, 120, 366, 543);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ROLL NUMBER:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(10, 42, 147, 40);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("NAME:");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_1.setBounds(10, 107, 83, 40);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("TOTAL QUESTION:");
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_2.setBounds(10, 184, 172, 40);
		panel_1.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("QUESTION NUMBER:");
		lblNewLabel_7_3.setForeground(Color.WHITE);
		lblNewLabel_7_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_3.setBounds(10, 274, 208, 40);
		panel_1.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_4 = new JLabel("MARKS OBTAINED:");
		lblNewLabel_7_4.setForeground(Color.WHITE);
		lblNewLabel_7_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_4.setBounds(10, 357, 191, 40);
		panel_1.add(lblNewLabel_7_4);
		
		 lblNewLabel_7_5 = new JLabel("01");
		lblNewLabel_7_5.setForeground(Color.WHITE);
		lblNewLabel_7_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_5.setBounds(169, 42, 147, 40);
		panel_1.add(lblNewLabel_7_5);
		
		 lblNewLabel_7_6 = new JLabel("MALLIK");
		lblNewLabel_7_6.setForeground(Color.WHITE);
		lblNewLabel_7_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_6.setBounds(138, 107, 147, 40);
		panel_1.add(lblNewLabel_7_6);
		
		JLabel lblNewLabel_7_7 = new JLabel("10");
		lblNewLabel_7_7.setForeground(Color.WHITE);
		lblNewLabel_7_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_7.setBounds(192, 184, 147, 40);
		panel_1.add(lblNewLabel_7_7);
		
		 lblNewLabel_7_8 = new JLabel("01");
		lblNewLabel_7_8.setForeground(Color.WHITE);
		lblNewLabel_7_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_8.setBounds(228, 274, 42, 40);
		panel_1.add(lblNewLabel_7_8);
		
		 lblNewLabel_7_9 = new JLabel("00");
		lblNewLabel_7_9.setForeground(Color.WHITE);
		lblNewLabel_7_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_9.setBounds(220, 357, 50, 40);
		panel_1.add(lblNewLabel_7_9);
		
		lblNewLabel_8 = new JLabel("QUESTION?");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_8.setBounds(401, 152, 775, 86);
		contentPane.add(lblNewLabel_8);
		
		 rdbtnNewRadioButton = new JRadioButton("OPTION1");
		
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(401, 244, 634, 37);
		contentPane.add(rdbtnNewRadioButton);
		
	 rdbtnOption = new JRadioButton("OPTION2");
		
		rdbtnOption.setBackground(new Color(255, 255, 255));
		rdbtnOption.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnOption.setBounds(401, 327, 719, 37);
		contentPane.add(rdbtnOption);
		
		 rdbtnOption_1 = new JRadioButton("OPTION3");
		
		rdbtnOption_1.setBackground(new Color(255, 255, 255));
		rdbtnOption_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnOption_1.setBounds(401, 416, 719, 37);
		contentPane.add(rdbtnOption_1);
		
		rdbtnOption_2 = new JRadioButton("OPTION4");
		
		rdbtnOption_2.setBackground(new Color(255, 255, 255));
		rdbtnOption_2.setForeground(new Color(0, 0, 0));
		rdbtnOption_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnOption_2.setBounds(401, 498, 719, 37);
		contentPane.add(rdbtnOption_2);
		
	
		
		
		 btnNewButton_1 = new JButton("NEXT");
		
		btnNewButton_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1.setIcon(new ImageIcon(quizexamstudent.class.getResource("/quizapplication/Next.png")));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setBounds(514, 584, 134, 50);
		contentPane.add(btnNewButton_1);
		
		 btnNewButton_1_1 = new JButton("SUBMIT");
		
		btnNewButton_1_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1_1.setIcon(new ImageIcon(quizexamstudent.class.getResource("/quizapplication/save.png")));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1_1.setBounds(901, 584, 134, 50);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerCheck();
				question();
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to exit.","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					answerCheck();
					submit();
				}
			}
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnOption.setSelected(false);
					rdbtnOption_1.setSelected(false);
					rdbtnOption_2.setSelected(false);
				}
			}
		});
		rdbtnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnOption.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnOption_1.setSelected(false);
					rdbtnOption_2.setSelected(false);
				}
			}
		});
		rdbtnOption_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnOption_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnOption.setSelected(false);
					rdbtnOption_2.setSelected(false);
				}
			}
		});
		rdbtnOption_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnOption_2.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnOption_1.setSelected(false);
					rdbtnOption.setSelected(false);
				}
			}
		});
	}
	///////////////////////////////////////////////
	Timer time;
	public quizexamstudent(String rollNo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1186, 121);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(quizexamstudent.class.getResource("/quizapplication/index student.png")));
		lblNewLabel.setBounds(0, 0, 68, 82);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(73, 0, 242, 82);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL TIME:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(827, 10, 166, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("10 MIN");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(1022, 10, 68, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("TIME TAKEN:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(827, 62, 146, 32);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("00");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setBounds(985, 66, 36, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("00");
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(1031, 66, 36, 25);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("DATE:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(434, 31, 74, 37);
		panel.add(lblNewLabel_5);
		
		 lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(538, 25, 124, 49);
		panel.add(lblNewLabel_6);
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(0, 120, 366, 543);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ROLL NUMBER:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(10, 42, 147, 40);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("NAME:");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_1.setBounds(10, 107, 83, 40);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("TOTAL QUESTION:");
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_2.setBounds(10, 184, 172, 40);
		panel_1.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("QUESTION NUMBER:");
		lblNewLabel_7_3.setForeground(Color.WHITE);
		lblNewLabel_7_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_3.setBounds(10, 274, 208, 40);
		panel_1.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_4 = new JLabel("MARKS OBTAINED:");
		lblNewLabel_7_4.setForeground(Color.WHITE);
		lblNewLabel_7_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_4.setBounds(10, 357, 191, 40);
		panel_1.add(lblNewLabel_7_4);
		
		 lblNewLabel_7_5 = new JLabel("01");
		lblNewLabel_7_5.setForeground(Color.WHITE);
		lblNewLabel_7_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_5.setBounds(169, 42, 147, 40);
		panel_1.add(lblNewLabel_7_5);
		
		lblNewLabel_7_6 = new JLabel("MALLIK");
		lblNewLabel_7_6.setForeground(Color.WHITE);
		lblNewLabel_7_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_6.setBounds(138, 107, 147, 40);
		panel_1.add(lblNewLabel_7_6);
		
		JLabel lblNewLabel_7_7 = new JLabel("10");
		lblNewLabel_7_7.setForeground(Color.WHITE);
		lblNewLabel_7_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_7.setBounds(192, 184, 147, 40);
		panel_1.add(lblNewLabel_7_7);
		
		 lblNewLabel_7_8 = new JLabel("01");
		lblNewLabel_7_8.setForeground(Color.WHITE);
		lblNewLabel_7_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_8.setBounds(228, 274, 42, 40);
		panel_1.add(lblNewLabel_7_8);
		
		lblNewLabel_7_9 = new JLabel("00");
		lblNewLabel_7_9.setForeground(Color.WHITE);
		lblNewLabel_7_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7_9.setBounds(220, 357, 50, 40);
		panel_1.add(lblNewLabel_7_9);
		
		 lblNewLabel_8 = new JLabel("QUESTION?");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_8.setBounds(401, 152, 775, 86);
		contentPane.add(lblNewLabel_8);
		
		 rdbtnNewRadioButton = new JRadioButton("OPTION1");
		
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(401, 244, 634, 37);
		contentPane.add(rdbtnNewRadioButton);
		
		 rdbtnOption = new JRadioButton("OPTION2");
		
		rdbtnOption.setBackground(new Color(255, 255, 255));
		rdbtnOption.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnOption.setBounds(401, 327, 719, 37);
		contentPane.add(rdbtnOption);
		
		 rdbtnOption_1 = new JRadioButton("OPTION3");
		
		rdbtnOption_1.setBackground(new Color(255, 255, 255));
		rdbtnOption_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnOption_1.setBounds(401, 416, 719, 37);
		contentPane.add(rdbtnOption_1);
		
		rdbtnOption_2 = new JRadioButton("OPTION4");
		
		rdbtnOption_2.setBackground(new Color(255, 255, 255));
		rdbtnOption_2.setForeground(new Color(0, 0, 0));
		rdbtnOption_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnOption_2.setBounds(401, 498, 719, 37);
		contentPane.add(rdbtnOption_2);
		
		
		
		
		 btnNewButton_1 = new JButton("NEXT");
		
		btnNewButton_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1.setIcon(new ImageIcon(quizexamstudent.class.getResource("/quizapplication/Next.png")));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setBounds(514, 584, 134, 50);
		contentPane.add(btnNewButton_1);
		
		 btnNewButton_1_1 = new JButton("SUBMIT");
		
		btnNewButton_1_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1_1.setIcon(new ImageIcon(quizexamstudent.class.getResource("/quizapplication/save.png")));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1_1.setBounds(901, 584, 134, 50);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerCheck();
				question();
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to exit.","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					answerCheck();
					submit();
				}
			}
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnOption.setSelected(false);
					rdbtnOption_1.setSelected(false);
					rdbtnOption_2.setSelected(false);
				}
			}
		});
		rdbtnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnOption.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnOption_1.setSelected(false);
					rdbtnOption_2.setSelected(false);
				}
			}
		});
		rdbtnOption_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnOption_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnOption.setSelected(false);
					rdbtnOption_2.setSelected(false);
				}
			}
		});
		rdbtnOption_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnOption_2.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnOption_1.setSelected(false);
					rdbtnOption.setSelected(false);
				}
			}
		});
		////////////////////////////////////////////////////////
		
		lblNewLabel_7_5.setText(rollNo);
		//date
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date d=new Date();
		lblNewLabel_6.setText(df.format(d));
		//first question and student details
		Connect();
		try {
		Statement	st = conn.createStatement();
			ResultSet rs=st.executeQuery("select * from student where rollno='"+rollNo+"'");
			while(rs.next()) {
				lblNewLabel_7_6.setText(rs.getString(2));
			}
			 ResultSet rsl=st.executeQuery("select * from question where id='"+quesid+"'");
			 while(rsl.next()) {
				 lblNewLabel_7_8.setText(rsl.getString(1));
				 lblNewLabel_8.setText(rsl.getString(2));
				 rdbtnNewRadioButton.setText(rsl.getString(3));
				 rdbtnOption.setText(rsl.getString(4));
				 rdbtnOption_1.setText(rsl.getString(5));
				 rdbtnOption_2.setText(rsl.getString(6));
				 ans=rsl.getString(7);
			 }
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		//time program
		setLocationRelativeTo(this);
		time=new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				lblNewLabel_4_1.setText(String.valueOf(sec));
				lblNewLabel_4.setText(String.valueOf(min));
				if(sec==60) {
					sec=0;
					min++;
					if(min==10) {
						time.stop();
						answerCheck();
						submit();
					}
					
				}
				sec++;
			}
		});
		time.start();	
	}
	
	
	
}
