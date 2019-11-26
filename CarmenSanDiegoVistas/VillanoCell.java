package CarmenSanDiegoVistas;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CarmenSanDiego.src.Villano;

public class VillanoCell extends JLabel implements ListCellRenderer<Villano> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Villano> arg0, Villano arg1, int arg2, boolean arg3,
			boolean arg4){
		setText(arg1.getNombre());
		return this;
	}

}
