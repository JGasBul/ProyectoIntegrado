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

public class Index extends JFrame {

	private JPanel contentPane;
	Informacion f=new Informacion(Login.nom);




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
		lblBienvenidosAlProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosAlProyecto.setFont(new Font("SansSerif", Font.PLAIN, 50));

		JLabel lblElijaLoQue = new JLabel("Elija lo que quiere hacer: ");
		lblElijaLoQue.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel lblPrueba = new JLabel("");
		lblPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		lblPrueba.setIcon(new ImageIcon(Index.class.getResource("/img/user.png")));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Index.class.getResource("/img/Tragamonedas.png")));

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Index.class.getResource("/img/A\u00F1adir Saldo.png")));

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		f.users();
		JLabel lblUser = new JLabel(f.getUser());
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblDineroTotal = new JLabel("Dinero Total: ");
		lblDineroTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel label_3 = new JLabel(String.valueOf(f.getSaldoTotal()));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblPrueba, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
										.addGap(52)
										.addComponent(label)
										.addGap(118)
										.addComponent(label_1)
										.addContainerGap(38, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblElijaLoQue, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
										.addGap(229))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblUsuario)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblUser)
														.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
														.addComponent(lblBienvenidosAlProyecto)
														.addGap(96))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(280)
														.addComponent(lblDineroTotal)
														.addContainerGap())))))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lblDineroTotal, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
										.addComponent(lblBienvenidosAlProyecto)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblElijaLoQue, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblUsuario)
												.addComponent(lblUser))
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrueba)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(17)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(label)
												.addComponent(label_1))))
						.addGap(24))
				);

		contentPane.setLayout(gl_contentPane);

	}
}
