package CarmenSanDiegoVistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

import CarmenSanDiego.src.Caso;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
	private Caso caso;
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
	public ResolviendoCaso(Caso caso) {
		this.caso = caso;
		setTitle("Resolviendo robo: "+caso.getObjeto());
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		//panel principal
		contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta donde se encuentra
		Label label = new Label("Estan en "+"'pais' ");
		label.setBounds(50, 0, 100, 50);
		contentPane.add(label);
		
		//creo panel lugares
		JPanel panelLugares = new JPanel();
		panelLugares.setBounds(0, 50, 300, 280);
		panelLugares.setLayout(null);
		contentPane.add(panelLugares);
			//etiqueta lugares
		Label lugares= new Label("Lugares");
		lugares.setBounds(50, 0, 250, 30);
		panelLugares.add(lugares);
			//botones lugares
		JButton biblioteca = new JButton("Biblioteca");
		biblioteca.setBounds(50, 30, 200, 50);
		JButton club = new JButton("Club");
		club.setBounds(50, 90, 200, 50);
		JButton embajada = new JButton("Embajada");
		embajada.setBounds(50, 150, 200, 50);
		JButton banco = new JButton("Banco");
		banco.setBounds(50, 210, 200, 50);
		panelLugares.add(biblioteca);
		panelLugares.add(banco);
		panelLugares.add(embajada);
		panelLugares.add(club);
		
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
		Label ordenEmitida = new Label("Orden emitida: no emitida");
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
		Label recorridoFallido = new Label("Desino fallido");
		recorridoFallido.setBounds(25, 0, 250, 30);
		recorridoFallido.setBackground(Color.gray);
		recorridoFallido.setAlignment(Label.CENTER);
		panelRecorridoFallido.add(recorridoFallido);
		Label label2 = new Label("agregar paises");
		label2.setBounds(25, 40, 200, 30);
		panelRecorridoFallido.add(label2);
	}
}
