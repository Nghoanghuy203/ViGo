package entities;

import java.util.ArrayList;

public class LichTrinh {
	private ArrayList<LichTrinhCon> dsLichTrinh;
	public  LichTrinh() {
		dsLichTrinh = new ArrayList<LichTrinhCon>();
	}
	
	public ArrayList<LichTrinhCon> getdSLichTrinh() {
		return dsLichTrinh;
	}
	
	public int cout() {
		return dsLichTrinh.size();
	}
	
	public boolean themLichTrinh(LichTrinhCon lichtrinh) {
		if (dsLichTrinh.contains(lichtrinh))
			return false;
		return dsLichTrinh.add(lichtrinh);
	}
	
	public boolean xoaLichTrinhCon(int index ) {
		if (index >= 0 && index < dsLichTrinh.size()) {
			dsLichTrinh.remove(index);
			return true;
		}
		return false;
	}
	
	
	public boolean suaLichTrinhCon(String thuTuCu, LichTrinhCon LichTrinhnew) {
		LichTrinhCon lichTrinhCu = new LichTrinhCon(thuTuCu);
		if (dsLichTrinh.contains(lichTrinhCu)) {
			lichTrinhCu = dsLichTrinh.get(dsLichTrinh.indexOf(lichTrinhCu));
			lichTrinhCu.setDiemDi(LichTrinhnew.getDiemDi());
			lichTrinhCu.setDiemDen(LichTrinhnew.getDiemDen());
			lichTrinhCu.setNgayDi(LichTrinhnew.getNgayDi());
			lichTrinhCu.setNgayDen(LichTrinhnew.getNgayDen());
			lichTrinhCu.setThoiGianDi(LichTrinhnew.getThoiGianDi());
			lichTrinhCu.setThoiGianVe(LichTrinhnew.getThoiGianVe());
			lichTrinhCu.setHinhThuc(LichTrinhnew.getHinhThuc());
			return true;
		}
		return false;
	}
}
