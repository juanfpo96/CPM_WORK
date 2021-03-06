package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Catalog;
import logic.Cruise;
import logic.Extra;
import logic.Pedido;
import logic.Person;
import logic.Room;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Component;

public class VentanaAddRoom extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private VentanaInicio vI;
	private Cruise crucero;
	private Room room;
	private final ButtonGroup btnGroupLocal = new ButtonGroup();
	private final ButtonGroup btnGroupType = new ButtonGroup();
	private JComboBox cbExtras;
	private JScrollPane spExtras;
	private JPanel pnExtras;
	private JList listaExtras;
	private DefaultListModel modeloLista;
	private JButton btnAddExtra;
	private JPanel pnRoom;
	private JLabel lblTypeOfRoom;
	private JLabel lblLocation;
	private JRadioButton rdbtnDouble;
	private JRadioButton rdbtnFamily;
	private JRadioButton rdbtnInside;
	private JRadioButton rdbtnOutside;
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel pnPeople;
	private JScrollPane spPeople;
	private JList listaPeople;
	private JTextField txAge;
	private JButton btnAdd_1;
	private JLabel lblAge;
	private JButton btnRemove;
	private JButton btnRemoveExtra;
	private DefaultListModel modeloPeople;

	/**
	 * Create the dialog.
	 */
	public VentanaAddRoom(VentanaInicio vI, Cruise crucero) {
		this.vI = vI;
		this.crucero = crucero;
		room = new Room();
		setResizable(false);
		setTitle("Add Room");
		setBounds(100, 100, 489, 326);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPnExtras());
		contentPanel.add(getPnRoom());
		contentPanel.add(getBtnAdd());
		contentPanel.add(getBtnCancel());
		contentPanel.add(getPnPeople());

	}

	private JComboBox getCbExtras() {
		if (cbExtras == null) {
			cbExtras = new JComboBox();
			cbExtras.setBounds(10, 29, 115, 20);
			cbExtras.setModel(new DefaultComboBoxModel(vI.getCatalogo().getExtras()));
		}
		return cbExtras;
	}

	private JScrollPane getSpExtras() {
		if (spExtras == null) {
			spExtras = new JScrollPane();
			spExtras.setBounds(152, 11, 115, 117);
			spExtras.setViewportView(getListaExtras());
		}
		return spExtras;
	}

	private JList getListaExtras() {
		if (listaExtras == null) {
			modeloLista = new DefaultListModel<>();
			listaExtras = new JList(modeloLista);
		}
		return listaExtras;
	}

	private JPanel getPnExtras() {
		if (pnExtras == null) {
			pnExtras = new JPanel();
			pnExtras.setBorder(new TitledBorder(null, "Extras: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnExtras.setBounds(28, 110, 277, 137);
			pnExtras.setLayout(null);
			pnExtras.add(getCbExtras());
			pnExtras.add(getSpExtras());
			pnExtras.add(getBtnAddExtra());
			pnExtras.add(getBtnRemoveExtra());
		}
		return pnExtras;
	}

	private JButton getBtnAddExtra() {
		if (btnAddExtra == null) {
			btnAddExtra = new JButton("Add Extra");
			btnAddExtra.setToolTipText("Add the extra above");
			btnAddExtra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Extra extra = (Extra) cbExtras.getSelectedItem();
					if (!modeloLista.contains(extra)) {
						room.addExtra(extra);
						modeloLista.addElement(extra);
					}
				}
			});
			btnAddExtra.setBounds(10, 79, 115, 23);
		}
		return btnAddExtra;
	}

	private JPanel getPnRoom() {
		if (pnRoom == null) {
			pnRoom = new JPanel();
			pnRoom.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Room: ",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRoom.setBounds(20, 11, 285, 88);
			pnRoom.setLayout(null);
			pnRoom.add(getLblTypeOfRoom());
			pnRoom.add(getRdbtnDouble());
			pnRoom.add(getRdbtnFamily());
			pnRoom.add(getLblLocation());
			pnRoom.add(getRdbtnInside());
			pnRoom.add(getRdbtnOutside());
		}
		return pnRoom;
	}

	private JLabel getLblTypeOfRoom() {
		if (lblTypeOfRoom == null) {
			lblTypeOfRoom = new JLabel("Type of Room:");
			lblTypeOfRoom.setBounds(16, 20, 71, 14);
		}
		return lblTypeOfRoom;
	}

	private JLabel getLblLocation() {
		if (lblLocation == null) {
			lblLocation = new JLabel("Location:");
			lblLocation.setBounds(16, 45, 44, 14);
		}
		return lblLocation;
	}

	private JRadioButton getRdbtnDouble() {
		if (rdbtnDouble == null) {
			rdbtnDouble = new JRadioButton("Double");
			rdbtnDouble.setToolTipText("2 People Room");
			rdbtnDouble.setSelected(true);
			btnGroupType.add(rdbtnDouble);
			rdbtnDouble.setBounds(93, 16, 87, 23);
		}
		return rdbtnDouble;
	}

	private JRadioButton getRdbtnFamily() {
		if (rdbtnFamily == null) {
			rdbtnFamily = new JRadioButton("Family");
			rdbtnFamily.setToolTipText("4 People Room");
			btnGroupType.add(rdbtnFamily);
			rdbtnFamily.setBounds(182, 16, 76, 23);
		}
		return rdbtnFamily;
	}

	private JRadioButton getRdbtnInside() {
		if (rdbtnInside == null) {
			rdbtnInside = new JRadioButton("Inside");
			rdbtnInside.setToolTipText("Inside Room");
			rdbtnInside.setSelected(true);
			btnGroupLocal.add(rdbtnInside);
			rdbtnInside.setBounds(93, 42, 87, 23);
		}
		return rdbtnInside;
	}

	private JRadioButton getRdbtnOutside() {
		if (rdbtnOutside == null) {
			rdbtnOutside = new JRadioButton("Outside");
			rdbtnOutside.setToolTipText("Outside Room");
			btnGroupLocal.add(rdbtnOutside);
			rdbtnOutside.setBounds(182, 42, 76, 23);
		}
		return rdbtnOutside;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setToolTipText("Add the room to the cruise");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (modeloPeople.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There is no people in the room");
					} else {

						boolean roomDouble = getRdbtnDouble().isSelected();
						boolean roomInside = getRdbtnInside().isSelected();
						if (roomDouble) {
							if (roomInside) {
								room.setCam(1);
							} else {
								room.setCam(2);
							}
						} else {
							if (roomInside) {
								room.setCam(3);
							} else {
								room.setCam(4);
							}
						}
						vI.loadRoom(room);
					}
				}
			});
			btnAdd.setBounds(305, 263, 70, 23);
		}
		return btnAdd;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setToolTipText("Cancel room add");
			VentanaAddRoom ventanaAddRoom=this;
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventanaAddRoom.dispose();
				}
			});
			btnCancel.setBounds(385, 263, 75, 23);
		}
		return btnCancel;
	}

	private JPanel getPnPeople() {
		if (pnPeople == null) {
			pnPeople = new JPanel();
			pnPeople.setBorder(new TitledBorder(null, "People", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPeople.setBounds(315, 11, 145, 236);
			pnPeople.setLayout(null);
			pnPeople.add(getSpPeople());
			pnPeople.add(getTxAge());
			pnPeople.add(getBtnAdd_1());
			pnPeople.add(getLblAge());
			pnPeople.add(getBtnRemove());
		}
		return pnPeople;
	}

	private JScrollPane getSpPeople() {
		if (spPeople == null) {
			spPeople = new JScrollPane();
			spPeople.setBounds(10, 72, 125, 122);
			spPeople.setViewportView(getListaPeople());
		}
		return spPeople;
	}

	private JList getListaPeople() {
		if (listaPeople == null) {
			modeloPeople = new DefaultListModel<>();
			listaPeople = new JList(modeloPeople);
		}
		return listaPeople;
	}

	private JTextField getTxAge() {
		if (txAge == null) {
			txAge = new JTextField();
			txAge.setBounds(10, 42, 45, 23);
			txAge.setColumns(10);
		}
		return txAge;
	}

	private JButton getBtnAdd_1() {
		if (btnAdd_1 == null) {
			btnAdd_1 = new JButton("Add");
			btnAdd_1.setToolTipText("Add new person");
			btnAdd_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!crucero.isAptoMenores() && (Integer.parseInt(txAge.getText()) < 16)) {
						JOptionPane.showMessageDialog(null, "People under 16 are not allowed in this cruise");
					} else {
						Person person = new Person(Integer.parseInt(txAge.getText()));
						room.addPeople(person);
						modeloPeople.addElement(person);
					}

				}
			});
			btnAdd_1.setBounds(76, 42, 59, 23);
		}
		return btnAdd_1;
	}

	private JLabel getLblAge() {
		if (lblAge == null) {
			lblAge = new JLabel("Age");
			lblAge.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblAge.setBounds(10, 26, 45, 14);
		}
		return lblAge;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.setToolTipText("Remove selected person from room");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Person person = (Person) listaPeople.getSelectedValue();
					modeloPeople.removeElement(person);
					room.removePeople(person);
				}
			});
			btnRemove.setBounds(29, 205, 89, 20);
		}
		return btnRemove;
	}

	private JButton getBtnRemoveExtra() {
		if (btnRemoveExtra == null) {
			btnRemoveExtra = new JButton("Remove Extra");
			btnRemoveExtra.setToolTipText("Remove the Extra from the list");
			btnRemoveExtra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Extra extra = (Extra) listaExtras.getSelectedValue();
					room.removeExtra(extra);
					modeloLista.removeElement(extra);
				}
			});
			btnRemoveExtra.setBounds(10, 105, 115, 23);
		}
		return btnRemoveExtra;
	}
}
