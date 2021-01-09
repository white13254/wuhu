package MySQLManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
	static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String connectionUrl = "jdbc:sqlserver://LAPTOP-GRMADOG1:1433;databaseName=stu;user=sa;password=sa123"; 
	static {
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConn(Connection conn) {
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void closePS(PreparedStatement ps) {
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void closeRs(ResultSet rs) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
