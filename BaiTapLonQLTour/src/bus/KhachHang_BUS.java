package bus;

import java.util.ArrayList;

import dao.KhachHang_DAO;
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
		return khachHang_DAO.xoaKhachHang(id);
	}

	@Override
	public boolean capNhatKhachHang(String oldID, KhachHang newHDV) {
		// TODO Auto-generated method stub
		return khachHang_DAO.capNhatKhachHang(oldID, newHDV);
	}

}
