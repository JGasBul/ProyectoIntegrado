package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Gestion;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;
	private JTextField textConfContr;
	private Gestion gestion;
	private JLabel lblLasContraseasNo;
	private JLabel lblUsuarioRegistradoCon;
	private JLabel lblNuevoNombreDe;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblConfContr;
	private JButton btnEnviar;
	private JButton btnRestablecer;
	private JButton btnMenuPrincipal;



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

		lblNuevoNombreDe = new JLabel("Nuevo nombre de usuario y contrase\u00F1a");
		if(Login.idioma) {
			lblNuevoNombreDe.setText("New username and password");

		}
		lblNuevoNombreDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNuevoNombreDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoNombreDe.setBounds(12, 13, 441, 43);
		contentPane.add(lblNuevoNombreDe);

		textUsuario = new JTextField();
		textUsuario.setBounds(279, 69, 116, 22);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		lblUsuario = new JLabel("Usuario:");
		if(Login.idioma) {
			lblUsuario.setText("User: ");

		}
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(172, 69, 95, 22);
		contentPane.add(lblUsuario);

		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(279, 104, 116, 22);
		contentPane.add(textContraseña);

		lblContrasea = new JLabel("Contrase\u00F1a: ");
		if(Login.idioma) {
			lblContrasea.setText("Password: ");

		}
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(151, 104, 116, 22);
		contentPane.add(lblContrasea);

		textConfContr = new JTextField();
		textConfContr.setColumns(10);
		textConfContr.setBounds(279, 139, 116, 22);
		contentPane.add(textConfContr);

		lblConfContr = new JLabel("Confirmar contrase\u00F1a: ");
		lblConfContr.setHorizontalAlignment(SwingConstants.RIGHT);
		if(Login.idioma) {
			lblConfContr.setText("Confirm Password: ");

		}
		lblConfContr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfContr.setBounds(63, 136, 204, 22);
		contentPane.add(lblConfContr);

		btnEnviar = new JButton("Enviar");
		if(Login.idioma) {
			btnEnviar.setText("Send");

		}
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestion=new Gestion();
				if(textContraseña.getText().equals(textConfContr.getText())) {
					lblLasContraseasNo.setVisible(false);
					gestion.updateUsuario(textUsuario.getText(), textContraseña.getText());
					textUsuario.setText("");
					textContraseña.setText("");
					textConfContr.setText("");
					lblUsuarioRegistradoCon.setVisible(true);
				}
				else {
					lblLasContraseasNo.setVisible(true);
					lblUsuarioRegistradoCon.setVisible(false);
				}
			}
		});
		btnEnviar.setBounds(80, 197, 97, 25);
		contentPane.add(btnEnviar);

		btnRestablecer = new JButton("Restablecer");
		if(Login.idioma) {
			btnRestablecer.setText("Reset");

		}
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textUsuario.setText("");
				textContraseña.setText("");
				textConfContr.setText("");
				lblUsuarioRegistradoCon.setVisible(false);
				lblLasContraseasNo.setVisible(false);

			}
		});
		btnRestablecer.setBounds(286, 197, 109, 25);
		contentPane.add(btnRestablecer);

		btnMenuPrincipal = new JButton("Menu principal");
		if(Login.idioma) {
			btnMenuPrincipal.setText("Main Menu");

		}
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index i=new Index();
				i.setVisible(true);
				dispose();
			}
		});
		btnMenuPrincipal.setBounds(175, 237, 128, 25);
		contentPane.add(btnMenuPrincipal);

		lblLasContraseasNo = new JLabel("Las contrase\u00F1as no son iguales");
		if(Login.idioma) {
			lblLasContraseasNo.setText("The passwords are not the same");

		}
		lblLasContraseasNo.setVisible(false);
		lblLasContraseasNo.setForeground(Color.RED);
		lblLasContraseasNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLasContraseasNo.setBounds(63, 171, 340, 22);
		contentPane.add(lblLasContraseasNo);

		lblUsuarioRegistradoCon = new JLabel("Usuario Registrado con éxito");
		if(Login.idioma) {
			lblUsuarioRegistradoCon.setText("Registered user successfully");

		}
		lblUsuarioRegistradoCon.setVisible(false);
		lblUsuarioRegistradoCon.setForeground(Color.BLACK);
		lblUsuarioRegistradoCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioRegistradoCon.setBounds(63, 168, 340, 25);
		contentPane.add(lblUsuarioRegistradoCon);
	}
}
