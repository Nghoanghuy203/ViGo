package custom_entity;

import java.awt.Color;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChonMau extends JFrame{
	private String bit_16_mau;
	public static final Color blue_4B70F5 = new ChonMau("4B70F5").getMau();
	public static final Color lightred_FF6666 = new ChonMau("FF6666").getMau();	
	public String getBit_16_mau() {
		return bit_16_mau;
	}

	public void setBit_16_mau(String bit_16_mau) {
		this.bit_16_mau = bit_16_mau;
	}
	
	public ChonMau(String bit_16_mau) {
		setBit_16_mau(bit_16_mau);
	}
	public Color getMau() {
		return new Color(Integer.parseInt(bit_16_mau,16),false);
	}
	
}
