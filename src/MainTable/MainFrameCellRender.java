package MainTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class MainFrameCellRender extends DefaultTableCellRenderer{
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