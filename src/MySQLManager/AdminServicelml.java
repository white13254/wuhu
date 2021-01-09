package MySQLManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.AdminDo;

public class AdminServicelml implements AdminService{

	@Override
	public boolean vaildataAdmin(AdminDo adminDo) {
		String userName=adminDo.getUserName();
		String pwdparam=adminDo.getPwd();
		String sql="select password from human where username=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=MySQLManager.getConn();
			if(conn==null) {
				return false;
			}
			ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			while(rs.next()) {
				String pwd=rs.getString(1);
				if(pwdparam.equals(pwd))
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MySQLManager.closeConn(conn);
			MySQLManager.closePS(ps);
		}
		
		return false;
	}
}
