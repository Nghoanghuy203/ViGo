package QuanLyTour;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectDB {
	
	public Connection getCConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTour";
			String user = "sa";
			String password = "thai011555";
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null)
				System.out.println("Kết nối thành công!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return conn;
	}
}
