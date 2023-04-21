package my_Interfaces;

import java.util.ArrayList;

import entities.HanhKhach;

public interface IHanhKhach {
	public ArrayList<HanhKhach> getDsHanhKhach(String idTour);
	public boolean taoHanhKhach(HanhKhach hk, String idDon);
}
