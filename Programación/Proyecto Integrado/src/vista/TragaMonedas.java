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

public class TragaMonedas extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public TragaMonedas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Azul.png")));
		lblNewLabel.setBounds(221, 89, 125, 125);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);

		JButton btnNum = new JButton("1");
		btnNum.addActionListener(new ActionListener() {
			private int num=1;

			public void actionPerformed(ActionEvent e) {
				switch(this.num) {
				case 1:btnNum.setText("3");this.num=3;
				break;
				case 3:btnNum.setText("5");this.num=5;
				break;
				case 5:btnNum.setText("1");this.num=1;
				break;
				default:num=1;btnNum.setText("1");//Por si tenemos algun error inesperado la variable volvera a su posicion inicial.
				}

			}
		});
		btnNum.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNum.setBounds(231, 466, 97, 51);
		contentPane.add(btnNum);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJugar.setBounds(488, 466, 97, 51);
		contentPane.add(btnJugar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Rojo2.png")));
		label.setBounds(342, 89, 125, 125);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Verde.png")));
		label_1.setBounds(466, 89, 125, 125);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Azul.png")));
		label_2.setBounds(221, 215, 125, 125);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Azul.png")));
		label_3.setBounds(342, 215, 125, 125);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Azul.png")));
		label_4.setBounds(466, 215, 125, 125);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Rojo2.png")));
		label_5.setBounds(221, 340, 125, 125);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Rojo2.png")));
		label_6.setBounds(342, 340, 125, 125);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Siete Rojo2.png")));
		label_7.setBounds(466, 340, 125, 125);
		contentPane.add(label_7);
	}
}
