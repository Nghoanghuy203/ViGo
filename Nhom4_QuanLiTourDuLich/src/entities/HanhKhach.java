package entities;

import java.util.Objects;

public class HanhKhach {
	private String maHK,hoTen,sdt;

	public String getMaHK() {
		return maHK;
	}

	public void setMaHK(String maHK) {
		this.maHK = maHK;
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

	public HanhKhach(String maHK, String hoTen, String sdt) {
		super();
		this.maHK = maHK;
		this.hoTen = hoTen;
		this.sdt = sdt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HanhKhach other = (HanhKhach) obj;
		return Objects.equals(maHK, other.maHK);
	}

	@Override
	public String toString() {
		return maHK + ";" + hoTen + ";" + sdt;
	}
	
}
