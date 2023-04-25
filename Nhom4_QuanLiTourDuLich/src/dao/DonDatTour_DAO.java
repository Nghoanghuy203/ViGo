package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import bus.KhachHang_BUS;
import bus.Tour_BUS;
import connectDB.ConnectDB;
import entities.DonDatTour;
import entities.KhachHang;
import entities.Tour;
import my_Interfaces.IDonDatTour;

public class DonDatTour_DAO implements IDonDatTour{


	@Override
	public boolean themDonDatTour(DonDatTour d) {
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

	@Override
	public ArrayList<DonDatTour> getDSDonDatTour() {
		ArrayList<DonDatTour> ds = new ArrayList<>();
		Tour_BUS tour_BUS = new Tour_BUS();
		KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
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
				//String tenTour = rs.getNString(3);
				Tour t = tour_BUS.getTour(maTour);
				String maNguoiDung = rs.getNString(3);
				//String hoTenNguoiDung = rs.getNString(5);
				Date ngayDat = rs.getDate(4);
				int soVe = rs.getInt(5);
				double tongTien = rs.getDouble(6);
				KhachHang nd = khachHang_BUS.getKhachHang(maNguoiDung);
				DonDatTour d = new DonDatTour(maDon, t, nd, (java.sql.Date) ngayDat, soVe);
				ds.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public ArrayList<DonDatTour> timKiem(String noiDungTimKiem) {
		 ArrayList<DonDatTour> ds = new ArrayList<>();
	        Tour_BUS tour_BUS = new Tour_BUS();
	        KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
	        Connection con = ConnectDB.getConnection();
	        PreparedStatement statement = null;
	        try {
	            String sql = "Select * from DonDatTour d inner join KhachHang k on d.maKH = k.maKH inner join Tour t "
	            		+ "on d.maTour = t.maTour  where maDon =  ? or d.maKH = ? or k.hoTen = ? or d.maTour =  ? or t.tenTour = ?";
	            statement= con.prepareStatement(sql);
	            for (int i = 1; i <= 5; i++) {
	            	statement.setNString(i, noiDungTimKiem);
				}
	            ResultSet rs = statement.executeQuery();
	            //duyet tren ket qua 
	            while (rs.next()) {
	                String maDon = rs.getNString("maDon");
	                String maTour = rs.getNString("maTour");
	                //String tenTour = rs.getNString(3);
	                Tour t = tour_BUS.getTour(maTour);
	                String maNguoiDung = rs.getNString("maKH");
	                //String hoTenNguoiDung = rs.getNString(5);
	                Date ngayDat = rs.getDate("gioGianDat");
	                int soVe = rs.getInt("soVe");
	                double tongTien = rs.getDouble("tongTien");
	                KhachHang nd = khachHang_BUS.getKhachHang(maNguoiDung);
	                DonDatTour d = new DonDatTour(maDon, t, nd, (java.sql.Date) ngayDat, soVe);
	                ds.add(d);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ds;
	}


	@Override
	public ArrayList<DonDatTour> timKiem(String noiDungTimKiem, int soVeThapNhat, int soVeCaoNhat,
			double tongGiaThapNhat, double tongGiaCaoNhat, String ngayDat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean xoaDonDatTourTheoMaTour(String maTour) {
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from DonDatTour where maTour=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTour);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public boolean xoaDonDatTourTheoMaKH(String maKH) {
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from DonDatTour where maKH=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			n=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public DonDatTour getDonTheoMaKH(String maKH) {
		DonDatTour don=null;
		Tour_BUS tour_BUS = new Tour_BUS();
		KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DonDatTour where maKH = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, maKH);
			//thuc thi cau lenh SQL tra ve ket qua result
			ResultSet rs = statement.executeQuery();
			//duyet tren ket qua 
			while (rs.next()) {
				String maDon = rs.getNString(1);
				String maTour = rs.getNString(2);
				//String tenTour = rs.getNString(3);
				Tour t = tour_BUS.getTour(maTour);
				String maNguoiDung = rs.getNString(3);
				//String hoTenNguoiDung = rs.getNString(5);
				Date ngayDat = rs.getDate(4);
				int soVe = rs.getInt(5);
				double tongTien = rs.getDouble(6);
				KhachHang nd = khachHang_BUS.getKhachHang(maNguoiDung);
				don = new DonDatTour(maDon, t, nd, (java.sql.Date) ngayDat, soVe);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return don;
	}

	@Override
	public ArrayList<DonDatTour> getDsDonTheoMaTour(String id) {
		ArrayList<DonDatTour> ds = new ArrayList<>();
		Tour_BUS tour_BUS = new Tour_BUS();
		KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DonDatTour where maTour = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setNString(1, id);
			//thuc thi cau lenh SQL tra ve ket qua result
			ResultSet rs = statement.executeQuery();
			//duyet tren ket qua 
			while (rs.next()) {
				String maDon = rs.getNString(1);
				String maTour = rs.getNString(2);
				//String tenTour = rs.getNString(3);
				Tour t = tour_BUS.getTour(maTour);
				String maNguoiDung = rs.getNString(3);
				//String hoTenNguoiDung = rs.getNString(5);
				Date ngayDat = rs.getDate(4);
				int soVe = rs.getInt(5);
				double tongTien = rs.getDouble(6);
				KhachHang nd = khachHang_BUS.getKhachHang(maNguoiDung);
				DonDatTour don = new DonDatTour(maDon, t, nd, (java.sql.Date) ngayDat, soVe);
				ds.add(don);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
}
