package custom_entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Code_Generator {
	@SuppressWarnings("unused")
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	@SuppressWarnings("unused")
	private static final int ID_LENGTH = 8;
	@SuppressWarnings("unused")
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
	

}
