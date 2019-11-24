package CarmenSanDiegoVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CarmenSanDiego.src.Villano;
import CarmenSanDiegoControladores.ControladorOrden;
import CarmenSanDiegoModeloVistas.ResolverMisterioViewModel;
import CarmenSanDiegoVistas.OrdenDeArresto.obtenerNombreVillanos;

public class OrdenDeArresto extends JFrame {

	public class obtenerNombreVillanos extends ArrayList<String> {

	}

	ResolverMisterioViewModel modelo;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenDeArresto frame = new OrdenDeArresto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param modelo 
	 */
	public OrdenDeArresto(ResolverMisterioViewModel modelo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.modelo = modelo;
		Label label = new Label("seleccione villano contra quien emitira la orden");
		label.setBounds(50, 0, 400, 50);
		contentPane.add(label);
		
		ControladorOrden controlador = new ControladorOrden(modelo);
		ArrayList<String> nombreVillanos= controlador.obtenerNombreVillanos(modelo);
		JComboBox villanos = new JComboBox();
		for(int i=0; i<nombreVillanos.size(); i++) {
			villanos.addItem(nombreVillanos.get(i));
		}
		villanos.setBounds(50,70, 280, 40);
		
		contentPane.add(villanos);
		
		JButton cancelar = new JButton("cancelar");
		cancelar.setBounds(50, 130, 130, 40);
		contentPane.add(cancelar);

		JButton generar = new JButton("generar");
		generar.setBounds(190, 130, 90, 40);
		contentPane.add(generar);
		
		//funcionalidad cancelar
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		//funcionalidad generar
		generar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mensaje = "desea generar la orden a "+nombreVillanos.get(villanos.getSelectedIndex())+"?";
				int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar orden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirmacion == JOptionPane.YES_OPTION) {
					controlador.generarOrden(nombreVillanos.get(villanos.getSelectedIndex()));
					setVisible(false);
				}	
			}
		});
	}
	
	
}
