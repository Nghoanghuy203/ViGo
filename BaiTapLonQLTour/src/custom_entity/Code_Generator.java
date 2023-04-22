package custom_entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Code_Generator {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int ID_LENGTH = 8;
	private static Random random = new Random();

	public static String generateMaKhachHang(String tenKH, LocalDate ngaysinh, boolean gt) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
		int gtinh = gt?1:0;
		String string = getFirstCharacter(tenKH) + dateTimeFormatter.format(ngaysinh)+gtinh;
		return string;
	}
	public static String generateHuongDanVien(String tenHDV) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
		String string = getFirstCharacter(tenHDV) + dateTimeFormatter.format(LocalDateTime.now());
		return string;
	}

	public static String generateMaTour(String diemDi, String diemDen, String tenTour, LocalDate ngaykhoihanh) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
		String string = getFirstCharacter(diemDi) + "-" + getFirstCharacter(diemDen) + "-"+ getFirstCharacter(tenTour) + dateTimeFormatter.format(ngaykhoihanh);
		return string;
	}
	
	public static String generateMaDon(String maTour, String maKH) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
		return maTour+"-"+maKH+"-"+dateTimeFormatter.format(LocalDate.now());
	}
	
	static int Count = 1;
	public static String generateMaHanhKhach(String maDon) {
		return String.format("%02d", Count++)+"-"+maDon;
	}
	
	public static String getFirstCharacter(String input) {
		return input.replaceAll("[a-z|\\ |\\u00E0\\u00E1\\u00E2\\u00E3\\u00E8\\u00E9\\u00EA\\u00EC\\u00ED\\u00F2\\u00F3\\u00F4\\u00F5\\u00F9\r\n"
				+ "\\u00FA\\u00FD\\u00E5\\u0111\\u0123\\u0169\\u01A1\\u01B0\\u1EA1\\u1EA3\\u1EA5\\u1EA7\\u1EA9\\u1EAB\r\n"
				+ "\\u1EAD\\u1EAF\\u1EB1\\u1EB3\\u1EB5\\u1EB7\\u1EB9\\u1EBB\\u1EBD\\u1EBF\\u1EC1\\u1EC3\\u1EC5\r\n"
				+ "\\u1EC7\\u1EC9\\u1ECB\\u1ECD\\u1ECF\\u1ED1\\u1ED3\\u1ED5\\u1ED7\\u1ED9\\u1EDB\\u1EDD\\u1EDF\r\n"
				+ "\\u1EE1\\u1EE3\\u1EE5\\u1EE7\\u1EE9\\u1EEB\\u1EED\\u1EEF\\u1EF1\\u1EF3\\u1EF5\\u1EF7\\u1EF9abcdefghiklmnopqrstuvxy0123456789_']", "");

	}
	
	public static void main(String[] args) {
		//generateMaKhachHang();
		
		System.out.println(generateMaHanhKhach("adasd"));
		String hdv = generateHuongDanVien("Nguyễn Hoàng Huy");
		System.out.println(hdv);
		String kh = generateMaKhachHang("Nguyễn Hoàng Huy", LocalDate.of(2003, 3, 2), true);
		System.out.println(kh);
		String tour = generateMaTour("Hồ Chí Minh", "Hà Nội", "Hồ Gươm", LocalDate.now());
		System.out.println(tour);
		String don = generateMaDon(tour, kh);
		System.out.println(don);
		String hk = generateMaHanhKhach(don);
		System.out.println(hk);
	}
}
