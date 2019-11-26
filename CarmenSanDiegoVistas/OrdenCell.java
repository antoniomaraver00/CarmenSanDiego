package CarmenSanDiegoVistas;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CarmenSanDiego.src.Villano;

public class OrdenCell extends	JButton implements ListCellRenderer<Villano> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Villano> list, Villano value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setText(value.getNombre());
		return this;
	}

}
