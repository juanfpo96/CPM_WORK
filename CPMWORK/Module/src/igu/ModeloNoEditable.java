package igu;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ModeloNoEditable extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public ModeloNoEditable(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

}
