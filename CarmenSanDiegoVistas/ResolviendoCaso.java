package CarmenSanDiegoVistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

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
	public ResolviendoCaso() {
		setTitle("resolviendo caso"+"'nombre caso'");
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		//panel principal
		contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta donde se encuentra
		Label label = new Label("estan en "+"'pais' ");
		label.setBounds(0, 0, 100, 50);
		contentPane.add(label);
		
		//creo panel lugares
		JPanel panelLugares = new JPanel();
		panelLugares.setBounds(0, 50, 300, 280);
		panelLugares.setLayout(null);
		contentPane.add(panelLugares);
			//etiqueta lugares
		Label lugares= new Label("Lugares");
		lugares.setBounds(0, 0, 300, 30);
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
		contentPane.add(panelAcciones);
		
		//creo panel paises visitados
		JPanel panelRecorridoCriminal = new JPanel();
		panelRecorridoCriminal.setBounds(0,330, 300, 250);
		contentPane.add(panelRecorridoCriminal);
		
		//creo panel paises visitado y no estuvo el criminal
		JPanel panelRecorridoFallido = new JPanel();
		panelRecorridoFallido.setBounds(300,330, 300, 250);
		contentPane.add(panelRecorridoFallido);
	}
}
