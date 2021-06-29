package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
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

public class deletequestion extends JFrame {

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
					deletequestion frame = new deletequestion();
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
	public deletequestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connect();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(deletequestion.class.getResource("/quizapplication/delete Question.png")));
		lblNewLabel.setBounds(0, 0, 61, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DELETE QUESTION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1.setBounds(64, 0, 350, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminhome.open=0;
				setVisible(false);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(deletequestion.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_2.setBounds(991, 0, 61, 60);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 70, 1052, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("QUESTION ID:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3.setBounds(64, 116, 116, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("QUESTION:");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(64, 176, 116, 37);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("OPTION 1:");
		lblNewLabel_3_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(64, 238, 116, 37);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("OPTION 2:");
		lblNewLabel_3_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(64, 302, 116, 37);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("OPTION 3:");
		lblNewLabel_3_4.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(64, 363, 116, 37);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("OPTION 4:");
		lblNewLabel_3_5.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(64, 425, 116, 37);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("ANSWER:");
		lblNewLabel_3_6.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(64, 486, 116, 37);
		contentPane.add(lblNewLabel_3_6);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				try {
					pst=conn.prepareStatement("delete from question where id=?");
					pst.setString(1,id);
					pst.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"Deleted Succesfully!");
					setVisible(false);
					new deletequestion().setVisible(true);
				} catch (SQLException e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,e1);
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(deletequestion.class.getResource("/quizapplication/delete.png")));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(188, 558, 126, 45);
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
				textField_6.setText("");
				textField.setEditable(true);
			}
		});
		btnClear.setIcon(new ImageIcon(deletequestion.class.getResource("/quizapplication/clear.png")));
		btnClear.setFont(new Font("Verdana", Font.BOLD, 13));
		btnClear.setBounds(521, 558, 126, 45);
		contentPane.add(btnClear);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 13));
		textField.setBounds(229, 127, 207, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setIcon(new ImageIcon(deletequestion.class.getResource("/quizapplication/search.png")));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_1.setBounds(536, 116, 126, 37);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(229, 187, 553, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(229, 249, 553, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(229, 308, 553, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(229, 374, 553, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(229, 436, 553, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.BOLD, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(229, 497, 553, 26);
		contentPane.add(textField_6);
	}
}
