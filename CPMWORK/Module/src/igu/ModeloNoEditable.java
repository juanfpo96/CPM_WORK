package igu;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ModeloNoEditable extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	public ModeloNoEditable() {
		// TODO Auto-generated constructor stub
	}

	public ModeloNoEditable(int rowCount, int columnCount) {
		super(rowCount, columnCount);
		// TODO Auto-generated constructor stub
	}

	public ModeloNoEditable(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public ModeloNoEditable(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public ModeloNoEditable(Vector data, Vector columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public ModeloNoEditable(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

}
