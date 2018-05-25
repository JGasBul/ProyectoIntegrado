package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Informacion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private Informacion f=new Informacion(Login.nom);
	private Usuario usr=new Usuario();
	private JLabel lblBienvenidosAlProyecto;
	private JLabel lblElijaLoQue;
	private JLabel lblUserCnf;
	private JLabel labelTraga;
	private JLabel labelAñadir;
	private JLabel lblUsuario;
	private JLabel lblDineroTotal;
	private JLabel labelT;
	private String strDouble;
	private JLabel lblNewLabel;
	private JButton btnCerrarSesin;
	private JLabel label_3;
	private JLabel lblUsuarioY;
	private JLabel lblTragaperras;
	private JLabel lblAadirSaldo;

	/**
	 * Create the frame.
	 */
	public Index() {
		setTitle("LUDA2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 909, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblBienvenidosAlProyecto = new JLabel("Bienvenidos al proyecto Luda2");
		if (Login.idioma) {
			lblBienvenidosAlProyecto.setText("Welcome to the project Luda2");
		}
		lblBienvenidosAlProyecto.setBounds(79, 59, 712, 64);
		lblBienvenidosAlProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosAlProyecto.setFont(new Font("SansSerif", Font.PLAIN, 50));

		lblElijaLoQue = new JLabel("Elija lo que quiere hacer: ");
		if (Login.idioma) {
			lblElijaLoQue.setText("Choose whatever you want");
		}
		lblElijaLoQue.setBounds(251, 136, 463, 64);
		lblElijaLoQue.setFont(new Font("Tahoma", Font.PLAIN, 30));

		lblUserCnf = new JLabel("");
		lblUserCnf.setBounds(12, 223, 322, 154);
		lblUserCnf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				usr.setVisible(true);
				dispose();
			}
		});
		lblUserCnf.setIcon(new ImageIcon(Index.class.getResource("/img/user.png")));

		labelTraga = new JLabel("");
		labelTraga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TragaMonedas tm=new TragaMonedas();
				tm.setVisible(true);
				dispose();
			}
		});
		labelTraga.setBounds(374, 235, 171, 142);
		labelTraga.setIcon(new ImageIcon(Index.class.getResource("/img/Tragamonedas.png")));

		labelAñadir = new JLabel("");
		labelAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OPago o = new OPago();
				o.setVisible(true);
				dispose();
			}
		});

		labelAñadir.setBounds(664, 235, 150, 142);
		labelAñadir.setIcon(new ImageIcon(Index.class.getResource("/img/A\u00F1adir Saldo.png")));

		lblUsuario = new JLabel("Usuario: ");
		if (Login.idioma) {
			lblUsuario.setText("User: ");
		}
		lblUsuario.setBounds(17, 18, 65, 20);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		f.users();

		lblDineroTotal = new JLabel("Dinero Total: ");
		if (Login.idioma) {
			lblDineroTotal.setText("Cash: ");
		}
		lblDineroTotal.setBounds(362, 18, 99, 20);
		lblDineroTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));

		label_3 = new JLabel(String.valueOf(f.getSaldoTotal()));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setLayout(null);
		contentPane.add(lblUserCnf);
		contentPane.add(labelTraga);
		contentPane.add(labelAñadir);
		contentPane.add(lblElijaLoQue);
		contentPane.add(lblUsuario);
		contentPane.add(lblBienvenidosAlProyecto);
		contentPane.add(lblDineroTotal);

		strDouble = String.format("%.2f", f.getSaldoTotal());

		labelT = new JLabel(String.valueOf(strDouble));
		labelT.setBounds(464, 21, 203, 16);
		contentPane.add(labelT);

		lblNewLabel = new JLabel(f.getUser());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(83, 21, 79, 16);
		contentPane.add(lblNewLabel);

		btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		if (Login.idioma) {
			btnCerrarSesin.setText("Log out");
		}
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login L=new Login();
				L.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCerrarSesin.setBounds(745, 21, 134, 25);
		contentPane.add(btnCerrarSesin);

		lblUsuarioY = new JLabel("Usuario y configuraciones");
		lblUsuarioY.setHorizontalAlignment(SwingConstants.CENTER);
		if (Login.idioma) {
			lblUsuarioY.setText("User and settings");
		}
		lblUsuarioY.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuarioY.setBounds(38, 324, 285, 64);
		contentPane.add(lblUsuarioY);

		lblTragaperras = new JLabel("Tragaperras");
		if (Login.idioma) {
			lblTragaperras.setText("Slot Machine");
		}
		lblTragaperras.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTragaperras.setBounds(390, 324, 143, 64);
		contentPane.add(lblTragaperras);

		lblAadirSaldo = new JLabel("A\u00F1adir Saldo");
		if (Login.idioma) {
			lblAadirSaldo.setText("Add Cash");
		}
		lblAadirSaldo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAadirSaldo.setBounds(674, 324, 143, 64);
		contentPane.add(lblAadirSaldo);

	}
}
