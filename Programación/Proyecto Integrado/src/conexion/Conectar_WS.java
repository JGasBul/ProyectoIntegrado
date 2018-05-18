package conexion;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class Conectar_WS {
	private String user,pass;
	public Conectar_WS() {
		// TODO Auto-generated constructor stub
	}
	public Conectar_WS(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean conect() {
		String temp;
		temp=this.user+"@sistemas2018pepe.com";
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://10.2.74.34");

		//Rellenamos con el usuario/dominio y password
		env.put(Context.SECURITY_PRINCIPAL, temp);
		env.put(Context.SECURITY_CREDENTIALS, this.pass);

		DirContext ctx;

		try {
			// Authenticate the logon user
			ctx = new InitialDirContext(env);
			System.out.println("El usuario se ha autenticado correctamente");			
			ctx.close();
			return true;
		} catch (NamingException ex) {
			System.out.println("Ha habido un error en la autenticación");
			return false;
		}

	}


}
