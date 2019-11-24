package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;


public class ElegirCaso extends JFrame{
	private ResolverMisterioViewModel modelo;
	private JPanel contentPane;		
	private JLabel frase;
	private JLabel descripcion;
	
	public ElegirCaso(String nombre) {
		crearModelo(nombre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 500, 580, 600);
		contentPane = new JPanel();
	    
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(modelo.getCasoSeleccionado().getObjeto());
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelDescr = new JPanel();
		frase = new JLabel(nombre+" tenemos un caso para usted:");
		frase.setBounds(0, 0, 570, 62);
		descripcion = new JLabel(modelo.getCasoSeleccionado().getReporte());
		descripcion.setBounds(0, 124, 570, 62);
		
		panelDescr.setLayout(null);
		panelDescr.add(frase);
		panelDescr.add(descripcion);
		
		contentPane.add(panelDescr);
		
		JPanel panelBotones = new JPanel(new GridBagLayout()){
	        @Override
	        public Dimension getMinimumSize() {
	            return new Dimension(400, 300);
	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(800, 600);
	        }

	        @Override
	        public Dimension getMaximumSize() {
	            return new Dimension(800, 600);
	        }
	    };
	    
	    contentPane.add(panelBotones);
	    
		JButton bElegirOtro = new JButton("Elegir Otro");
		bElegirOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.setCasoSeleccionadoRandom();
				descripcion.setText(modelo.getCasoSeleccionado().getReporte());
				setTitle(modelo.getCasoSeleccionado().getObjeto());
			}
		});
		
		bElegirOtro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(bElegirOtro);
		
		JButton bAceptar = new JButton("Aceptar Caso");
		bAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ResolviendoCaso ventanaResolverCaso=new ResolviendoCaso(modelo);
				ventanaResolverCaso.setVisible(true);
				setVisible(false);
			}
		});
		bAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(bAceptar);
		
		
}


	private void crearModelo(String nombre) {
		modelo = new ResolverMisterioViewModel();
		DataDummy data = new DataDummy();
		modelo.setCasos(data.crearCasos());
		modelo.setCasoSeleccionadoRandom();
		modelo.crearDetective(nombre);
	}
	
}
