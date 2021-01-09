package tool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class JTableDemo extends JFrame{
	public JTableDemo() {
		super("测试JTable");
		
		
		
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
		
		
		//tablemodel：和table关联后，之后只需要更新model就能把数据的变化反应到JTable中
		MachineTableModel machineTableModel=MachineTableModel.assembleModel(data);
		//JTable和table关联
		JTable jtable=new JTable(machineTableModel);
		//设置表头
		JTableHeader tableHeader=jtable.getTableHeader();
		tableHeader.setFont(new Font(null,Font.BOLD,16));
		//设置表格体
		jtable.setFont(new Font(null,Font.PLAIN,14));
		jtable.setForeground(Color.black);
		jtable.setGridColor(Color.black);
		jtable.setRowHeight(30);
		//设置多行选择
		jtable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		//设置表格列的渲染方式
		Vector<String> columnStrings=MachineTableModel.getColumns();
		MachineCellRender render=new MachineCellRender();
		for(int i=0;i<columnStrings.size();i++) {
			TableColumn column=jtable.getColumn(columnStrings.get(i));
			column.setCellRenderer(render);
		}
		
		
		Container contentpane=getContentPane();
		//jtable放在jpanel上的话，默认是不展示列头的，需要特殊设置，放在JScrollPane上面
		//默认是展示列头
		JScrollPane jscrollpane=new JScrollPane(jtable);
		contentpane.add(jscrollpane);
		
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
}
//自定义TableModel
class MachineTableModel extends DefaultTableModel{
	static Vector<String> columns=new Vector<>();
	static {
		columns.addElement("编号");
		columns.addElement("名称");
		columns.addElement("类型");
		columns.addElement("重量");
		columns.addElement("高度");
		columns.addElement("运输编号");
		columns.addElement("运输工具名称");
	}
	private MachineTableModel() {
		super(null,columns);
	}
	private static MachineTableModel machineTableModel=new MachineTableModel();
	public static MachineTableModel assembleModel(Vector<Vector<Object>> data) {
		machineTableModel.setDataVector(data, columns);
		return machineTableModel;
	}
	public static Vector<String> getColumns(){
		return columns;
	}
	public boolean isCellEditable(int row,int column) {
		return false;
	}
}
class MachineCellRender extends DefaultTableCellRenderer{
	//在每一行的每一列显示之前都会调用
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
		if(row%2==0) {
			setBackground(Color.LIGHT_GRAY);
		}else {
			setBackground(Color.white);
		}
		setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
	}
}