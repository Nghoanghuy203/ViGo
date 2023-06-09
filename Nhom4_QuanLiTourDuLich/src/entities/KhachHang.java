package entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
public class KhachHang {
	private String soNguoiDung;
	private String hoTen;
	private String soDienThoai;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private String email;
	private String matKhau;
	
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoNguoiDung() {
		return soNguoiDung;
	}
	public String getHoTen() {
		return hoTen;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoNguoiDung(String soNguoiDung) {
		this.soNguoiDung = soNguoiDung;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public KhachHang(String soNguoiDung, String hoTen, LocalDate ngaySinh, String soDienThoai, boolean gioiTinh, String email, String matKhau) {
		super();
		this.soNguoiDung = soNguoiDung;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.matKhau=matKhau;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String soNguoiDung) {
		super();
		this.soNguoiDung = soNguoiDung;
	}
	public KhachHang(String maNguoiDung, String hoten) {
		this.soNguoiDung=maNguoiDung;
		this.hoTen=hoten;
	}
	@Override
    public String toString() {
		String gt = isGioiTinh()?"Nam":"Nữ";
        return soNguoiDung + ";" +  hoTen + ";" +  ngaySinh.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ";" + soDienThoai + ";" + gt + ";" + email + ";" +matKhau;
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
		KhachHang other = (KhachHang) obj;
		return Objects.equals(soNguoiDung, other.soNguoiDung);
	}
}
