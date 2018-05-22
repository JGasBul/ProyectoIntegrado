package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Informacion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OPago extends JFrame {

	private JPanel contentPane;
	Informacion f=new Informacion(Login.nom);
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public OPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOpcionesDePago = new JLabel("Opciones de pago");
		lblOpcionesDePago.setBounds(5, 5, 646, 66);
		lblOpcionesDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionesDePago.setFont(new Font("Bookman Old Style", Font.PLAIN, 56));
		contentPane.add(lblOpcionesDePago);
		
		JLabel lblIntrooduzcaElDinero = new JLabel("Introduzca el dinero que desea introducir: ");
		lblIntrooduzcaElDinero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIntrooduzcaElDinero.setBounds(81, 87, 543, 41);
		contentPane.add(lblIntrooduzcaElDinero);
		
		textField = new JTextField();
		textField.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		textField.setBounds(273, 133, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnIntroducir = new JButton("Introducir");
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIntroducir.setBounds(283, 168, 97, 25);
		contentPane.add(btnIntroducir);
	}
}
