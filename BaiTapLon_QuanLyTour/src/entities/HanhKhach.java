package entities;

import java.util.Objects;

public class HanhKhach {
	enum LoaiKhach {
		duoi12, tu12den65, tren65
	}

	enum LoaiPhong {
		PhongVIP, PhongBinhDan
	}

	private String maKhachHang;
	private boolean gioiTinh;
	private String hoTen;
	private String email;
	private String soDienThoai;
	private LoaiKhach loaiKhach;
	private String quocTich;
	private LoaiPhong loaiPhong;
	private String ghiChu;

	public HanhKhach(String maKhachHang, boolean gioiTinh, String hoTen, String email, String soDienThoai,
			LoaiKhach loaiKhach, String quocTich, LoaiPhong loaiPhong, String ghiChu) {
		this.maKhachHang = maKhachHang;
		this.gioiTinh = gioiTinh;
		this.hoTen = hoTen;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.loaiKhach = loaiKhach;
		this.quocTich = quocTich;
		this.loaiPhong = loaiPhong;
		this.ghiChu = ghiChu;
	}

	public HanhKhach() {
		super();
	}

	public HanhKhach(String maKhachHang) {
		this(maKhachHang, true, "", "", "", LoaiKhach.duoi12, "", LoaiPhong.PhongVIP, "");
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public LoaiKhach getLoaiKhach() {
		return loaiKhach;
	}

	public void setLoaiKhach(LoaiKhach loaiKhach) {
		this.loaiKhach = loaiKhach;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
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
		HanhKhach other = (HanhKhach) obj;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equalsIgnoreCase(other.maKhachHang))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HanhKhach [maKhachHang=" + maKhachHang + ", gioiTinh=" + gioiTinh + ", hoTen=" + hoTen + ", email="
				+ email + ", soDienThoai=" + soDienThoai + ", loaiKhach=" + loaiKhach + ", quocTich=" + quocTich
				+ ", loaiPhong=" + loaiPhong + ", ghiChu=" + ghiChu + "]";
	}
}
