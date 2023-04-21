package entities;

import java.util.Objects;
public class NguoiDung {
	private String soNguoiDung;
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private TaiKhoan taiKhoan;
	public String getSoNguoiDung() {
		return soNguoiDung;
	}
	public String getHoTen() {
		return hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setSoNguoiDung(String soNguoiDung) {
		this.soNguoiDung = soNguoiDung;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public NguoiDung(String soNguoiDung, String hoTen, String ngaySinh, String diaChi, String soDienThoai,
			TaiKhoan taiKhoan) {
		super();
		this.soNguoiDung = soNguoiDung;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
	}
	public NguoiDung() {
		super();
	}
	public NguoiDung(String soNguoiDung) {
		super();
		this.soNguoiDung = soNguoiDung;
	}
	public NguoiDung(String maNguoiDung, String hoten) {
		this.soNguoiDung=maNguoiDung;
		this.hoTen=hoten;
	}
	@Override
	public String toString() {
		return "NguoiDung [soNguoiDung=" + soNguoiDung + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi="
				+ diaChi + ", soDienThoai=" + soDienThoai + ", taiKhoan=" + taiKhoan + ", loaiNguoiDung="+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(soNguoiDung);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NguoiDung other = (NguoiDung) obj;
		return Objects.equals(soNguoiDung, other.soNguoiDung);
	}
}
