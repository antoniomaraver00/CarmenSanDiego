package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Villano;
import CarmenSanDiegoControladores.OrdenControlador;
import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;
import CarmenSanDiegoModeloVistas.OrdenViewModel;
import CarmenSanDiegoModeloVistas.ResolviendoCasoViewModel;

public class OrdenDeArresto extends JFrame {
	OrdenViewModel modelo;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param modelo 
	 */
	public OrdenDeArresto(ArrayList<Villano> sospechosos, Detective detective) {
		this.modelo = new OrdenViewModel(sospechosos, detective);
		
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Label label = new Label("Seleccione villano contra quien emitira la orden");
		label.setBounds(50, 0, 400, 50);
		contentPane.add(label);
		
		OrdenControlador controlador = new OrdenControlador(modelo);
		ArrayList<String> nombreVillanos= controlador.obtenerNombreVillanos();
		
		JComboBox villanos = new JComboBox();
		for(int i=0; i<nombreVillanos.size(); i++) {
			villanos.addItem(nombreVillanos.get(i));
		}
		villanos.setBounds(50,70, 280, 40);
		
		contentPane.add(villanos);
		
		JButton cancelar = new JButton("cancelar");
		cancelar.setBounds(50, 130, 130, 40);
		contentPane.add(cancelar);

		JButton generar = new JButton("generar");
		generar.setBounds(190, 130, 90, 40);
		contentPane.add(generar);
		
		//funcionalidad cancelar
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//funcionalidad generar
		generar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mensaje = "Desea generar la orden a "+nombreVillanos.get(villanos.getSelectedIndex())+"?";
				int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar orden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirmacion == JOptionPane.YES_OPTION) {
					controlador.generarOrden(nombreVillanos.get(villanos.getSelectedIndex()));
					dispose();
				}	
			}
		});
	}
	
	
}
