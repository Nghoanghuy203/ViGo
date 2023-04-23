package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.HuongDanVien;
import my_Interfaces.IHuongDanVien;

public class HuongDanVien_DAO implements IHuongDanVien{
	public HuongDanVien_DAO() {
		
	}
	@Override
	public ArrayList<HuongDanVien> getDSHuongDanVien() {
		ArrayList<HuongDanVien> ds = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HuongDanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getNString("maHDV");
				String ten = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				HuongDanVien hdv = new HuongDanVien(ma, ten, sdt);
				ds.add(hdv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	@Override
	public ArrayList<HuongDanVien> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean themHuongDanVien(HuongDanVien hdv) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into HuongDanVien values(?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setNString(1, hdv.getMaHDV());
			statement.setNString(2, hdv.getHoTen());
			statement.setNString(3, hdv.getSdt());
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	@Override
	public boolean xoaHuuongDanVien(String id) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from HuongDanVien where maHDV=?";
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
	public boolean suaHuongDanVien(String oldID, HuongDanVien newHDV) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update HuongDanVien set tenHDV=?, sdt=? where maHDV=?";
			statement = con.prepareStatement(sql);
			statement.setNString(1, newHDV.getHoTen());
			statement.setNString(2, newHDV.getSdt());
			statement.setNString(3, oldID);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	@Override
	public HuongDanVien getHuongDanVien(String id) {
		// TODO Auto-generated method stub
		HuongDanVien hdv=null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from HuongDanVien where maHDV=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getNString("maHDV");
				String ten = rs.getNString("tenHDV");
				String sdt = rs.getNString("sdt");
				hdv = new HuongDanVien(ma, ten, sdt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hdv;
	}

}
