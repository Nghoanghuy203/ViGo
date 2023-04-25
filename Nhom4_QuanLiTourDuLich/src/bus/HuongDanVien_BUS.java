package bus;

import java.util.ArrayList;

import dao.HuongDanVien_DAO;
import entities.HuongDanVien;
import my_Interfaces.IHuongDanVien;

public class HuongDanVien_BUS implements IHuongDanVien{
	private HuongDanVien_DAO huongDanVien_DAO;
	public HuongDanVien_BUS() {
		huongDanVien_DAO=new HuongDanVien_DAO();
	}
	@Override
	public ArrayList<HuongDanVien> getDSHuongDanVien() {
		// TODO Auto-generated method stub
		ArrayList<HuongDanVien> ds  = huongDanVien_DAO.getDSHuongDanVien();
		return ds;
	}

	@Override
	public ArrayList<HuongDanVien> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return huongDanVien_DAO.timKiem(noiDungTimKiem);
	}

	@Override
	public boolean themHuongDanVien(HuongDanVien hdv) {
		// TODO Auto-generated method stub
		return huongDanVien_DAO.themHuongDanVien(hdv);
	}

	@Override
	public boolean xoaHuuongDanVien(String id) {
		// TODO Auto-generated method stub
		return huongDanVien_DAO.xoaHuuongDanVien(id);
	}

	@Override
	public boolean suaHuongDanVien(String oldID, HuongDanVien newHDV) {
		// TODO Auto-generated method stub
		return huongDanVien_DAO.suaHuongDanVien(oldID, newHDV);
	}
	@Override
	public HuongDanVien getHuongDanVien(String id) {
		// TODO Auto-generated method stub
		return huongDanVien_DAO.getHuongDanVien(id);
	}

}
