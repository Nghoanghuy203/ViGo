package bus;

import java.util.ArrayList;

import dao.HanhKhach_DAO;
import entities.HanhKhach;
import my_Interfaces.IHanhKhach;

public class HanhKhach_BUS implements IHanhKhach{
	private HanhKhach_DAO hanhKhach_Dao = new HanhKhach_DAO();
	@Override
	public ArrayList<HanhKhach> getDsHanhKhach(String idDon) {
		// TODO Auto-generated method stub
		return hanhKhach_Dao.getDsHanhKhach(idDon);
	}

	@Override
	public boolean themHanhKhach(HanhKhach hangKhach, String idDonDatTour) {
		// TODO Auto-generated method stub
		return hanhKhach_Dao.themHanhKhach(hangKhach, idDonDatTour);
	}

}
