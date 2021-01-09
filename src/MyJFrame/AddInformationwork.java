package MyJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import IOManager.Machine;
import IOManager.MachineManager;
import MySQLManager.MySQLManager;

public class AddInformationwork implements ActionListener{
	private AddInformationFrame addframe;
	public AddInformationwork(AddInformationFrame addframe) {
		this.addframe=addframe;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jbutton=(JButton)e.getSource();
		String text=jbutton.getText();
		String words[]=new String[7];
		if("确认".equals(text)) {
			//jdbc数据库
			words[0]=addframe.getT1().getText();
			words[1]=addframe.getT2().getText();
			words[2]=addframe.getT3().getText();
			words[3]=addframe.getT4().getText();
			words[4]=addframe.getT5().getText();
			words[5]=addframe.getT6().getText();
			words[6]=addframe.getT7().getText();
			//System.out.println("insert into machine values("+words[0]+",'"+words[1]+"','"+words[2]+"',"+words[3]+","+words[4]+","+words[5]+",'"+words[6]+"')");
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn=MySQLManager.getConn();
				ps=conn.prepareStatement("insert into machine values("+words[0]+",'"+words[1]+"','"+words[2]+"',"+words[3]+","+words[4]+","+words[5]+",'"+words[6]+"')");
				ps.executeUpdate();
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
			}
			//IO流
		 /*ArrayList<Machine> list=new ArrayList<>();
		list.add(new Machine("20160001","孙悟空","飞飞","212","22","21322","打"));
		list.add(new Machine("20160002","孙悟空","飞飞","212","22","21322","打"));
		list.add(new Machine("1230","孙悟空","飞飞","212","22","21322","打"));
		MachineManager am;
		try {
			am = new MachineManager();
			try {
				am.save(list);
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}//保存账户信息
			System.out.println("-----  输出账户信息  --------");
			am.showAll();
			try {
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			am.add(new Machine(words[0],words[1],words[2],words[3],words[4],words[5],words[6]));
			System.out.println("-----  输出增加后的账户信息  --------");
			am.showAll();
		}catch(Exception e5){
			e5.printStackTrace();
		}*/
	}
	}
}
