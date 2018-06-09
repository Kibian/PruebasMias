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
	private static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/labdb";
	private static String PASSWORD = "";
	private static String USERNAME = "SA";
	
	public static Connection getConnection() throws SQLException
	{			
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			return DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
	}
	
	public static void registroCliente(String nombre, String apellidos, String direccion,
			String provincia, String contrasenna, String usuario) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement("insert into clientes values (" + nombre + ", " + apellidos + ", " + 
					direccion + ", " + provincia + ", " + usuario + ", " + contrasenna +")");
			pst.executeQuery();
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}
}
