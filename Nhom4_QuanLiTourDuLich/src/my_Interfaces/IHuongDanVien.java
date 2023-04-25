package my_Interfaces;

import java.util.ArrayList;

import entities.HuongDanVien;

public interface IHuongDanVien {
	public ArrayList<HuongDanVien> getDSHuongDanVien();
	public ArrayList<HuongDanVien> timKiem(String noiDungTimKiem);
	public boolean themHuongDanVien(HuongDanVien hdv);
	public boolean xoaHuuongDanVien(String id);
	public boolean suaHuongDanVien(String oldID, HuongDanVien newHDV);
	public HuongDanVien getHuongDanVien(String id);
}
