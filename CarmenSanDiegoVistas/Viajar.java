package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import CarmenSanDiego.src.Pais;
import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;
import javax.swing.JList;

public class Viajar extends JFrame {

	private JPanel contentPane;
	private ResolverMisterioViewModel modelo;

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
	public Viajar(ResolverMisterioViewModel modelo) {
		this.modelo = modelo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Viajar");
		
		Label pais = new Label("Estan en: "+modelo.getDetective().getPaisActual().getNombre());
		pais.setBounds(50, 0, 300, 50);
		contentPane.add(pais);
		Label destino = new Label("Posibles Destinos");
		destino.setBounds(50, 70, 200, 50);
		destino.setBackground(Color.gray);
		contentPane.add(destino);
		
	}

}
