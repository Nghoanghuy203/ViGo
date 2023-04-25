package view;

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
import javax.swing.border.MatteBorder;

import bus.KhachHang_BUS;
import connectDB.ConnectDB;
import custom_entity.RoundedCornerBorder;
import custom_entity.ScaledImg;
import custom_entity.SomeStaticMethod;
import test.Test;

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

public class ManHinhDangNhap extends JFrame implements ActionListener {
	

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
	public ManHinhDangNhap() {
		
		
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
		txtemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtemail.setBackground(new Color(255,255,255,0));
		txtemail.setOpaque(false);
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
		pFDangNhap.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pFDangNhap.setBackground(new Color(255,255,255,0));
		pFDangNhap.setOpaque(false);
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
		btnTroVe.setIcon(new ImageIcon(ManHinhDatTour.class.getResource("/images/back.png")));
		btnTroVe.setBounds(10, 10, 80, 21);
		pnLogin.add(btnTroVe);
		
		JLabel btnShowPass = new JLabel("");
		btnShowPass.setIcon(new ImageIcon(ManHinhDangNhap.class.getResource("/images/show.png")));
		btnShowPass.setBounds(650, 320, 40, 40);
		pnLogin.add(btnShowPass);
		
		char dot = pFDangNhap.getEchoChar();
		
		JLabel btnHidePass = new JLabel("");
		btnHidePass.setIcon(new ImageIcon(ManHinhDangNhap.class.getResource("/images/eye-off.png")));
		btnHidePass.setBounds(650, 320, 40, 40);
		btnHidePass.setVisible(false);
		pnLogin.add(btnHidePass);
		
		btnShowPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pFDangNhap.setEchoChar((char)0);
				btnHidePass.setVisible(true);
				btnShowPass.setVisible(false);
			}
		});
		
		btnHidePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pFDangNhap.setEchoChar(dot);
				btnShowPass.setVisible(true);
				btnHidePass.setVisible(false);
			}
		});
		
		hinhnen = new JLabel("New label");
		hinhnen.setOpaque(true);
		hinhnen.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		hinhnen.setBackground(new Color(127, 255, 212));
		File f = new File(ManHinhDangNhap.class.getResource("/images/travel_mbaandrews-min.jpg").getFile());
		BufferedImage img=null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hinhnen.setIcon(new ImageIcon(ScaledImg.scaledImage(img, pnLogin.getWidth(), pnLogin.getHeight())));
		hinhnen.setBounds(0, 0, 800, 560);
		pnLogin.add(hinhnen);
		
		
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThemAccount)) {
			ManHinhDangKyTaiKhoan them = new ManHinhDangKyTaiKhoan();
			them.setVisible(true);
			this.dispose();
		}
		if(o.equals(btnDangNhap)) {
			KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
			String email="";
			String mk = "";
			String maKH ="";
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement st =null;
			try {
				String sql = "select * from KhachHang where email=? and matKhau=?";
				st = con.prepareStatement(sql);
				st.setNString(1, txtemail.getText().trim());
				st.setNString(2, pFDangNhap.getText().trim());
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					maKH=rs.getNString("maKH");
					if (maKH=="") break;
					email=rs.getNString("email");
					mk = rs.getNString("matKhau");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if (txtemail.getText().trim().equals("manager") && pFDangNhap.getText().trim().equals("123")) {
				ManHinhNguoiQuanLy gui_ql = new ManHinhNguoiQuanLy();
				gui_ql.setVisible(true);
				setVisible(false);
			}
			else	
			if (validDataDangNhap()) {
				if (maKH=="") SomeStaticMethod.showDialog(JOptionPane.ERROR_MESSAGE, "Sai tài khoản mật khẩu!");
				else
				if (txtemail.getText().trim().equals(email) && pFDangNhap.getText().equals(mk)) {
					//Home.isLogin=true;
					//NhanVienQuanLy qlnv = new NhanVienQuanLy();
					//qlnv.setVisible(true);
					setVisible(false);
					ManHinhChinh.isLogin=true;
					ManHinhChinh.user=khachHang_BUS.getKhachHang(maKH);
					System.out.println(ManHinhChinh.user.toString());
					ManHinhChinh.btnCart.setVisible(true);
					
					SomeStaticMethod.showDialog(10, "Đăng nhập thành công!");
					//DatTour.btnCart.setVisible(true);
				}
			}
		}
	}
	public boolean validDataDangNhap() {
        try {
            String taiKhoan = txtemail.getText();
            if(!(taiKhoan.length() > 0 && taiKhoan.matches("^[A-Za-z]{1}[\\w|\\.|\\_]+@(yahoo.com|gmail.com)$"))) {
                txtemail.selectAll();
                txtemail.requestFocus();
            	SomeStaticMethod.showDialog(2, "Email bắt đầu là chữ theo sau là ký tự tùy muốn và theo sau là @gmail hoặc @yahoo và tên miền");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	public static void main(String[] args) {
		new ManHinhDangNhap().setVisible(true);
	}

}
