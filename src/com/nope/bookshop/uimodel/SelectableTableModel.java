package com.nope.bookshop.uimodel;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 * TableModel allowing row selection using checkBoxes
 * 
 * @author zvr
 */
public class SelectableTableModel extends AbstractTableModel {
    
    private Vector<String> columnNames;
    private Vector<Vector> data;

    
    public SelectableTableModel(Vector<Vector> data, Vector<String> columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row).get(col);
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if(getColumnClass(col).equals(Boolean.class)){
            return true;
        }
        return false;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
    }
}
