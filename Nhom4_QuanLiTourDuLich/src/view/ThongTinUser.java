package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import custom_entity.RoundedCornerBorder;
import entities.KhachHang;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

public class ThongTinUser extends JFrame{
	private JLabel txtHoTen,txtEmail;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtSdt;
	public ThongTinUser(KhachHang user) {
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
			
		JPanel pnContent = new JPanel();
		pnContent.setBorder(new LineBorder(Color.BLUE, 1, true));
		pnContent.setBackground(Color.WHITE);
		pnContent.setBounds(750, 80, 350, 400);
		pnContent.setLayout(null);
		pnMain.add(pnContent);
		
		JLabel lblNewLabel = new JLabel("Khách hàng");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 10, 100, 20);
		pnContent.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(ThongTinUser.class.getResource("/images/account.png")));
		lblNewLabel_1.setBounds(135, 35, 80, 80);
		pnContent.add(lblNewLabel_1);
		
		txtHoTen = new JLabel("Nguyễn Hoàng Huy");
		txtHoTen.setFont(new Font("Calibri", Font.BOLD, 14));
		txtHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoTen.setBounds(75, 110, 200, 20);
		txtHoTen.setText(user.getHoTen());
		pnContent.add(txtHoTen);
		
		txtEmail = new JLabel("ng.hoang.huy23@gmail.com");
		txtEmail.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(50, 130, 250, 20);
		txtEmail.setText(user.getEmail());
		pnContent.add(txtEmail);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày sinh:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 170, 100, 20);
		pnContent.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Giới tính:");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(30, 220, 100, 20);
		pnContent.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_4_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(30, 270, 100, 20);
		pnContent.add(lblNewLabel_4_1_1);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBorder(null);
		txtNgaySinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNgaySinh.setText("02-03-2003");
		txtNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgaySinh.setBounds(170, 170, 150, 20);
		txtNgaySinh.setText(user.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		pnContent.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBorder(null);
		txtGioiTinh.setText("Nam");
		txtGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(170, 220, 150, 20);
		String gt = user.isGioiTinh()?"Nam":"Nữ";
		txtGioiTinh.setText(gt);
		pnContent.add(txtGioiTinh);
		
		txtSdt = new JTextField();
		txtSdt.setDisabledTextColor(Color.WHITE);
		txtSdt.setBorder(null);
		txtSdt.setText("0362026128");
		txtSdt.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSdt.setColumns(10);
		txtSdt.setBounds(170, 270, 150, 20);
		txtSdt.setText(user.getSoDienThoai());
		pnContent.add(txtSdt);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManHinhChinh.isLogin=false;
				ManHinhChinh.user=null;
				ManHinhChinh.btnCart.setVisible(false);
				//DatTour.btnCart.setVisible(false);
				setVisible(false);
			}
		});
		btnDangXuat.setBorder(null);
		btnDangXuat.setBackground(new Color(65, 105, 225));
		btnDangXuat.setFont(new Font("Arial", Font.BOLD, 16));
		btnDangXuat.setBounds(105, 330, 140, 30);
		btnDangXuat.setForeground(Color.white);
		pnContent.add(btnDangXuat);
		
		JLabel btnReturn = new JLabel("X");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Arial", Font.BOLD, 14));
		btnReturn.setHorizontalAlignment(SwingConstants.CENTER);
		btnReturn.setBounds(315, 5, 30, 20);
		pnContent.add(btnReturn);
	}
}
