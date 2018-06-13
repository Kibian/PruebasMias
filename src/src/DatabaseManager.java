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
			pst = con.prepareStatement("insert into clientes values (?, ?, ?, ?, ?, ?, 'USER')");
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
		}
	}
	
	public static Cliente checkLoginCliente(String dni, String password) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			getConnection();
			pst = con.prepareStatement("select nombre, apellidos, "
					+ "direccion, provincia from clientes where dni = ? and contrasenna = ?");
			pst.setString(1, dni);
			pst.setString(2, password);
			rs = pst.executeQuery();
			String nombre, apellidos, direccion, provincia;
			Cliente c = null;
			if(rs.next()) {
				nombre = rs.getString(1);
				apellidos = rs.getString(2);
				direccion = rs.getString(3);
				provincia = rs.getString(4);
				c = new Cliente(nombre, apellidos, direccion, password, dni, provincia);
			}
			return c;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
		}
	}
	
	public static Transportista checkLoginTransportista(String dni, String password) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			getConnection();
			pst = con.prepareStatement("select dni, nombre, contrasenna, disponible "
					+ "from transportistas where dni = ? and contrasenna = ?");
			pst.setString(1, dni);
			pst.setString(2, password);
			rs = pst.executeQuery();
			String nombre, contrasenna, dniObtenido;
			boolean disponible;
			Transportista t = null;
			if(rs.next()) {
				nombre = rs.getString(2);
				dniObtenido = rs.getString(1);
				contrasenna = rs.getString(3);
				disponible = rs.getBoolean(4);
				t = new Transportista(contrasenna, dniObtenido, nombre, disponible);
			}
			return t;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
		}
	}
	
	public static Cliente getCliente(String dni) throws SQLException {
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
				c = new Cliente(nombre, apellidos, direccion, pw, dni, provincia);
			}
			return c;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
		}
	}
	
	public static Envio getEnvioById(Integer id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			getConnection();
			pst = con.prepareStatement("select busquedaadomicilio, envioadomicilio, receptordni, "
					+ "emisordni, transportistadni, vehiculomatricula, provinciadestino, provinciaorigen, "
					+ "lugarenvio, estado, precio from envios where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			String busquedaadomicilio, envioadomicilio, receptordni, emisordni, transportistadni,
			vehiculomatricula, provinciadestino, provinciaorigen, lugarenvio, estado;
			Double precio;
			Envio e = null;
			if(rs.next()) {
				busquedaadomicilio = rs.getString(1);
				envioadomicilio = rs.getString(2);
				receptordni = rs.getString(3);
				emisordni = rs.getString(4);
				transportistadni = rs.getString(5);
				vehiculomatricula = rs.getString(6);
				provinciadestino = rs.getString(7);
				provinciaorigen = rs.getString(8);
				lugarenvio = rs.getString(9);
				estado = rs.getString(10);
				precio = rs.getDouble(11);
				boolean bad = false;
				boolean ead = false;
				if(busquedaadomicilio.equals("Si")) {
					bad = true;
				}
				if(envioadomicilio.equals("Si")) {
					ead = true;
				}
				e = new Envio(bad, ead, receptordni, emisordni, 
						transportistadni, vehiculomatricula, provinciadestino, provinciaorigen,
						lugarenvio, estado, precio);
			}
			return e;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
		}
	}

	public static void registraEnvio(Envio envio) throws SQLException {
		String emisor = envio.getEmisor();
		String receptor = envio.getReceptor();
		String estado = envio.getEstado();
		String lugarEnvio = envio.getLugarEnvio();
		double precio = envio.calculaPrecio();
		String provinciaD = envio.getProvinciaDestino();
		String provinciaO = envio.getProvinciaOrigen();
		String transportistaDNI = envio.getTransportista();
		String vehiculoMatricula = envio.getVehiculo();
		boolean bad = envio.isbusquedaADomicilio();
		boolean ead = envio.isenvioADomicilio();
		PreparedStatement pst = null;
		try {
			getConnection();
			pst = con.prepareStatement("insert into envios values (?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, maxId());
			pst.setBoolean(2, bad);
			pst.setBoolean(3, ead);
			pst.setString(4, receptor);
			pst.setString(5, emisor);
			pst.setString(6, transportistaDNI);
			pst.setString(7, vehiculoMatricula);
			pst.setString(8, provinciaD);
			pst.setString(9, provinciaO);
			pst.setString(10, lugarEnvio);
			pst.setString(11, estado);
			pst.setDouble(12, precio);
			
			pst.executeQuery();
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
		
	}
	
	public static int maxId() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		getConnection();
		pst = con.prepareStatement("select max(id) from envios");
		rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public static List<String[]> getEnviosEmisor(String dni) throws SQLException{
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> objects = new ArrayList<String[]>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, lugarenvio, estado, receptordni, precio from"
					+ " envios where emisordni = ?");
			pst.setString(1, dni);
			rs = pst.executeQuery();
			while(rs.next()) {
				String[] o = {new Integer(rs.getInt(1)).toString(), rs.getString(2), rs.getString(3), rs.getString(4), new Double(rs.getDouble(5)).toString()};
				objects.add(o);
			}
			return objects;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
		}
	}
	
	public static void modifyEnvioById(String envioADomicilio, String lugarEnvio, Integer id) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		pst = con.prepareStatement("update envios set envioadomicilio = ?, lugarenvio = ? from envios where id = ?");
		pst.setString(1, envioADomicilio);
		pst.setString(2, lugarEnvio);
		pst.setInt(3, id);
		pst.execute();
	}

	public static void updatePrecioEnvio(Integer id, Double precioNuevo) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		pst = con.prepareStatement("update envios set precio = ? from envios where id = ?");
		pst.setDouble(1, precioNuevo);
		pst.setInt(2, id);
		pst.execute();		
	}
	
	public static List<Edificio> getEdificiosByProvincia(String provincia) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Edificio> result = new ArrayList<Edificio>();
		getConnection();
		pst = con.prepareStatement("select id, nombre, provincialocalizacion, tipo from edificios "
				+ "where provinciaLocalizacion = ?");
		pst.setString(1, provincia);
		rs = pst.executeQuery();
		while(rs.next()) {
			if(rs.getString(3).equals("Oficina")) {
				Edificio e = new Oficina(rs.getInt(0), rs.getString(2), rs.getString(1));
				result.add(e);
			}
			else if(rs.getString(3).equals("Almacen")) {
				Edificio e = new Almacen(rs.getInt(0), rs.getString(2), rs.getString(1));
				result.add(e);
			}
			
		}
		return result;
	}

	public static List<Transportista> getTransportistas() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transportista> result = new ArrayList<Transportista>();
		getConnection();
		pst = con.prepareStatement("select dni, nombre, contrasenna, disponible "
				+ "from transportistas");
		rs=pst.executeQuery();
		while(rs.next()) {
			Transportista t = new Transportista(rs.getString(2), rs.getString(0),
					rs.getString(1), rs.getBoolean(3));
			result.add(t);
		}
		return result;
	}

	public static List<Vehiculo> getVehiculos() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Vehiculo> result = new ArrayList<Vehiculo>();
		getConnection();
		pst = con.prepareStatement("select matricula, marca, tipo "
				+ "from vehiculos");
		rs=pst.executeQuery();
		while(rs.next()) {
			Vehiculo v = new Vehiculo(rs.getString(0), rs.getString(1),
					rs.getString(2));
			result.add(v);
		}
		return result;
	}
}
