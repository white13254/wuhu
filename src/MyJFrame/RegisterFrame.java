package MyJFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterFrame {
	private JFrame frame;
	private JLabel user;
	private JLabel password;
	private JLabel pass2;
	private JTextField txtpass2;
	private JTextField txtuser;
	private JTextField txtpassword;
	private JButton btnOk;
	private Registerwork registerwork;
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public RegisterFrame() {
		frame=new JFrame("注册");
		user=new JLabel("请输入用户名:");
		txtuser=new JTextField();
		password=new JLabel("请输入密码：");
		txtpassword=new JTextField();
		btnOk=new JButton("确认注册");
		pass2=new JLabel("确认密码:");
		txtpass2=new JTextField();
		registerwork=new Registerwork(this);
		
		init();
	}
	
	public void init() {
		frame.setSize(340,220);
		frame.setLocation(400,200);
		frame.setLayout(null);
		//自定义图标
		java.net.URL imgurl=MainFrame.class.getClassLoader().getResource("llchvq1ugsy.jpg");
		frame.setIconImage(new ImageIcon(imgurl).getImage());
		
		user.setBounds(50,20 , 100,20  );
		password.setBounds(50, 60, 100, 20);
		txtuser.setBounds(130, 20, 100, 20);
		txtpassword.setBounds(130, 60, 100, 20);
		btnOk.setBounds(120, 140, 120, 30);
		pass2.setBounds(50, 100, 100, 20);
		txtpass2.setBounds(130, 100, 100, 20);
		
		frame.add(user);
		frame.add(txtuser);
		frame.add(password);
		frame.add(txtpassword);
		frame.add(btnOk);
		frame.add(pass2);
		frame.add(txtpass2);
		btnOk.addActionListener(registerwork);
		
		//设置btnOk为默认按钮
		frame.getRootPane().setDefaultButton(btnOk);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JLabel getPassword() {
		return password;
	}
	public void setPassword(JLabel password) {
		this.password = password;
	}
	public JLabel getPass2() {
		return pass2;
	}
	public JLabel getUser() {
		return user;
	}

	public void setUser(JLabel user) {
		this.user = user;
	}

	public void setPass2(JLabel pass2) {
		this.pass2 = pass2;
	}
	public JTextField getTxtpass2() {
		return txtpass2;
	}
	public void setTxtpass2(JTextField txtpass2) {
		this.txtpass2 = txtpass2;
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
	public Registerwork getRegisterwork() {
		return registerwork;
	}
	public void setRegisterwork(Registerwork registerwork) {
		this.registerwork = registerwork;
	}
}
