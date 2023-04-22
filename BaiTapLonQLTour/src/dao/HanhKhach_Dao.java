package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.HanhKhach;
import my_Interfaces.IHanhKhach;

public class HanhKhach_DAO implements IHanhKhach{



	@Override
	public ArrayList<HanhKhach> getDsHanhKhach(String idDon) {
		// TODO Auto-generated method stub
		ArrayList<HanhKhach> ds = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from hanhkhach where maDon = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, idDon);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getNString(1);
				String ten = rs.getNString(2);
				String sdt = rs.getNString(3);
				HanhKhach hk = new HanhKhach(ma, ten, sdt);
				ds.add(hk);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public boolean themHanhKhach(HanhKhach hk, String idDon) {
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into hanhkhach values(?,?,?,?)";
			statement =con.prepareStatement(sql);
			statement.setString(1, hk.getMaHK());
			statement.setNString(2, hk.getHoTen());
			statement.setNString(3, hk.getSdt());
			statement.setNString(4, idDon);
			n =statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n>0;
	}

}
