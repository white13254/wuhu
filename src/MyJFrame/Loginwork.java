package MyJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import MySQLManager.AdminServicelml;
import data.AdminDo;

public class Loginwork extends KeyAdapter implements ActionListener{
	private LoginFrame loginframe;
	public Loginwork(LoginFrame loginframe) {
		this.loginframe=loginframe;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jbutton=(JButton)e.getSource();
		String text=jbutton.getText();
		if("登录".equals(text)) {
			String user=loginframe.getTxtuser().getText();
			String pwd=loginframe.getTxtpassword().getText();
			
			if(user==null||"".equals(user.trim())||pwd==null||"".equals(pwd.trim())) {
				JOptionPane.showMessageDialog(null, "请填写用户密码");
			}
			//查询database
			AdminServicelml adminservice=new AdminServicelml();
			AdminDo adminDo=new AdminDo();
			adminDo.setUserName(user);
			adminDo.setPwd(pwd);
			boolean flag=adminservice.vaildataAdmin(adminDo);
			if(flag) {
				new MainFrame("select * from machine");
			}else {
				JOptionPane.showMessageDialog(null, "用户名账户不存在或者密码错误，请重新输入");
				loginframe.getTxtpassword().setText("");
			}
		}
		
	}
	public void KeyPressed(KeyEvent e) {
		if(KeyEvent.VK_ENTER==e.getKeyCode()) {
			String user=loginframe.getTxtuser().getText();
			String pwd=loginframe.getTxtpassword().getText();
			//查询database
			if(user==null||"".equals(user.trim())||pwd==null||"".equals(pwd.trim())) {
				JOptionPane.showMessageDialog(null, "请填写用户密码");
			}
			AdminServicelml adminservice=new AdminServicelml();
			AdminDo adminDo=new AdminDo();
			adminDo.setUserName(user);
			adminDo.setPwd(pwd);
			boolean flag=adminservice.vaildataAdmin(adminDo);
			if(flag) {
				new MainFrame("select * from machine");
			}else {
				JOptionPane.showMessageDialog(null, "用户名账户不存在或者密码错误，请重新输入");
				loginframe.getTxtpassword().setText("");
			}
		}
	}
}
