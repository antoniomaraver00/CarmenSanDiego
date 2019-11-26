package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Villano;
import CarmenSanDiegoControladores.OrdenControlador;
import CarmenSanDiegoModeloVistas.OrdenViewModel;

public class OrdenDeArresto extends JFrame {
	OrdenViewModel modelo;
	private JPanel contentPane;

	public OrdenDeArresto(ArrayList<Villano> sospechosos, Detective detective) {
		this.modelo = new OrdenViewModel(sospechosos, detective);
		
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Seleccione villano contra quien emitira la orden");
		label.setBounds(50, 0, 400, 50);
		contentPane.add(label);
		
		JComboBox villanos = new JComboBox<Villano>();
		villanos.setModel(new DefaultComboBoxModel<Villano>(new Vector<Villano>(modelo.obtenerSospechosos())));
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
				
		
				String mensaje = "Desea generar la orden a "+villanos.getSelectedItem().toString()+"?";
				int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar orden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirmacion == JOptionPane.YES_OPTION) {
					modelo.obtenerDetective().generarOrden((Villano)villanos.getSelectedItem());
					dispose();
				}	
			}
		});
	}
}
