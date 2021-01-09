package MyJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import MySQLManager.MySQLManager;

public class UpdateInformationwork implements ActionListener{
	private UpdateInformationFrame frame;
	public UpdateInformationwork(UpdateInformationFrame frame) {
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jbutton=(JButton)e.getSource();
		String text=jbutton.getText();
		String words[]=new String[7];
		if("确认".equals(text)) {
			words[0]=frame.getT1().getText();
			words[1]=frame.getT2().getText();
			words[2]=frame.getT3().getText();
			words[3]=frame.getT4().getText();
			words[4]=frame.getT5().getText();
			words[5]=frame.getT6().getText();
			words[6]=frame.getT7().getText();
			//System.out.println("update machine set 编号="+words[0]+",名称='"+words[1]+"',类型='"+words[2]+"',重量="+words[3]+",高度="+words[4]+",运输编号="+words[5]+",运输工具名称='"+words[6]+"' where 编号="+words[0]);
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn=MySQLManager.getConn();
				ps=conn.prepareStatement("update machine set 编号="+words[0]+",名称='"+words[1]+"',类型='"+words[2]+"',重量="+words[3]+",高度="+words[4]+",运输编号="+words[5]+",运输工具名称='"+words[6]+"' where 编号="+words[0]);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "修改完成");
				new MainFrame("select * from machine");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					conn.close();
					ps.close();
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
