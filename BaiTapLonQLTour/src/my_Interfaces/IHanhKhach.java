package my_Interfaces;

import java.util.ArrayList;

import entities.HanhKhach;

public interface IHanhKhach {
	public ArrayList<HanhKhach> getDsHanhKhach(String idDon);
	public boolean themHanhKhach(HanhKhach hangKhach, String idDonDatTour);
	public boolean xoaHanhKhach(String maDon);
}
