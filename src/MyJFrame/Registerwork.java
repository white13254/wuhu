package MyJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import MySQLManager.AdminInsert;
import MySQLManager.MySQLManager;
import data.AdminDo;

public class Registerwork extends KeyAdapter implements ActionListener{
	private RegisterFrame registerframe;
	public Registerwork(RegisterFrame registerframe) {
		this.registerframe=registerframe;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		JButton jbutton=(JButton)e.getSource();
		String text=jbutton.getText();
		if("确认注册".equals(text)) {
			String pwd=registerframe.getTxtpassword().getText();
			String pwd2=registerframe.getTxtpass2().getText();
			String user=registerframe.getTxtuser().getText();
			if(pwd.equals(pwd2)&&!pwd.isEmpty()&&!pwd2.isEmpty()&&!user.isEmpty()) {
				boolean flag=true;
				//查询该用户是否已注册
				try {
					Connection conn=MySQLManager.getConn();
					PreparedStatement psc=null;
					String sqlcString="select username from human where username=?";
					psc=conn.prepareStatement(sqlcString);
					psc.setString(1, user );
					ResultSet rSet=psc.executeQuery();
					while(rSet.next()) {
						if(rSet!=null) {
							JOptionPane.showMessageDialog(null, "该用户已注册");
							psc.close();
							rSet.close();
							flag=false;
							registerframe.getTxtuser().setText("");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag) {
					JOptionPane.showMessageDialog(null, "注册成功");
					//将用户数据存储进入数据库
					AdminDo adminDo =new AdminDo();
					adminDo.setUserName(user);
					adminDo.setPwd(pwd);
					new AdminInsert(adminDo);
					//直接登入系统 关闭注册页面```````````````````````````````````````````````````````````````
					new MainFrame("select * from machine");
				}
			}else {
				JOptionPane.showMessageDialog(null, "两次输入密码不相同，请重新输入");
				registerframe.getTxtpass2().setText("");
			}
				
		}
		
	}
	public void KeyPressed(KeyEvent e) {
		if(KeyEvent.VK_ENTER==e.getKeyCode()) {
			String pwd=registerframe.getTxtpassword().getText();
			String pwd2=registerframe.getTxtpass2().getText();
			String user=registerframe.getTxtuser().getText();
			if(pwd.equals(pwd2)&!pwd.isEmpty()&&!pwd2.isEmpty()&&!user.isEmpty()) {
				boolean flag=true;
				try {
					//查询该用户是否已注册
					Connection conn=MySQLManager.getConn();
					String sqlString="select username from human where username=?";
					PreparedStatement psc=conn.prepareStatement(sqlString);
					psc.setString(1, user );
					ResultSet rSet = psc .executeQuery();
					while(rSet .next()) {
						if(rSet!=null) {
							JOptionPane .showMessageDialog(null, "该用户已注册");
							psc.close();
							rSet.close();
							registerframe.getTxtuser().setText("");
							flag=false;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag) {
					JOptionPane.showMessageDialog(null, "注册成功");
					//将用户数据存储进入数据库
					AdminDo adminDo =new AdminDo();
					adminDo.setUserName(user);
					adminDo.setPwd(pwd);
					new AdminInsert(adminDo);
					//直接登入系统 关闭注册页面
					//registerframe.setVisible(false); `````````````````````````````````````````````````````````````````
					new MainFrame("select * from machine");
				}
			}else {
				JOptionPane.showMessageDialog(null, "两次输入密码不相同，请重新输入");
				registerframe.getTxtpass2().setText("");
			}
			
			
			/*if(pwd.equals(pwd2)&!pwd.isEmpty()&&!pwd2.isEmpty()&&!user.isEmpty()) {
				JOptionPane.showMessageDialog(null, "注册成功");
				//将用户数据存储进入数据库
				AdminDo adminDo =new AdminDo();
				adminDo.setUserName(user);
				adminDo.setPwd(pwd);
				new AdminInsert(adminDo);
				//直接登入系统 关闭注册页面
				new MainFrame();
			}else if(user.isEmpty()){
				JOptionPane.showMessageDialog(null, "未输入用户名");
			}else {
				JOptionPane.showMessageDialog(null, "两次输入密码不相同，请重新输入");
				registerframe.getTxtpass2().setText("");
			}*/
		}
	}
}
