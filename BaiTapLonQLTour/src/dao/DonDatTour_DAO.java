package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entities.DonDatTour;
import entities.NguoiDung;
import entities.Tour;
import my_Interfaces.IDonDatTour;

public class DonDatTour_DAO implements IDonDatTour{

	@Override
	public ArrayList<DonDatTour> getDsDonDatTour() {
		ArrayList<DonDatTour> ds = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DonDatTour";
			Statement statement = con.createStatement();
			//thuc thi cau lenh SQL tra ve ket qua result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua 
			while (rs.next()) {
				String maDon = rs.getNString(1);
				String maTour = rs.getNString(2);
				String tenTour = rs.getNString(3);
				Tour t = new Tour(maTour, tenTour);
				String maNguoiDung = rs.getNString(4);
				String hoTenNguoiDung = rs.getNString(5);
				Date ngayDat = rs.getDate(6);
				int soVe = rs.getInt(7);
				double tongTien = rs.getDouble(8);
				NguoiDung nd = new NguoiDung(maNguoiDung, hoTenNguoiDung);
				DonDatTour d = new DonDatTour(maDon, t, nd, (java.sql.Date) ngayDat, soVe, tongTien);
				ds.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public Tour getDonDatTour(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean themTour(DonDatTour d) {
		// TODO Auto-generated method stub
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "insert into DonDatTour values(?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setNString(1, d.getMaDon());
			st.setNString(2, d.getTour().getMaTour());
			st.setNString(3, d.getNguoiDung().getSoNguoiDung());
			st.setDate(4, d.getNgayDat());
			st.setInt(5, d.getSoVeDat());
			st.setDouble(6, d.getTongTien());
			n=st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n>0;
	}
	
}
