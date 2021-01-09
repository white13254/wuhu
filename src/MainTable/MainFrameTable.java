package MainTable;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class MainFrameTable extends JTable{
	public MainFrameTable() {
		JTableHeader tableHeader=getTableHeader();
		tableHeader.setFont(new Font(null,Font.BOLD,16));
		//设置表格体
		setFont(new Font(null,Font.PLAIN,14));
		setForeground(Color.black);
		setGridColor(Color.black);
		setRowHeight(30);
		//设置多行选择
		getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	
	public void renderRule() {
		//设置表格列的渲染方式
				Vector<String> columnStrings=MainFrameTableModel.getColumns();
				MainFrameCellRender render=new MainFrameCellRender();
				for(int i=0;i<columnStrings.size();i++) {
					TableColumn column=getColumn(columnStrings.get(i));
					column.setCellRenderer(render);
				}
	}
}
