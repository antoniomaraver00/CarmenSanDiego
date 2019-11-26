package CarmenSanDiegoVistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.GameOverException;
import CarmenSanDiego.src.GameWonException;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Pais;
import CarmenSanDiegoControladores.ViajarController;
import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;
import CarmenSanDiegoModeloVistas.VisitarLugarViewModel;

import javax.swing.JList;
import javax.swing.JOptionPane;

import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitarLugar extends JFrame{
	private JPanel contentPane;
	private VisitarLugarViewModel modelo;

	public VisitarLugar(Caso caso, Detective detective, Lugar lugar) {
		setBounds(100, 100, 450, 300);
		this.modelo = new VisitarLugarViewModel(caso, detective, lugar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblLugarVisitado= new JLabel("Estas visitando:" +modelo.obtenerNombreLugarSeleccionado());
		contentPane.add(lblLugarVisitado);
		
		ArrayList<String> pistas;
		
		try {
			pistas = modelo.obtenerPistas();
		} catch(GameOverException | GameWonException e) {
			JOptionPane.showMessageDialog(null, e.getMessage().toString());
			
			throw new CerrarVentanaException();
		}
		
		for( String pista : pistas ) {
			JLabel lblPista = new JLabel(pista);
			contentPane.add(lblPista);
		}
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnContinuar);
		setTitle("Resolviendo: "+modelo.obtenerNombreObjetoRobado());
		
		
	}
}
