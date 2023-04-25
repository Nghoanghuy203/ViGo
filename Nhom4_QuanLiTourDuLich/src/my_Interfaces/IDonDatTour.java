package my_Interfaces;

import java.util.ArrayList;
import java.util.Date;

import entities.DonDatTour;
import entities.Tour;

public interface IDonDatTour {
	public ArrayList<DonDatTour> getDSDonDatTour();
	public ArrayList<DonDatTour> timKiem(String noiDungTimKiem);
	public boolean themDonDatTour(DonDatTour d);
	public boolean xoaDonDatTourTheoMaTour(String maTour);
	public boolean xoaDonDatTourTheoMaKH(String maKH);
	public DonDatTour getDonTheoMaKH(String maKH);
	public ArrayList<DonDatTour> getDsDonTheoMaTour(String maTour);
	ArrayList<DonDatTour> timKiem(String noiDungTimKiem, int soVeThapNhat, int soVeCaoNhat, double tongGiaThapNhat,double tongGiaCaoNhat, String ngayDat);
}
