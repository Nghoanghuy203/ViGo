package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 1200, 620));
		//frame.setLocationRelativeTo(null);
		//frame.setSize(900, 500);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(255, 255, 255));
		frame.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.setBounds(0, 0, 1200, 620);
		frame.getContentPane().setLayout(null);
		
		JPanel login = new JPanel();
		login.setBounds(0, 0, 1200, 620);
		login.setBackground(new Color(65, 105, 225));
		frame.getContentPane().add(login);
		login.setLayout(null);
		
		JPanel logo = new JPanel();
		logo.setBackground(new Color(255, 255, 255));
		logo.setBounds(0, -79, 405, 701);
		login.add(logo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
		lblPassword.setBounds(461, 191, 97, 29);
		login.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 18));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(461, 87, 97, 29);
		login.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(461, 122, 321, 20);
		login.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnSignin = new JButton("Sign in");
		btnSignin.setBorder(null);
		btnSignin.setBackground(new Color(124, 252, 0));
		btnSignin.setBounds(591, 371, 89, 23);
		login.add(btnSignin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(461, 219, 321, 20);
		login.add(txtPassword);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExit.setFont(new Font("Arial", Font.BOLD, 20));
		lblExit.setBounds(1144, 11, 46, 14);
		login.add(lblExit);
		
		JLabel lblShowpass = new JLabel("show");
		JLabel lblHidenpass = new JLabel("hiden");
		lblHidenpass.setVisible(false);
		lblShowpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setEchoChar((char) 0);
				lblShowpass.setVisible(false);
				lblHidenpass.setVisible(true);
			}
		});
		lblShowpass.setBounds(799, 222, 46, 14);
		login.add(lblShowpass);
		
		
		lblHidenpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setEchoChar('*');
				lblShowpass.setVisible(true);
				lblHidenpass.setVisible(false);
			}
		});
		lblHidenpass.setBounds(799, 222, 46, 14);
		login.add(lblHidenpass);
	}
}
