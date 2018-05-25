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
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPass;
	public static String nom;
	public static boolean idioma;
	private JLabel lblBienvenidosALuda;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JButton btnNewButton;
	private JButton btnRegistrarse;
	private JLabel lblSadfd;
	private JButton btnEspaol;
	private JButton btnIngles;
	private JLabel lblUsuarioOContrasea;


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
		setTitle("LUDA2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblBienvenidosALuda = new JLabel("Bienvenidos a luda2");
		lblBienvenidosALuda.setBounds(12, 71, 574, 102);
		lblBienvenidosALuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosALuda.setFont(new Font("Bookman Old Style", Font.PLAIN, 56));

		lblNombreDeUsuario = new JLabel("Nombre de usuario ");
		lblNombreDeUsuario.setBounds(30, 302, 276, 45);
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));

		textNom = new JTextField();
		textNom.setBounds(311, 317, 242, 22);
		textNom.setColumns(10);

		lblContrasea = new JLabel("Contrase\u00F1a ");
		lblContrasea.setBounds(30, 360, 276, 45);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));

		textPass = new JTextField();
		textPass.setBounds(311, 375, 242, 20);
		textPass.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 13));
		textPass.setColumns(10);

		btnNewButton = new JButton("Acceder");
		btnNewButton.setBounds(136, 418, 135, 41);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nom=textNom.getText();
				nom.trim();
				String pass=textPass.getText();
				if(nom.equals("Administrador")) {
					Conectar_WS con=new Conectar_WS(nom,pass);
					if(con.conect()) {
						lblUsuarioOContrasea.setVisible(false);
						Index p=new Index();
						p.setVisible(true);
						dispose();
					}
					else {
						lblUsuarioOContrasea.setVisible(true);
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
						else {
							lblUsuarioOContrasea.setVisible(true);
						}
					}
					else {
						System.out.println("El servidor no esta disponible ahora mismo. Pida ayuda a un administrador");
					}
				}


			}
		});

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(299, 418, 180, 41);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro r=new registro();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.setLayout(null);
		contentPane.add(lblBienvenidosALuda);
		contentPane.add(lblNombreDeUsuario);
		contentPane.add(textNom);
		contentPane.add(lblContrasea);
		contentPane.add(btnNewButton);
		contentPane.add(btnRegistrarse);
		contentPane.add(textPass);

		lblSadfd = new JLabel("sadfd");
		lblSadfd.setIcon(new ImageIcon(Login.class.getResource("/img/logosinfondo.png")));
		lblSadfd.setBounds(157, 153, 242, 183);
		contentPane.add(lblSadfd);

		btnEspaol = new JButton("Espa\u00F1ol");
		btnEspaol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idioma=false;
				textNom.setText("");
				textPass.setText("");
				lblBienvenidosALuda.setText("Bienvenidos a luda2");
				lblContrasea.setText("Contraseña");
				lblNombreDeUsuario.setText("Nombre de usuario");
				btnNewButton.setText("Acceder");
				btnRegistrarse.setText("Registrarse");
			}
		});
		btnEspaol.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnEspaol.setBounds(12, 13, 130, 41);
		contentPane.add(btnEspaol);

		btnIngles = new JButton("English");
		btnIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idioma=true;
				textNom.setText("");
				textPass.setText("");
				lblBienvenidosALuda.setText("Welcome to luda2");
				lblContrasea.setText("Password");
				lblNombreDeUsuario.setText("Username");
				btnNewButton.setText("Log in");
				btnRegistrarse.setText("Sign up");

			}
		});
		btnIngles.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnIngles.setBounds(154, 13, 130, 41);
		contentPane.add(btnIngles);

		lblUsuarioOContrasea = new JLabel("Usuario o contrase\u00F1a incorrectos");
		lblUsuarioOContrasea.setVisible(false);
		lblUsuarioOContrasea.setForeground(Color.RED);
		lblUsuarioOContrasea.setBounds(308, 346, 245, 22);
		contentPane.add(lblUsuarioOContrasea);
	}
}
