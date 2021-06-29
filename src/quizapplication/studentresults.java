package quizapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class studentresults extends JFrame {

	private JPanel contentPane;
	private final JSeparator separator = new JSeparator();
	private JTable table;
	private JTextField textField;

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
					studentresults frame = new studentresults();
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
	public studentresults() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(studentresults.class.getResource("/quizapplication/all student result.png")));
		lblNewLabel.setBounds(0, 0, 75, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ALL STUDENT RESULTS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(69, 0, 462, 69);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminhome.open=0;
				setVisible(false);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(studentresults.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_2.setBounds(989, 0, 62, 69);
		contentPane.add(lblNewLabel_2);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 68, 1051, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 149, 994, 444);
		contentPane.add(scrollPane);
		Connect(); 
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("FILTER STUDENT BY MARKS");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 97, 287, 42);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int marks;
				if(textField.getText().equals("")) {
					marks=0;
				}
				else {
					marks=Integer.parseInt(textField.getText());
					try {
						Statement st;
						st = conn.createStatement();
						ResultSet rs=st.executeQuery("select * from student where marks>="+marks+"");
						table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (SQLException e1) {
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf,e1);
					}
					
				}
			}
		});
		textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(307, 100, 153, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e1);
		}
		
		
		
	}
}
