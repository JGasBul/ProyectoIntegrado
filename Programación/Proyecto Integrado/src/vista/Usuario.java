package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Informacion;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario extends JFrame {

	private JPanel contentPane;
	Informacion f=new Informacion(Login.nom);
	/**
	 * Create the frame.
	 */
	public Usuario() {
		setTitle("LUDA2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblBienvenidoATu = new JLabel("Bienvenido a tu usuario");
		lblBienvenidoATu.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBienvenidoATu.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 25));
		f.users();
		JLabel lblUser = new JLabel(f.getUser()+"(Clica para editar)");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblclicaPara = new JLabel("******** (Clica para editar)");
		lblclicaPara.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnPginaPrincipal = new JButton("P\u00E1gina Principal");
		btnPginaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Index x=new Index();
				x.setVisible(true);
				dispose();
			}
		});
		btnPginaPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblBienvenidoATu, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblContrasea)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblclicaPara, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblUsuario)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnPginaPrincipal))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblBienvenidoATu)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblclicaPara, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContrasea))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnPginaPrincipal)
						.addContainerGap(17, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
