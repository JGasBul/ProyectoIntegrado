package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Gestion;
import conexion.Informacion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class OPago extends JFrame {

	private JPanel contentPane;
	Informacion f=new Informacion(Login.nom);
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public OPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOpcionesDePago = new JLabel("Opciones de pago");
		if(Login.idioma) {
			lblOpcionesDePago.setText("Payment options");
		}
		lblOpcionesDePago.setBounds(5, 5, 646, 66);
		lblOpcionesDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionesDePago.setFont(new Font("Bookman Old Style", Font.PLAIN, 56));
		contentPane.add(lblOpcionesDePago);

		JLabel lblIntrooduzcaElDinero = new JLabel("Introduzca el dinero que desea introducir: ");
		if(Login.idioma) {
			lblIntrooduzcaElDinero.setText("Enter the money you want to enter: ");
		}
		lblIntrooduzcaElDinero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIntrooduzcaElDinero.setBounds(81, 87, 543, 41);
		contentPane.add(lblIntrooduzcaElDinero);

		textField = new JTextField();
		textField.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		textField.setBounds(273, 133, 116, 22);
		contentPane.add(textField);

		textField.setColumns(10);
		JLabel lblSeHaIntroducido = new JLabel("Se ha introducido un caracter no numerico");
		if(Login.idioma) {
			lblSeHaIntroducido.setText("Character not numeric");
		}
		lblSeHaIntroducido.setVisible(false);
		lblSeHaIntroducido.setForeground(Color.RED);
		lblSeHaIntroducido.setBounds(214, 206, 253, 16);
		JButton btnIntroducir = new JButton("Añadir");
		if(Login.idioma) {
			btnIntroducir.setText("Add");
		}
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isNumeric(textField.getText().trim())) {
					lblSeHaIntroducido.setVisible(false);
					double saldo=Double.parseDouble(textField.getText().trim());
					Gestion g=new Gestion();
					g.añadir_saldo(saldo);
				}
				else {
					lblSeHaIntroducido.setVisible(true);
				}

			}
		});
		btnIntroducir.setBounds(283, 168, 97, 25);
		contentPane.add(btnIntroducir);


		contentPane.add(lblSeHaIntroducido);

		JButton btnOpcionesDeUsuario = new JButton("Opciones de usuario");
		if(Login.idioma) {
			btnOpcionesDeUsuario.setText("User Options");
		}
		btnOpcionesDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u=new Usuario();
				u.setVisible(true);
				dispose();
			}
		});
		btnOpcionesDeUsuario.setBounds(12, 202, 173, 25);
		contentPane.add(btnOpcionesDeUsuario);

		JButton btnMenuPrincipal = new JButton("Menu principal");
		if(Login.idioma) {
			btnMenuPrincipal.setText("Main");
		}
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Index i=new Index();
				i.setVisible(true);
				dispose();
			}
		});
		btnMenuPrincipal.setBounds(493, 202, 129, 25);
		contentPane.add(btnMenuPrincipal);
	}
	public boolean isNumeric(String s) {  
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
