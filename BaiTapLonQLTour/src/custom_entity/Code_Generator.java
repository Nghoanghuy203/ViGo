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

	public static String generateMaKhachHang() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmmssddMMyy");
		String string = "KH" + dateTimeFormatter.format(LocalDateTime.now());
		return string;
	}
	public static String generateMaNhanVien() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmmssddMMyy");
		String string = "NV" + dateTimeFormatter.format(LocalDateTime.now());
		return string;
	}

	public static String generateMaTour(String tenTour,LocalDate localDate) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
		String string = tenTour.replaceAll("\\s", "") + "-" + dateTimeFormatter.format(localDate);
		return string;
	}
	static int Count = 1;
	public static String generateMaHangKhach(String tenTour, LocalDate localDate) {
		return generateMaTour(tenTour,localDate)+"-"+String.format("%02d", Count++);
	}

	public static void main(String[] args) {
		generateMaKhachHang();
		generateMaHangKhach("Da Lat Vung Tau", LocalDate.now());
	}
}
