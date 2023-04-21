package my_Interfaces;

import java.util.ArrayList;

import entities.DonDatTour;
import entities.Tour;

public interface IDonDatTour {
	public ArrayList<DonDatTour> getDsDonDatTour();
	public Tour getDonDatTour(String id);
	public int count();
	public boolean themTour(DonDatTour don);
	//public boolean xoaTour();
	//public boolean suaTour();
	//public ArrayList<Tour> timKiem(String diemDi, String diemDen, String ngayDi);
	//public ArrayList<Tour> timKiem(String diemDi, String diemDen);
	//ArrayList<Tour> timKiem(String noiDungTimKiem);
}
