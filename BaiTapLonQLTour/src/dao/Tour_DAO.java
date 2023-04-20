package dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import connectDB.ConnectDB;
import entities.HuongDanVien;
import entities.Tour;
import my_Interfaces.ITour;

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
			String sql = "Select * from Tour t join HuongDanVien h on t.maHDV=h.maHDV order by tgCapNhat desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getNString(1);
				String ten = rs.getNString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDI = rs.getNString(9);
				String diemDen = rs.getNString(10);
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				Tour t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, ngayTapTrung, tgTapTrung, diemDI, diemDen, hdv);
				ds.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean themTour() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaTour() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suaTour() {
		// TODO Auto-generated method stub
		return false;
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
				LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDI = rs.getNString(9);
				String diemDen = rs.getNString(10);
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, ngayTapTrung, tgTapTrung, diemDI, diemDen, hdv);
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
				LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDi1 = rs.getNString(9);
				String diemDen1 = rs.getNString(10);
				String mahdv = rs.getNString("maHDV");
				String tenhdv = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(mahdv, tenhdv, sdt);
				Tour t = new Tour(ma, ten, ngayKhoiHanh, tgKhoiHanh, soNgay, soVeConLai, gia, img, ngayTapTrung, tgTapTrung, diemDi1, diemDen1,hdv);
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
