package entities;

import java.util.Objects;

public class HuongDanVien {
	private String maHDV;
	private String hoTen;
	private String sdt;
	public String getMaHDV() {
		return maHDV;
	}
	public void setMaHDV(String maHDV) {
		this.maHDV = maHDV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public HuongDanVien(String maHDV, String hoTen, String sdt) {
		super();
		this.maHDV = maHDV;
		this.hoTen = hoTen;
		this.sdt = sdt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHDV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HuongDanVien other = (HuongDanVien) obj;
		return Objects.equals(maHDV, other.maHDV);
	}
	@Override
	public String toString() {
		return "HuongDanVien [maHDV=" + maHDV + ", hoTen=" + hoTen + ", sdt=" + sdt + "]";
	}
	
	
}
