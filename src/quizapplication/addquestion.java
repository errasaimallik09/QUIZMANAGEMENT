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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addquestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
					addquestion frame = new addquestion();
					frame.setVisible(true);
				} catch (Exception e) {
					Logger.getLogger(addquestion.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addquestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(addquestion.class.getResource("/quizapplication/add new question.png")));
		lblNewLabel.setBounds(0, 0, 60, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADD  NEW QUESTION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(70, 0, 408, 72);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminhome.open=0;
				setVisible(false);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(addquestion.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_2.setBounds(926, 0, 60, 60);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 76, 986, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("QUESTION ID:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3.setBounds(104, 139, 115, 47);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("QUESTION:");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(104, 196, 115, 47);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("OPTION 1:");
		lblNewLabel_3_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(104, 258, 115, 47);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("OPTION 2:");
		lblNewLabel_3_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(104, 315, 115, 47);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("OPTION 3:");
		lblNewLabel_3_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(104, 378, 115, 47);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("OPTION 4:");
		lblNewLabel_3_5.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(104, 438, 115, 47);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_4 = new JLabel("00");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_4.setBounds(246, 148, 60, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_6 = new JLabel("ANSWER:");
		lblNewLabel_3_6.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(104, 490, 115, 47);
		contentPane.add(lblNewLabel_3_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 12));
		textField.setBounds(220, 207, 600, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(220, 264, 600, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(220, 326, 600, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(220, 388, 600, 36);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(220, 446, 600, 36);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(220, 498, 600, 36);
		contentPane.add(textField_5);
		Connect();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select count(id) from question");
			if(rs.next()) {
				int id=rs.getInt(1);
				id=id+1;
				String str=String.valueOf(id);
				lblNewLabel_4.setText(str);
			}
			else {
				lblNewLabel_4.setText("1");
			}
			
		}
		catch(Exception e) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=lblNewLabel_4.getText();
				String name=textField.getText();
				String opt1=textField_1.getText();
				String opt2=textField_2.getText();
				String opt3=textField_3.getText();
				String opt4=textField_4.getText();
				String ans=textField_5.getText();
				try {
					pst=conn.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
					pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,opt1);
					pst.setString(4,opt2);
					pst.setString(5,opt3);
					pst.setString(6,opt4);
					pst.setString(7,ans);
					pst.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"succesfully updated!");
					setVisible(false);
					new addquestion().setVisible(true);
				}
				catch(Exception ce) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,ce);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(addquestion.class.getResource("/quizapplication/save.png")));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(177, 579, 129, 47);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnClear.setIcon(new ImageIcon(addquestion.class.getResource("/quizapplication/clear.png")));
		btnClear.setFont(new Font("Verdana", Font.BOLD, 13));
		btnClear.setBounds(461, 579, 129, 47);
		contentPane.add(btnClear);
	}
}
