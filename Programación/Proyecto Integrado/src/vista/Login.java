package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conectar_WS;
import conexion.Conexion_BD;
import conexion.Informacion;
import sun.text.normalizer.CharTrie.FriendAgent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPass;
	public String nom;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblBienvenidosALuda = new JLabel("Bienvenidos a luda2");
		lblBienvenidosALuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosALuda.setFont(new Font("Bookman Old Style", Font.PLAIN, 56));

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));

		textNom = new JTextField();
		textNom.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));

		textPass = new JTextField();
		textPass.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 13));
		textPass.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nom=textNom.getText();
				nom.trim();
				String pass=textPass.getText();
				if(nom.equals("Administrador")) {
					Conectar_WS con=new Conectar_WS(nom,pass);
					if(con.conect()) {

						Index p=new Index();
						p.setVisible(true);
						dispose();
					}
				}
				else {
					Conexion_BD con=new Conexion_BD(nom, pass);
					if(con.connectDB()) {
						if(con.users()) {
							Index p=new Index();
							p.setVisible(true);
							dispose();
						}
					}
					else {
						System.out.println("Caca");
					}
				}


			}
		});

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro r=new registro();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblBienvenidosALuda, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(31)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNombreDeUsuario, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textNom, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
																.addGap(5)
																.addComponent(textPass, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(153)
														.addComponent(btnNewButton)
														.addGap(45)
														.addComponent(btnRegistrarse)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblBienvenidosALuda, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreDeUsuario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(15)
										.addComponent(textPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(btnRegistrarse))
						.addContainerGap(298, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
