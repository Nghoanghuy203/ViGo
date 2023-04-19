package entities;

import java.util.ArrayList;

public class DanhSachHanhKhach {
	private ArrayList<HanhKhach> dsHanhKhach;

	public DanhSachHanhKhach() {
		dsHanhKhach = new ArrayList<HanhKhach>();
	}

	public ArrayList<HanhKhach> getdsHanhKhach() {
		return dsHanhKhach;
	}

	public int cout() {
		return dsHanhKhach.size();
	}

	// Thêm hành khách
	public boolean themHanhKhach(HanhKhach hk) {
		if (dsHanhKhach.contains(hk))
			return false;
		return dsHanhKhach.add(hk);
	}

	//Xóa hành khách
	public boolean xoaHanhKhach(int index) {
		if (index >= 0 && index < dsHanhKhach.size()) {
			dsHanhKhach.remove(index);
			return true;
		}
		return false;
	}

	//Cập nhật
	public boolean suaHanhKhach(String maHKOld, HanhKhach hanhKhachnew) {
		HanhKhach hanhKhachCu = new HanhKhach(maHKOld);
		if (dsHanhKhach.contains(hanhKhachCu)) {
			hanhKhachCu = dsHanhKhach.get(dsHanhKhach.indexOf(hanhKhachCu));
			hanhKhachCu.setGioiTinh(hanhKhachnew.isGioiTinh());
			hanhKhachCu.setHoTen(hanhKhachnew.getHoTen());
			hanhKhachCu.setEmail(hanhKhachnew.getEmail());
			hanhKhachCu.setSoDienThoai(hanhKhachnew.getSoDienThoai());
			hanhKhachCu.setLoaiKhach(hanhKhachnew.getLoaiKhach());
			hanhKhachCu.setQuocTich(hanhKhachnew.getQuocTich());
			hanhKhachCu.setLoaiPhong(hanhKhachnew.getLoaiPhong());
			hanhKhachCu.setGhiChu(hanhKhachnew.getGhiChu());
			return true;
		}
		return false;
	}

	//Tìm kiếm
	public HanhKhach timKiemHK(String maHanhKhach) {
		HanhKhach hK = new HanhKhach(maHanhKhach);
		if (dsHanhKhach.contains(hK))
			return dsHanhKhach.get(dsHanhKhach.indexOf(hK));
		return null;
	}
}
