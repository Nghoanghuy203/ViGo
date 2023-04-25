package bus;

import java.util.ArrayList;

import dao.KhachHang_DAO;
import entities.DonDatTour;
import entities.KhachHang;
import my_Interfaces.IKhachHang;

public class KhachHang_BUS implements IKhachHang{
	private KhachHang_DAO khachHang_DAO =new KhachHang_DAO();
	@Override
	public ArrayList<KhachHang> getDSKhachHang() {
		// TODO Auto-generated method stub
		return khachHang_DAO.getDSKhachHang();
	}

	@Override
	public ArrayList<KhachHang> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return khachHang_DAO.timKiem(noiDungTimKiem);
	}

	@Override
	public boolean themKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return khachHang_DAO.themKhachHang(khachHang);
	}

	@Override
	public boolean xoaKhachHang(String id) {
		// TODO Auto-generated method stub
		HanhKhach_BUS hanhKhach_BUS = new HanhKhach_BUS();
		DonDatTour_BUS donDatTour_BUS = new DonDatTour_BUS();
		DonDatTour donDatTour = donDatTour_BUS.getDonTheoMaKH(id);
		hanhKhach_BUS.xoaHanhKhach(donDatTour.getMaDon());
		donDatTour_BUS.xoaDonDatTourTheoMaKH(id);
		return khachHang_DAO.xoaKhachHang(id);
	}

	@Override
	public boolean capNhatKhachHang(String oldID, KhachHang newHDV) {
		// TODO Auto-generated method stub
		return khachHang_DAO.capNhatKhachHang(oldID, newHDV);
	}

	@Override
	public KhachHang getKhachHang(String id) {
		// TODO Auto-generated method stub
		return khachHang_DAO.getKhachHang(id);
	}

}
