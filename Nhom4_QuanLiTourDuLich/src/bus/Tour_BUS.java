package bus;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.Tour_DAO;
import entities.DonDatTour;
import entities.Tour;
import my_Interfaces.ITour;

public class Tour_BUS implements ITour{
	private Tour_DAO tour_Dao;
	public  Tour_BUS() {
		tour_Dao = new Tour_DAO();
	}
	@Override
	public ArrayList<Tour> getDS() {
		// TODO Auto-generated method stub
		ArrayList<Tour> ds = tour_Dao.getDS();
		return ds;
	}


	@Override
	public Tour getTour(String id) {
		// TODO Auto-generated method stub
		return tour_Dao.getTour(id);
	}
	
	@Override
	public ArrayList<Tour> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return tour_Dao.timKiem(noiDungTimKiem);
	}
	@Override
	public ArrayList<Tour> timKiem(String diemDi, String diemDen) {
		ArrayList<Tour> ds = tour_Dao.timKiem(diemDi, diemDen);
		return ds;
	}
	@Override
	public boolean themTour(Tour tour) {
		// TODO Auto-generated method stub
		return tour_Dao.themTour(tour);
	}
	@Override
	public boolean xoaTour(String id) {
		// TODO Auto-generated method stub
		HanhKhach_BUS hanhKhach_BUS = new HanhKhach_BUS();
		DonDatTour_BUS donDatTour_BUS = new DonDatTour_BUS();
		ArrayList<DonDatTour> donDatTour = donDatTour_BUS.getDsDonTheoMaTour(id);
		for (DonDatTour donDatTour2 : donDatTour) {
			hanhKhach_BUS.xoaHanhKhach(donDatTour2.getMaDon());
			donDatTour_BUS.xoaDonDatTourTheoMaTour(id);
		}
		return tour_Dao.xoaTour(id);
	}
	@Override
	public boolean suaTour(String id, Tour newTour) {
		// TODO Auto-generated method stub
		return tour_Dao.suaTour(id, newTour);
	}
	@Override
	public boolean capNhatSoLuongVe(String id, int soLuongVeDat) {
		// TODO Auto-generated method stub
		return tour_Dao.capNhatSoLuongVe(id, soLuongVeDat);
	}
	@Override
	public ArrayList<Tour> getTourForManager() {
		// TODO Auto-generated method stub
		return tour_Dao.getTourForManager();
	}
	@Override
	public ArrayList<Tour> timKiem(String noiDungTimKiem, String diemDi, String diemDen, String ngayDi) {
		ArrayList<Tour> ds = timKiem(noiDungTimKiem);
		ArrayList<Tour> dsLoc = new ArrayList<>();
		if (ds.size()==0) ds = getTourForManager();
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (Tour tour : ds) {
			if(tour.getDiemDi().equals(diemDi) && tour.getDiemDen().equals(diemDen) && (dtf.format(tour.getNgayKhoiHanh()).equals(ngayDi)||ngayDi.trim().equals(""))) 
				dsLoc.add(tour);
		}
		return dsLoc;	
	}

}
