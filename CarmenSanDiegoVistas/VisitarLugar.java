package CarmenSanDiegoVistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Label;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CarmenSanDiego.src.Pais;
import CarmenSanDiegoControladores.ViajarController;
import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;

import javax.swing.JList;

import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitarLugar extends JFrame{
	private JPanel contentPane;
	private ResolverMisterioViewModel modelo;
	private LugarViewModel modeloLugar;

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
	public VisitarLugar(ResolverMisterioViewModel modelo) {
		setBounds(100, 100, 450, 300);
		this.modelo = modelo;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblLugarVisitado= new JLabel("Estas visitando:" +modeloLugar.getLugarSeleccionado().getNombre());
		contentPane.add(lblLugarVisitado);
		
		JLabel lblPista = new JLabel("Aca van las variantes de las pistas");
		contentPane.add(lblPista);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnContinuar);
		setTitle("Resolviendo: "+modelo.getCasoSeleccionado().getObjeto());
		
		
	}
}
