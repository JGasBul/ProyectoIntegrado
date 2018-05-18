package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Registro;
import Modelo.ValidadorDNI;
import Modelo.ValidadorEmail;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro extends JFrame {

	private JPanel contentPane;
	private JTextField textDNI;
	private JTextField textNom;
	private JTextField textAP1;
	private JTextField textAP2;
	private JTextField textUser;
	private JTextField textpass;
	private JTextField textEM;
	private JTextField textTlf;

	/**
	 * Create the frame.
	 */
	public registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 50));

		JLabel lblNombre = new JLabel("DNI");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblapellido = new JLabel("1\u00BAApellido");
		lblapellido.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblapellido_1 = new JLabel("2\u00BAApellido");
		lblapellido_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textDNI = new JTextField();
		textDNI.setColumns(10);

		textNom = new JTextField();
		textNom.setColumns(10);

		textAP1 = new JTextField();
		textAP1.setColumns(10);

		textAP2 = new JTextField();
		textAP2.setColumns(10);

		textUser = new JTextField();
		textUser.setColumns(10);

		textpass = new JTextField();
		textpass.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 13));
		textpass.setColumns(10);

		textEM = new JTextField();
		textEM.setColumns(10);

		textTlf = new JTextField();
		textTlf.setColumns(10);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidadorDNI vD=new ValidadorDNI(textDNI.getText());
				ValidadorEmail vE=new ValidadorEmail(textEM.getText());
				if(vD.validar()) {
					if(vE.Validar()) {
						Registro r=new Registro(textEM.getText().trim(),textDNI.getText().trim(),textNom.getText().trim(),textAP1.getText().trim(),textAP2.getText().trim(),textUser.getText().trim(),textpass.getText().trim(),Integer.parseInt(textTlf.getText().trim()));
						r.insertarUsuario();
						Login L=new Login();
						L.setVisible(true);
						dispose();
					}
					else {
						Error err=new Error();
						err.setVisible(true);
					}
				}
				else {
					Error err=new Error();
					err.setVisible(true);
				}
			}
		});

		JButton btnRestablecer = new JButton("Restablecer");
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNom.setText("");
				textAP1.setText("");
				textAP2.setText("");
				textDNI.setText("");
				textEM.setText("");
				textTlf.setText("");
				textUser.setText("");
				textpass.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre)
								.addComponent(lblRegistro)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblapellido)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblUsername)
												.addComponent(lblapellido_1))
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblEmail)
												.addComponent(lblContrasea)
												.addComponent(lblTelefono))
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textAP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
										.addComponent(btnRegistrarse))
								.addComponent(textAP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnRestablecer))
								.addComponent(textTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textpass, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(textEM, Alignment.LEADING)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblRegistro)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblapellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRegistrarse))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblapellido_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRestablecer))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
