package dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import connectDB.ConnectDB;
import entities.HuongDanVien;
import entities.Tour;
import my_Interfaces.ITour;
import view.NhanVienQuanLy;

public class Tour_DAO implements ITour{
	public Tour_DAO() {
		
	}
	@Override
	public ArrayList<Tour> getDS() {
		// TODO Auto-generated method stub
		ArrayList<Tour> ds = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Tour t join HuongDanVien h on t.maHDV=h.maHDV where not soVeConLai=0  order by tgCapNhat desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getNString("maTour");
				String ten = rs.getNString("tenTour");
				LocalDate ngayKhoiHanh = rs.getDate("tgKhoiHanh").toLocalDate();
				Time tgKhoiHanh = rs.getTime("tgKhoiHanh");
				int soNgay = rs.getInt("soNgay");
				int soVeConLai = rs.getInt("soVeConLai");
				double gia= rs.getDouble("gia");
				Blob clob = rs.getBlob("hinhAnh");
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				Time tgTapTrung = rs.getTime("tgTapTrung");
				String diemDI = rs.getNString("diemDi");
				String diemDen = rs.getNString("diemDen");
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				Tour t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, tgTapTrung, diemDI, diemDen, hdv);
				ds.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}



	@Override
	public boolean themTour(Tour tour) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into Tour values(?,?,?,?,?,?,(SELECT * FROM OPENROWSET(BULK N'"+NhanVienQuanLy.url+"', SINGLE_BLOB) as img),?,?,?,getdate(),?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, tour.getMaTour());
			statement.setNString(2, tour.getTenTour());
			statement.setString(3, tour.getNgayKhoiHanh().toString());
			statement.setInt(4, tour.getSoNgay());
			statement.setInt(5, tour.getSoVeConLai());
			statement.setDouble(6, tour.getGia());
			statement.setString(7, tour.getTgKhoiHanh().toString());
			statement.setNString(8, tour.getDiemDi());
			statement.setNString(9, tour.getDiemDen());
			statement.setNString(10, tour.getHdv().getMaHDV());
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public boolean xoaTour(String id) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from Tour  where maTour=?";
			statement = con.prepareStatement(sql);
			statement.setNString(1, id);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public boolean suaTour(String id, Tour newTour) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update Tour set tenTour=?, tgKhoiHanh=?, soNgay=?, soVeConlai=?, gia=?,hinhAnh=(SELECT * FROM OPENROWSET(BULK N'" +NhanVienQuanLy.url+"', SINGLE_BLOB) as img), tgTapTrung=?, diemDi=?, diemDen=?, tgCapNhat=getdate(), maHDV=? where maTour = ?";
			statement = con.prepareStatement(sql);
			//statement.setString(1, newTour.getMaTour());
			statement.setNString(1, newTour.getTenTour());
			statement.setString(2, newTour.getNgayKhoiHanh().toString());
			statement.setInt(3, newTour.getSoNgay());
			statement.setInt(4, newTour.getSoVeConLai());
			statement.setDouble(5, newTour.getGia());
			statement.setString(6, newTour.getTgKhoiHanh().toString());
			statement.setNString(7, newTour.getDiemDi());
			statement.setNString(8, newTour.getDiemDen());
			statement.setNString(9, newTour.getHdv().getMaHDV());
			statement.setNString(10, id);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	@Override
	public Tour getTour(String id) {
		// TODO Auto-generated method stub
		Tour t = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from Tour t join HuongDanVien h on t.maHDV=h.maHDV where maTour = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				//LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDI = rs.getNString(9);
				String diemDen = rs.getNString(10);
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, tgTapTrung, diemDI, diemDen, hdv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return t;
	}
	@Override
	public ArrayList<Tour> timKiem(String diemDi, String diemDen,String ngayDi) {
		// TODO Auto-generated method stub
		ArrayList<Tour> list = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from Tour t join HuongDanVien h on t.maHDV=h.maHDV where diemDi = ? and diemDen = ? and convert(DATE,tgKhoiHanh) = ?";// and convert(date,tgKhoiHanh) = ?
			statement = con.prepareStatement(sql);
			statement.setNString(1, diemDi);
			statement.setNString(2, diemDen);
			statement.setString(3, ngayDi);
			System.out.println(diemDi+ diemDen+ ngayDi);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				//LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDi1 = rs.getNString(9);
				String diemDen1 = rs.getNString(10);
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				Tour t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, tgTapTrung, diemDi1, diemDen1,hdv);
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ArrayList<Tour> timKiem(String diemDi, String diemDen) {
		// TODO Auto-generated method stub
		ArrayList<Tour> list = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from Tour t join HuongDanVien h on t.maHDV=h.maHDV where diemDi = ? and diemDen = ?";// and convert(date,tgKhoiHanh) = ?
			statement = con.prepareStatement(sql);
			statement.setNString(1, diemDi);
			statement.setNString(2, diemDen);
			//statement.setString(3, ngayDi);
			//System.out.println(diemDi+ diemDen+ ngayDi);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				//LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDi1 = rs.getNString(9);
				String diemDen1 = rs.getNString(10);
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				Tour t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, tgTapTrung, diemDi1, diemDen1,hdv);
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ArrayList<Tour> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return null;
	}

}