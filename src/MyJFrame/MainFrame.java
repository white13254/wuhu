package MyJFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Pagetool.TableConnection;
import tool.DimensionUtil;
import tool.FitTablecolumn;

public class MainFrame {
	private JFrame frame;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnSearch;
	private JButton btnUpdate;
	private JTextField txt;
	private JButton btnpre;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JTable table;
	private Mainwork mainwork;
	
	public MainFrame(String sql) {
		frame=new JFrame("管理");
		btnAdd=new JButton("增加");
		btnDel=new JButton("删除");
		btnSearch=new JButton("查找");
		btnUpdate=new JButton("修改");
		btnpre=new JButton("刷新页面");
		
		
		//表格连接数据库
		TableConnection da=new TableConnection(sql);
		//table=new MainFrameTable();
		table=new JTable(da.data,da.name);
		
		txt=new JTextField(15);
		northPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		southPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		centerPanel=new JPanel();
		
		mainwork=new Mainwork(this,table);
		
		//table=new ShowTable(table);
		init();
		
	}
	public void init() {
		//设置窗口完全填满屏幕
		frame.setBounds(DimensionUtil.getBounds());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		//自定义图标
		java.net.URL imgurl=MainFrame.class.getClassLoader().getResource("llchvq1ugsy.jpg");
		frame.setIconImage(new ImageIcon(imgurl).getImage());
		
		
		northPanel.add(btnAdd);
		northPanel.add(btnDel);
		northPanel.add(btnSearch);
		northPanel.add(btnUpdate);
		northPanel.add(txt);
		//layoutCenter(centerPanel);

		new FitTablecolumn().FitTable(table);
		centerPanel.add(new JScrollPane(table));
		
		
		southPanel.add(btnpre);
		
		btnAdd.addActionListener(mainwork);
		btnDel.addActionListener(mainwork);
		btnSearch.addActionListener(mainwork);
		btnUpdate.addActionListener(mainwork);
		btnpre.addActionListener(mainwork);
		
		frame.add(southPanel,BorderLayout.SOUTH);
		frame.add(centerPanel,BorderLayout.CENTER);
		frame.add(northPanel,BorderLayout.NORTH);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*public void layoutCenter(Container contentPane) {
		Vector<Vector<Object>> data=new Vector<>();
		Vector<Object> rowVector1=new Vector<>();
		rowVector1.addElement("121");
		rowVector1.addElement("汽车");
		rowVector1.addElement("铁矿");
		rowVector1.addElement(2334.4);
		rowVector1.addElement(10.3);
		rowVector1.addElement("4313");
		rowVector1.addElement("飞机");
		
		Vector<Object> rowVector2=new Vector<>();
		rowVector2.addElement("124");
		rowVector2.addElement("汽车");
		rowVector2.addElement("铁矿");
		rowVector2.addElement(2334.4);
		rowVector2.addElement(10.3);
		rowVector2.addElement("4313");
		rowVector2.addElement("飞机");
		
		Vector<Object> rowVector3=new Vector<>();
		rowVector3.addElement("122");
		rowVector3.addElement("汽车");
		rowVector3.addElement("铁矿");
		rowVector3.addElement(2334.4);
		rowVector3.addElement(10.3);
		rowVector3.addElement("4313");
		rowVector3.addElement("飞机");
		
		data.addElement(rowVector1);
		data.addElement(rowVector2);
		data.addElement(rowVector3);
		
		MainFrameTableModel mainFrameTableModel=MainFrameTableModel.assembleModel(data);
		table.setModel(mainFrameTableModel); 
		table.renderRule();
		JScrollPane jScrollPane=new JScrollPane(table);
		contentPane.add(jScrollPane,BorderLayout.CENTER);
	}*/
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JButton getBtnDel() {
		return btnDel;
	}
	public void setBtnDel(JButton btnDel) {
		this.btnDel = btnDel;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}
	public JTextField getTxt() {
		return txt;
	}
	public void setTxt(JTextField txt) {
		this.txt = txt;
	}
	public JButton getBtnpre() {
		return btnpre;
	}
	public void setBtnpre(JButton btnpre) {
		this.btnpre = btnpre;
	}
}