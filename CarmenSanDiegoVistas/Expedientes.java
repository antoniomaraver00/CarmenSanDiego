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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoControladores.ExpedientesController;
import CarmenSanDiegoModeloVistas.ExpedientesViewModel;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Expedientes extends JFrame {

	private JPanel contentPane;
	private ExpedientesViewModel modelo;
	JLabel lblNombre ;
	JLabel lblSexo ;
	JPanel panelSenias;
	JPanel panelHobbies;
	JLabel imgLabel;
	JPanel centerPane;
	
	public Expedientes(ArrayList<Villano> villanos) {
		modelo = new ExpedientesViewModel(villanos);
		
		setBounds(100, 100, 700, 500);
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
		
		JPanel paneVillanos = new JPanel();
		leftPane.add(paneVillanos);
		JList<Villano> listaSospechosos = new JList<Villano>();
		listaSospechosos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaSospechosos.setCellRenderer(new VillanoCell());
		listaSospechosos.setModel(new ExpedientesController(modelo).getVillanos());
		paneVillanos.add(listaSospechosos);
		contentPane.add(leftPane, BorderLayout.WEST);
		
		centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		centerPane.setPreferredSize(new Dimension(200, 300)); 
		
		ImageIcon originalImage = new ImageIcon("CarmenSanDiegoImagenes/none.jpg");
		Image resizedImage = originalImage.getImage().getScaledInstance(190, 197, Image.SCALE_DEFAULT);
	    imgLabel = new JLabel(new ImageIcon(resizedImage));
	    centerPane.add(imgLabel);
	    
		lblNombre = new JLabel("Nombre: ");
		centerPane.add(lblNombre);
		
		lblSexo = new JLabel("Sexo:");
		centerPane.add(lblSexo);
		
		contentPane.add(centerPane, BorderLayout.CENTER);
		
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
		rightPane.setPreferredSize(new Dimension(200, 300)); 
		
		
		panelSenias = new JPanel();
		panelSenias.setBounds(220, 53, 300, 300);
		panelSenias.setLayout(new  BoxLayout(panelSenias, BoxLayout.Y_AXIS));
		panelSenias.setBorder(new EmptyBorder(0,0,50,0));
		rightPane.add(panelSenias);

		panelSenias.add(new JLabel("Senias particulares"));
		
		panelHobbies = new JPanel();
		panelHobbies.setBounds(220, 225, 183, 100);
		panelHobbies.setLayout(new  BoxLayout(panelHobbies, BoxLayout.Y_AXIS));
		rightPane.add(panelHobbies);
		panelHobbies.add(new JLabel("Hobbies"));
		
		
		JButton bAtras = new JButton("Atras.");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		rightPane.add(bAtras);
		
		contentPane.add(rightPane, BorderLayout.EAST);
		
		//funcionalidad listasospechosos
		listaSospechosos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Villano villano = listaSospechosos.getSelectedValue();
				if(villano!=null && e.getValueIsAdjusting()==false) {
					modelo.setVillanoSeleccionado(villano);
					actualizaVista();
				}
			}
	
		});

		modelo.setVillanoSeleccionado(modelo.obtenerPrimerVillanoSeleccionado());
		actualizaVista();
	}
	
	private void actualizaVista() {
		lblNombre.setText("Nombre: "+modelo.obtenerNombreSeleccionado());
		lblSexo.setText("Sexo: "+modelo.obtenerSexoSeleccionado());
		panelSenias.removeAll();
		panelSenias.add(new JLabel("Senias particulares"));
		for (String senia : modelo.obtenerSenias()) {
			panelSenias.add(new JLabel(senia));
		}
		panelSenias.repaint();
		
		panelHobbies.removeAll();
		panelHobbies.add(new JLabel("Hobbies"));
		for (String hobbie : modelo.obtenerHobbies()) {
			panelHobbies.add(new JLabel(hobbie));
		}
		panelHobbies.repaint();
		
		ImageIcon originalImage = new ImageIcon(modelo.obtenerRutaImagenPorSexoSeleccionado());
		Image resizedImage = originalImage.getImage().getScaledInstance(190, 197, Image.SCALE_DEFAULT);
	    imgLabel.setIcon(new ImageIcon(resizedImage));
	}
}