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
		if("ȷ��ע��".equals(text)) {
			String pwd=registerframe.getTxtpassword().getText();
			String pwd2=registerframe.getTxtpass2().getText();
			String user=registerframe.getTxtuser().getText();
			if(pwd.equals(pwd2)&&!pwd.isEmpty()&&!pwd2.isEmpty()&&!user.isEmpty()) {
				boolean flag=true;
				//��ѯ���û��Ƿ���ע��
				try {
					Connection conn=MySQLManager.getConn();
					PreparedStatement psc=null;
					String sqlcString="select username from human where username=?";
					psc=conn.prepareStatement(sqlcString);
					psc.setString(1, user );
					ResultSet rSet=psc.executeQuery();
					while(rSet.next()) {
						if(rSet!=null) {
							JOptionPane.showMessageDialog(null, "���û���ע��");
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
					JOptionPane.showMessageDialog(null, "ע��ɹ�");
					//���û����ݴ洢�������ݿ�
					AdminDo adminDo =new AdminDo();
					adminDo.setUserName(user);
					adminDo.setPwd(pwd);
					new AdminInsert(adminDo);
					//ֱ�ӵ���ϵͳ �ر�ע��ҳ��```````````````````````````````````````````````````````````````
					new MainFrame("select * from machine");
				}
			}else {
				JOptionPane.showMessageDialog(null, "�����������벻��ͬ������������");
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
					//��ѯ���û��Ƿ���ע��
					Connection conn=MySQLManager.getConn();
					String sqlString="select username from human where username=?";
					PreparedStatement psc=conn.prepareStatement(sqlString);
					psc.setString(1, user );
					ResultSet rSet = psc .executeQuery();
					while(rSet .next()) {
						if(rSet!=null) {
							JOptionPane .showMessageDialog(null, "���û���ע��");
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
					JOptionPane.showMessageDialog(null, "ע��ɹ�");
					//���û����ݴ洢�������ݿ�
					AdminDo adminDo =new AdminDo();
					adminDo.setUserName(user);
					adminDo.setPwd(pwd);
					new AdminInsert(adminDo);
					//ֱ�ӵ���ϵͳ �ر�ע��ҳ��
					//registerframe.setVisible(false); `````````````````````````````````````````````````````````````````
					new MainFrame("select * from machine");
				}
			}else {
				JOptionPane.showMessageDialog(null, "�����������벻��ͬ������������");
				registerframe.getTxtpass2().setText("");
			}
			
			
			/*if(pwd.equals(pwd2)&!pwd.isEmpty()&&!pwd2.isEmpty()&&!user.isEmpty()) {
				JOptionPane.showMessageDialog(null, "ע��ɹ�");
				//���û����ݴ洢�������ݿ�
				AdminDo adminDo =new AdminDo();
				adminDo.setUserName(user);
				adminDo.setPwd(pwd);
				new AdminInsert(adminDo);
				//ֱ�ӵ���ϵͳ �ر�ע��ҳ��
				new MainFrame();
			}else if(user.isEmpty()){
				JOptionPane.showMessageDialog(null, "δ�����û���");
			}else {
				JOptionPane.showMessageDialog(null, "�����������벻��ͬ������������");
				registerframe.getTxtpass2().setText("");
			}*/
		}
	}
}
