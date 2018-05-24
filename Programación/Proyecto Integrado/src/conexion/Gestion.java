package conexion;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import vista.Login;

public class Gestion {
	private Conexion_BD con=new Conexion_BD();
	private Informacion inf=new Informacion(Login.nom);
	private String DNI;
	private double Saldo;
	public Gestion() {
		inf.users();
		this.DNI=inf.getDni();
	}
	public void añadir_saldo(double Saldo) {
		Statement orden = null;
		this.Saldo=Saldo;
		con.connectDB();

		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "CALL `Añadir_Saldo`('"+this.DNI+"', '"+this.Saldo+"')";
			orden.executeUpdate(sql);

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
		}
	}
	public void restar_saldo(double Saldo) {
		Statement orden = null;
		this.Saldo=Saldo;
		con.connectDB();

		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "CALL `Restar_Saldo`('"+this.DNI+"', '"+this.Saldo+"')";
			orden.executeUpdate(sql);

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
		}


	}
	public void Pulsaciones(boolean Ganador,double Saldo) {
		Statement orden = null;
		this.Saldo=Saldo;
		con.connectDB();

		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "CALL `Pulsaciones`('"+Ganador+"','"+this.DNI+"', '"+this.Saldo+"')";
			orden.executeUpdate(sql);

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
		}


	}

}
