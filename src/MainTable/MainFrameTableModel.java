package MainTable;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MainFrameTableModel extends DefaultTableModel{
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
	private MainFrameTableModel() {
		super(null,columns);
	}
	private static MainFrameTableModel mainFrameTableModel=new MainFrameTableModel();
	public static MainFrameTableModel assembleModel(Vector<Vector<Object>> data) {
		mainFrameTableModel.setDataVector(data, columns);
		return mainFrameTableModel;
	}
	public static Vector<String> getColumns(){
		return columns;
	}
	public boolean isCellEditable(int row,int column) {
		return false;
	}
}

