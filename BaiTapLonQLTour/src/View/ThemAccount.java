package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custom_entity.Code_Generator;
import custom_entity.DateLabelFormatter;
import custom_entity.RoundedCornerBorder;
import custom_entity.ScaledImg;
import custom_entity.SomeStaticMethod;
import entities.KhachHang;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import connectDB.ConnectDB;

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
	private JRadioButton radNam, radNu;
	
	private UtilDateModel model; 
	private JDatePanelImpl datePanel; 
	private JDatePickerImpl datePicker;
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
		txtemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtemail.setBounds(30, 60, 400, 25);
		txtemail.setBackground(new Color(255, 255, 255, 0));
		txtemail.setOpaque(false);
		pnSignin.add(txtemail);
		txtemail.setColumns(10);
		
		txthoTen = new JTextField();
		txthoTen.setColumns(10);
		txthoTen.setBounds(30, 240, 400, 25);
		txthoTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txthoTen.setBackground(new Color(255,255,255,0));
		txthoTen.setOpaque(false);
		pnSignin.add(txthoTen);
		
		txtsDT = new JTextField();
		txtsDT.setColumns(10);
		txtsDT.setBounds(30, 300, 400, 25);
		txtsDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtsDT.setBackground(new Color(255,255,255,0));
		txtsDT.setOpaque(false);
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
		txtPass1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPass1.setBackground(new Color(255,255,255,0));
		txtPass1.setOpaque(false);
		pnSignin.add(txtPass1);
		
		txtPass2 = new JPasswordField();
		txtPass2.setBounds(30, 180, 400, 25);
		txtPass2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPass2.setBackground(new Color(255,255,255,0));
		txtPass2.setOpaque(false);
		pnSignin.add(txtPass2);
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBorder(null);
		datePicker.getJFormattedTextField().setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		datePicker.setBackground(new Color(255, 255, 255,0));
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255,0));
		datePicker.setBounds(30, 360, 400, 27);
		datePicker.getJDateInstantPanel().setShowYearButtons(true);
		//datePicker.getJFormattedTextField().setText("2023-01-01");
		datePicker.getJFormattedTextField().setForeground(Color.black);
		datePicker.setButtonFocusable(false);
		pnSignin.add(datePicker);
		
		radNam = new JRadioButton("Nam");
		radNam.setBackground(new Color(255, 255, 255, 0));
		radNam.setBounds(240, 420, 100, 25);
		pnSignin.add(radNam);
		
		radNu = new JRadioButton("Nữ");
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
		
		char dot = txtPass1.getEchoChar();
		JLabel btnShowPass = new JLabel("");
		btnShowPass.setIcon(new ImageIcon(FormDangNhap.class.getResource("/images/show.png")));
		btnShowPass.setBounds(440, 110, 40, 40);
		pnSignin.add(btnShowPass);
		
		
		
		JLabel btnHidePass = new JLabel("");
		btnHidePass.setIcon(new ImageIcon(FormDangNhap.class.getResource("/images/eye-off.png")));
		btnHidePass.setBounds(440, 110, 40, 40);
		btnHidePass.setVisible(false);
		pnSignin.add(btnHidePass);
		
		btnShowPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPass1.setEchoChar((char)0);
				btnHidePass.setVisible(true);
				btnShowPass.setVisible(false);
			}
		});
		
		btnHidePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPass1.setEchoChar(dot);
				btnShowPass.setVisible(true);
				btnHidePass.setVisible(false);
			}
		});
		
		JLabel btnShowPass1 = new JLabel("");
		btnShowPass1.setIcon(new ImageIcon(FormDangNhap.class.getResource("/images/show.png")));
		btnShowPass1.setBounds(440, 170, 40, 40);
		pnSignin.add(btnShowPass1);
		
		
		
		JLabel btnHidePass1 = new JLabel("");
		btnHidePass1.setIcon(new ImageIcon(FormDangNhap.class.getResource("/images/eye-off.png")));
		btnHidePass1.setBounds(440, 170, 40, 40);
		btnHidePass1.setVisible(false);
		pnSignin.add(btnHidePass1);
		
		btnShowPass1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPass2.setEchoChar((char)0);
				btnHidePass1.setVisible(true);
				btnShowPass1.setVisible(false);
			}
		});
		
		btnHidePass1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPass2.setEchoChar(dot);
				btnShowPass1.setVisible(true);
				btnHidePass1.setVisible(false);
			}
		});
		
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
		if(o.equals(btnThemAccount)) {	
			if (validDataDangKy()) {
				String email = txtemail.getText().trim();
				String mk = txtPass1.getText().trim();
				String hoten = txthoTen.getText().trim();
				String sdt = txtsDT.getText().trim();
				String[] ngaySinh = datePicker.getJFormattedTextField().getText().split("-");
				int nam = Integer.parseInt(ngaySinh[0]);
				int thang = Integer.parseInt(ngaySinh[1]);
				int ngay = Integer.parseInt(ngaySinh[2]);
				LocalDate ns = LocalDate.of(nam, thang, ngay);
				int gt = radNam.isSelected()?1:0;
				Boolean gtb = gt==1?true:false;
				String gtinh = gt==1?"Nam":"Nữ";
				String makh = Code_Generator.generateMaKhachHang(hoten, ns, gtinh);
				int n=0;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement st =null;
				
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký", "confirm", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					return;
				}
				try {
					String sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
					st = con.prepareStatement(sql);
					st.setNString(1, makh);
					st.setNString(2, hoten);
					st.setNString(3, ns.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
					st.setNString(4, sdt);
					st.setInt(5,gt);
					st.setNString(6, email);
					st.setNString(7, mk);				
					n = st.executeUpdate(); //update dữ liệu
					
//					if(txtemail.getText().equals("")||txtPass1.getText().equals("")||txtPass2.getText().equals("")||txthoTen.getText().equals("")||txtsDT.getText().equals("")||txtgtinh.getText().equals("")) {
//						JOptionPane.showMessageDialog(this, "Không để thông tin trống");
//					}
//					else if(n!=0) {
//						JOptionPane.showMessageDialog(this, "Đăng kí thành công!!");
//					} else {
//						JOptionPane.showMessageDialog(this, "Đăng kí thất bại!!");
//					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (n>0) {
					if (JOptionPane.showConfirmDialog(this, "Đăng ký thành công, bạn có muốn đăng nhập tại đây không?","Thông báo",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						KhachHang kh = new KhachHang(makh, hoten, ns,sdt,gtb, email, mk);
						Home.user=kh;
						Home.isLogin=true;
						Home.btnCart.setVisible(true);
						setVisible(false);
					}
					else return;
				}
			}
			
		} 
		if(o.equals(btnLogIn)) {
			FormDangNhap l = new FormDangNhap();
			l.setVisible(true);
			this.dispose();
		}
	}
	public boolean validDataDangKy() {
		try {
			String email = txtemail.getText();
			String matKhau = txtPass1.getText();
			String matKhau2 = txtPass2.getText();
			String hoTen = txthoTen.getText();
			String soDienThoai = txtsDT.getText();
			int namSinh = datePicker.getModel().getYear();
			LocalDateTime dt= LocalDateTime.now();
			int namHienTai = dt.getYear();
			if(!(email.length() > 0 && email.matches("([a-zA-Z]{1})([a-zA-Z0-9]*)(@)(yahoo|gmail)(.com)"))) {
				SomeStaticMethod.showDialog(2, "Email Ký tự đầu phải là chữ theo sau là chuỗi, @ và kết thúc là tên miền(.com)");
				txtemail.requestFocus();
				txtemail.selectAll();
				return false;
			}
			if(!(matKhau.length() >= 8 && matKhau.matches("([\\w]*)"))) {
				SomeStaticMethod.showDialog(2, "Độ dài mật khẩu phải lớn hơn hoặc bằng 8 ký tự");
				txtPass1.requestFocus();
				txtPass1.selectAll();
				return false;
			}
			if(!(matKhau2.equals(matKhau))) {
				SomeStaticMethod.showDialog(2, "Không trùng mật khẩu đầu");
				txtPass2.requestFocus();
				txtPass2.selectAll();
				return false;
			}
			if(!(hoTen.length() > 0 && hoTen.matches("^("+Code_Generator.tiengVietLow().toUpperCase()+Code_Generator.tiengVietLow()+"*((\\s)))+"+Code_Generator.tiengVietLow().toUpperCase()+Code_Generator.tiengVietLow()+"*$"))) {
				SomeStaticMethod.showDialog(2, "Họ Tên không chứa ký tự số. VD: Nguyễn Văn A");
				txthoTen.requestFocus();
				txthoTen.selectAll();
				return false;
			}
			if (!(soDienThoai.length() == 10 && soDienThoai.matches("([0])([0-9]{9})"))) {
				SomeStaticMethod.showDialog(2, "Số Điện thoại bắt đầu bằng số 0 và độ dài số điện thoại bằng 10");
				txtsDT.requestFocus();
				txtsDT.selectAll();
				return false;
			}
			int tuoi = namHienTai-namSinh;
			if(!(namSinh < namHienTai && tuoi >= 18)) {
				SomeStaticMethod.showDialog(2, String.valueOf("Năm sinh phải nhỏ hơn năm hiện tại và tuổi phải đủ 18"));
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
