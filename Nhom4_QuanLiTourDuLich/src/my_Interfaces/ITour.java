package my_Interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

import entities.Tour;

public interface ITour {
	public ArrayList<Tour> getDS();
	public Tour getTour(String id);
	public ArrayList<Tour> timKiem(String noiDungTimKiem);
	public ArrayList<Tour> timKiem(String diemDi, String diemDen);
	public ArrayList<Tour> timKiem(String noiDungTimKiem,String diemDi, String diemDen, String ngayDi);
	public boolean themTour(Tour tour);
	public boolean xoaTour(String maTour);
	public boolean suaTour(String id, Tour newTour);
	public boolean capNhatSoLuongVe(String id, int soLuongVeDat);
	public ArrayList<Tour> getTourForManager();
}
