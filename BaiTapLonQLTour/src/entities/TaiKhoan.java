package entities;

import java.util.Objects;

public class TaiKhoan {
	private String email;
	private String matKhau;
	public String getEmail() {
		return email;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public TaiKhoan(String email, String matKhau) {
		this.email = email;
		this.matKhau = matKhau;
	}
	public TaiKhoan() {
		super();
	}
	@Override
	public String toString() {
		return "TaiKhoan [email=" + email + ", matKhau=" + matKhau + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(email, other.email);
	}
}
