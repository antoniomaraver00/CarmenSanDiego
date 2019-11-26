package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoModeloVistas.ExpedientesViewModel;
import javafx.scene.control.SplitPane;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Expedientes extends JFrame {

	private JPanel contentPane;
	private ExpedientesViewModel modelo;

	public Expedientes(ArrayList<Villano> villanos) {
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
		leftPane.setPreferredSize(new Dimension(200, 300));
		
		JLabel lblVillanos = new JLabel("Villano");
		lblVillanos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillanos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblVillanos.setBounds(10, 11, 173, 31);
		leftPane.add(lblVillanos);
		
		JScrollPane scrollPaneVillanos = new JScrollPane();
		leftPane.add(scrollPaneVillanos);
		
		contentPane.add(leftPane, BorderLayout.WEST);
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		centerPane.setPreferredSize(new Dimension(200, 300)); 
		
		try {
			URL url = new URL("https://via.placeholder.com/190x197");
		    BufferedImage image = ImageIO.read(url);
		    JLabel imgLabel = new JLabel(new ImageIcon(image));
		    centerPane.add(imgLabel);
		} catch( IOException e ) {
			JLabel errorLabel = new JLabel("Error: Imagen no encontrada...");
			centerPane.add(errorLabel);
		}
	    
		JLabel lblNombre = new JLabel("Nombre: asd");
		centerPane.add(lblNombre);
		
		JLabel lblSexo = new JLabel("Sexo: asd");
		centerPane.add(lblSexo);
		
		contentPane.add(centerPane, BorderLayout.CENTER);
		
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
		rightPane.setPreferredSize(new Dimension(200, 300)); 
		
		JLabel lblSeniasParticulares=new JLabel("Senias particulares");		
		rightPane.add(lblSeniasParticulares);
		
		JScrollPane scrollPaneSenias = new JScrollPane();
		scrollPaneSenias.setBounds(220, 53, 183, 140);
		rightPane.add(scrollPaneSenias);
		
		JLabel lblHobbies=new JLabel("Hobbies");
		rightPane.add(lblHobbies);
		
		JScrollPane scrollPaneHobbies = new JScrollPane();
		scrollPaneHobbies.setBounds(220, 225, 183, 100);
		rightPane.add(scrollPaneHobbies);
		
		JButton bAtras = new JButton("Atras.");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		rightPane.add(bAtras);
		
		contentPane.add(rightPane, BorderLayout.EAST);
	}
}