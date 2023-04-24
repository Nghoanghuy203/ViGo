package custom_entity;

import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Code_Generator {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int ID_LENGTH = 8;
	private static Random random = new Random();

	public static String generateMaKhachHang(String tenKH, LocalDate ngaysinh, String gt) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
		int gtinh = gt.equals("Nam")?1:0;
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
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy-mmss");
		return maTour+"-"+maKH+"-"+dateTimeFormatter.format(LocalDateTime.now());
	}
	
	public static int Count = 1;
	public static String generateMaHanhKhach(String tenHK) {
		return String.format("%02d", Count++)+"-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm-ddMM")) +"-"+getFirstCharacter(tenHK);
	}
	
	public static String getFirstCharacter(String input) {
		return input.replaceAll("[a-z|\\ |"+tiengVietLow()+"]", "");

	}
	
	public static String tiengVietFull() {
		String tv = "A-ZĐ|Ắ|Ắ|Ắ|Ằ|Ằ|Ằ|Ẳ|Ẳ|Ẳ|Ẵ|Ẵ|Ẵ|Ặ|Ặ|Ặ|Ặ|Ặ|Ặ|Ă|Ă|Ấ|Ấ|Ấ|Ầ|Ầ|Ầ|Ẩ|Ẩ|Ẩ|Ẫ|Ẫ|Ẫ|Ậ|Ậ|Ậ|Ậ|Ậ|Ậ|Â|Â|Á|Á|À|À|Ã|Ã|Ả|Ả|Ạ|Ạ|Ế|Ế|Ế|Ề|Ề|Ề|Ể|Ể|Ể|Ễ|Ễ|Ễ|Ệ|Ệ|Ệ|Ệ|Ệ|Ệ|Ê|Ê|É|É|È|È|Ẻ|Ẻ|Ẽ|Ẽ|Ẹ|Ẹ|Í|Í|Ì|Ì|Ỉ|Ỉ|Ĩ|Ĩ|Ị|Ị|Ố|Ố|Ố|Ồ|Ồ|Ồ|Ổ|Ổ|Ổ|Ỗ|Ỗ|Ỗ|Ộ|Ộ|Ộ|Ộ|Ộ|Ộ|Ô|Ô|Ớ|Ớ|Ớ|Ớ|Ớ|Ớ|Ờ|Ờ|Ờ|Ờ|Ờ|Ờ|Ở|Ở|Ở|Ở|Ở|Ở|Ỡ|Ỡ|Ỡ|Ỡ|Ỡ|Ỡ|Ợ|Ợ|Ợ|Ợ|Ợ|Ợ|Ơ|Ơ|Ó|Ó|Ò|Ò|Õ|Õ|Ỏ|Ỏ|Ọ|Ọ|Ứ|Ứ|Ứ|Ứ|Ứ|Ứ|Ừ|Ừ|Ừ|Ừ|Ừ|Ừ|Ử|Ử|Ử|Ử|Ử|Ử|Ữ|Ữ|Ữ|Ữ|Ữ|Ữ|Ự|Ự|Ự|Ự|Ự|Ự|Ư|Ư|Ú|Ú|Ù|Ù|Ủ|Ủ|Ũ|Ũ|Ụ|Ụ|Ý|Ý|Ỳ|Ỳ|Ỷ|Ỷ|Ỹ|Ỹ|Ỵ|Ỵ";
		String ht = "["+tv.toLowerCase() + tv.toUpperCase() + "]";
		return ht;
	}

	public static String tiengVietLow() {
		String tv = "A-ZĐ|Ắ|Ắ|Ắ|Ằ|Ằ|Ằ|Ẳ|Ẳ|Ẳ|Ẵ|Ẵ|Ẵ|Ặ|Ặ|Ặ|Ặ|Ặ|Ặ|Ă|Ă|Ấ|Ấ|Ấ|Ầ|Ầ|Ầ|Ẩ|Ẩ|Ẩ|Ẫ|Ẫ|Ẫ|Ậ|Ậ|Ậ|Ậ|Ậ|Ậ|Â|Â|Á|Á|À|À|Ã|Ã|Ả|Ả|Ạ|Ạ|Ế|Ế|Ế|Ề|Ề|Ề|Ể|Ể|Ể|Ễ|Ễ|Ễ|Ệ|Ệ|Ệ|Ệ|Ệ|Ệ|Ê|Ê|É|É|È|È|Ẻ|Ẻ|Ẽ|Ẽ|Ẹ|Ẹ|Í|Í|Ì|Ì|Ỉ|Ỉ|Ĩ|Ĩ|Ị|Ị|Ố|Ố|Ố|Ồ|Ồ|Ồ|Ổ|Ổ|Ổ|Ỗ|Ỗ|Ỗ|Ộ|Ộ|Ộ|Ộ|Ộ|Ộ|Ô|Ô|Ớ|Ớ|Ớ|Ớ|Ớ|Ớ|Ờ|Ờ|Ờ|Ờ|Ờ|Ờ|Ở|Ở|Ở|Ở|Ở|Ở|Ỡ|Ỡ|Ỡ|Ỡ|Ỡ|Ỡ|Ợ|Ợ|Ợ|Ợ|Ợ|Ợ|Ơ|Ơ|Ó|Ó|Ò|Ò|Õ|Õ|Ỏ|Ỏ|Ọ|Ọ|Ứ|Ứ|Ứ|Ứ|Ứ|Ứ|Ừ|Ừ|Ừ|Ừ|Ừ|Ừ|Ử|Ử|Ử|Ử|Ử|Ử|Ữ|Ữ|Ữ|Ữ|Ữ|Ữ|Ự|Ự|Ự|Ự|Ự|Ự|Ư|Ư|Ú|Ú|Ù|Ù|Ủ|Ủ|Ũ|Ũ|Ụ|Ụ|Ý|Ý|Ỳ|Ỳ|Ỷ|Ỷ|Ỹ|Ỹ|Ỵ|Ỵ";
		String ht = "["+tv.toLowerCase()+"]";
		return ht;
	}
	
	public static void main(String[] args) {
		//generateMaKhachHang();
		
//		System.out.println(generateMaHanhKhach("adasd"));
//		String hdv = generateHuongDanVien("Nguyễn Hoàng Huy");
//		System.out.println(hdv);
//		String kh = generateMaKhachHang("Nguyễn Hoàng Huy", LocalDate.of(2003, 3, 2), "Nam");
//		System.out.println(kh);
//		String tour = generateMaTour("Hồ Chí Minh", "Hắ Nội", "Hồ Gươm", LocalDate.now());
//		System.out.println(tour);
//		String don = generateMaDon(tour, kh);
//		System.out.println(don);
//		String hk = generateMaHanhKhach(don);
//		System.out.println(hk);
//		String tv= "\\\\u00E0\\\\u00E1\\\\u00E2\\\\u00E3\\\\u00E8\\\\u00E9\\\\u00EA\\\\u00EC\\\\u00ED\\\\u00F2\\\\u00F3\\\\u00F4\\\\u00F5\\\\u00F9\\r\\n\"\r\n"
//				+ "				+ \"\\\\u00FA\\\\u00FD\\\\u00E5\\\\u0111\\\\u0123\\\\u0169\\\\u01A1\\\\u01B0\\\\u1EA1\\\\u1EA3\\\\u1EA5\\\\u1EA7\\\\u1EA9\\\\u1EAB\\r\\n\"\r\n"
//				+ "				+ \"\\\\u1EAD\\\\u1EAF\\\\u1EB1\\\\u1EB3\\\\u1EB5\\\\u1EB7\\\\u1EB9\\\\u1EBB\\\\u1EBD\\\\u1EBF\\\\u1EC1\\\\u1EC3\\\\u1EC5\\r\\n\"\r\n"
//				+ "				+ \"\\\\u1EC7\\\\u1EC9\\\\u1ECB\\\\u1ECD\\\\u1ECF\\\\u1ED1\\\\u1ED3\\\\u1ED5\\\\u1ED7\\\\u1ED9\\\\u1EDB\\\\u1EDD\\\\u1EDF\\r\\n\"\r\n"
//				+ "				+ \"\\\\u1EE1\\\\u1EE3\\\\u1EE5\\\\u1EE7\\\\u1EE9\\\\u1EEB\\\\u1EED\\\\u1EEF\\\\u1EF1\\\\u1EF3\\\\u1EF5\\\\u1EF7\\\\u1EF9abcdefghiklmnopqrstuvxy0123456789_']";
		String s = "Nguyến Hoàng Huy";
		String tv = "a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ";
		System.out.println(tv.toUpperCase());
		//System.out.println(s.matches("^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$"));
		//System.out.println(s.matches("^("+Code_Generator.tiengVietLow().toUpperCase()+"+)((\\s{1}"+Code_Generator.tiengVietFull()+"+){1,})$"));
		System.out.println(s.matches("^("+tiengVietLow().toUpperCase()+tiengVietLow()+"*((\\s)))+"+tiengVietLow().toUpperCase()+tiengVietLow()+"*$"));
		//System.out.println(s.matches("([A-Z]{1}"+tv+"*)(\\ [A-Z]{1}"+tv+"*)*"));
		Time t = Time.valueOf("12:12:00");
		//System.out.println(t.getMinutes());
		String ng = "2023-01-23 13:25:12";
		String ngaykh = ng.trim().substring(0, 10).replaceAll("-", "");
		int nam = Integer.parseInt(ngaykh.substring(0, 4));
		int thang = Integer.parseInt(ngaykh.substring(4, 6));
		int ngay = Integer.parseInt(ngaykh.substring(6, 8));
		LocalDate ngayKhoiHanh = LocalDate.of(nam, thang, ngay);
		Time tgKhoiHanh = Time.valueOf(ng.trim().substring(11, 19));
		System.out.println(tgKhoiHanh.toString());
	}
	
}
