package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtEnterSchoolName;
	private JTextField txtEnterUniversityName;
	private JTextField txtEnterCollegeName;
	private JTextField txtEnterCgpa;
	private JTextField txtPassedoutYr;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_4;
	private JTextField textField_11;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentdetails frame = new studentdetails();
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
	public studentdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 850);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(studentdetails.class.getResource("/quizapplication/login-profile.png")));
		lblNewLabel.setBounds(411, 0, 200, 173);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FILL THE FORM");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 33));
		lblNewLabel_1.setBounds(396, 170, 296, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLL NO:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(10, 248, 88, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NAME:");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 336, 88, 37);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("EMAIL:");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(604, 315, 88, 37);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("10TH:");
		lblNewLabel_2_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_1.setBounds(604, 393, 88, 37);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("FATHER NAME:");
		lblNewLabel_2_2_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_2.setBounds(10, 420, 111, 37);
		contentPane.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("12TH:");
		lblNewLabel_2_2_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_3.setBounds(604, 544, 88, 37);
		contentPane.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("MOTHER NAME:");
		lblNewLabel_2_2_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_4.setBounds(10, 506, 124, 37);
		contentPane.add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("GRADUATION:");
		lblNewLabel_2_2_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_5.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_5.setBounds(10, 692, 124, 37);
		contentPane.add(lblNewLabel_2_2_5);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("CONTACT NUMBER:");
		lblNewLabel_2_2_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_6.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_6.setBounds(556, 248, 156, 37);
		contentPane.add(lblNewLabel_2_2_6);
		
		JLabel lblNewLabel_2_2_7 = new JLabel("GENDER:");
		lblNewLabel_2_2_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_7.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_7.setBounds(10, 566, 88, 37);
		contentPane.add(lblNewLabel_2_2_7);
		
		JLabel lblNewLabel_2_2_8 = new JLabel("ADDRESS:");
		lblNewLabel_2_2_8.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2_8.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_2_2_8.setBounds(10, 624, 88, 37);
		contentPane.add(lblNewLabel_2_2_8);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 13));
		textField.setBounds(123, 259, 323, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(123, 336, 323, 37);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(123, 420, 323, 37);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(123, 506, 323, 37);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(123, 624, 323, 37);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(731, 248, 311, 37);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(731, 305, 311, 37);
		contentPane.add(textField_7);
		
		txtEnterSchoolName = new JTextField();
		txtEnterSchoolName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterSchoolName.getText().equals("ENTER SCHOOL NAME")){
					txtEnterSchoolName.setText("");
					txtEnterSchoolName.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterSchoolName.getText().equals("")){
					txtEnterSchoolName.setText("ENTER SCHOOL NAME");
					txtEnterSchoolName.setForeground(new Color(153,153,153));
					
				}
			}
		});
		txtEnterSchoolName.setText("ENTER SCHOOL NAME");
		txtEnterSchoolName.setFont(new Font("Verdana", Font.BOLD, 13));
		txtEnterSchoolName.setColumns(10);
		txtEnterSchoolName.setBounds(731, 393, 324, 37);
		contentPane.add(txtEnterSchoolName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE", "OTHERS"}));
		comboBox.setBounds(123, 567, 323, 38);
		contentPane.add(comboBox);
		
		txtEnterUniversityName = new JTextField();
		txtEnterUniversityName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterUniversityName.getText().equals("ENTER UNIVERSITY NAME")){
					txtEnterUniversityName.setText("");
					txtEnterUniversityName.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterUniversityName.getText().equals("")){
					txtEnterUniversityName.setText("ENTER UNIVERSITY NAME");
					txtEnterUniversityName.setForeground(new Color(153,153,153));
					
				}
			}
		});
		txtEnterUniversityName.setText("ENTER UNIVERSITY NAME");
		txtEnterUniversityName.setFont(new Font("Verdana", Font.BOLD, 13));
		txtEnterUniversityName.setColumns(10);
		txtEnterUniversityName.setBounds(123, 692, 323, 37);
		contentPane.add(txtEnterUniversityName);
		
		txtEnterCollegeName = new JTextField();
		txtEnterCollegeName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterCollegeName.getText().equals("ENTER COLLEGE NAME")){
					txtEnterCollegeName.setText("");
					txtEnterCollegeName.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterCollegeName.getText().equals("")){
					txtEnterCollegeName.setText("ENTER COLLEGE NAME");
					txtEnterCollegeName.setForeground(new Color(153,153,153));
					
				}
			}
		});
		txtEnterCollegeName.setText("ENTER COLLEGE NAME");
		txtEnterCollegeName.setFont(new Font("Verdana", Font.BOLD, 13));
		txtEnterCollegeName.setColumns(10);
		txtEnterCollegeName.setBounds(731, 544, 324, 37);
		contentPane.add(txtEnterCollegeName);
		
		JLabel lblNewLabel_3 = new JLabel("DATE:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setBounds(731, 59, 56, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DATESTODAY");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_4.setBounds(816, 59, 205, 37);
		contentPane.add(lblNewLabel_4);
		Connect();
		JButton btnNewButton = new JButton("SAVE & NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollNo=textField.getText();
				String name=textField_1.getText();
				String father=textField_2.getText();
				String mother=textField_3.getText();
				String gender=(String)comboBox.getSelectedItem();
				String address=textField_5.getText();
				String contact=textField_6.getText();
				String email=textField_7.getText();
				String tenname=txtEnterSchoolName.getText();
				String tenpercent=txtEnterCgpa.getText();
				String tenpassyear=txtPassedoutYr.getText();
				String twelvename=txtEnterCollegeName.getText();
				String twelvepercent=textField_10.getText();
				String twelvepassyear=textField_9.getText();
				String gradname=txtEnterUniversityName.getText();
				String gradpercent=textField_4.getText();
				String gradpassyear=textField_11.getText();
				String marks="0";
				try {
					pst=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, rollNo);
					pst.setString(2, name);
					pst.setString(3, father);
					pst.setString(4, mother);
					pst.setString(5, gender);
					pst.setString(6, contact);
					pst.setString(7, email);
					pst.setString(8,tenname);
					pst.setString(9, tenpercent);
					pst.setString(10, tenpassyear);
					pst.setString(11, twelvename);
					pst.setString(12, twelvepercent);
					pst.setString(13, twelvepassyear);
					pst.setString(14, gradname);
					pst.setString(15, gradpercent);
					pst.setString(16, gradpassyear);
					pst.setString(17,address);
					pst.setString(18, marks);
					pst.executeUpdate();
					setVisible(false);
					new studentinstructions(rollNo).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setIcon(new ImageIcon(studentdetails.class.getResource("/quizapplication/save.png")));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setBounds(504, 755, 156, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(studentdetails.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_5.setBounds(1016, 0, 70, 60);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(studentdetails.class.getResource("/quizapplication/goback.png")));
		lblNewLabel_6.setBounds(0, 0, 30, 48);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new index().setVisible(true);
			}
		});
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 156, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("GO BACK");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_7.setForeground(new Color(192, 192, 192));
		lblNewLabel_7.setBounds(46, 10, 82, 40);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("NOTE:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_8.setForeground(new Color(0, 0, 128));
		lblNewLabel_8.setIcon(new ImageIcon(studentdetails.class.getResource("/quizapplication/Next.png")));
		lblNewLabel_8.setBounds(10, 88, 58, 37);
		contentPane.add(lblNewLabel_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 93, 243, 134);
		contentPane.add(scrollPane);
		
		JTextPane txtpnExaminationManagementSystem = new JTextPane();
		txtpnExaminationManagementSystem.setText("EXAMINATION MANAGEMENT SYSTEM IS MANAGING ALL THE ACTIVITIES RELATED TO EXAMINATION MANAGEMENT RIGHT FROM RECEIPT OF ENROLLMENT FORMS AND EXAMINATION FORMS THROUGH THE PROCESSING OF  RESLUTS AND CERTIFICATES AND GRADING SYSTEM.\r\n\r\n");
		scrollPane.setViewportView(txtpnExaminationManagementSystem);
		
		txtEnterCgpa = new JTextField();
		txtEnterCgpa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterCgpa.getText().equals("ENTER CGPA:")){
					txtEnterCgpa.setText("");
					txtEnterCgpa.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterCgpa.getText().equals("")){
					txtEnterCgpa.setText("ENTER CGPA:");
					txtEnterCgpa.setForeground(new Color(153,153,153));
					
				}
			}
		});
		txtEnterCgpa.setText("ENTER CGPA:");
		txtEnterCgpa.setFont(new Font("Verdana", Font.BOLD, 13));
		txtEnterCgpa.setColumns(10);
		txtEnterCgpa.setBounds(741, 452, 124, 37);
		contentPane.add(txtEnterCgpa);
		
		txtPassedoutYr = new JTextField();
		txtPassedoutYr.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassedoutYr.getText().equals("PASSEDOUT YEAR")){
					txtPassedoutYr.setText("");
					txtPassedoutYr.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassedoutYr.getText().equals("")){
					txtPassedoutYr.setText("PASSEDOUT YEAR");
					txtPassedoutYr.setForeground(new Color(153,153,153));
					
				}
			}
		});
		txtPassedoutYr.setText("PASSEDOUT YEAR");
		txtPassedoutYr.setFont(new Font("Verdana", Font.BOLD, 13));
		txtPassedoutYr.setColumns(10);
		txtPassedoutYr.setBounds(919, 452, 136, 37);
		contentPane.add(txtPassedoutYr);
		
		textField_9 = new JTextField();
		textField_9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_9.getText().equals("PASSEDOUT YEAR")){
					textField_9.setText("");
					textField_9.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_9.getText().equals("")){
					textField_9.setText("PASSEDOUT YEAR");
					textField_9.setForeground(new Color(153,153,153));
					
				}
			}
		});
		textField_9.setText("PASSEDOUT YEAR");
		textField_9.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_9.setColumns(10);
		textField_9.setBounds(906, 624, 144, 37);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_10.getText().equals("ENTER CGPA:")){
					textField_10.setText("");
					textField_10.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_10.getText().equals("")){
					textField_10.setText("ENTER CGPA:");
					textField_10.setForeground(new Color(153,153,153));
					
				}
			}
		});
		textField_10.setText("ENTER CGPA:");
		textField_10.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(741, 624, 124, 37);
		contentPane.add(textField_10);
		
		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_4.getText().equals("ENTER CGPA:")){
					textField_4.setText("");
					textField_4.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_4.getText().equals("")){
					textField_4.setText("ENTER CGPA:");
					textField_4.setForeground(new Color(153,153,153));
					
				}
			}
		});
		textField_4.setText("ENTER CGPA:");
		textField_4.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(133, 738, 124, 37);
		contentPane.add(textField_4);
		
		textField_11 = new JTextField();
		textField_11.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_11.getText().equals("PASSEDOUT YEAR")){
					textField_11.setText("");
					textField_11.setForeground(new Color(0,0,0));
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_11.getText().equals("")){
					textField_11.setText("PASSEDOUT YEAR");
					textField_11.setForeground(new Color(153,153,153));
					
				}
			}
		});
		textField_11.setText("PASSEDOUT YEAR");
		textField_11.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_11.setColumns(10);
		textField_11.setBounds(302, 739, 144, 37);
		contentPane.add(textField_11);
		txtpnExaminationManagementSystem.setEditable(false);
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date date=new Date();
		lblNewLabel_4.setText(df.format(date));
		
		
		
		
	}
}
