package my_Interfaces;

import java.util.ArrayList;

import entities.KhachHang;

public interface IKhachHang {
	public ArrayList<KhachHang> getDSKhachHang();
	public ArrayList<KhachHang> timKiem(String noiDungTimKiem);
	public boolean themKhachHang(KhachHang khachHang);
	public boolean xoaKhachHang(String id);
	public boolean capNhatKhachHang(String oldID, KhachHang newHDV);
	public KhachHang getKhachHang(String id);
}
