package entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import custom_entity.Format;

public class DonDatTour {
	private String maDon;
	private Tour tour;
	private KhachHang nguoiDung;
	private ArrayList<HanhKhach> dsHanhKhach;
	private Date ngayDat;
	private int soVeDat;
	private double tongTien;
	public String getMaDon() {
		return maDon;
	}
	public void setMaDon(String maDon) {
		this.maDon = maDon;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public KhachHang getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(KhachHang nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public ArrayList<HanhKhach> getDsHanhKhach() {
		return dsHanhKhach;
	}
	public void setDsHanhKhach(ArrayList<HanhKhach> dsHanhKhach) {
		this.dsHanhKhach = dsHanhKhach;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public int getSoVeDat() {
		return soVeDat;
	}
	public void setSoVeDat(int soVeDat) {
		this.soVeDat = soVeDat;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public DonDatTour(String maDon, Tour tour, KhachHang nguoiDung, Date ngayDat,
			int soVeDat) {
		super();
		this.maDon = maDon;
		this.tour = tour;
		this.nguoiDung = nguoiDung;
		//this.dsHanhKhach = dsHanhKhach;
		this.ngayDat = ngayDat;
		this.soVeDat = soVeDat;
		this.tongTien = tinhTongTien();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonDatTour other = (DonDatTour) obj;
		return Objects.equals(maDon, other.maDon);
	}
	@Override
	public String toString() {
		return maDon + ";" + tour.getMaTour() + ";" + tour.getTenTour() +";" + nguoiDung.getSoNguoiDung() + ";"
				+ nguoiDung.getHoTen() + ";" + ngayDat.toString() + ";" + soVeDat + ";" + Format.formatMoneyVND(tongTien);
	}
	
	public double tinhTongTien() {
		return soVeDat*tour.getGia();
	}
}
