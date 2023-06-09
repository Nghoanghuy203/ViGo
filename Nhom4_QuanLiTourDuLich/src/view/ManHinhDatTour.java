package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import bus.DonDatTour_BUS;
import bus.HanhKhach_BUS;
import bus.Tour_BUS;
import connectDB.ConnectDB;
import custom_entity.ScaledImg;
import custom_entity.SomeStaticMethod;
import custom_entity.Code_Generator;
import custom_entity.FileChooser;
import entities.DonDatTour;
import entities.HanhKhach;
import entities.KhachHang;
import entities.Tour;
import test.Test;

import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ManHinhDatTour extends JFrame {
	public static JLabel btnCart;
	private JPanel pnDatTour;
	private JTable table;
	private DefaultTableModel tableModel;
	private int soLuongHK;
	//
	private Tour_BUS tour_BUS;
	//
	private JLabel tenTour,maTour,ngayKhoiHanh,gioDi,diemTapTrung,soNgay,noiKhoiHanh,soChoConNhan,tenHDV,sdtHDV,giaTour,hinhAnh;
	private int soVeCon;
	
	private ManHinhDangNhap f = new ManHinhDangNhap();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
////		EventQueue.invokeLater(new Runnable() {
////			public void run() {
////				try {
////					DatTour frame = new DatTour();
////					frame.setVisible(true);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////		});
//		new DatTour(null).setVisible(true);
//	}

	/**
	 * Create the frame.
	 */
	public ManHinhDatTour(String ma) {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//
		tour_BUS = new Tour_BUS();
		setSize(1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//setBounds(84, 99, 1200, 620);
		//setBounds(84,19,1200,700);
		setLocationRelativeTo(null);
		pnDatTour = new JPanel();
		pnDatTour.setBackground(new Color(255, 255, 255));
		pnDatTour.setBorder(null);

		setContentPane(pnDatTour);
		pnDatTour.setLayout(null);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(null);
		pnHeader.setBackground(new Color(65, 105, 225));
		pnHeader.setBounds(0, 0, 1200, 80);
		pnDatTour.add(pnHeader);
		pnHeader.setLayout(null);
		
		JLabel btnExit = new JLabel("x");
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Arial", Font.PLAIN, 30));
		btnExit.setBounds(1177, 0, 23, 31);
		pnHeader.add(btnExit);
		
		JLabel btnUser = new JLabel("");
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!ManHinhChinh.isLogin) {	
					ManHinhDangNhap f = new ManHinhDangNhap();
					f.setVisible(true);
				}
				else {
					new ThongTinUser(ManHinhChinh.user).setVisible(true);
				}
			}
		});
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setIcon(new ImageIcon(ManHinhDatTour.class.getResource("/images/user.png")));
		btnUser.setBounds(1050, 11, 51, 52);
		pnHeader.add(btnUser);
		
		JLabel lblLogo = new JLabel("ViGo");
		lblLogo.setFont(new Font("Arial", Font.BOLD, 35));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setIcon(new ImageIcon(ManHinhDatTour.class.getResource("/images/logo.png")));
		lblLogo.setBounds(10, 3, 211, 72);
		pnHeader.add(lblLogo);
		
		btnCart = new JLabel("");
		btnCart.setVisible(false);
		btnCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThongTinGioHang hienThiDanhSachVe = new ThongTinGioHang();
				hienThiDanhSachVe.setVisible(true);
			}
		});
		btnCart.setBounds(1104, 11, 51, 52);
		pnHeader.add(btnCart);
		btnCart.setIcon(new ImageIcon(ManHinhDatTour.class.getResource("/images/cart.png")));
		if (ManHinhChinh.isLogin) btnCart.setVisible(true);
		
		tenTour = new JLabel("Đà Lạt");
		tenTour.setForeground(new Color(65, 105, 225));
		tenTour.setFont(new Font("Arial", Font.PLAIN, 30));
		tenTour.setBounds(74, 123, 468, 49);
		pnDatTour.add(tenTour);
		
		JLabel h1 = new JLabel("Thông tin cơ bản:");
		h1.setFont(new Font("Arial", Font.PLAIN, 20));
		h1.setBounds(74, 204, 161, 21);
		pnDatTour.add(h1);
		
		maTour = new JLabel("Mã tour:");
		maTour.setBounds(114, 232, 300, 14);
		pnDatTour.add(maTour);
		
		ngayKhoiHanh = new JLabel("Khởi hành 11/04/2023");
		ngayKhoiHanh.setBounds(114, 252, 186, 14);
		pnDatTour.add(ngayKhoiHanh);
		
		gioDi = new JLabel("- Giờ đi: 17:50");
		gioDi.setBounds(278, 252, 131, 14);
		pnDatTour.add(gioDi);
		
		diemTapTrung = new JLabel("Tập trung 15:00 tại sân bay Tân Sơn Nhất ");
		diemTapTrung.setBounds(114, 272, 385, 14);
		pnDatTour.add(diemTapTrung);
		
		soNgay = new JLabel("Số ngày: 3");
		soNgay.setBounds(114, 292, 99, 14);
		pnDatTour.add(soNgay);
		
		noiKhoiHanh = new JLabel("Nơi khởi hành: TP Hồ Chí Minh");
		noiKhoiHanh.setBounds(114, 312, 246, 14);
		pnDatTour.add(noiKhoiHanh);
		
		soChoConNhan = new JLabel("Số chỗ còn nhận: 2");
		soChoConNhan.setBounds(114, 332, 131, 14);
		pnDatTour.add(soChoConNhan);
		
		JLabel h2 = new JLabel("Thông tin hướng dẫn viên:");
		h2.setFont(new Font("Arial", Font.PLAIN, 20));
		h2.setBounds(74, 354, 246, 24);
		pnDatTour.add(h2);
		
		tenHDV = new JLabel("Họ tên: Nguyễn Văn A");
		tenHDV.setBounds(114, 382, 196, 14);
		pnDatTour.add(tenHDV);
		
		sdtHDV = new JLabel("Số điện thoại: 0213232333");
		sdtHDV.setBounds(114, 402, 196, 14);
		pnDatTour.add(sdtHDV);
		
		JPanel btnDatNgay = new JPanel();
		btnDatNgay.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                if (!ManHinhChinh.isLogin) {
                    showLogin();
                }
                else 
                if(tableModel.getValueAt(0, 1).toString().trim().equals("")) {
                	SomeStaticMethod.showDialog(JOptionPane.ERROR_MESSAGE, "Bạn không thể đặt tour khi chưa thêm ít nhất 1 hàng khách");
                }
                else {
                	HanhKhach_BUS hanhKhach_BUS = new HanhKhach_BUS();
                	DonDatTour_BUS donDatTour_BUS = new  DonDatTour_BUS();
                	String maDon = Code_Generator.generateMaDon(ma, ManHinhChinh.user.getSoNguoiDung());
                	Tour t = tour_BUS.getTour(ma);
                	KhachHang kh = ManHinhChinh.user;
                	DonDatTour don = new DonDatTour(maDon, t, kh, Date.valueOf(LocalDate.now()), soLuongHK);
                	if (donDatTour_BUS.themDonDatTour(don)) {
                		Code_Generator.Count=1;
                		for (int i = 0; i < soLuongHK; i++) {
                    		String hoTenHK = (String) table.getValueAt(i, 1);
                    		
                    		String sdt = (String) table.getValueAt(i, 2);
                    		String maHK = Code_Generator.generateMaHanhKhach(hoTenHK);
                    		HanhKhach hk = new HanhKhach(maHK+maDon.substring(0, 10), hoTenHK, sdt);
                    		hanhKhach_BUS.themHanhKhach(hk, maDon);
    					}
                		tour_BUS.capNhatSoLuongVe(ma, soLuongHK);
                		ManHinhChinh.ds=tour_BUS.getDS();
                		Tour mTour = tour_BUS.getTour(ma);
                		hienThongTinTour(t.getMaTour());
                		SomeStaticMethod.showDialog(10, "Bạn đã đặt tour thành công!");
                		if (mTour.getSoVeConLai()==0) setVisible(false);
                	}
                	else SomeStaticMethod.showDialog(10, "Đặt tour thất bại!");
                }
            }
		});
		btnDatNgay.setBackground(new Color(220, 20, 60));
		btnDatNgay.setToolTipText("");
		btnDatNgay.setBounds(74, 615, 246, 49);
		pnDatTour.add(btnDatNgay);
		btnDatNgay.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Đặt ngay");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(97, 11, 74, 29);
		btnDatNgay.add(lblNewLabel_10);
		
		hinhAnh = new JLabel("");
		hinhAnh.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		hinhAnh.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\thanh-pho-da-lat.jpg"));
		hinhAnh.setBounds(469, 123, 653, 332);
		pnDatTour.add(hinhAnh);
		
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				//System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon(ManHinhDatTour.class.getResource("/images/back.png")));
		btnTroVe.setBounds(10, 90, 80, 21);
		pnDatTour.add(btnTroVe);
		
		giaTour = new JLabel("5.000.000đ");
		giaTour.setForeground(new Color(255, 0, 0));
		giaTour.setFont(new Font("Arial", Font.BOLD, 26));
		giaTour.setBounds(74, 166, 161, 28);
		pnDatTour.add(giaTour);
		
		hienThongTinTour(ma);
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(1,1,soVeCon,1));
		spinner.addChangeListener((ChangeListener) new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				soLuongHK = (int) spinner.getValue();
				showTable();
			}
        });
		spinner.setBounds(230, 485, 45, 28);
		pnDatTour.add(spinner);
		spinner.setValue((int)1);
		
		
		JLabel soLuongVe = new JLabel("Số lượng vé");
		soLuongVe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		soLuongVe.setBounds(74, 485, 161, 28);
		pnDatTour.add(soLuongVe);
		String header[] = {"STT","Họ tên","Số điện thoại"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int col) {
				// TODO Auto-generated method stub
				if (col==0) return false;
				return true;
			}
		});
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		table.setBorder(null);
		scrollPane.setBounds(469, 489, 653, 175);
		pnDatTour.add(scrollPane);
		
		
		soLuongHK=1;
		showTable();
		
	}
	
	private void removeDataTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		table.setModel(dm);
	}
	private void updateDataTable() {
		removeDataTable();
		for (int i=0;i<soLuongHK;i++) {
			String []data = {i+1+"","",""};
			tableModel.addRow(data);
		}
	}
	private void showTable() {
		updateDataTable();
		table.setModel(tableModel);
	}
	public void hienThongTinTour(String ma) {
		Tour t = tour_BUS.getTour(ma);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		soVeCon=t.getSoVeConLai();
		tenTour.setText(t.getTenTour());
		maTour.setText("Mã tour: "+t.getMaTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		giaTour.setText(df.format(t.getGia()));
		ngayKhoiHanh.setText("Ngày khởi hành: "+dtf.format(t.getNgayKhoiHanh()));
		gioDi.setText("-Giờ đi: "+DateFormat.getTimeInstance().format(t.getTgKhoiHanh()));
		diemTapTrung.setText("Thời gian tập trung: "+DateFormat.getTimeInstance().format(t.getTgTapTrung())+", "+dtf.format(t.getNgayKhoiHanh()));
		soNgay.setText("Thời gian: "+t.getSoNgay()+" ngày");
		noiKhoiHanh.setText("Lộ trình: "+t.getDiemDi()+" đến "+t.getDiemDen());
		soChoConNhan.setText("Số vé còn nhận: "+t.getSoVeConLai());
		hinhAnh.setIcon(new ImageIcon(ScaledImg.scaledImage(t.getHinhAnh(), hinhAnh.getWidth(), hinhAnh.getHeight())));
		tenHDV.setText("Họ tên: "+t.getHdv().getHoTen());
		sdtHDV.setText("Số điện thoại: "+t.getHdv().getSdt());
	}

	public void showLogin() {
		if (!ManHinhChinh.isLogin) {
			if (JOptionPane.showConfirmDialog(this, "Bạn cần đăng nhập tài khoản để đặt tour!", "Lưu ý", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				new ManHinhDangNhap().setVisible(true);
			}	
		}
	}
	public void showMs() {
		JOptionPane.showMessageDialog(this, "succes!");
	}
}
