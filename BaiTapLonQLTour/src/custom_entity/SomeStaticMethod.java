package custom_entity;

import javax.swing.JOptionPane;

public class SomeStaticMethod {
	public static int MAX(int a, int b) {
		if(a>b) return a;
		else return b;
	}
	public static int showDialog(int dangDialog, String message) {
		switch (dangDialog) {
		case JOptionPane.WARNING_MESSAGE: {
			JOptionPane.showMessageDialog(null, message,"Cảnh Báo!", dangDialog);
			break;
		}
		case JOptionPane.ERROR_MESSAGE:{
			JOptionPane.showMessageDialog(null, message, "Lỗi!", dangDialog);
			break;
		}
		case JOptionPane.QUESTION_MESSAGE:{
			return JOptionPane.showConfirmDialog(null, message,"Bạn chắc không?", dangDialog);
		}
		default:
			JOptionPane.showMessageDialog(null, message);
			break;
		}
		return 0;
	}
}
