package CarmenSanDiegoVistas;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CarmenSanDiego.src.Lugar;

public class LugarCell extends JButton implements ListCellRenderer<Lugar> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4642610935328204802L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Lugar> list, Lugar value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setText(value.getNombre());
		return this;
	}

}
