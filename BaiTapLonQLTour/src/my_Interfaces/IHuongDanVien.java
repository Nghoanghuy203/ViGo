package my_Interfaces;

import java.util.ArrayList;

import entities.HuongDanVien;

public interface IHuongDanVien {
	public ArrayList<HuongDanVien> getDsHDV();
	public void addHDV(HuongDanVien hdv);
	public void removeHDV(String id);
	public void updateHDV(String oldID, HuongDanVien newHDV);
}
