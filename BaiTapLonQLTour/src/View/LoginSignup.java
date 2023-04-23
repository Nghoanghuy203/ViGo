package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class LoginSignup extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginSignup frame = new LoginSignup();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		new LoginSignup().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginSignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(84, 99, 1200, 620);
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JPanel pnMain = new JPanel();
		pnMain.setBackground(new Color(255, 255, 255));
		pnMain.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		pnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
//				System.exit(0);
			}
		});
		pnMain.setBounds(0, 0, 1200, 620);
		getContentPane().add(pnMain);
		pnMain.setLayout(null);
		
		JPanel dangNhap = new JPanel();
		dangNhap.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		dangNhap.setBounds(124, 86, 400, 350);
		pnMain.add(dangNhap);
		dangNhap.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
		lblNewLabel_1.setBounds(171, 11, 89, 14);
		dangNhap.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(30, 81, 46, 14);
		dangNhap.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(30, 106, 320, 20);
		dangNhap.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		lblNewLabel_3.setBounds(30, 164, 46, 14);
		dangNhap.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 200, 320, 20);
		dangNhap.add(passwordField);
		char de = passwordField.getEchoChar();
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setBounds(145, 295, 89, 23);
		dangNhap.add(btnNewButton);
		
		JLabel show = new JLabel("");
		JLabel hiden = new JLabel("");
		hiden.setVisible(false);
		hiden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar(de);
				System.out.println(de);
				show.setVisible(true);
				hiden.setVisible(false);
			}
		});
		show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char)0);
				hiden.setVisible(true);
				show.setVisible(false);
			}
		});
		show.setIcon(new ImageIcon("C:\\Users\\nghoa\\Downloads\\show.png"));
		show.setBounds(354, 203, 36, 17);
		dangNhap.add(show);
		
		
		hiden.setIcon(new ImageIcon("C:\\Users\\nghoa\\Downloads\\eye-off.png"));
		hiden.setBounds(354, 203, 36, 14);
		dangNhap.add(hiden);
		
		JLabel lblNewLabel = new JLabel("Trở về");
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 15));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nghoa\\Downloads\\back.png"));
		lblNewLabel.setBounds(0, 0, 99, 32);
		pnMain.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(627, 86, 400, 350);
		pnMain.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đăng kí");
		lblNewLabel_1_1.setBounds(173, 5, 53, 14);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 76, 320, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setBounds(10, 51, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 132, 320, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Họ Tên");
		lblNewLabel_2_1_1.setBounds(10, 107, 46, 14);
		panel.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 188, 320, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_2_1_2.setBounds(10, 163, 88, 14);
		panel.add(lblNewLabel_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 244, 320, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Mật khẩu");
		lblNewLabel_2_1_3.setBounds(10, 219, 58, 14);
		panel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Nhâp lại mật khẩu");
		lblNewLabel_2_1_3_1.setBounds(10, 275, 102, 14);
		panel.add(lblNewLabel_2_1_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 300, 320, 20);
		panel.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Đăng kí");
		btnNewButton_1.setBounds(154, 327, 89, 23);
		panel.add(btnNewButton_1);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
	}
}
