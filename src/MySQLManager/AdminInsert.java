package MySQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.AdminDo;

public class AdminInsert {
	
	public AdminInsert(AdminDo adminDo ) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="insert into  human values(?,?)";
		
		try {
			String userName=adminDo.getUserName();
			String pwdparam=adminDo.getPwd();
			conn=MySQLManager.getConn();
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, userName );
			ps.setString(2, pwdparam );
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
