package conexion;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Conexion_BD {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";

	//DATOS DE LA BBDD
	private String host; //host donde está la base de datos
	private String bbdd; //nombre de la base de datos
	private String userbd; //nombre usuario para acceder base de datos
	private String passbd; //password de usuario
	private String user; //nombre de usuario en la base de datos
	private String pass; //contraseña del usuario
	private String url;  //proporcionará al método DriverManager la dirección de conexión
	//en la forma adeduaca

	//Conexion
	private Connection conexion = null;// maneja la conexión


	//Constructor (le pasaremos los datos necesarios para la conexión)

	public Conexion_BD(String USER,String PASS) {
		this.host="34.204.47.187";
		this.bbdd="tragaperras";
		this.userbd="tragaperras";
		this.passbd="1234";
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd+"?useSSL=false";
	}
	public Conexion_BD() {
		this.host="34.204.47.187";
		this.bbdd="tragaperras";
		this.userbd="tragaperras";
		this.passbd="1234";
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd+"?useSSL=false";
	}


	//Método para conectarse con la BBDD: true si ha conseguido conectarse
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = (Connection) DriverManager.getConnection(this.url,this.userbd,this.passbd);
		}
		catch( SQLException excepcionSql ) //No encuentra la Base de Datos
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch( ClassNotFoundException noEncontroClase) //No encuentra el driver para la conexión
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}

	//Devuelve una instancia de la conexión
	public Connection getConexion(){
		return this.conexion;
	}
	public boolean users() {
		ResultSet rs = null;
		Statement orden = null;
		boolean x=false;
		try{
			orden = (Statement) conexion.createStatement();
			String sql = "SELECT count(Contraseña) FROM usuarios WHERE UserName='"+this.user+"'";
			rs = orden.executeQuery(sql);
			//Cogemos los usuarios y recorremos la BBDD mientras haya datos
			while(rs.next()){
				if(rs.getInt(1)==0) {
					System.out.println("Usuario incorrecto");

				}
				else {
					String sql1 = "SELECT Contraseña FROM usuarios WHERE UserName='"+this.user+"'";
					rs = orden.executeQuery(sql1);
					//Cogemos los usuarios y recorremos la BBDD mientras haya datos

					while(rs.next()){
						if(this.pass.equals(rs.getString("Contraseña"))) {
							System.out.println("Contraseña correcta");
							x=true;
						}
						else {
							System.out.println("Contraseña incorrecta");

						}
					}
				}
			}
			rs.close();
		}catch(SQLException se){
			//Se produce un error con la consulta
			se.printStackTrace();
		}catch(Exception e){
			//Se produce cualquier otro error
			e.printStackTrace();
		}finally{
			//Cerramos los recursos
			try{
				if(orden!=null)
					orden.close();
			}catch(SQLException se){
			}
			try{
				if(conexion!=null)
					conexion.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}
		return x;


	}

}
