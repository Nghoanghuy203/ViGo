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
	

}
