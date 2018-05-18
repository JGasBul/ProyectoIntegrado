package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Error extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Error() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 892, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblDniIncorrecto = new JLabel("Ha habido un error, revise los campos porfavor");
		lblDniIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniIncorrecto.setFont(new Font("Tahoma", Font.PLAIN, 38));
		contentPane.add(lblDniIncorrecto, BorderLayout.CENTER);
	}

}
