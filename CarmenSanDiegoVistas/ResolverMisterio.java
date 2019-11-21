package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CarmenSanDiego.src.DataDummy;
import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


public class ResolverMisterio extends JFrame{
	private ResolverMisterioViewModel modelo;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResolverMisterio frame = new ResolverMisterio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
		
	
	public ResolverMisterio() {
		crearModelo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 500, 580, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton bElegirOtro = new JButton("Elegir Otro");
		bElegirOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bElegirOtro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bElegirOtro.setBounds(100, 400, 130, 38);
		contentPane.add(bElegirOtro);
		
		JButton bAceptar = new JButton("Aceptar Caso");
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bAceptar.setBounds(350, 400, 130,38);
		contentPane.add(bAceptar);
		
}


	private void crearModelo() {
		modelo = new ResolverMisterioViewModel();
		
		DataDummy data = new DataDummy();
		
		modelo.setCasos(data.crearCasos());
		modelo.setCasoSeleccionado(modelo.getCasos().get(0));
	}
	
}
