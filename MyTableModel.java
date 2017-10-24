package src;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{

	public DefaultTableCellRenderer render = new DefaultTableCellRenderer();

	public boolean isCellEditable(int row, int column){  
	    return false;  
	 }  

    List<Color> rowColours = Arrays.asList(
        Color.RED,
        Color.GREEN,
        Color.CYAN
    );

    public void setRowColour(int row, Color c) {
    	render.setBackground(c);
        fireTableRowsUpdated(row, row);
    }

    public Color getRowColour(int row) {
        return rowColours.get(row);
    }
}