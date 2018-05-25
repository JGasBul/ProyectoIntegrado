package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import Modelo.Juego;
import conexion.Gestion;
import conexion.Informacion;
import java.awt.Color;
public class TragaMonedas extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	private Gestion gestion;
	private Informacion info;
	JLabel posicion10 = new JLabel("");
	JLabel posicion11 = new JLabel("");
	JLabel posicion12 = new JLabel("");


	/**
	 * Create the frame.
	 */
	public TragaMonedas() {

		gestion=new Gestion();
		info=new Informacion(Login.nom);
		info.users();
		juego=new Juego();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(info.getUser());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(83, 21, 79, 16);
		contentPane.add(lblNewLabel);

		JLabel labelT = new JLabel(String.valueOf(info.getSaldoTotal()));
		labelT.setBounds(464, 21, 56, 16);
		contentPane.add(labelT);

		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
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
		btnCerrarSesin.setBounds(747, 48, 134, 25);
		contentPane.add(btnCerrarSesin);

		JButton btnMenuPrincipal = new JButton("Menu principal");
		btnMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		if(Login.idioma) {
			btnMenuPrincipal.setText("Main");
		}
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Index i=new Index();
				i.setVisible(true);
				dispose();
			}
		});
		btnMenuPrincipal.setBounds(747, 21, 134, 25);
		contentPane.add(btnMenuPrincipal);


		posicion10 = new JLabel("");
		rulo1();
		posicion10.setBackground(Color.BLACK);

		posicion10.setBounds(200, 251, 173, 141);

		posicion11 = new JLabel("");
		rulo2();
		posicion11.setBackground(Color.BLACK);
		posicion11.setBounds(374, 251, 173, 141);

		posicion12 = new JLabel("");
		rulo3();
		posicion12.setBackground(Color.BLACK);
		posicion12.setBounds(548, 251, 173, 141);
		contentPane.setLayout(null);
		contentPane.add(posicion10);
		contentPane.add(posicion11);
		contentPane.add(posicion12);

		JButton btnNum = new JButton("1");
		btnNum.addActionListener(new ActionListener() {

			private int num=(int)juego.getValorTirada();
			public void actionPerformed(ActionEvent e) {

				if (info.getSaldoTotal()<1) {

				}
				else {
					switch(this.num) {
					case 1:btnNum.setText("3");this.num=3;

					break;
					case 3:btnNum.setText("5");this.num=5;

					break;
					case 5:btnNum.setText("1");this.num=1;

					break;
					default:num=1;btnNum.setText("1");//Por si tenemos algun error inesperado la variable volvera a su posicion inicial.
					}
					juego.setValorTirada(this.num);

				}
			}
		});
		btnNum.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNum.setBounds(200, 557, 97, 51);
		contentPane.add(btnNum);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num=(int)juego.getValorTirada();

				//System.out.println("Pon mas dinero (LLamar ventana error)");

				switch (num) {
				case 1: gestion.restar_saldo(0.20);
				break;
				case 3: gestion.restar_saldo(0.60);
				break;
				case 5: gestion.restar_saldo(1.0);
				break;
				}
				if (juego.getnCoincidencias()==2) {
					juego.retencion();
				}
				else {
					juego.tiraPalanca();
				}
				rulo1();
				rulo2();
				rulo3();


			}
		});
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJugar.setBounds(624, 561, 97, 51);
		contentPane.add(btnJugar);

		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(23, 21, 65, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblDineroTotal = new JLabel("Dinero Total:");
		lblDineroTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDineroTotal.setBounds(358, 21, 106, 16);
		contentPane.add(lblDineroTotal);
	}
	public void rulo1(){
		switch (juego.getPosRulo1()) {
		case 0: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Cereza.png")));
		break;
		case 1: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Uva.png")));
		break;
		case 2: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Racimo.png")));
		break;
		case 3: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Naranja.png")));
		break;
		case 4: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Campana.png")));
		break;
		case 5: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteVerde.png")));
		break;
		case 6: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteRojo2.png")));
		break;
		case 7: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteAzul.png")));
		break;
		case 8: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Diamante.png")));
		break;
		case 9: posicion10.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/logosinfondo.png")));
		break;
		}
	}
	public void rulo2(){
		switch (juego.getPosRulo2()) {
		case 0: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Cereza.png")));
		break;
		case 1: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Uva.png")));
		break;
		case 2: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Racimo.png")));
		break;
		case 3: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Naranja.png")));
		break;
		case 4: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Campana.png")));
		break;
		case 5: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteVerde.png")));
		break;
		case 6: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteRojo2.png")));
		break;
		case 7: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteAzul.png")));
		break;
		case 8: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Diamante.png")));
		break;
		case 9: posicion11.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/logosinfondo.png")));
		break;
		}
	}
	public void rulo3(){
		switch (juego.getPosRulo3()) {
		case 0: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Cereza.png")));
		break;
		case 1: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Uva.png")));
		break;
		case 2: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Racimo.png")));
		break;
		case 3: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Naranja.png")));
		break;
		case 4: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Campana.png")));
		break;
		case 5: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteVerde.png")));
		break;
		case 6: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteRojo2.png")));
		break;
		case 7: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/SieteAzul.png")));
		break;
		case 8: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Diamante.png")));
		break;
		case 9: posicion12.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/logosinfondo.png")));
		break;
		}
	}

}
