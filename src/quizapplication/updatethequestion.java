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
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updatethequestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
					updatethequestion frame = new updatethequestion();
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
	public updatethequestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connect();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(updatethequestion.class.getResource("/quizapplication/Update Question.png")));
		lblNewLabel.setBounds(0, 0, 66, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPDATE QUESTION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(76, 10, 321, 60);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 92, 986, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			adminhome.open=0;
			setVisible(false);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(updatethequestion.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_2.setBounds(925, 0, 61, 65);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("QUESTION ID:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3.setBounds(114, 178, 110, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("QUESTION:");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(114, 236, 94, 33);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("OPTION 1:");
		lblNewLabel_3_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(114, 300, 83, 33);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("OPTION 2:");
		lblNewLabel_3_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(121, 366, 76, 33);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("OPTION 3:");
		lblNewLabel_3_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(121, 431, 76, 33);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("OPTION 4:");
		lblNewLabel_3_5.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(114, 492, 83, 33);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("ANSWER:");
		lblNewLabel_3_6.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(114, 570, 83, 33);
		contentPane.add(lblNewLabel_3_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField.setBounds(287, 180, 265, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				try {
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery("select * from question where id='"+id+"'");
					if(rs.next()) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(6));
						textField_6.setText(rs.getString(7));
						textField.setEditable(false);
					}
					else {
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "Question id doesnot exist");
					}
				} catch (SQLException e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(updatethequestion.class.getResource("/quizapplication/search.png")));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(663, 164, 130, 60);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(287, 236, 525, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(287, 300, 525, 33);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(287, 366, 525, 33);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(287, 431, 525, 33);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(287, 492, 525, 33);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(299, 570, 525, 33);
		contentPane.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String opt1=textField_2.getText();
				String opt2=textField_3.getText();
				String opt3=textField_4.getText();
				String opt4=textField_5.getText();
				String ans=textField_6.getText();
				try {
					pst=conn.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,ans=? where id=? ");
					pst.setString(1, name);
					pst.setString(2, opt1);
					pst.setString(3, opt2);
					pst.setString(4, opt3);
					pst.setString(5, opt4);
					pst.setString(6, ans);
					pst.setString(7, id);
					pst.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully Updated");
					setVisible(false);
					new updatethequestion().setVisible(true);
				} catch (SQLException e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(updatethequestion.class.getResource("/quizapplication/save.png")));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_1.setBounds(169, 617, 130, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("CLEAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField.setEditable(true);
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(updatethequestion.class.getResource("/quizapplication/clear.png")));
		btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(663, 613, 130, 46);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(updatethequestion.class.getResource("/quizapplication/pages background student.jpg")));
		lblNewLabel_4.setBounds(0, 0, 986, 663);
		contentPane.add(lblNewLabel_4);
	}
}
