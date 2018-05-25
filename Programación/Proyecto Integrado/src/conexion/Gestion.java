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
	public void Pulsaciones(int ganador,double Saldo) {
		Statement orden = null;
		this.Saldo=Saldo;
		con.connectDB();

		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "CALL `Pulsaciones`('"+ganador+"','"+this.DNI+"', '"+this.Saldo+"')";
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
	public void updateUsuario(String newName,String newPass){
		Statement orden = null;
		con.connectDB();
		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "UPDATE `tragaperras`.`usuarios` SET `UserName`='"+newName+"', `Contraseña`='"+newPass+"' WHERE  `DNI`='"+inf.getDni()+"';";
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
