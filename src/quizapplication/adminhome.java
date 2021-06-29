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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminhome extends JFrame {
	public static int open=0;


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminhome frame = new adminhome();
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
	public adminhome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/add new question.png")));
		lblNewLabel.setBounds(148, 146, 60, 82);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0) {
					new addquestion().setVisible(true);
					open=1;
				}
				else {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"this is already opened");
				}
			}
		});
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(72, 104, 205, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("ADD QUESTION");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_6.setBounds(45, 148, 135, 49);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0) {
					new updatethequestion().setVisible(true);
					open=1;
				}
				else {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showConfirmDialog(jf, "One form is already open");
				}
			}
		});
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setLayout(null);
		panel_1.setBounds(447, 104, 205, 227);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/Update Question.png")));
		lblNewLabel_1.setBounds(69, 50, 71, 85);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("UPDATE QUESTION");
		lblNewLabel_6_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(34, 151, 135, 49);
		panel_1.add(lblNewLabel_6_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0) {
					new allquestion().setVisible(true);
					open=1;
				}
				else {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf,"One form is already opened");
				}
			}
		});
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setLayout(null);
		panel_2.setBounds(907, 104, 205, 227);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/all questions.png")));
		lblNewLabel_2.setBounds(58, 47, 83, 94);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("ALL QUESTION");
		lblNewLabel_6_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_6_2.setBounds(36, 151, 135, 49);
		panel_2.add(lblNewLabel_6_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0) {
					new deletequestion().setVisible(true);
					open=1;
				}
				else {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showConfirmDialog(jf, "One form is already open");
				}
			}
		});
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setLayout(null);
		panel_3.setBounds(72, 447, 205, 227);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/delete Question.png")));
		lblNewLabel_3.setBounds(58, 47, 60, 68);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6_3 = new JLabel("DELETE QUESTION");
		lblNewLabel_6_3.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_6_3.setBounds(34, 150, 135, 49);
		panel_3.add(lblNewLabel_6_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(open==0) {
					new studentresults().setVisible(true);
					open=1;
				}
				else {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showConfirmDialog(jf, "One form is already open");
				}
			}
		});
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setLayout(null);
		panel_4.setBounds(447, 448, 205, 227);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/all student result.png")));
		lblNewLabel_4.setBounds(67, 42, 67, 70);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6_4 = new JLabel("ALL STUDENT RESULT");
		lblNewLabel_6_4.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_6_4.setBounds(37, 146, 147, 49);
		panel_4.add(lblNewLabel_6_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf,"Do you Really want to Logout","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					setVisible(false);
					new loginadmin().setVisible(true);
				}
				
				
			}
		});
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setLayout(null);
		panel_5.setBounds(907, 447, 205, 227);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/Logout.png")));
		lblNewLabel_5.setBounds(62, 55, 71, 73);
		panel_5.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_5 = new JLabel("LOGOUT");
		lblNewLabel_6_5.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_6_5.setBounds(72, 138, 84, 49);
		panel_5.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				int a=JOptionPane.showConfirmDialog(jf,"Do you Really want to Exit Application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
			}
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/Close.png")));
		lblNewLabel_7.setBounds(1282, 10, 60, 70);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(adminhome.class.getResource("/quizapplication/index background.png")));
		lblNewLabel_8.setBounds(10, 0, 1342, 731);
		contentPane.add(lblNewLabel_8);
	}

}
