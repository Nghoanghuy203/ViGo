package dao;

import java.sql.Connection;
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
	public ArrayList<HuongDanVien> getDsHDV() {
		// TODO Auto-generated method stub
		ArrayList<HuongDanVien> ds = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HuongDanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getNString(1);
				String ten = rs.getNString(2);
				String sdt = rs.getNString(3);
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
	public void addHDV(HuongDanVien hdv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeHDV(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHDV(String oldID, HuongDanVien newHDV) {
		// TODO Auto-generated method stub
		
	}

}
