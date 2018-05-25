package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;
	private JTextField textContraseña2;


	/**
	 * Create the frame.
	 */
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoNombreDe = new JLabel("Nuevo nombre de usuario y contrase\u00F1a");
		lblNuevoNombreDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNuevoNombreDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoNombreDe.setBounds(12, 13, 441, 43);
		contentPane.add(lblNuevoNombreDe);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(279, 69, 116, 22);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(151, 69, 95, 22);
		contentPane.add(lblUsuario);
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(279, 104, 116, 22);
		contentPane.add(textContraseña);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(151, 104, 116, 22);
		contentPane.add(lblContrasea);
		
		textContraseña2 = new JTextField();
		textContraseña2.setColumns(10);
		textContraseña2.setBounds(279, 139, 116, 22);
		contentPane.add(textContraseña2);
		
		JLabel lblNuevaContrasea = new JLabel("Confirmar contrase\u00F1a: ");
		lblNuevaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevaContrasea.setBounds(63, 136, 204, 22);
		contentPane.add(lblNuevaContrasea);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(80, 197, 97, 25);
		contentPane.add(btnEnviar);
		
		JButton btnRestablecer = new JButton("Restablecer");
		btnRestablecer.setBounds(286, 197, 109, 25);
		contentPane.add(btnRestablecer);
		
		JButton btnMenuPrincipal = new JButton("Menu principal");
		btnMenuPrincipal.setBounds(175, 237, 116, 25);
		contentPane.add(btnMenuPrincipal);
	}
}
