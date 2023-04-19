package QuanLyTour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class FormDangNhap extends JFrame implements ActionListener {
	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;databasename=DANGNHAP;encrypt=false;trustServerCertificate=false;";
	String user = "sa";
	String password = "quocthai011555";
	Statement st;
	ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtemail;
	private JPasswordField pFDangNhap;
	private JButton btnDangNhap, btnThemAccount;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
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
	public FormDangNhap() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 512);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setSize(900,600);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(0, 0, 886, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtemail = new JTextField();
		txtemail.setToolTipText("");
		txtemail.setBounds(222, 216, 415, 41);
		panel.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(222, 193, 234, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(222, 284, 234, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblDangNhap = new JLabel("Đăng Nhập");
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDangNhap.setForeground(Color.BLUE);
		lblDangNhap.setBackground(Color.BLUE);
		lblDangNhap.setBounds(373, 129, 116, 33);
		panel.add(lblDangNhap);
		
		JCheckBox cbGhiNho = new JCheckBox("Ghi nhớ đăng nhập");
		cbGhiNho.setBackground(new Color(255, 255, 255));
		cbGhiNho.setBounds(222, 391, 158, 21);
		panel.add(cbGhiNho);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(this);
		btnDangNhap.setBackground(new Color(0, 0, 255));
		btnDangNhap.setForeground(new Color(245, 255, 250));
		btnDangNhap.setBounds(222, 452, 178, 41);
		panel.add(btnDangNhap);
		
		btnThemAccount = new JButton("Thêm Account ");
		btnThemAccount.addActionListener(this);
		btnThemAccount.setForeground(new Color(245, 255, 250));
		btnThemAccount.setBackground(Color.BLUE);
		btnThemAccount.setBounds(459, 452, 178, 41);
		panel.add(btnThemAccount);
		
		pFDangNhap = new JPasswordField();
		pFDangNhap.setBounds(222, 307, 415, 41);
		panel.add(pFDangNhap);
		
		lblNewLabel_2 = new JLabel("Chào mừng Quý Khách đã đến với VIGO ");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(247, 29, 373, 53);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse.workspace\\img\\Ellipse 1.png"));
		lblNewLabel_5.setBounds(10, 0, 91, 91);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(127, 255, 212));
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse.workspace\\img\\travel_mbaandrews-min.jpg"));
		lblNewLabel_6.setBounds(0, 0, 886, 563);
		panel.add(lblNewLabel_6);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThemAccount)) {
			ThemAccount them = new ThemAccount();
			them.setVisible(true);
			this.dispose();
		}
		if(o.equals(btnDangNhap)) {
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, password);
				String sql = "select*from ACCOUNT where EMAIL=? and MATKHAU=?"; // truy vấn đến sql
				PreparedStatement ps = con.prepareStatement(sql); 
				ps.setString(1,txtemail.getText());
				ps.setString(2,pFDangNhap.getText());
				rs = ps.executeQuery();
				
				if(txtemail.getText().equals("") || pFDangNhap.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Chưa nhập Email và Mật khẩu");
				} else if(rs.next()) {
					Home home = new Home();
					home.setVisible(true);
					this.dispose();
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
				}
			} catch (Exception e2) {
			
			}
		}
	}
}
