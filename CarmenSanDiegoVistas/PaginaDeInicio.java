package CarmenSanDiegoVistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class PaginaDeInicio extends JFrame {
	private static final long serialVersionUID = -7797745868537851156L;
	private JPanel contentPane;
	private JPanel buttonsPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaDeInicio frame = new PaginaDeInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PaginaDeInicio() {
		setTitle("Carmen San Diego");
		setBounds(100, 100, 500, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		Label label = new Label("�Que haremos ahora Detective?");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(label);
		
		buttonsPane = new JPanel();
		buttonsPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(buttonsPane);
		buttonsPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTextField nombreTextField= new JTextField();
		nombreTextField.setText("Ingrese su nombre...");
		buttonsPane.add(nombreTextField);
		
		JButton bResolverMisterio = new JButton("Resolver Misterio");
		bResolverMisterio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if( nombreTextField.getText().length() == 0 )
				{
					JOptionPane.showMessageDialog(contentPane, "Debe ingresar su nombre!");
				} else {
					ElegirCaso ventana = new ElegirCaso(nombreTextField.getText());
					ventana.setVisible(true);	
				}
			}
		});
		
		bResolverMisterio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonsPane.add(bResolverMisterio);
		
	}
}