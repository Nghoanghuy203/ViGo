package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import custom_entity.ChonMau;
import custom_entity.CustomTable;
import custom_entity.DateLabelFormatter;
import custom_entity.RoundedCornerBorder;
import custom_entity.ScaledImg;
import entities.DonDatTour;
import entities.HanhKhach;
import entities.HuongDanVien;
import entities.KhachHang;
import entities.Tour;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import bus.DonDatTour_BUS;
import bus.HanhKhach_BUS;
import bus.HuongDanVien_BUS;
import bus.KhachHang_BUS;
import bus.Tour_BUS;
import connectDB.ConnectDB;

import java.awt.Color;
import java.awt.Cursor;
import custom_entity.CustomButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import custom_entity.CustomComboxBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class NhanVienQuanLy extends JFrame {

	private JPanel pnNhanVienQuanLy;
	private CustomComboxBox cboDiemDen;
	private CustomComboxBox cboDiemDi;
	private CustomComboxBox cboThang;
	private ArrayList<Tour> dsTour;
	private Tour_BUS tour_BUS;
	private KhachHang nguoiDungBus;
	private String sDDi, sDDen, sNgay;
	private JLabel lblNgy;
	private UtilDateModel model; 
	private JDatePanelImpl datePanel; 
	private JDatePickerImpl datePicker;
	private CustomTable table;
	private DefaultTableModel modelKhachHang,modelTour,modelDonDat,modelHuongDanVien,modelHangKhach;
	private String[] strDiemDi,strDiemDen;
	private JTextField T_txtMaTour,D_txtSoDonDatTour,HDV_txtMaHDV;
	private JTextField T_txtTenTour,D_txtMaTour,HDV_txtHoTen;
	private JTextField T_txtTgTapTrung,D_txtTenTour,HDV_txtSoDienThoai;
	private JTextField T_txtTgKhoiHanh,D_txtSoNguoiDung;
	private JTextField T_txtSoNgay,D_txtHoTen;
	private JTextField T_txtSoVeCon,D_txtSoVe;
	private JTextField T_txtGia,D_txtTgDatTour;
	private JTextField T_txtDiemDi,D_txtTongTien,T_txtDiemDen;
	private JTextField txtSearch;
	private JTextField txtTim;
	private CustomButton T_btnThem,D_btnThem,HDV_btnThem;
	private CustomButton T_btnXoa,D_btnXoa,HDV_btnXoa;
	private CustomButton T_btnSua,D_btnSua,HDV_btnSua;
	private CustomButton btnTim;
	private int soVeThapNhat, soVeCaoNhat;
	private double tongGiaThapNhat,tongGiaCaoNhat;
	private JPanel T_panel,KH_panel,D_panel,HDV_panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhanVienQuanLy frame = new NhanVienQuanLy();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		new NhanVienQuanLy().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public NhanVienQuanLy() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//
		//tourBus = new Tour_BUS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		// setBounds(84, 99, 1200, 620);
		setBounds(84, 19, 1200, 700);
		
		//huongDanVien_BUS = new HuongDanVien_BUS();
		//dsHDV = huongDanVien_BUS.getDSHuongDanVien();
		//dsKH = khachHang_BUS.getDSKhachHang();
		pnNhanVienQuanLy = new JPanel();
		pnNhanVienQuanLy.setBackground(new Color(255, 255, 255));
		pnNhanVienQuanLy.setBorder(null);

		setContentPane(pnNhanVienQuanLy);
		pnNhanVienQuanLy.setLayout(null);

		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(null);
		pnHeader.setBackground(new Color(65, 105, 225));
		pnHeader.setBounds(0, 0, 1200, 80);
		pnNhanVienQuanLy.add(pnHeader);
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
//		btnUser.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				login = new LoginSignup();
//				login.main(null);
//			}
//		});
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\user.png"));
		btnUser.setBounds(1050, 11, 51, 52);
		pnHeader.add(btnUser);

		JLabel lblLogo = new JLabel("ViGo");
		lblLogo.setFont(new Font("Arial", Font.BOLD, 35));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\beach_118051 (1).png"));
		lblLogo.setBounds(10, 3, 211, 72);
		pnHeader.add(lblLogo);

		JLabel btnCart = new JLabel("");
		btnCart.setBounds(1104, 11, 51, 52);
		pnHeader.add(btnCart);
		btnCart.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\cart.png"));
		
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				// System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon("C:\\Users\\nghoa\\Downloads\\back.png"));
		btnTroVe.setBounds(10, 90, 80, 21);
		pnNhanVienQuanLy.add(btnTroVe);
		
		CustomButton btnTour = new CustomButton((String) null);
		btnTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//T_panel.setVisible(false);
				KH_panel.setVisible(false);
				D_panel.setVisible(false);
				HDV_panel.setVisible(false);
				GUI_Tour();
			}
		});
		btnTour.setColor_fogeground(ChonMau.blue_4B70F5);
		btnTour.setHightlight(Color.WHITE);
		btnTour.setForeground(ChonMau.blue_4B70F5);
		btnTour.setRadius(30);
		btnTour.setText("TOUR");
		btnTour.setBounds(20, 122, 130, 50);
		btnTour.setFont(new Font("Arial", Font.BOLD, 30));
		pnNhanVienQuanLy.add(btnTour);
		
		CustomButton btnKhachHang = new CustomButton((String) null);
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T_panel.setVisible(false);
				//KH_panel.setVisible(false);
				D_panel.setVisible(false);
				HDV_panel.setVisible(false);
				GUI_KhachHang();
			}
		});
		btnKhachHang.setText("KHÁCH HÀNG");
		btnKhachHang.setRadius(30);
		btnKhachHang.setHightlight(Color.WHITE);
		btnKhachHang.setForeground(new Color(75, 112, 245));
		btnKhachHang.setFont(new Font("Arial", Font.BOLD, 30));
		btnKhachHang.setColor_fogeground(new Color(75, 112, 245));
		btnKhachHang.setBounds(160, 122, 214, 50);
		pnNhanVienQuanLy.add(btnKhachHang);
		
		CustomButton btnDonDat = new CustomButton((String) null);
		btnDonDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T_panel.setVisible(false);
				KH_panel.setVisible(false);
				//D_panel.setVisible(false);
				HDV_panel.setVisible(false);
				GUI_DonDat();
			}
		});
		btnDonDat.setText("ĐƠN ĐẶT");
		btnDonDat.setRadius(30);
		btnDonDat.setHightlight(Color.WHITE);
		btnDonDat.setForeground(new Color(75, 112, 245));
		btnDonDat.setFont(new Font("Arial", Font.BOLD, 30));
		btnDonDat.setColor_fogeground(new Color(75, 112, 245));
		btnDonDat.setBounds(383, 122, 168, 50);
		pnNhanVienQuanLy.add(btnDonDat);
		
		CustomButton btnHuongDanVien = new CustomButton((String) null);
		btnHuongDanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T_panel.setVisible(false);
				KH_panel.setVisible(false);
				D_panel.setVisible(false);
				//HDV_panel.setVisible(false);
				GUI_HuongDanVien();
			}
		});
		btnHuongDanVien.setText("HG DẪN VIÊN");
		btnHuongDanVien.setRadius(30);
		btnHuongDanVien.setHightlight(Color.WHITE);
		btnHuongDanVien.setForeground(new Color(75, 112, 245));
		btnHuongDanVien.setFont(new Font("Arial", Font.BOLD, 30));
		btnHuongDanVien.setColor_fogeground(new Color(75, 112, 245));
		btnHuongDanVien.setBounds(561, 122, 230, 50);
		pnNhanVienQuanLy.add(btnHuongDanVien);
		
		JLabel lblTraCuu = new JLabel("Tra cứu mã, tên, SDT hoặc email:");
		lblTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTraCuu.setBounds(803, 122, 240, 20);
		pnNhanVienQuanLy.add(lblTraCuu);
		
		txtTim = new JTextField();
		txtTim.setBounds(801, 145, 283, 27);
		pnNhanVienQuanLy.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new CustomButton((String) null);
		btnTim.setBounds(1094, 145, 80, 27);
		pnNhanVienQuanLy.add(btnTim);
		btnTim.setHightlight(Color.WHITE);
		btnTim.setForeground(new Color(75, 112, 245));
		btnTim.setFont(new Font("Arial", Font.BOLD, 20));
		btnTim.setColor_fogeground(new Color(75, 112, 245));
		btnTim.setText("TÌM");
		
		T_panel = new JPanel();
		D_panel = new JPanel();
		KH_panel = new JPanel();
		HDV_panel = new JPanel();
		
		//GUI_KhachHang();
		//GUI_Tour();
		GUI_HuongDanVien();
		//GUI_DonDat();
	}
	private void GUI_Tour() {
		//dsTour = tourBus.getDS();
		tour_BUS = new Tour_BUS();
		dsTour = tour_BUS.getDS();
		T_panel.setBounds(20, 183, 1170, 506);
		pnNhanVienQuanLy.add(T_panel);
		T_panel.setLayout(null);
		T_panel.setVisible(true);
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		JPanel search = new JPanel();
		search.setBounds(0, 11, 771, 58);
		T_panel.add(search);
		search.setBackground(new Color(255, 255, 255));
		search.setLayout(null);
		search.setBorder(new RoundedCornerBorder());
		strDiemDi = updateCboBoxDiemDi();
		strDiemDen = updateCboBoxDiemDen();
		cboDiemDi = new CustomComboxBox(strDiemDi, ChonMau.blue_4B70F5, Color.white, Color.black, ChonMau.blue_4B70F5, 30, true);
		cboDiemDi.setSize(93, 31);
		cboDiemDi.setEditable(true);
		cboDiemDi.setLocation(63, 10);
		search.add(cboDiemDi.getPanel(Color.white, 55, 5, 170, 45));
		sDDi = (String) cboDiemDi.getSelectedItem();
		
		JLabel sDiemDi = new JLabel("Điểm đi:");
		sDiemDi.setFont(new Font("Arial", Font.PLAIN, 12));
		sDiemDi.setBounds(10, 21, 50, 20);
		search.add(sDiemDi);
		
		JLabel sDiemDen = new JLabel("Điểm đến:");
		sDiemDen.setFont(new Font("Arial", Font.PLAIN, 12));
		sDiemDen.setBounds(230, 21, 66, 20);
		search.add(sDiemDen);
		cboDiemDen = new CustomComboxBox(strDiemDen, ChonMau.blue_4B70F5, Color.white, Color.black, ChonMau.blue_4B70F5, 30, true);
		cboDiemDen.setSize(128, 37);
		cboDiemDen.setLocation(288, 10);
		search.add(cboDiemDen.getPanel(Color.white, 280, 5, 170, 45));
		sDDen = (String) cboDiemDen.getSelectedItem();
		
		lblNgy = new JLabel("Ngày:");
		lblNgy.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNgy.setBounds(450, 21, 36, 20);
		search.add(lblNgy);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		datePicker.setBackground(new Color(255, 255, 255));
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setBounds(490, 17, 180, 28);
		datePicker.getJDateInstantPanel().setShowYearButtons(true);
		//datePicker.getJFormattedTextField().setText("2023-01-01");
		//datePicker.getModel().setValue(Date("2023-01-01"));
		search.add(datePicker);
		
		CustomButton customButton = new CustomButton((String) null);
		customButton.setBounds(699, 25, 1, 1);
		search.add(customButton);
		
		CustomButton cstmbtnLc = new CustomButton((String) null);
		cstmbtnLc.setRadius(20);
		cstmbtnLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cstmbtnLc.setForeground(ChonMau.blue_4B70F5);
		cstmbtnLc.setOver(true);
		cstmbtnLc.setText("LỌC");
		cstmbtnLc.setBounds(680, 18, 55, 26);
		search.add(cstmbtnLc);
		
		String header[] =  "Mã Tour, Tên Tour,TG TTrung, TG KhHành,Số Ngày, Số Vé Còn,Giá,Điểm Đi,Điểm Đến,HDV".split(",");
		modelTour = new DefaultTableModel(header,0);
		for (Tour tour : dsTour) {
			modelTour.addRow(tour.toString().split(";"));
		}
		CustomButton customButton_1 = new CustomButton((String) null);
		customButton_1.setBounds(351, 488, 1, 1);
		T_panel.add(customButton_1);
		
		CustomTable customTable = new CustomTable(modelTour, ChonMau.blue_4B70F5, Color.white);
		customTable.setBounds(10, 90, 761, 387);
		
		JScrollPane scrollPane = new JScrollPane(customTable);
		scrollPane.setBounds(0, 77, 771, 397);
		T_panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(ChonMau.blue_4B70F5));
		panel_1.setBounds(781, 11, 379, 464);
		T_panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin Tour");
		lblNewLabel_1.setBounds(85, 0, 217, 34);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		T_txtMaTour = new JTextField();
		T_txtMaTour.setColumns(10);
		T_txtMaTour.setBounds(151, 36, 206, 20);
		panel_1.add(T_txtMaTour);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Tour");
		lblNewLabel_2.setBounds(10, 36, 97, 14);
		panel_1.add(lblNewLabel_2);
		
		T_txtTenTour = new JTextField();
		T_txtTenTour.setColumns(10);
		T_txtTenTour.setBounds(151, 68, 206, 20);
		panel_1.add(T_txtTenTour);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Tour");
		lblNewLabel_2_1.setBounds(10, 68, 97, 14);
		panel_1.add(lblNewLabel_2_1);
		
		T_txtTgKhoiHanh = new JTextField();
		T_txtTgKhoiHanh.setColumns(10);
		T_txtTgKhoiHanh.setBounds(151, 99, 206, 20);
		panel_1.add(T_txtTgKhoiHanh);
		
		JLabel lblNewLabel_2_2 = new JLabel("Thời Gian Khởi Hành");
		lblNewLabel_2_2.setBounds(10, 99, 131, 14);
		panel_1.add(lblNewLabel_2_2);
		
		T_txtSoNgay = new JTextField();
		T_txtSoNgay.setColumns(10);
		T_txtSoNgay.setBounds(151, 130, 206, 20);
		panel_1.add(T_txtSoNgay);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Số Ngày");
		lblNewLabel_2_2_1.setBounds(10, 130, 97, 14);
		panel_1.add(lblNewLabel_2_2_1);
		
		T_txtSoVeCon = new JTextField();
		T_txtSoVeCon.setColumns(10);
		T_txtSoVeCon.setBounds(151, 161, 206, 20);
		panel_1.add(T_txtSoVeCon);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Số Vé Còn");
		lblNewLabel_2_2_2.setBounds(10, 161, 97, 14);
		panel_1.add(lblNewLabel_2_2_2);
		
		T_txtGia = new JTextField();
		T_txtGia.setColumns(10);
		T_txtGia.setBounds(151, 192, 206, 20);
		panel_1.add(T_txtGia);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Giá");
		lblNewLabel_2_2_3.setBounds(10, 192, 97, 14);
		panel_1.add(lblNewLabel_2_2_3);
		
		T_txtTgTapTrung = new JTextField();
		T_txtTgTapTrung.setColumns(10);
		T_txtTgTapTrung.setBounds(151, 223, 206, 20);
		panel_1.add(T_txtTgTapTrung);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Thời Gian Tập Trung");
		lblNewLabel_2_2_4.setBounds(10, 223, 131, 14);
		panel_1.add(lblNewLabel_2_2_4);
		
		T_txtDiemDi = new JTextField();
		T_txtDiemDi.setColumns(10);
		T_txtDiemDi.setBounds(151, 254, 206, 20);
		panel_1.add(T_txtDiemDi);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Điểm Đi");
		lblNewLabel_2_2_5.setBounds(10, 254, 97, 14);
		panel_1.add(lblNewLabel_2_2_5);
		
		T_txtDiemDen = new JTextField();
		T_txtDiemDen.setColumns(10);
		T_txtDiemDen.setBounds(151, 285, 206, 20);
		panel_1.add(T_txtDiemDen);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("Điểm Đến");
		lblNewLabel_2_2_6.setBounds(10, 285, 97, 14);
		panel_1.add(lblNewLabel_2_2_6);
		
		T_btnThem = new CustomButton((String) null);
		T_btnThem.setText("Thêm");
		T_btnThem.setRadius(30);
		T_btnThem.setHightlight(Color.WHITE);
		T_btnThem.setForeground(new Color(75, 112, 245));
		T_btnThem.setFont(new Font("Dialog", Font.PLAIN, 30));
		T_btnThem.setColor_fogeground(new Color(75, 112, 245));
		T_btnThem.setBounds(10, 414, 97, 39);
		panel_1.add(T_btnThem);
		
		T_btnXoa = new CustomButton((String) null);
		T_btnXoa.setText("Xóa");
		T_btnXoa.setRadius(30);
		T_btnXoa.setHightlight(Color.WHITE);
		T_btnXoa.setForeground(new Color(75, 112, 245));
		T_btnXoa.setFont(new Font("Dialog", Font.PLAIN, 30));
		T_btnXoa.setColor_fogeground(new Color(75, 112, 245));
		T_btnXoa.setBounds(136, 416, 101, 34);
		panel_1.add(T_btnXoa);
		
		T_btnSua = new CustomButton((String) null);
		T_btnSua.setText("Sửa");
		T_btnSua.setRadius(30);
		T_btnSua.setHightlight(Color.WHITE);
		T_btnSua.setForeground(new Color(75, 112, 245));
		T_btnSua.setFont(new Font("Dialog", Font.PLAIN, 30));
		T_btnSua.setColor_fogeground(new Color(75, 112, 245));
		T_btnSua.setBounds(268, 416, 101, 34);
		panel_1.add(T_btnSua);
		
		JLabel lblNewLabel_2_2_6_1 = new JLabel("Hình Ảnh");
		lblNewLabel_2_2_6_1.setBounds(10, 310, 97, 14);
		panel_1.add(lblNewLabel_2_2_6_1);
		
		JLabel lblNewLabel_3 = new JLabel("Label Hinh");
		lblNewLabel_3.setBounds(151, 316, 206, 89);
		panel_1.add(lblNewLabel_3);
		
		customTable.addMouseListener(new MouseListener() {
				
			@Override
			public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = customTable.getSelectedRow();
				T_txtMaTour.setText((String)customTable.getValueAt(selected, 0));
				T_txtTenTour.setText((String)customTable.getValueAt(selected, 1));
				T_txtTgTapTrung.setText((String)customTable.getValueAt(selected, 2));
				T_txtTgKhoiHanh.setText((String)customTable.getValueAt(selected, 3));
				T_txtSoNgay.setText((String)customTable.getValueAt(selected, 4));
				T_txtSoVeCon.setText((String)customTable.getValueAt(selected, 5));
				T_txtGia.setText((String)customTable.getValueAt(selected, 6));
				T_txtDiemDi.setText((String)customTable.getValueAt(selected, 7));
				T_txtDiemDen.setText((String)customTable.getValueAt(selected, 8));
				for (Tour t : dsTour) {
					if(T_txtMaTour.getText().equals(t.getMaTour())){
						lblNewLabel_3.setIcon(new ImageIcon(ScaledImg.scaledImage(t.getHinhAnh(), lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight())));
					}
				}
			}
		});
	}
	private void GUI_KhachHang() {
		KhachHang_BUS khachHang_BUS= new KhachHang_BUS();
		ArrayList<KhachHang> dsKH =khachHang_BUS.getDSKhachHang();
		KH_panel.setBounds(20, 183, 1170, 506);
		pnNhanVienQuanLy.add(KH_panel);
		KH_panel.setLayout(null);
		KH_panel.setVisible(true);
		
		String header[] =  "Số Khách Hàng,Họ Tên,Ngày Sinh,SĐT,Giới Tính,TK Email,Mật Khẩu".split(",");
		modelKhachHang = new DefaultTableModel(header,0);
		//tkBus = new KhachHang_BUS();
		//ds_KhachHang = tkBus.getDsTK();
		for (KhachHang khachHang : dsKH) {
			modelKhachHang.addRow(khachHang.toString().split(";"));
		}
		
		CustomButton customButton_1 = new CustomButton((String) null);
		customButton_1.setBounds(351, 488, 1, 1);
		KH_panel.add(customButton_1);
		
		CustomTable customTable = new CustomTable(modelKhachHang, ChonMau.blue_4B70F5, Color.white);
		customTable.setModel(modelKhachHang);
		customTable.setBounds(10, 90, 761, 387);
		
		JScrollPane scrollPane = new JScrollPane(customTable);
		scrollPane.setBounds(0, 0, 771, 463);
		KH_panel.add(scrollPane);
		
		
		JPanel pnThongTinKH = new JPanel();
		pnThongTinKH.setBorder(new LineBorder(ChonMau.blue_4B70F5));
		pnThongTinKH.setBounds(781, 0, 379, 463);
		KH_panel.add(pnThongTinKH);
		pnThongTinKH.setLayout(null);
		
		JTextField KH_txtTaiKhoan = new JTextField();
		KH_txtTaiKhoan.setColumns(10);
		KH_txtTaiKhoan.setBounds(130, 110, 240, 20);
		KH_txtTaiKhoan.setEditable(false);
		pnThongTinKH.add(KH_txtTaiKhoan);
		
		JLabel lblTaiKhoan = new JLabel("Email:");
		lblTaiKhoan.setFont(new Font("Arial", Font.BOLD, 15));
		lblTaiKhoan.setBounds(20, 110, 100, 20);
		pnThongTinKH.add(lblTaiKhoan);
		
		
		CustomButton KH_btnThem = new CustomButton((String) null);
		//KH_btnThem.setIcon(new ImageIcon(NhanVienQuanLy.class.getResource("/images/left-arrow.png")));
		KH_btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		KH_btnThem.setBounds(3, 406, 125, 47);
		pnThongTinKH.add(KH_btnThem);
		KH_btnThem.setText("Thêm");
		KH_btnThem.setRadius(30);
		KH_btnThem.setHightlight(Color.WHITE);
		KH_btnThem.setForeground(new Color(75, 112, 245));
		KH_btnThem.setFont(new Font("Arial", Font.BOLD, 30));
		KH_btnThem.setColor_fogeground(new Color(75, 112, 245));
		
		CustomButton KH_btnXoa = new CustomButton((String) null);
		//KH_btnXoa.setIcon(new ImageIcon(NhanVienQuanLy.class.getResource("/images/right-arrow.png")));
		KH_btnXoa.setBounds(138, 406, 113, 47);
		pnThongTinKH.add(KH_btnXoa);
		KH_btnXoa.setText("Xóa");
		KH_btnXoa.setRadius(30);
		KH_btnXoa.setHightlight(Color.WHITE);
		KH_btnXoa.setForeground(new Color(75, 112, 245));
		KH_btnXoa.setFont(new Font("Arial", Font.BOLD, 30));
		KH_btnXoa.setColor_fogeground(new Color(75, 112, 245));
		
		CustomButton KH_btnSua = new CustomButton((String) null);
		//KH_btnSua.setIcon(new ImageIcon(NhanVienQuanLy.class.getResource("/images/right-arrow.png")));
		KH_btnSua.setBounds(261, 406, 114, 47);
		pnThongTinKH.add(KH_btnSua);
		KH_btnSua.setText("Sửa");
		KH_btnSua.setRadius(30);
		KH_btnSua.setHightlight(Color.WHITE);
		KH_btnSua.setForeground(new Color(75, 112, 245));
		KH_btnSua.setFont(new Font("Arial", Font.BOLD, 30));
		KH_btnSua.setColor_fogeground(new Color(75, 112, 245));
		
		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN TÀI KHOẢN KHÁCH HÀNG");
		lblNewLabel_1.setBounds(3, 11, 379, 34);
		pnThongTinKH.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMK = new JLabel("Mật Khẩu:");
		lblMK.setBounds(20, 150, 100, 20);
		pnThongTinKH.add(lblMK);
		lblMK.setFont(new Font("Arial", Font.BOLD, 15));
		
		JTextField KH_txtMa = new JTextField();
		KH_txtMa.setEditable(false);
		KH_txtMa.setColumns(10);
		KH_txtMa.setBounds(130, 70, 240, 20);
		pnThongTinKH.add(KH_txtMa);
		
		JTextField KH_txtTen = new JTextField();
		KH_txtTen.setColumns(10);
		KH_txtTen.setBounds(130, 190, 240, 20);
		pnThongTinKH.add(KH_txtTen);
		
		JTextField KH_txtNgaySinh = new JTextField();
		KH_txtNgaySinh.setColumns(10);
		KH_txtNgaySinh.setBounds(130, 270, 240, 20);
		pnThongTinKH.add(KH_txtNgaySinh);
		
		JTextField KH_txtSdt = new JTextField();
		KH_txtSdt.setColumns(10);
		KH_txtSdt.setBounds(130, 230, 240, 20);
		pnThongTinKH.add(KH_txtSdt);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Mã KHàng:");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(20, 70, 100, 20);
		pnThongTinKH.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Họ Tên:");
		lblNewLabel_2_2_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_2_2.setBounds(20, 190, 100, 20);
		pnThongTinKH.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Số tiện thoại:\r\n");
		lblNewLabel_2_2_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_2_3.setBounds(20, 230, 100, 20);
		pnThongTinKH.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Ngày Sinh:");
		lblNewLabel_2_2_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_2_4.setBounds(20, 270, 100, 20);
		pnThongTinKH.add(lblNewLabel_2_2_4);
		
		JTextField KH_txtMatKhau = new JTextField();
		KH_txtMatKhau.setBounds(130, 150, 240, 20);
		pnThongTinKH.add(KH_txtMatKhau);
		KH_txtMatKhau.setColumns(10);
				
		JLabel lblNewLabel_2_2_4_1 = new JLabel("Giới tính:");
		lblNewLabel_2_2_4_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_2_4_1.setBounds(20, 310, 100, 20);
		pnThongTinKH.add(lblNewLabel_2_2_4_1);
		
		JTextField KH_txtGt = new JTextField();
		KH_txtGt.setColumns(10);
		KH_txtGt.setBounds(130, 310, 240, 20);
		pnThongTinKH.add(KH_txtGt);
		
		customTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = customTable.getSelectedRow();
				KH_txtMa.setText((String)customTable.getValueAt(selected, 0));
				KH_txtTaiKhoan.setText((String)customTable.getValueAt(selected, 5));
				KH_txtMatKhau.setText((String)customTable.getValueAt(selected, 6));
				KH_txtTen.setText((String)customTable.getValueAt(selected, 1));
				KH_txtSdt.setText((String)customTable.getValueAt(selected, 2));
				KH_txtNgaySinh.setText((String)customTable.getValueAt(selected, 3));
				KH_txtGt.setText((String)customTable.getValueAt(selected, 4));
			}
		});
	}
	private void GUI_DonDat() {
		DonDatTour_BUS donDatTour_BUS = new DonDatTour_BUS();
		ArrayList<DonDatTour> dsDDT = donDatTour_BUS.getDSDonDatTour();
		HanhKhach_BUS hanhKhach_BUS = new HanhKhach_BUS();
		D_panel.setBounds(20, 183, 1170, 506);
		pnNhanVienQuanLy.add(D_panel);
		D_panel.setLayout(null);
		D_panel.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin Đơn Đặt Tour và Hàng Khách");
		lblNewLabel_1.setBounds(809, 11, 335, 58);
		D_panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		JPanel search = new JPanel();
		search.setBounds(0, 11, 771, 58);
		D_panel.add(search);
		search.setBackground(new Color(255, 255, 255));
		search.setLayout(null);
		search.setBorder(new RoundedCornerBorder());
		
		lblNgy = new JLabel("Ngày Đặt:");
		lblNgy.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNgy.setBounds(425, 17, 55, 20);
		search.add(lblNgy);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
		datePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		datePicker.setBackground(new Color(255, 255, 255));
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setBounds(490, 17, 180, 30);
		datePicker.getJDateInstantPanel().setShowYearButtons(true);
		//datePicker.getJFormattedTextField().setText("2023-01-01");
		//datePicker.getModel().setValue(Date("2023-01-01"));
		search.add(datePicker);
		
		
		CustomButton customButton = new CustomButton((String) null);
		customButton.setBounds(699, 25, 1, 1);
		search.add(customButton);
		
		CustomButton cstmbtnLc = new CustomButton((String) null);
		cstmbtnLc.setFont(new Font("Arial", Font.BOLD, 11));
		cstmbtnLc.setHightlight(new Color(255, 255, 255));
		cstmbtnLc.setRadius(20);
		cstmbtnLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cstmbtnLc.setForeground(ChonMau.blue_4B70F5);
		cstmbtnLc.setOver(true);
		cstmbtnLc.setText("LỌC");
		cstmbtnLc.setBounds(680, 18, 55, 26);
		search.add(cstmbtnLc);
		
		JLabel lblSoVeThapNhat = new JLabel("Sồ Vé Thấp Nhất");
		lblSoVeThapNhat.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSoVeThapNhat.setBounds(10, 6, 99, 20);
		search.add(lblSoVeThapNhat);
		
		JSpinner spinnerSoVeMin = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerSoVeMin.addChangeListener((ChangeListener) new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				soVeThapNhat = (int) spinnerSoVeMin.getValue();
				//capNhatTable();
			}
		});
		spinnerSoVeMin.setBounds(119, 3, 44, 23);
		search.add(spinnerSoVeMin);
		spinnerSoVeMin.setValue((int) 1);
		
		JLabel lblSVCao = new JLabel("Sồ Vé Cao Nhất");
		lblSVCao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSVCao.setBounds(10, 32, 99, 20);
		search.add(lblSVCao);
		
		JSpinner spinnerSoVeMax = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerSoVeMax.setBounds(119, 32, 44, 23);
		search.add(spinnerSoVeMax);
		
		JLabel lblTngGiThp = new JLabel("Tổng Giá Thấp Nhất");
		lblTngGiThp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTngGiThp.setBounds(173, 6, 135, 20);
		search.add(lblTngGiThp);
		
		JSpinner spinnerTGMin = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 100000.0));
		spinnerTGMin.setBounds(318, 3, 99, 23);
		search.add(spinnerTGMin);
		
		JLabel lblTngGiCao = new JLabel("Tổng Giá Cao Nhất");
		lblTngGiCao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTngGiCao.setBounds(173, 32, 135, 20);
		search.add(lblTngGiCao);
		
		JSpinner spinnerTGMax = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 100000.0));
		spinnerTGMax.setBounds(318, 32, 99, 23);
		search.add(spinnerTGMax);
		
		String header1[] =  "Mã Đơn Đặt,Mã Tour, Tên Tour,Mã KH, Họ TênKH,TG Đặt,Số Vé,Tổng Tiền".split(",");
		
		modelDonDat = new DefaultTableModel(header1,0);
		for (DonDatTour don : donDatTour_BUS.getDSDonDatTour()) {
			modelDonDat.addRow(don.toString().split(";"));
		}
		CustomButton customButton_1 = new CustomButton((String) null);
		customButton_1.setBounds(351, 488, 1, 1);
		D_panel.add(customButton_1);
		
		CustomTable customTable = new CustomTable(modelDonDat, ChonMau.blue_4B70F5, Color.white);
		customTable.setModel(modelDonDat);
		customTable.setBounds(10, 90, 761, 387);
		
		JScrollPane scrollPane = new JScrollPane(customTable);
		scrollPane.setBounds(0, 77, 771, 429);
		D_panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(781, 77, 389, 429);
		D_panel.add(scrollPane_1);
		String header2[] =  "Số Hàng Khách,Họ Tên,Số Điện Thoại".split(",");
		modelHangKhach = new DefaultTableModel(header2,0);
		CustomTable customTable_1 = new CustomTable(modelHangKhach, ChonMau.blue_4B70F5, Color.white);
		scrollPane_1.setViewportView(customTable_1);
		
		customTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = customTable.getSelectedRow();
				String id = (String)customTable.getValueAt(selected, 0);
				for (HanhKhach hk : hanhKhach_BUS.getDsHanhKhach(id)) {
					modelHangKhach.addRow(hk.toString().split(";"));
				}
				customTable_1.setModel(modelHangKhach);
			}
		});
	}
	private void GUI_HuongDanVien(){
		HuongDanVien_BUS huongDanVien_BUS =new HuongDanVien_BUS();
		ArrayList<HuongDanVien> dsHDV = huongDanVien_BUS.getDSHuongDanVien();
		//dsHDV = huongDanVien_BUS.getDSHuongDanVien();
		HDV_panel.setBounds(20, 183, 1170, 506);
		pnNhanVienQuanLy.add(HDV_panel);
		HDV_panel.setLayout(null);
		HDV_panel.setVisible(true);
		//dsHDV = huongDanVien_BUS.getDSHuongDanVien();
		String header[] =  "Mã Hướng Dân Viên,Họ Tên, Số Điện Thoại".split(",");
		modelHuongDanVien = new DefaultTableModel(header,0);
		for (HuongDanVien hdv : huongDanVien_BUS.getDSHuongDanVien()) {
			modelHuongDanVien.addRow(hdv.toString().split(";"));
		}
		
		CustomButton customButton_1 = new CustomButton((String) null);
		customButton_1.setBounds(351, 488, 1, 1);
		HDV_panel.add(customButton_1);
		
		CustomTable customTable = new CustomTable(modelHuongDanVien, ChonMau.blue_4B70F5, Color.white);
		customTable.setModel(modelHuongDanVien);
		customTable.setBounds(10, 90, 761, 387);
		
		JScrollPane scrollPane = new JScrollPane(customTable);
		scrollPane.setBounds(0, 11, 771, 463);
		HDV_panel.add(scrollPane);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(ChonMau.blue_4B70F5));
		panel_1.setBounds(781, 11, 379, 464);
		HDV_panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSdt = new JLabel("Số Điện Thoại");
		lblSdt.setBounds(20, 180, 100, 20);
		panel_1.add(lblSdt);
		
		HDV_txtSoDienThoai = new JTextField();
		HDV_txtSoDienThoai.setColumns(10);
		HDV_txtSoDienThoai.setBounds(120, 180, 250, 20);
		panel_1.add(HDV_txtSoDienThoai);
		
		HDV_txtMaHDV = new JTextField();
		HDV_txtMaHDV.setColumns(10);
		HDV_txtMaHDV.setBounds(120, 80, 250, 20);
		HDV_txtMaHDV.setEditable(false);
		panel_1.add(HDV_txtMaHDV);
		
		JLabel lblMaHDV = new JLabel("MÃ HDV:");
		lblMaHDV.setBounds(20, 80, 100, 20);
		panel_1.add(lblMaHDV);

		HDV_txtHoTen = new JTextField();
		HDV_txtHoTen.setColumns(10);
		HDV_txtHoTen.setBounds(120, 130, 250, 20);
		panel_1.add(HDV_txtHoTen);
		
		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setBounds(20, 130, 100, 20);
		panel_1.add(lblHoTen);
		
		HDV_btnThem = new CustomButton((String) null);
		HDV_btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		HDV_btnThem.setBounds(21, 419, 101, 34);
		panel_1.add(HDV_btnThem);
		HDV_btnThem.setText("Thêm");
		HDV_btnThem.setRadius(30);
		HDV_btnThem.setHightlight(Color.WHITE);
		HDV_btnThem.setForeground(new Color(75, 112, 245));
		HDV_btnThem.setFont(new Font("Arial", Font.BOLD, 30));
		HDV_btnThem.setColor_fogeground(new Color(75, 112, 245));
		
		HDV_btnXoa = new CustomButton((String) null);
		HDV_btnXoa.setBounds(145, 419, 101, 34);
		panel_1.add(HDV_btnXoa);
		HDV_btnXoa.setText("Xóa");
		HDV_btnXoa.setRadius(30);
		HDV_btnXoa.setHightlight(Color.WHITE);
		HDV_btnXoa.setForeground(new Color(75, 112, 245));
		HDV_btnXoa.setFont(new Font("Arial", Font.BOLD, 30));
		HDV_btnXoa.setColor_fogeground(new Color(75, 112, 245));
		
		HDV_btnSua = new CustomButton((String) null);
		HDV_btnSua.setBounds(268, 419, 101, 34);
		panel_1.add(HDV_btnSua);
		HDV_btnSua.setText("Sửa");
		HDV_btnSua.setRadius(30);
		HDV_btnSua.setHightlight(Color.WHITE);
		HDV_btnSua.setForeground(new Color(75, 112, 245));
		HDV_btnSua.setFont(new Font("Arial", Font.BOLD, 30));
		HDV_btnSua.setColor_fogeground(new Color(75, 112, 245));
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin Hướng Dẫn Viên");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 379, 34);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		customTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
				
			@Override
			public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = customTable.getSelectedRow();
				HDV_txtMaHDV.setText((String)customTable.getValueAt(selected, 0));
				HDV_txtHoTen.setText((String)customTable.getValueAt(selected, 1));
				HDV_txtSoDienThoai.setText((String)customTable.getValueAt(selected, 2));
			}
		});
	}
	
	private String[] updateCboBoxDiemDi() {
		String[] s = {};
		List<String> list = new ArrayList<>(Arrays.asList(s));
		for (Tour t : tour_BUS.getDS()) {
				if (!list.contains(t.getDiemDi())) list.add(t.getDiemDi());
		}
		s=list.toArray(new String[0]);
		return s;
	}
	private String[] updateCboBoxDiemDen() {
		String[] s = {};
		List<String> list = new ArrayList<>(Arrays.asList(s));
		for (Tour t : tour_BUS.getDS()) {
				if (!list.contains(t.getDiemDen())) list.add(t.getDiemDen());
			
		}
		s=list.toArray(new String[0]);
		return s;
	}
}
