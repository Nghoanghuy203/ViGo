package View;

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

import app.Test;
import custom_entity.RoundedCornerBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
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
	private JLabel hinhnen;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormDangNhap frame = new FormDangNhap();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormDangNhap() {
		
		
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
			
		JPanel pnLogin = new JPanel();
		pnLogin.setBackground(UIManager.getColor("Button.background"));
		pnLogin.setBounds(200, 100, 800, 560);
		pnLogin.setLayout(null);
		pnLogin.setBorder(new RoundedCornerBorder());
		pnMain.add(pnLogin);
		
		
		txtemail = new JTextField();
		txtemail.setToolTipText("");
		txtemail.setBounds(222, 216, 415, 41);
		pnLogin.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(222, 193, 234, 13);
		pnLogin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(222, 284, 234, 13);
		pnLogin.add(lblNewLabel_1);
		
		JLabel lblDangNhap = new JLabel("Đăng Nhập");
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDangNhap.setForeground(Color.BLUE);
		lblDangNhap.setBackground(Color.BLUE);
		lblDangNhap.setBounds(373, 129, 116, 33);
		pnLogin.add(lblDangNhap);
		
		JCheckBox cbGhiNho = new JCheckBox("Ghi nhớ đăng nhập");
		cbGhiNho.setBackground(new Color(255, 255, 255));
		cbGhiNho.setBounds(222, 391, 158, 21);
		pnLogin.add(cbGhiNho);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(this);
		btnDangNhap.setBackground(new Color(0, 0, 255));
		btnDangNhap.setForeground(new Color(245, 255, 250));
		btnDangNhap.setBounds(222, 452, 178, 41);
		pnLogin.add(btnDangNhap);
		
		btnThemAccount = new JButton("Đăng ký tài khoản");
		btnThemAccount.addActionListener(this);
		btnThemAccount.setForeground(new Color(245, 255, 250));
		btnThemAccount.setBackground(Color.BLUE);
		btnThemAccount.setBounds(459, 452, 178, 41);
		pnLogin.add(btnThemAccount);
		
		pFDangNhap = new JPasswordField();
		pFDangNhap.setBounds(222, 307, 415, 41);
		pnLogin.add(pFDangNhap);
		
		lblNewLabel_2 = new JLabel("Chào mừng Quý Khách đã đến với VIGO ");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(247, 29, 373, 53);
		pnLogin.add(lblNewLabel_2);
		
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				//System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon(DatTour.class.getResource("/images/back.png")));
		btnTroVe.setBounds(10, 10, 80, 21);
		pnLogin.add(btnTroVe);
		
		hinhnen = new JLabel("New label");
		hinhnen.setOpaque(true);
		hinhnen.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		hinhnen.setBackground(new Color(127, 255, 212));
		File f = new File(FormDangNhap.class.getResource("/images/travel_mbaandrews-min.jpg").getFile());
		BufferedImage img=null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hinhnen.setIcon(new ImageIcon(scaledImage(img, pnLogin.getWidth(), pnLogin.getHeight())));
		hinhnen.setBounds(0, 0, 800, 560);
		pnLogin.add(hinhnen);
		
		
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
	public static void main(String[] args) {
		new FormDangNhap().setVisible(true);
	}
	private BufferedImage scaledImage(BufferedImage img, int w, int h) {
		BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h,null);
		g2.dispose();
		return resizedImage;
	}
}
