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
		super("����JTable");
		
		
		
		Vector<Vector<Object>> data=new Vector<>();
		Vector<Object> rowVector1=new Vector<>();
		rowVector1.addElement("121");
		rowVector1.addElement("����");
		rowVector1.addElement("����");
		rowVector1.addElement(2334.4);
		rowVector1.addElement(10.3);
		rowVector1.addElement("4313");
		rowVector1.addElement("�ɻ�");
		
		Vector<Object> rowVector2=new Vector<>();
		rowVector2.addElement("124");
		rowVector2.addElement("����");
		rowVector2.addElement("����");
		rowVector2.addElement(2334.4);
		rowVector2.addElement(10.3);
		rowVector2.addElement("4313");
		rowVector2.addElement("�ɻ�");
		
		Vector<Object> rowVector3=new Vector<>();
		rowVector3.addElement("122");
		rowVector3.addElement("����");
		rowVector3.addElement("����");
		rowVector3.addElement(2334.4);
		rowVector3.addElement(10.3);
		rowVector3.addElement("4313");
		rowVector3.addElement("�ɻ�");
		
		data.addElement(rowVector1);
		data.addElement(rowVector2);
		data.addElement(rowVector3);
		
		
		//tablemodel����table������֮��ֻ��Ҫ����model���ܰ����ݵı仯��Ӧ��JTable��
		MachineTableModel machineTableModel=MachineTableModel.assembleModel(data);
		//JTable��table����
		JTable jtable=new JTable(machineTableModel);
		//���ñ�ͷ
		JTableHeader tableHeader=jtable.getTableHeader();
		tableHeader.setFont(new Font(null,Font.BOLD,16));
		//���ñ����
		jtable.setFont(new Font(null,Font.PLAIN,14));
		jtable.setForeground(Color.black);
		jtable.setGridColor(Color.black);
		jtable.setRowHeight(30);
		//���ö���ѡ��
		jtable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		//���ñ���е���Ⱦ��ʽ
		Vector<String> columnStrings=MachineTableModel.getColumns();
		MachineCellRender render=new MachineCellRender();
		for(int i=0;i<columnStrings.size();i++) {
			TableColumn column=jtable.getColumn(columnStrings.get(i));
			column.setCellRenderer(render);
		}
		
		
		Container contentpane=getContentPane();
		//jtable����jpanel�ϵĻ���Ĭ���ǲ�չʾ��ͷ�ģ���Ҫ�������ã�����JScrollPane����
		//Ĭ����չʾ��ͷ
		JScrollPane jscrollpane=new JScrollPane(jtable);
		contentpane.add(jscrollpane);
		
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
}
//�Զ���TableModel
class MachineTableModel extends DefaultTableModel{
	static Vector<String> columns=new Vector<>();
	static {
		columns.addElement("���");
		columns.addElement("����");
		columns.addElement("����");
		columns.addElement("����");
		columns.addElement("�߶�");
		columns.addElement("������");
		columns.addElement("���乤������");
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
	//��ÿһ�е�ÿһ����ʾ֮ǰ�������
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