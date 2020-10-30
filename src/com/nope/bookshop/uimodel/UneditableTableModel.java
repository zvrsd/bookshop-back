package com.nope.bookshop.uimodel;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zvr
 */
public class UneditableTableModel extends DefaultTableModel{

    public UneditableTableModel(Vector<Vector> data, Vector<String> columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
