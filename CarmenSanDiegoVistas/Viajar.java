package CarmenSanDiegoVistas;

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

import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Pais;
import CarmenSanDiegoControladores.ViajarController;
import CarmenSanDiegoModeloVistas.ElegirCasoViewModel;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class Viajar extends JFrame {

	private JPanel contentPane;
	private Detective detective;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viajar frame = new Viajar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Viajar(Detective detective) {
		this.detective = detective;
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		setTitle("Viajar");
		
		Label pais = new Label("Estan en: "+detective.getPaisActual().getNombre());
		pais.setBounds(50, 0, 300, 50);
		contentPane.add(pais);
		Label destino = new Label("Posibles Destinos");
		destino.setBounds(50, 70, 200, 50);
		destino.setBackground(Color.gray);
		contentPane.add(destino);
		
		JList<Pais> listaDePaises = new JList<Pais>();
		listaDePaises.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaDePaises.setCellRenderer(new PaisCell());
		listaDePaises.setModel(new ViajarController(obtenerConexionesPaisActual()).getPaises());
		contentPane.add(listaDePaises);		
		
		listaDePaises.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Pais pais = listaDePaises.getSelectedValue();
				if (pais != null) {
					String mensaje = "Desea viajar a "+pais.getNombre()+"?";
					int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar viaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(confirmacion == JOptionPane.YES_OPTION) {
						detective.viajar(pais);
						dispose();
					}
				}

			}
		});

	}
	
	public ArrayList<Pais> obtenerConexionesPaisActual() {
		List<Pais> paises;
		
		paises = detective.getPaisActual().getConexiones();
		
		return (ArrayList<Pais>)paises;
	}
}
