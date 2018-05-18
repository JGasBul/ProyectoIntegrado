package conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Informacion {
	private String dni,nombre,apellido,seg_Apellido,user,eMail;
	private int telf;
	private double saldoTotal,saldoIngresado,saldoGanado,saldoGastado;
	private Conexion_BD con=new Conexion_BD();
	public Informacion(String user) {
		this.user=user;
	}

	public Informacion() {
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSeg_Apellido() {
		return seg_Apellido;
	}

	public void setSeg_Apellido(String seg_Apellido) {
		this.seg_Apellido = seg_Apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getTelf() {
		return telf;
	}

	public void setTelf(int telf) {
		this.telf = telf;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public double getSaldoIngresado() {
		return saldoIngresado;
	}

	public void setSaldoIngresado(double saldoIngresado) {
		this.saldoIngresado = saldoIngresado;
	}

	public double getSaldoGanado() {
		return saldoGanado;
	}

	public void setSaldoGanado(double saldoGanado) {
		this.saldoGanado = saldoGanado;
	}

	public double getSaldoGastado() {
		return saldoGastado;
	}

	public void setSaldoGastado(double saldoGastado) {
		this.saldoGastado = saldoGastado;
	}

	public Conexion_BD getCon() {
		return con;
	}

	public void setCon(Conexion_BD con) {
		this.con = con;
	}

	public void users() {
		ResultSet rs = null;
		Statement orden = null;
		con.connectDB();
		try{
			orden = (Statement) con.getConexion().createStatement();
			String sql = "SELECT * from usuarios WHERE UserName='"+this.user+"'";
			rs = orden.executeQuery(sql);
			//Cogemos los usuarios y recorremos la BBDD mientras haya datos
			while(rs.next()){
				this.dni=rs.getString("DNI");
				this.nombre=rs.getString("Nombre");
				this.apellido=rs.getString("1ºApellido");
				this.seg_Apellido=rs.getString("2ºApellido");
				this.user=rs.getString("UserName");
				this.telf=rs.getInt("Telefono");
				this.eMail=rs.getString("E-mail");
			}
			sql = "SELECT * from saldo WHERE DNI='"+this.dni+"'";
			rs=orden.executeQuery(sql);
			while(rs.next()){
				this.saldoIngresado=rs.getDouble("Saldo_Ingresado");
				this.saldoGastado=rs.getDouble("Saldo_Gastado");
				this.saldoGanado=rs.getDouble("Saldo_Ganado");
				this.saldoTotal=rs.getDouble("Saldo_Total");
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
				if(con.getConexion()!=null)
					con.getConexion().close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}

	}


}
