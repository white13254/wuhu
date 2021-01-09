package MyJFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame {
	private JFrame frame;
	private JLabel user;
	private JLabel password;
	private JTextField txtuser;
	private JTextField txtpassword;
	private JButton btnOk;
	private JLabel register;
	private JLabel forgetpassword;
	private Loginwork loginwork;
	public LoginFrame() {
		frame=new JFrame("重型机械运输管理系统");
		user=new JLabel("用户名：");
		password=new JLabel("密码：");
		txtuser=new JTextField();
		btnOk=new JButton("登录");
		txtpassword=new JTextField();
		register=new JLabel("注册账号");
		forgetpassword=new JLabel("忘记密码");
		loginwork=new Loginwork(this);
		
		init();
	}
	public void init() {
		frame.setSize(340,200);
		frame.setLocation(400,200);
		frame.setLayout(null);
		//自定义图标
		java.net.URL imgurl=MainFrame.class.getClassLoader().getResource("c054afb6377d76440d91c0c2852c0436.jpg");
		frame.setIconImage(new ImageIcon(imgurl).getImage());
		
		user.setBounds(50, 20, 100, 20);
		password.setBounds(50, 60, 100, 20);
		txtuser.setBounds(130, 20, 100, 20);
		txtpassword.setBounds(130, 60, 100, 20);
		register.setBounds(10,130,100,20);
		forgetpassword.setBounds(260,130,100,20);
		btnOk.setBounds(110, 100, 120, 30);
		frame.add(user);
		frame.add(btnOk);
		frame.add(password);
		frame.add(txtpassword);
		frame.add(txtuser);
		frame.add(register);
		frame.add(forgetpassword);
		
		btnOk.addActionListener(loginwork);
		btnOk.addKeyListener(loginwork);
		register.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new RegisterFrame();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		forgetpassword.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//设置btnOk为默认按钮
		frame.getRootPane().setDefaultButton(btnOk);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JTextField getTxtuser() {
		return txtuser;
	}
	public void setTxtuser(JTextField txtuser) {
		this.txtuser = txtuser;
	}
	public JTextField getTxtpassword() {
		return txtpassword;
	}
	public void setTxtpassword(JTextField txtpassword) {
		this.txtpassword = txtpassword;
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
}
