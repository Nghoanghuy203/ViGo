package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custom_entity.ScaledImg;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

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

	private JPanel pnSignin;
	private JTextField txtemail;
	private JTextField txthoTen;
	private JTextField txtsDT;
	private JLabel lblhoTen;
	private JLabel lblMK;
	private JLabel lblnhapLaiMK;
	private JLabel lblhoten;
	private JLabel lblsDT;
	private JLabel lblgioiTinh;
	private JButton btnLogIn;
	private JButton btnThemAccount;
	private JPasswordField txtPass1;
	private JPasswordField txtPass2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNgaySinh;

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
		setSize(1200,700);
		setLocationRelativeTo(null);

		
		
		setUndecorated(true);
		JPanel pnMain = new JPanel();
		pnMain.setSize(1200, 700);
		getContentPane().add(pnMain);
		pnMain.setLayout(null);
		pnMain.setBackground(new Color(0, 0, 0, 30));
		setBackground(new Color(0, 0, 0, 30));
		getContentPane().add(pnMain);
		
		
		pnSignin = new JPanel();
		pnSignin.setSize(800, 560);
		pnSignin.setLocation(200, 100);
		pnSignin.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnSignin.setLayout(null);
		pnMain.add(pnSignin);
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(197, 10, 103, 21);
		pnSignin.add(lblNewLabel);
		
		txtemail = new JTextField();
		txtemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		txtemail.setBounds(30, 60, 400, 25);
		pnSignin.add(txtemail);
		txtemail.setColumns(10);
		
		txthoTen = new JTextField();
		txthoTen.setColumns(10);
		txthoTen.setBounds(30, 240, 400, 25);
		pnSignin.add(txthoTen);
		
		txtsDT = new JTextField();
		txtsDT.setColumns(10);
		txtsDT.setBounds(30, 300, 400, 25);
		pnSignin.add(txtsDT);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 40, 400, 15);
		pnSignin.add(lblEmail);
		
		lblMK = new JLabel("Mật Khẩu");
		lblMK.setBounds(30, 100, 389, 15);
		pnSignin.add(lblMK);
		
		lblnhapLaiMK = new JLabel("Nhập Lại mật khẩu");
		lblnhapLaiMK.setBounds(30, 160, 400, 15);
		pnSignin.add(lblnhapLaiMK);
		
		lblhoten = new JLabel("Họ Tên");
		lblhoten.setBounds(30, 220, 400, 15);
		pnSignin.add(lblhoten);
		
		lblsDT = new JLabel("Số Điện Thoại");
		lblsDT.setBounds(30, 280, 400, 15);
		pnSignin.add(lblsDT);
		
		lblgioiTinh = new JLabel("Giới Tính");
		lblgioiTinh.setBounds(30, 400, 400, 15);
		pnSignin.add(lblgioiTinh);
		
		btnLogIn = new JButton("Trở về đăng nhập");
		btnLogIn.addActionListener(this);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogIn.setBackground(Color.BLUE);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBounds(30, 460, 190, 50);
		pnSignin.add(btnLogIn);
		
		btnThemAccount = new JButton("Đăng Ký");
		btnThemAccount.addActionListener(this);
		btnThemAccount.setForeground(Color.WHITE);
		btnThemAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemAccount.setBackground(Color.BLUE);
		btnThemAccount.setBounds(240, 460, 190, 50);
		pnSignin.add(btnThemAccount);
		
		txtPass1 = new JPasswordField();
		txtPass1.setBounds(30, 120, 400, 25);
		pnSignin.add(txtPass1);
		
		txtPass2 = new JPasswordField();
		txtPass2.setBounds(30, 180, 400, 25);
		pnSignin.add(txtPass2);
		
		
		
		JRadioButton radNam = new JRadioButton("Nam");
		radNam.setBackground(new Color(255, 255, 255, 0));
		radNam.setBounds(240, 420, 100, 25);
		pnSignin.add(radNam);
		
		JRadioButton radNu = new JRadioButton("Nữ");
		radNu.setBackground(new Color(255, 255, 255, 0));
		radNu.setBounds(30, 420, 100, 25);
		pnSignin.add(radNu);
		
		ButtonGroup groupRad = new ButtonGroup();
		groupRad.add(radNu);
		groupRad.add(radNam);
		
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				//System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon(ThemAccount.class.getResource("/images/back.png")));
		btnTroVe.setBounds(700, 10, 80, 21);
		pnSignin.add(btnTroVe);
		

		lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(30, 340, 400, 15);
		pnSignin.add(lblNgaySinh);
		
		JLabel hinhnen = new JLabel("New label");
		File f =new File(ThemAccount.class.getResource("/images/anhnen.jpg").getFile());
		BufferedImage img =null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hinhnen.setIcon(new ImageIcon(ScaledImg.scaledImage(img, pnSignin.getWidth(), pnSignin.getHeight())));
		hinhnen.setBounds(0, 0, 800, 560);
		pnSignin.add(hinhnen);
		
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
				ps.setString(2, txtPass1.getText());
				ps.setString(3, txtPass2.getText());
				ps.setString(4, txthoTen.getText());
				ps.setString(5, txtsDT.getText());
				//ps.setString(6, txtgtinh.getText());
				
				int n = ps.executeUpdate(); //update dữ liệu
				
//				if(txtemail.getText().equals("")||txtPass1.getText().equals("")||txtPass2.getText().equals("")||txthoTen.getText().equals("")||txtsDT.getText().equals("")||txtgtinh.getText().equals("")) {
//					JOptionPane.showMessageDialog(this, "Không để thông tin trống");
//				}
//				else if(n!=0) {
//					JOptionPane.showMessageDialog(this, "Đăng kí thành công!!");
//				} else {
//					JOptionPane.showMessageDialog(this, "Đăng kí thất bại!!");
//				}
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
