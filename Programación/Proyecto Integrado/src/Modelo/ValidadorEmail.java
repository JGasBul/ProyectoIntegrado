package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEmail {
	private String email;

	public ValidadorEmail(String email) {
		this.email = email;
	}

	public boolean Validar() {
		boolean temp;
		// Patrón para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar
		String email = this.email;

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			temp=true;
		} else {
			temp=false;
		}
		return temp;
	}

}