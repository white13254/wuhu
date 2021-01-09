package MyJFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddInformationFrame {
	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JLabel getL1() {
		return l1;
	}
	public void setL1(JLabel l1) {
		this.l1 = l1;
	}
	public JLabel getL2() {
		return l2;
	}
	public void setL2(JLabel l2) {
		this.l2 = l2;
	}
	public JLabel getL3() {
		return l3;
	}
	public void setL3(JLabel l3) {
		this.l3 = l3;
	}
	public JLabel getL4() {
		return l4;
	}
	public void setL4(JLabel l4) {
		this.l4 = l4;
	}
	public JLabel getL5() {
		return l5;
	}
	public void setL5(JLabel l5) {
		this.l5 = l5;
	}
	public JLabel getL6() {
		return l6;
	}
	public void setL6(JLabel l6) {
		this.l6 = l6;
	}
	public JLabel getL7() {
		return l7;
	}
	public void setL7(JLabel l7) {
		this.l7 = l7;
	}
	public JTextField getT1() {
		return t1;
	}
	public void setT1(JTextField t1) {
		this.t1 = t1;
	}
	public JTextField getT2() {
		return t2;
	}
	public void setT2(JTextField t2) {
		this.t2 = t2;
	}
	public JTextField getT3() {
		return t3;
	}
	public void setT3(JTextField t3) {
		this.t3 = t3;
	}
	public JTextField getT4() {
		return t4;
	}
	public void setT4(JTextField t4) {
		this.t4 = t4;
	}
	public JTextField getT5() {
		return t5;
	}
	public void setT5(JTextField t5) {
		this.t5 = t5;
	}
	public JTextField getT6() {
		return t6;
	}
	public void setT6(JTextField t6) {
		this.t6 = t6;
	}
	public JTextField getT7() {
		return t7;
	}
	public void setT7(JTextField t7) {
		this.t7 = t7;
	}
	public JButton getBtn() {
		return btn;
	}
	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private AddInformationwork addwork;
	
	private JButton btn;
	public AddInformationFrame() {
		frame=new JFrame("添加重型机械信息");
		l1=new JLabel("编号：");
		l2=new JLabel("名称：");
		l3=new JLabel("类型：");
		l4=new JLabel("重量：");
		l5=new JLabel("高度：");
		l6=new JLabel("运输编号：");
		l7=new JLabel("运输工具名称：");
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		btn=new JButton("确认");
		
		addwork=new AddInformationwork(this);
		
		init();
	}
	public void init() {
		frame.setSize(300,320);
		frame.setLocation(400,200);
		frame.setLayout(null);
		//自定义图标
		java.net.URL imgurl=MainFrame.class.getClassLoader().getResource("c054afb6377d76440d91c0c2852c0436.jpg");
		frame.setIconImage(new ImageIcon(imgurl).getImage());
		
		l1.setBounds(50, 20, 100, 20);
		l2.setBounds(50, 50, 100, 20);
		l3.setBounds(50, 80, 100, 20);
		l4.setBounds(50, 110, 100, 20);
		l5.setBounds(50, 140, 100, 20);
		l6.setBounds(50, 170, 100, 20);
		l7.setBounds(50, 200, 100, 20);
		
		t1.setBounds(130, 20, 100, 20);
		t2.setBounds(130, 50, 100, 20);
		t3.setBounds(130, 80, 100, 20);
		t4.setBounds(130, 110, 100, 20);
		t5.setBounds(130, 140, 100, 20);
		t6.setBounds(130, 170, 100, 20);
		t7.setBounds(130, 200, 100, 20);
//		password.setBounds(50, 60, 100, 20);
//		txtuser.setBounds(130, 20, 100, 20);
//		txtpassword.setBounds(130, 60, 100, 20);
//		register.setBounds(10,130,100,20);
//		forgetpassword.setBounds(260,130,100,20);
		btn.setBounds(90, 230, 120, 30);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
		frame.add(t1);
		frame.add(t2);
		frame.add(t3);
		frame.add(t4);
		frame.add(t5);
		frame.add(t6);
		frame.add(t7);
		frame.add(btn);
		
		btn.addActionListener(addwork);
		//btn.addKeyListener(addwork);
		
		//设置确认为默认按钮
		frame.getRootPane().setDefaultButton(btn);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
