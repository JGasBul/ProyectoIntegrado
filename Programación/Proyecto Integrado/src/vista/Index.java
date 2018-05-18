package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setTitle("LUDA2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 909, 395);
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

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblPrueba, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
								.addGap(52)
								.addComponent(label)
								.addGap(118)
								.addComponent(label_1)
								.addGap(37))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(lblBienvenidosAlProyecto)
								.addGap(94)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblElijaLoQue, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
							.addGap(232))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBienvenidosAlProyecto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblElijaLoQue, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPrueba))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1))))
					.addContainerGap(18, Short.MAX_VALUE))
		);

		contentPane.setLayout(gl_contentPane);

	}
}
