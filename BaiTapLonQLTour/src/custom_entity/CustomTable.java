package custom_entity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class CustomTable extends JTable{
	private Color backgroundHeaderColor;
	private Color foregroundHeaderColor;
	private Color foregroundColor;
	private Color borderColor;
	private Color stripeBackgroundColor;
	private Color stripeForegroundColor;
	
	
	public void makeCustomTable() {
		JTableHeader header = this.getTableHeader();
	    header.setBackground(backgroundHeaderColor);
	    header.setForeground(foregroundHeaderColor);
	    header.setFont(new Font(null,ABORT,15));
	    this.setForeground(borderColor);
	    this.setBorder(BorderFactory.createLineBorder(borderColor));
	    this.setRowHeight(30);
	    this.setBackground(Color.white);
	    this.setFont(new Font(null,ABORT,10));
	}
	public CustomTable(DefaultTableModel tableModel,Color backgroundHeaderColor,Color foregroundHeaderColor ,Color foregroundColor, Color borderColor,
			Color stripeBackgroundColor, Color stripeForegroundColor) {
		super(tableModel);
		this.backgroundHeaderColor = backgroundHeaderColor;
		this.foregroundColor = foregroundColor;
		this.foregroundHeaderColor = foregroundHeaderColor;
		this.borderColor = borderColor;
		this.stripeBackgroundColor = stripeBackgroundColor;
		this.stripeForegroundColor = stripeForegroundColor;
		makeCustomTable();
	}
	public CustomTable(DefaultTableModel tableModel,Color backgroundHeaderColor,Color foregroundHeaderColor,Color stripeBackgroundColor) {
		// TODO Auto-generated constructor stub
	      // Thêm bảng vào khung JFrame
		super(tableModel);
		this.foregroundHeaderColor = foregroundHeaderColor;
		this.backgroundHeaderColor = backgroundHeaderColor;
		this.foregroundColor = foregroundColor;
		makeCustomTable();
	}
	public CustomTable(DefaultTableModel tableModel,Color backgroundHeaderColor,Color foregroundHeaderColor) {
		// TODO Auto-generated constructor stub
	      // Thêm bảng vào khung JFrame
		super(tableModel);
		this.foregroundHeaderColor = foregroundHeaderColor;
		this.backgroundHeaderColor = backgroundHeaderColor;
		makeCustomTable();
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
		
	}
}
