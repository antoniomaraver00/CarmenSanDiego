package CarmenSanDiegoVistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class PaginaDeInicio extends JFrame {
	private static final long serialVersionUID = -7797745868537851156L;
	private JPanel contentPane;
	
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
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
	
		Label label = new Label("�Que haremos ahora Detective?");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(label);
		
		JButton bResolverMisterio = new JButton("Resolver Misterio");
		bResolverMisterio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ResolverMisterio ventana = new ResolverMisterio();
				ventana.setVisible(true);
			}
		});
		
		bResolverMisterio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(bResolverMisterio);
	}
}