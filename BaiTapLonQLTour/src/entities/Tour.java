package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import javax.swing.ImageIcon;

public class Tour {
	private String maTour;
	private String tenTour;
	private LocalDate ngayKhoiHanh;
	private Time tgKhoiHanh;
	private int soNgay;
	private int soVeConLai;
	private double gia;
	private BufferedImage hinhAnh;
	private LocalDate ngayTapTrung;
	private Time tgTapTrung;
	private String diemDi;
	private String diemDen;
	private HuongDanVien hdv;
	
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public LocalDate getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(LocalDate ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public Time getTgKhoiHanh() {
		return tgKhoiHanh;
	}
	public void setTgKhoiHanh(Time tgKhoiHanh) {
		this.tgKhoiHanh = tgKhoiHanh;
	}
	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	public int getSoVeConLai() {
		return soVeConLai;
	}
	public void setSoVeConLai(int soVeConLai) {
		this.soVeConLai = soVeConLai;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public BufferedImage getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(BufferedImage hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public LocalDate getNgayTapTrung() {
		return ngayTapTrung;
	}
	public void setNgayTapTrung(LocalDate ngayTapTrung) {
		this.ngayTapTrung = ngayTapTrung;
	}
	public Time getTgTapTrung() {
		return tgTapTrung;
	}
	public void setTgTapTrung(Time tgTapTrung) {
		this.tgTapTrung = tgTapTrung;
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
	
	public HuongDanVien getHdv() {
		return hdv;
	}
	public void setHdv(HuongDanVien hdv) {
		this.hdv = hdv;
	}
	public Tour(String maTour, String tenTour, LocalDate ngayKhoiHanh, Time tgKhoiHanh, int soNgay, int soVeConLai,
			double gia, BufferedImage hinhAnh, LocalDate ngayTapTrung, Time tgTapTrung, String diemDi, String diemDen, HuongDanVien hdv) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.tgKhoiHanh = tgKhoiHanh;
		this.soNgay = soNgay;
		this.soVeConLai = soVeConLai;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.ngayTapTrung = ngayTapTrung;
		this.tgTapTrung = tgTapTrung;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		this.hdv=hdv;
	}
	public Tour(String maTour) {
		super();
		this.maTour = maTour;
	}
	public Tour() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTour);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return Objects.equals(maTour, other.maTour);
	}
	
	
	
	
	
}
