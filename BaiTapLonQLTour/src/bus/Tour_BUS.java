package bus;

import java.util.ArrayList;

import dao.Tour_DAO;
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
	public ArrayList<Tour> timKiem(String diemDi, String diemDen, String ngayDi) {
		// TODO Auto-generated method stub
		ArrayList<Tour> ds = tour_Dao.timKiem(diemDi, diemDen, ngayDi);
		return ds;
	}
	@Override
	public ArrayList<Tour> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return null;
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
		return tour_Dao.xoaTour(id);
	}
	@Override
	public boolean suaTour(String id, Tour newTour) {
		// TODO Auto-generated method stub
		return tour_Dao.suaTour(id, newTour);
	}
	

}
