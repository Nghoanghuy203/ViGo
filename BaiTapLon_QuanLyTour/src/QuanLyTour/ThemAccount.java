package QuanLyTour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class ThemAccount extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;databasename=DANGNHAP;encrypt=false;trustServerCertificate=false;";
	String user = "sa";
	String password = "quocthai011555";
	Statement st;
	ResultSet rs;

	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txthoTen;
	private JTextField txtsDT;
	private JTextField txtgtinh;
	private JLabel lblhoTen;
	private JLabel lblMK;
	private JLabel lblnhapLaiMK;
	private JLabel lblhoten;
	private JLabel lblsDT;
	private JLabel lblgioiTinh;
	private JButton btnLogIn;
	private JButton btnThemAccount;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemAccount frame = new ThemAccount();
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
	public ThemAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(900,600);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(197, 10, 103, 21);
		contentPane.add(lblNewLabel);
		
		txtemail = new JTextField();
		txtemail.setBounds(28, 73, 389, 27);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txthoTen = new JTextField();
		txthoTen.setColumns(10);
		txthoTen.setBounds(28, 263, 389, 27);
		contentPane.add(txthoTen);
		
		txtsDT = new JTextField();
		txtsDT.setColumns(10);
		txtsDT.setBounds(28, 330, 389, 27);
		contentPane.add(txtsDT);
		
		txtgtinh = new JTextField();
		txtgtinh.setColumns(10);
		txtgtinh.setBounds(28, 399, 389, 27);
		contentPane.add(txtgtinh);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(28, 49, 389, 13);
		contentPane.add(lblEmail);
		
		lblMK = new JLabel("Mật Khẩu");
		lblMK.setBounds(28, 110, 389, 13);
		contentPane.add(lblMK);
		
		lblnhapLaiMK = new JLabel("Nhập Lại mật khẩu hoặc th tháiGO bắn m");
		lblnhapLaiMK.setBounds(28, 176, 389, 13);
		contentPane.add(lblnhapLaiMK);
		
		lblhoten = new JLabel("Họ Tên");
		lblhoten.setBounds(28, 240, 389, 13);
		contentPane.add(lblhoten);
		
		lblsDT = new JLabel("Số Điện Thoại");
		lblsDT.setBounds(28, 307, 389, 13);
		contentPane.add(lblsDT);
		
		lblgioiTinh = new JLabel("Giới Tính");
		lblgioiTinh.setBounds(28, 377, 389, 13);
		contentPane.add(lblgioiTinh);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(this);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogIn.setBackground(Color.BLUE);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBounds(28, 469, 190, 47);
		contentPane.add(btnLogIn);
		
		btnThemAccount = new JButton("Đăng Ký");
		btnThemAccount.addActionListener(this);
		btnThemAccount.setForeground(Color.WHITE);
		btnThemAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemAccount.setBackground(Color.BLUE);
		btnThemAccount.setBounds(228, 469, 189, 47);
		contentPane.add(btnThemAccount);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(28, 133, 389, 33);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(28, 199, 389, 33);
		contentPane.add(passwordField_1);
		
		JLabel lblbgr = new JLabel("New label");
		lblbgr.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse.workspace\\img\\ảnh nền.jpg"));
		lblbgr.setBounds(0, 0, 917, 576);
		contentPane.add(lblbgr);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThemAccount))
		{
			int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký", "confirm", JOptionPane.YES_NO_OPTION);
			if (dk != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, password);
				String sql = "insert into ACCOUNT values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, txtemail.getText());
				ps.setString(2, passwordField.getText());
				ps.setString(3, passwordField_1.getText());
				ps.setString(4, txthoTen.getText());
				ps.setString(5, txtsDT.getText());
				ps.setString(6, txtgtinh.getText());
				
				int n = ps.executeUpdate(); //update dữ liệu
				
				if(txtemail.getText().equals("")||passwordField.getText().equals("")||passwordField_1.getText().equals("")||txthoTen.getText().equals("")||txtsDT.getText().equals("")||txtgtinh.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Không để thông tin trống");
				}
				else if(n!=0) {
					JOptionPane.showMessageDialog(this, "Đăng kí thành công!!");
				} else {
					JOptionPane.showMessageDialog(this, "Đăng kí thất bại!!");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
		if(o.equals(btnLogIn)) {
			FormDangNhap l = new FormDangNhap();
			l.setVisible(true);
			this.dispose();
		}
	}
}
