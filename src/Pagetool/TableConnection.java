package Pagetool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MySQLManager.MySQLManager;

public class TableConnection {
	public Object data[][];
	public Object name[]= {"编号","名称","类型","重量","高度","运输编号","运输工具名称"};
	public TableConnection(String sql) {
		Connection conn=MySQLManager.getConn();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
			rs.last();
			data=new Object[rs.getRow()][7];
			int i=0;
			rs.beforeFirst();
			while(rs.next()) {
				String id=rs.getString("编号");
				String nam=rs.getString("名称");
				String type=rs.getString("类型");
				float weight=rs.getFloat("重量");
				float height=rs.getFloat("高度");
				String num=rs.getString("运输编号");
				String tran=rs.getString("运输工具名称");
				data[i][0]=id;
				data[i][1]=nam;
				data[i][2]=type;
				data[i][3]=weight;
				data[i][4]=height;
				data[i][5]=num;
				data[i][6]=tran;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if (rs != null)    
			        try {    
			            rs.close();    
			        } catch (Exception e) {    
			        }    
			    if (stmt != null)    
			        try {    
			            stmt.close();  
			        } catch (Exception e) {    
			        }    
			    if (conn != null)    
			        try {    
			            conn.close();    
			        } catch (Exception e) {    
			        }    
		}
	}
}
