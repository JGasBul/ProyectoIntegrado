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
	Informacion f=new Informacion(Login.nom);
	Usuario usr=new Usuario();

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

		JLabel lblBienvenidosAlProyecto = new JLabel("Bienvenidos al proyecto luda2");
		lblBienvenidosAlProyecto.setBounds(116, 59, 674, 64);
		lblBienvenidosAlProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosAlProyecto.setFont(new Font("SansSerif", Font.PLAIN, 50));

		JLabel lblElijaLoQue = new JLabel("Elija lo que quiere hacer: ");
		lblElijaLoQue.setBounds(273, 136, 384, 64);
		lblElijaLoQue.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel lblUserCnf = new JLabel("");
		lblUserCnf.setBounds(17, 218, 340, 154);
		lblUserCnf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				usr.setVisible(true);
				dispose();
			}
		});
		lblUserCnf.setIcon(new ImageIcon(Index.class.getResource("/img/user.png")));

		JLabel labelTraga = new JLabel("");
		labelTraga.setBounds(409, 235, 171, 123);
		labelTraga.setIcon(new ImageIcon(Index.class.getResource("/img/Tragamonedas.png")));

		JLabel labelAñadir = new JLabel("");
		labelAñadir.setBounds(698, 235, 150, 123);
		labelAñadir.setIcon(new ImageIcon(Index.class.getResource("/img/A\u00F1adir Saldo.png")));

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(17, 18, 65, 20);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		f.users();

		JLabel lblDineroTotal = new JLabel("Dinero Total: ");
		lblDineroTotal.setBounds(362, 18, 99, 20);
		lblDineroTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel label_3 = new JLabel(String.valueOf(f.getSaldoTotal()));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setLayout(null);
		contentPane.add(lblUserCnf);
		contentPane.add(labelTraga);
		contentPane.add(labelAñadir);
		contentPane.add(lblElijaLoQue);
		contentPane.add(lblUsuario);
		contentPane.add(lblBienvenidosAlProyecto);
		contentPane.add(lblDineroTotal);

		JLabel labelT = new JLabel(String.valueOf(f.getSaldoTotal()));
		labelT.setBounds(464, 21, 56, 16);
		contentPane.add(labelT);

		JLabel lblNewLabel = new JLabel(f.getUser());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(83, 21, 79, 16);
		contentPane.add(lblNewLabel);

		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
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

	}
}
