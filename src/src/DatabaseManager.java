package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
//	private static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/";
//	private static String PASSWORD = "";
//	private static String USERNAME = "SA";
	static Connection con = null;
	
	public static void getConnection() throws SQLException
	{			     
	      try {
	         //Registering the HSQLDB JDBC driver
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         //Creating the connection with HSQLDB
	         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
	         if (con!= null){
	            System.out.println("Connection created successfully");
	            
	         }else{
	            System.out.println("Problem with creating connection");
	         }
	      
	      }  catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	}
	
	public static void registroCliente(String DNI, String nombre, String apellidos,
			String contrasenna, String direccion, String provincia) throws SQLException {
		PreparedStatement pst = null;
		try {
			getConnection();
			pst = con.prepareStatement("insert into clientes values (?, ?, ?, ?, ?, ?, USER)");
			pst.setString(1, DNI);
			pst.setString(2, nombre);
			pst.setString(3, apellidos);
			pst.setString(4, contrasenna);
			pst.setString(5, direccion);
			pst.setString(6, provincia);
			pst.executeQuery();
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}
	
	public static boolean existeClientePorDNI(String dni) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			getConnection();
			pst = con.prepareStatement("select * from clientes where dni = ?");
			pst.setString(1, dni);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
	}
	
	public static Cliente checkLogin(String dni, String password) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			getConnection();
			pst = con.prepareStatement("select nombre, apellidos, contrasenna, "
					+ "direccion, provincia from clientes where dni = ?");
			pst.setString(1, dni);
			rs = pst.executeQuery();
			String nombre, apellidos, pw, direccion, provincia;
			Cliente c = null;
			if(rs.next()) {
				nombre = rs.getString(1);
				apellidos = rs.getString(2);
				pw = rs.getString(3);
				direccion = rs.getString(4);
				provincia = rs.getString(5);
//				String nombre, String apellidos, String direccion, String contrasenna, String usuario,
//				String provincia
				c = new Cliente(nombre, apellidos, direccion, pw, dni, provincia);
			}
			return c;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
	}
}
