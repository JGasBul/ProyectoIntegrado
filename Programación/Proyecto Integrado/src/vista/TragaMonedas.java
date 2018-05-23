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
		setBounds(100, 100, 929, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TragaMonedas.class.getResource("/img/Tragamonedas.png")));
		lblNewLabel.setBounds(201, 130, 173, 141);

		JLabel label = new JLabel("New label");
		label.setBounds(375, 130, 173, 141);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(549, 130, 173, 141);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(201, 274, 173, 141);

		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(375, 274, 173, 141);

		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(549, 274, 173, 141);

		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(375, 414, 173, 141);

		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(549, 414, 173, 141);

		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(201, 414, 173, 141);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(label_5);
		contentPane.add(label_6);
		contentPane.add(label_7);

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
		btnNum.setBounds(200, 561, 97, 51);
		contentPane.add(btnNum);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJugar.setBounds(531, 561, 97, 51);
		contentPane.add(btnJugar);
	}
}
