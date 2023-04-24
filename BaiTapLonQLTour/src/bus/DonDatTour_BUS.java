package bus;

import java.util.ArrayList;
import java.util.Date;

import dao.DonDatTour_DAO;
import entities.DonDatTour;
import my_Interfaces.IDonDatTour;

public class DonDatTour_BUS implements IDonDatTour{
	private DonDatTour_DAO donDatTour_DAO = new DonDatTour_DAO();

	@Override
	public ArrayList<DonDatTour> getDSDonDatTour() {
		// TODO Auto-generated method stub
		return donDatTour_DAO.getDSDonDatTour();
	}

	@Override
	public ArrayList<DonDatTour> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.timKiem(noiDungTimKiem);
	}

	@Override
	public ArrayList<DonDatTour> timKiem(int soVeThapNhat, int soVeCaoNhat, double tongGiaThapNhat,
			double tongGiaCaoNhat, Date ngayDat) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.timKiem(soVeThapNhat, soVeCaoNhat, tongGiaThapNhat, tongGiaCaoNhat, ngayDat);
	}

	@Override
	public boolean themDonDatTour(DonDatTour d) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.themDonDatTour(d);
	}

	@Override
	public boolean xoaDonDatTourTheoMaTour(String maTour) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.xoaDonDatTourTheoMaTour(maTour);
	}

	@Override
	public boolean xoaDonDatTourTheoMaKH(String maKH) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.xoaDonDatTourTheoMaKH(maKH);
	}

	@Override
	public DonDatTour getDonTheoMaKH(String maKH) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.getDonTheoMaKH(maKH);
	}

	@Override
	public ArrayList<DonDatTour> getDsDonTheoMaTour(String maTour) {
		// TODO Auto-generated method stub
		return donDatTour_DAO.getDsDonTheoMaTour(maTour);
	}
	
}
