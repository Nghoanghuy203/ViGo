package dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import connectDB.ConnectDB;
import entities.HuongDanVien;
import entities.KhachHang;
import entities.Tour;
import my_Interfaces.IKhachHang;

public class KhachHang_DAO implements IKhachHang{


	@Override
	public boolean themKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into khachhang values(?, ?, ?, ?, ?, ?, ?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getSoNguoiDung());
			statement.setNString(2, kh.getHoTen());
			statement.setNString(3, kh.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setNString(4, kh.getSoDienThoai());
			statement.setBoolean(5, kh.isGioiTinh());
			statement.setNString(6, kh.getEmail());
			statement.setNString(7, kh.getMatKhau());
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public ArrayList<KhachHang> getDSKhachHang() {
		ArrayList<KhachHang> ds = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from khachhang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getNString("maKH");
				String tenKH = rs.getNString("hoTen");
				String sdt = rs.getNString("soDienThoai");
				Date ngaySinh = rs.getDate("ngaySinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String email = rs.getNString("email");
				String matKhau = rs.getNString("matKhau");
				KhachHang kh = new KhachHang(maKH, tenKH, ngaySinh, sdt, gioiTinh, email, matKhau);
				ds.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public ArrayList<KhachHang> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean capNhatKhachHang(String oldID, KhachHang newKH) {
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update KhachHang "
					+ "set hoTen=?, ngaySinh=?, soDienThoai=?, gioiTinh=?, email=?, matKhau=? "
					+ "where maKh = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, newKH.getHoTen());
			statement.setString(2, newKH.getNgaySinh().toString());
			statement.setNString(3, newKH.getSoDienThoai());
			int gt = newKH.isGioiTinh()?1:0;
			statement.setInt(4, gt);
			statement.setNString(5, newKH.getEmail());
			statement.setNString(6, newKH.getMatKhau());
			statement.setString(7, oldID);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public boolean xoaKhachHang(String id) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "alter table KhachHang delete where maKH=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public KhachHang getKhachHang(String id) {
		// TODO Auto-generated method stub
		KhachHang kh=null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			
			String sql = "select * from khachhang where maKH=?";
			statement = con.prepareStatement(sql);
			statement.setNString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maKH = rs.getNString("maKH");
				String tenKH = rs.getNString("hoTen");
				String sdt = rs.getNString("soDienThoai");
				Date ngaySinh = rs.getDate("ngaySinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String email = rs.getNString("email");
				String matKhau = rs.getNString("matKhau");
				kh = new KhachHang(maKH, tenKH, ngaySinh, sdt, gioiTinh, email, matKhau);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return kh;
	}
	
}
