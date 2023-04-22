package my_Interfaces;

import java.util.ArrayList;
import java.util.Date;

import entities.DonDatTour;
import entities.Tour;

public interface IDonDatTour {
	public ArrayList<DonDatTour> getDSDonDatTour();
	public ArrayList<DonDatTour> timKiem(String noiDungTimKiem);
	public ArrayList<DonDatTour> timKiem(int soVeThapNhat, int soVeCaoNhat, double tongGiaThapNhat, double tongGiaCaoNhat,Date ngayDat);
	public boolean themDonDatTour(DonDatTour d);
}
