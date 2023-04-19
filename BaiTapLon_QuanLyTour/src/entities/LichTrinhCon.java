package entities;

import java.time.LocalDate;

public class LichTrinhCon {
	private String maLichTrinh;
	private String diemDi;
	private String diemDen;
	private String ngayDi;
	private String ngayDen;
	private LocalDate thoiGianDi;
	private LocalDate thoiGianVe;
	private String hinhThuc;
	

	public LichTrinhCon(String maLichTrinh, String diemDi, String diemDen, String ngayDi, String ngayDen,
			LocalDate thoiGianDi, LocalDate thoiGianVe, String hinhThuc) {
		this.maLichTrinh = maLichTrinh;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		this.ngayDi = ngayDi;
		this.ngayDen = ngayDen;
		this.thoiGianDi = thoiGianDi;
		this.thoiGianVe = thoiGianVe;
		this.hinhThuc = hinhThuc;
	}


	public LichTrinhCon() {
	}


	public LichTrinhCon(String maLichTrinh) {
		this(maLichTrinh,"","","","",LocalDate.of(0000, 00, 00),LocalDate.of(0000, 00, 00),"");
	}


	public String getMaLichTrinh() {
		return maLichTrinh;
	}


	public void setMaLichTrinh(String maLichTrinh) {
		this.maLichTrinh = maLichTrinh;
	}


	public String getDiemDi() {
		return diemDi;
	}


	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}


	public String getDiemDen() {
		return diemDen;
	}


	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}


	public String getNgayDi() {
		return ngayDi;
	}


	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}


	public String getNgayDen() {
		return ngayDen;
	}


	public void setNgayDen(String ngayDen) {
		this.ngayDen = ngayDen;
	}


	public LocalDate getThoiGianDi() {
		return thoiGianDi;
	}


	public void setThoiGianDi(LocalDate thoiGianDi) {
		this.thoiGianDi = thoiGianDi;
	}


	public LocalDate getThoiGianVe() {
		return thoiGianVe;
	}


	public void setThoiGianVe(LocalDate thoiGianVe) {
		this.thoiGianVe = thoiGianVe;
	}


	public String getHinhThuc() {
		return hinhThuc;
	}


	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLichTrinh == null) ? 0 : maLichTrinh.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichTrinhCon other = (LichTrinhCon) obj;
		if (maLichTrinh == null) {
			if (other.maLichTrinh != null)
				return false;
		} else if (!maLichTrinh.equalsIgnoreCase(other.maLichTrinh))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LichTrinhCon [maLichTrinh=" + maLichTrinh + ", diemDi=" + diemDi + ", diemDen=" + diemDen + ", ngayDi="
				+ ngayDi + ", ngayDen=" + ngayDen + ", thoiGianDi=" + thoiGianDi + ", thoiGianVe=" + thoiGianVe
				+ ", hinhThuc=" + hinhThuc + "]";
	}
	
	
}
