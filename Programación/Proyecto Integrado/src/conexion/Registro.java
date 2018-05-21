package conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Registro {
	private String dni,nombre,apellido,seg_Apellido,user,pass,eMail;
	private int telf;
	private Conexion_BD con=new Conexion_BD();
	private String tj;


	public Registro() {
		// TODO Auto-generated constructor stub
	}

	public Registro(String eMail, String dni, String nombre, String apellido, String seg_Apellido, String user, String pass,
			int telf, String tj) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.seg_Apellido = seg_Apellido;
		this.user = user;
		this.pass = pass;
		this.eMail = eMail;
		this.telf = telf;
		this.tj=tj;
	}
	public void insertarUsuario(){
		Statement orden = null;
		con.connectDB();
		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "INSERT INTO `tragaperras`.`usuarios` (`DNI`, `Nombre`, `1ºApellido`, `2ºApellido`, `UserName`, `Telefono`, `Email`, `Contraseña`,`Tarjeta_Credito`) "
					+ "VALUES ('"+this.dni+"','"+this.nombre+"','"+this.apellido+"','"+this.seg_Apellido+"','"+this.user+"',"+this.telf+",'"+this.eMail+"','"+this.pass+"','"+this.tj+"')";
			orden.executeUpdate(sql);
			System.out.println("Usuario registrado con exito");

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
					con.getConexion().close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con.getConexion()!=null)
					con.getConexion().close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
	}





}
