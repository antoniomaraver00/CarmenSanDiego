package CarmenSanDiegoVistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

import CarmenSanDiego.src.Caso;
import CarmenSanDiego.src.Detective;
import CarmenSanDiego.src.Lugar;
import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;
import CarmenSanDiegoVistas.VentanaSeCierraListener;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ResolviendoCaso extends JFrame{
	private JPanel contentPane;
	private ResolverMisterioViewModel modelo;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResolviendoCaso frame = new ResolviendoCaso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	public ResolviendoCaso(ResolverMisterioViewModel modelo) {
		this.modelo = modelo;
		setTitle("Resolviendo robo: "+modelo.getCasoSeleccionado().getObjeto());
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		//panel principal
		contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta donde se encuentra
		Label label = new Label("Estan en "+modelo.getDetective().getPaisActual().getNombre());
		label.setBounds(50, 0, 400, 50);
		contentPane.add(label);
		
		//creo panel lugares
		JPanel panelLugares = new JPanel();
		panelLugares.setBounds(0, 50, 300, 280);
		panelLugares.setLayout(null);
		contentPane.add(panelLugares);
		
		//etiqueta lugares
		Label labelLugares= new Label("Lugares");
		labelLugares.setBounds(50, 0, 200, 20);
		panelLugares.add(labelLugares);

		ArrayList<Lugar> lugares = this.modelo.obtenerLugaresDelPaisActual();
		for( int i = 0; i < lugares.size(); i++ ) {
			JButton bLugar = new JButton(lugares.get(i).getNombre());
			bLugar.setBounds(50, 30+(60*i), 200, 50);
			panelLugares.add(bLugar);
		}
		
		//creo panel acciones
		JPanel panelAcciones = new JPanel();
		panelAcciones.setBounds(300, 50, 300, 280);
		panelAcciones.setLayout(null);
		contentPane.add(panelAcciones);
		
		Label acciones = new Label("Acciones");
		acciones.setBounds(50, 0,250, 30);
		panelAcciones.add(acciones);
		
		JButton orden = new JButton("Orden de arresto");
		orden.setBounds(50, 50, 200, 50);
		panelAcciones.add(orden);
		
		Label ordenEmitida = new Label("Orden emitida: "+modelo.obtenerNombreVillanoEnOrden());
		ordenEmitida.setBounds(50, 100, 250, 30);
		panelAcciones.add(ordenEmitida);
		
		JButton viajar = new JButton("Viajar");
		viajar.setBounds(50, 140, 200, 50);
		panelAcciones.add(viajar);
		
		JButton expedientes = new JButton("Expedientes");
		expedientes.setBounds(50,210, 200, 50);
		panelAcciones.add(expedientes);
		
		//creo panel paises visitados
		JPanel panelRecorridoCriminal = new JPanel();
		panelRecorridoCriminal.setBounds(0,330, 300, 250);
		panelRecorridoCriminal.setLayout(null);
		contentPane.add(panelRecorridoCriminal);
		
		Label recorrido = new Label("Recorrido por el criminal");
		recorrido.setBounds(25, 0, 250, 30);
		recorrido.setBackground(Color.gray);
		recorrido.setAlignment(Label.CENTER);
		panelRecorridoCriminal.add(recorrido);
		
		Label label1 = new Label("agregar paises");
		label1.setBounds(25, 40, 200, 30);
		panelRecorridoCriminal.add(label1);
		
		//creo panel paises visitado y no estuvo el criminal
		JPanel panelRecorridoFallido = new JPanel();
		panelRecorridoFallido.setBounds(300,330, 300, 250);
		panelRecorridoFallido.setLayout(null);
		contentPane.add(panelRecorridoFallido);
		Label recorridoFallido = new Label("Destino fallido");
		recorridoFallido.setBounds(25, 0, 250, 30);
		recorridoFallido.setBackground(Color.gray);
		recorridoFallido.setAlignment(Label.CENTER);
		panelRecorridoFallido.add(recorridoFallido);
		Label label2 = new Label("agregar paises");
		label2.setBounds(25, 40, 200, 30);
		panelRecorridoFallido.add(label2);
		
		//funcionalidad a boton Expediente
		expedientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Expedientes ventanaExpediente = new Expedientes(); 
				//ventanaExpediente.setVisible(true);
			}
		});
		
		//Funcionlidad a viajar
		viajar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Viajar ventanaViajar = new Viajar(modelo);
				ventanaViajar.setVisible(true);
				
			}
		});
		
		
		
		//Funcionalidad a orden de arresto
		orden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modelo.getDetective().getSospechosoEnOrden()==null) {
					OrdenDeArresto ventanaOrden = new OrdenDeArresto(modelo);
					ventanaOrden.setVisible(true);
					ventanaOrden.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							ordenEmitida.setText("Orden emitida: "+modelo.obtenerNombreVillanoEnOrden());
						}
					});
				}else {
					JOptionPane.showMessageDialog(contentPane, "Ya genero orden,no se puede cambiar");
				}
			}
		});
	}
}
