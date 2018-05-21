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
	protected static String nom;


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
		setBounds(100, 100, 609, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblBienvenidosALuda = new JLabel("Bienvenidos a luda2");
		lblBienvenidosALuda.setBounds(12, 13, 574, 102);
		lblBienvenidosALuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosALuda.setFont(new Font("Bookman Old Style", Font.PLAIN, 56));

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setBounds(30, 244, 276, 45);
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));

		textNom = new JTextField();
		textNom.setBounds(311, 259, 242, 22);
		textNom.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setBounds(30, 302, 276, 45);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));

		textPass = new JTextField();
		textPass.setBounds(311, 317, 242, 20);
		textPass.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 13));
		textPass.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(136, 360, 107, 41);
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
		btnRegistrarse.setBounds(299, 360, 180, 41);
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
		
		JLabel lblSadfd = new JLabel("sadfd");
		lblSadfd.setIcon(new ImageIcon(Login.class.getResource("/img/logosinfondo.png")));
		lblSadfd.setBounds(157, 95, 242, 183);
		contentPane.add(lblSadfd);
	}
}
