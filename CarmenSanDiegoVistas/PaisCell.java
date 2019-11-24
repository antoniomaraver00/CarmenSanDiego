package CarmenSanDiegoVistas;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CarmenSanDiego.src.Pais;

public class PaisCell extends JLabel implements ListCellRenderer<Pais> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Pais> list, Pais value, int index, boolean isSelected,
			boolean cellHasFocus) {
		setText(value.getNombre());
		return this;
	}

}
