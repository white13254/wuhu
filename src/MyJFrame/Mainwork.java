package MyJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import MySQLManager.MySQLManager;

public class Mainwork implements ActionListener{
	private MainFrame mainframe;
	private JTable ta;
	public Mainwork(MainFrame mainframe,JTable ta) {
		this.mainframe=mainframe;
		this.ta=ta;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jbutton=(JButton)e.getSource();
		String text=jbutton.getText();
		String txt=mainframe.getTxt().getText();
		if("增加".equals(text)) {
			AddInformationFrame addframe=new AddInformationFrame();
			
			//String[] words=new String[7];
			/*words[0]=addframe.getT1().getText();
			words[1]=addframe.getT2().getText();
			words[2]=addframe.getT3().getText();
			words[3]=addframe.getT4().getText();
			words[4]=addframe.getT5().getText();
			words[5]=addframe.getT6().getText();
			words[6]=addframe.getT7().getText();*/
			//System.out.println(words[0]+":"+words[1]);
			/*String[] words=txt.trim().split(" ");
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn=MySQLManager.getConn();
				ps=conn.prepareStatement("insert into machine values("+words[0]+",'"+words[1]+"','"+words[2]+"',"+words[3]+","+words[4]+","+words[5]+",'"+words[6]+"')");
				ps.executeUpdate();
				mainframe.getTxt().setText("");
				JOptionPane.showMessageDialog(null, "已增加信息");
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
			}*/
		}else if("删除".equals(text)) {
			if("".equals(txt)) {
				JOptionPane.showMessageDialog(null, "请输入所需要的删除信息的编号");
			}else {
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					conn=MySQLManager.getConn();
					ps=conn.prepareStatement("delete from machine where 编号=?");
					ps.setString(1, txt);
					ps.executeUpdate();
					mainframe.getTxt().setText("");
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
			
			//操作之后刷新表格
			/*TableConnection da=new TableConnection();
			DefaultTableModel model=new DefaultTableModel(da.data, da.name);
			ta.setModel(model);
			ta.repaint();
			ta.updateUI();*/
		}else if("查找".equals(text)) {
			//jdbc数据库
			if("".equals(txt))
				JOptionPane.showMessageDialog(null, "未查找到信息");
			else {
				mainframe.getTxt().setText("");
				new MainFrame("select * from machine where 编号="+txt);
			}
			//IO流
			
		}else if("修改".equals(text)) {
			UpdateInformationFrame upframe=new UpdateInformationFrame();
			/*String[] words=txt.trim().split(" ");
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn=MySQLManager.getConn();
				ps=conn.prepareStatement("update machine set 编号="+words[0]+",名称='"+words[1]+"',类型='"+words[2]+"',重量="+words[3]+",高度="+words[4]+",运输编号="+words[5]+",运输工具名称='"+words[6]+"' where 编号="+words[0]);
				ps.executeUpdate();
				mainframe.getTxt().setText("");
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
			}*/
		}else if("刷新页面".equals(text)) {
			new MainFrame("select * from machine");
		}
	}
	
}
