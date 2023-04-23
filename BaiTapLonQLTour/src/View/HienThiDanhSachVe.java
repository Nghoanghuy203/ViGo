package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

import entities.DonDatTour;
import entities.HuongDanVien;
import view.DatTour;

import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

import javax.swing.JFrame;

import custom_entity.*;

public class HienThiDanhSachVe extends JFrame{
	private JPanel pnHome;
	//
	private JPanel item1,item2,item3,item4,item5,item6;
	//
	private JLabel tourPicture1,tourName1,tourPrice1,tourTime1,tourID1;
	private JLabel tourPicture2,tourName2,tourPrice2,tourTime2,tourID2;
	private JLabel tourPicture3,tourName3,tourPrice3,tourTime3,tourID3;
	private JLabel tourPicture4,tourName4,tourPrice4,tourTime4,tourID4;
	private JLabel tourPicture5,tourName5,tourPrice5,tourTime5,tourID5;
	private JLabel tourPicture6,tourName6,tourPrice6,tourTime6,tourID6;
	//
	//
	private int iTour,lItem;
	private JLabel lblNgy;
	
	private String sDDi, sDDen, sNgay;
	private JTextField txtMess;
	private JLabel btnUndo, btnRedu;
	private SpringLayout springLayout;
	public HienThiDanhSachVe() {
		// TODO Auto-generated constructor stub
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CustomScollPane a = new CustomScollPane();
		entities.Tour tour = new entities.Tour("MaTour", "TenTour", LocalDate.now(), new Time(1, 1, 1), 3, 10, 100000000, null, new Time(0,1,1),"Ha Noi", "Sai Gon", new HuongDanVien("HDV1", "a", "91829821"));
		getContentPane().add(a);
		try {
			//ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//
		//ds = tourBus.getDS();
		
		//datTour = new DatTour("");
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		this.setLocationRelativeTo(null);
		pnHome = new JPanel();
		pnHome.setIgnoreRepaint(true);
		pnHome.setBackground(Color.WHITE);
		pnHome.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));

		setContentPane(pnHome);
		pnHome.setLayout(null);
		
		JPanel pnMain = new JPanel();
		pnMain.setSize(1200, 700);
		getContentPane().add(pnMain);
		pnMain.setLayout(null);
		pnMain.setBackground(new Color(0, 0, 0, 30));
		setBackground(new Color(0, 0, 0, 30));
		
		pnMain.add(a);
		
		
		JPanel pnContent = new JPanel();
		pnContent.setLayout(null);
		pnContent.setBackground(new Color(255, 255, 255, 255));
		pnContent.setBounds(150, 100, 900, 550);
		
		CustomScollPane noticeBoard = new CustomScollPane();
		noticeBoard.themVe(new DonDatTour("Ma Tour", tour, null, new java.sql.Date(2000, 10, 10), 5));
		for (int i = 0; i < 10; i++) {
			noticeBoard.themVe(new DonDatTour("Ma Tour", tour, null, new java.sql.Date(2000, 10, 10), i));
		}
		noticeBoard.setBounds(0, 30, 900, 520);
		noticeBoard.setOpaque(false);
		pnContent.add(noticeBoard);
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				//System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon(DatTour.class.getResource("/images/back.png")));
		btnTroVe.setBounds(5, 5, 100, 20);
		btnTroVe.setOpaque(false);
		pnContent.add(btnTroVe);
		pnHome.add(pnContent);
	}
	public static void main(String[] args) {
		new HienThiDanhSachVe().setVisible(true);
	}
}
