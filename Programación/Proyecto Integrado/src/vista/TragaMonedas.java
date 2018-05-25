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
import javax.swing.SwingConstants;
public class TragaMonedas extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	private Gestion gestion;
	private Informacion info;
	private JLabel posicion10 = new JLabel("");
	private JLabel posicion11 = new JLabel("");
	private JLabel posicion12 = new JLabel("");
	private JLabel lblNewLabel;
	private String strDouble;
	private JLabel labelT;
	private JButton btnCerrarSesin;
	private JButton btnMenuPrincipal;
	private JButton btnNum;
	private JButton btnJugar;
	private JLabel lblUser;
	private JLabel lblDineroTotal;
	private JLabel label;
	private JLabel lblCereza;
	private JLabel lblUva;
	private JLabel lblRacimo;
	private JLabel lblNaranja;
	private JLabel lblCampana;
	private JLabel lblSieteVerde;
	private JLabel lblSieteRojo;
	private JLabel lblSieteAzul;
	private JLabel lblDiamante;
	private JLabel lblLuda;
	private JLabel lblhasGanado;
	private JLabel lblElijaConCuantas;
	private JLabel lblElPremioSera;
	private JLabel lblPorTalCifra;
	private JLabel lblDinero_Ganado;


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

		lblNewLabel = new JLabel(info.getUser());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(152, 48, 221, 25);
		contentPane.add(lblNewLabel);

		strDouble = String.format("%.2f", info.getSaldoTotal());

		labelT = new JLabel(String.valueOf(strDouble));
		labelT.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelT.setBounds(620, 48, 115, 25);
		contentPane.add(labelT);

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
		btnCerrarSesin.setBounds(747, 48, 134, 25);
		contentPane.add(btnCerrarSesin);

		btnMenuPrincipal = new JButton("Menu principal");
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

		btnNum = new JButton("1");

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
					default:this.num=1;btnNum.setText("1");//Por si tenemos algun error inesperado la variable volvera a su posicion inicial.
					}
					juego.setValorTirada(num);

				}
			}
		});
		btnNum.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNum.setBounds(212, 557, 97, 51);
		contentPane.add(btnNum);

		btnJugar = new JButton("Jugar");
		if(Login.idioma) {
			lblDineroTotal.setText("Play");
		}
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.users();
				strDouble = String.format("%.2f", info.getSaldoTotal());
				labelT.setText(String.valueOf(strDouble));
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
					if(juego.getnCoincidencias()==3) {
						lblhasGanado.setVisible(true);
						lblDinero_Ganado.setText(String.valueOf(juego.getValorPremio()+" €"));
						lblDinero_Ganado.setVisible(true);
					}
					else {
						lblhasGanado.setVisible(false);
					}
				}
				else {
					juego.tiraPalanca();
					if(juego.getnCoincidencias()==3) {
						lblhasGanado.setVisible(true);
						lblDinero_Ganado.setText(String.valueOf(juego.getValorPremio())+" €");
						lblDinero_Ganado.setVisible(true);
					}
					else {
						lblhasGanado.setVisible(false);
						lblDinero_Ganado.setVisible(false);
					}

				}
				rulo1();
				rulo2();
				rulo3();



			}
		});
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJugar.setBounds(624, 561, 97, 51);
		contentPane.add(btnJugar);

		lblUser = new JLabel("Usuario: ");
		if(Login.idioma) {
			lblUser.setText("User: ");
		}
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUser.setBounds(23, 21, 139, 66);
		contentPane.add(lblUser);

		lblDineroTotal = new JLabel("Dinero Total:");

		if(Login.idioma) {
			lblDineroTotal.setText("Total cash: ");
		}
		lblDineroTotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDineroTotal.setBounds(426, 42, 198, 31);
		contentPane.add(lblDineroTotal);

		label = new JLabel("Premios: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(23, 168, 97, 25);
		contentPane.add(label);

		lblCereza = new JLabel("Cereza=0.40\u20AC");
		lblCereza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCereza.setBounds(23, 206, 139, 25);
		contentPane.add(lblCereza);

		lblUva = new JLabel("Uva=0.80\u20AC");
		lblUva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUva.setBounds(23, 232, 139, 25);
		contentPane.add(lblUva);

		lblRacimo = new JLabel("Racimo=1.60\u20AC");
		lblRacimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRacimo.setBounds(23, 259, 139, 25);
		contentPane.add(lblRacimo);

		lblNaranja = new JLabel("Naranja=2.40\u20AC");
		lblNaranja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNaranja.setBounds(23, 285, 139, 25);
		contentPane.add(lblNaranja);

		lblCampana = new JLabel("Campana=3.20\u20AC");
		lblCampana.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCampana.setBounds(23, 310, 149, 25);
		contentPane.add(lblCampana);

		lblSieteVerde = new JLabel("Siete Verde=4\u20AC");
		lblSieteVerde.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSieteVerde.setBounds(23, 336, 149, 25);
		contentPane.add(lblSieteVerde);

		lblSieteRojo = new JLabel("Siete Rojo=8\u20AC");
		lblSieteRojo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSieteRojo.setBounds(23, 359, 139, 25);
		contentPane.add(lblSieteRojo);

		lblSieteAzul = new JLabel("Siete Azul=14\u20AC");
		lblSieteAzul.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSieteAzul.setBounds(23, 385, 139, 25);
		contentPane.add(lblSieteAzul);

		lblDiamante = new JLabel("Diamante=20\u20AC");
		lblDiamante.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiamante.setBounds(23, 409, 139, 25);
		contentPane.add(lblDiamante);

		lblLuda = new JLabel("Luda2=100\u20AC");
		lblLuda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLuda.setBounds(23, 434, 139, 25);
		contentPane.add(lblLuda);

		lblhasGanado = new JLabel("\u00A1HAS GANADO!");
		if(Login.idioma) {
			lblhasGanado.setText("You WIN!!");
		}
		lblhasGanado.setVisible(false);
		lblhasGanado.setForeground(Color.RED);
		lblhasGanado.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblhasGanado.setHorizontalAlignment(SwingConstants.CENTER);
		lblhasGanado.setBounds(299, 455, 311, 99);
		contentPane.add(lblhasGanado);

		lblElijaConCuantas = new JLabel("Elija con cuantas fichas jugara: ");
		lblElijaConCuantas.setBounds(9, 557, 191, 16);
		contentPane.add(lblElijaConCuantas);

		lblElPremioSera = new JLabel("El premio sera multiplicado");
		lblElPremioSera.setBounds(9, 592, 188, 16);
		contentPane.add(lblElPremioSera);

		lblPorTalCifra = new JLabel("por tal cifra");
		lblPorTalCifra.setBounds(9, 608, 178, 16);
		contentPane.add(lblPorTalCifra);

		lblDinero_Ganado = new JLabel("100 \u20AC");
		lblDinero_Ganado.setVisible(false);
		lblDinero_Ganado.setForeground(Color.RED);
		lblDinero_Ganado.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDinero_Ganado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinero_Ganado.setBounds(343, 557, 230, 66);
		contentPane.add(lblDinero_Ganado);
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
