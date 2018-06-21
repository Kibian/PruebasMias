package src;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			pst = con.prepareStatement("insert into clientes values (?, ?, ?, ?, ?, ?)");
			pst.setString(1, DNI);
			pst.setString(2, nombre);
			pst.setString(3, apellidos);
			pst.setString(4, contrasenna);
			pst.setString(5, direccion);
			pst.setString(6, provincia);
			pst.execute();
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
	
	public static boolean existeTransportistaPorDNI(String dni) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			getConnection();
			pst = con.prepareStatement("select * from transportistas where dni = ?");
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
			pst = con.prepareStatement("select dni, nombre, contrasenna, provincia "
					+ "from transportistas where dni = ? and contrasenna = ?");
			pst.setString(1, dni);
			pst.setString(2, password);
			rs = pst.executeQuery();
			String nombre, contrasenna, dniObtenido,
			provincia;
			Transportista t = null;
			if(rs.next()) {
				nombre = rs.getString(2);
				dniObtenido = rs.getString(1);
				contrasenna = rs.getString(3);
				provincia = rs.getString(4);
				t = new Transportista(contrasenna, dniObtenido, nombre, provincia);
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
					+ "lugarenvio, estado, precio, lugarrecogida, localizacionactual from envios where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			String busquedaadomicilio, envioadomicilio, receptordni, emisordni, transportistadni,
			vehiculomatricula, provinciaenvio, provinciarecogida, lugarenvio, lugarrecogida, estado, localizacionactual;
			Double precio;
			Envio e = null;
			if(rs.next()) {
				busquedaadomicilio = rs.getString(1);
				envioadomicilio = rs.getString(2);
				receptordni = rs.getString(3);
				emisordni = rs.getString(4);
				transportistadni = rs.getString(5);
				vehiculomatricula = rs.getString(6);
				provinciaenvio = rs.getString(7);
				provinciarecogida = rs.getString(8);
				lugarenvio = rs.getString(9);
				estado = rs.getString(10);
				precio = rs.getDouble(11);
				lugarrecogida = rs.getString(12);
				localizacionactual = rs.getString(13);
				boolean bad = false;
				boolean ead = false;
				if(busquedaadomicilio.equals("Si")) {
					bad = true;
				}
				if(envioadomicilio.equals("Si")) {
					ead = true;
				}
				e = new Envio(id, bad, ead, receptordni, emisordni, 
						transportistadni, vehiculomatricula, provinciaenvio, provinciarecogida,
						lugarenvio, lugarrecogida, estado, precio, localizacionactual);
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
		String lugarRecogida = envio.getLugarRecogida();
		String localizacionactual = envio.getUbicacionActual();
		boolean bad = envio.isBusquedaADomicilio();
		boolean ead = envio.isEnvioADomicilio();
		String badS = "No";
		String eadS = "No";
		if(bad) {
			badS = "Si";
		}
		if(ead) {
			eadS = "Si";
		}
		PreparedStatement pst = null;
		try {
			getConnection();
			pst = con.prepareStatement("insert into envios values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, maxId()+1);
			pst.setString(2, badS);
			pst.setString(3, eadS);
			pst.setString(4, receptor);
			pst.setString(5, emisor);
			pst.setString(6, transportistaDNI);
			pst.setString(7, vehiculoMatricula);
			pst.setString(8, provinciaD);
			pst.setString(9, provinciaO);
			pst.setString(10, lugarEnvio);
			pst.setString(11, estado);
			pst.setDouble(12, precio);
			pst.setString(13, lugarRecogida);
			pst.setString(14, localizacionactual);
			pst.execute();
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
				String[] o = {new Integer(rs.getInt(1)).toString(), rs.getString(2), rs.getString(4), rs.getString(3), new Double(rs.getDouble(5)).toString()};
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
		pst = con.prepareStatement("update envios set envioadomicilio = ?, lugarenvio = ? where id = ?");
		pst.setString(1, envioADomicilio);
		pst.setString(2, lugarEnvio);
		pst.setInt(3, id);
		pst.execute();
	}

	public static void updatePrecioEnvio(Integer id, Double precioNuevo) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		pst = con.prepareStatement("update envios set precio = ? where id = ?");
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
			if(rs.getString(4).equals("Oficina")) {
				Edificio e = new Oficina(rs.getInt(1), rs.getString(3), rs.getString(2));
				result.add(e);
			}
			else if(rs.getString(4).equals("Almacen")) {
				Edificio e = new Almacen(rs.getInt(1), rs.getString(3), rs.getString(2));
				result.add(e);
			}
			
		}
		return result;
	}

	public static List<Transportista> getTransportistasProvincia(String provincia) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transportista> result = new ArrayList<Transportista>();
		getConnection();
		pst = con.prepareStatement("select dni, nombre, contrasenna, provincia "
				+ "from transportistas where provincia = ?");
		pst.setString(1, provincia);
		rs=pst.executeQuery();
		while(rs.next()) {
			Transportista t = new Transportista(rs.getString(3), rs.getString(1),
					rs.getString(2), rs.getString(4));
			result.add(t);
		}
		return result;
	}

	public static List<Vehiculo> getVehiculosDeProvincia(String provincia) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Vehiculo> result = new ArrayList<Vehiculo>();
		getConnection();
		pst = con.prepareStatement("select matricula, marca, tipo, edificioId, provincialocalizacion "	
				+ "from vehiculos, edificios where provincialocalizacion = ? and id = edificioid");
		pst.setString(1, provincia);
		rs=pst.executeQuery();
		while(rs.next()) {
			Vehiculo v = new Vehiculo(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getInt(4));
			result.add(v);
		}
		return result;
	}
	
	public static List<Envio> getEnviosByDNITransportista(String dniTransportista) throws SQLException{
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Envio> envios = new ArrayList<Envio>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, busquedaadomicilio, envioadomicilio, receptordni, "
					+ "emisordni, transportistadni, vehiculomatricula, provinciadestino, provinciaorigen, "
					+ "lugarenvio, estado, precio, lugarrecogida, localizacionactual from envios where transportistadni = ?");
			pst.setString(1, dniTransportista);
			rs = pst.executeQuery();
			String busquedaadomicilio, envioadomicilio, receptordni, emisordni, transportistadni,
			vehiculomatricula, provinciadestino, provinciaorigen, lugarenvio, lugarrecogida, localizacionactual, estado;
			Double precio;
			Integer id;
			Envio e = null;
			while(rs.next()) {
				id = rs.getInt(1);
				busquedaadomicilio = rs.getString(2);
				envioadomicilio = rs.getString(3);
				receptordni = rs.getString(4);
				emisordni = rs.getString(5);
				transportistadni = rs.getString(6);
				vehiculomatricula = rs.getString(7);
				provinciadestino = rs.getString(8);
				provinciaorigen = rs.getString(9);
				lugarenvio = rs.getString(10);
				estado = rs.getString(11);
				precio = rs.getDouble(12);
				lugarrecogida = rs.getString(13);
				localizacionactual = rs.getString(14);
				boolean bad = false;
				boolean ead = false;
				if(busquedaadomicilio.equals("Si")) {
					bad = true;
				}
				if(envioadomicilio.equals("Si")) {
					ead = true;
				}
				e = new Envio(id, bad, ead, receptordni, emisordni, 
						transportistadni, vehiculomatricula, provinciadestino, provinciaorigen,
						lugarenvio, lugarrecogida, estado, precio, localizacionactual);
				envios.add(e);
			}
			return envios;
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			rs.close();
			pst.close();
		}
	}

	public static List<String[]> getEnviosTransportista(String dni) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();
		getConnection();
		pst = con.prepareStatement("select id, lugarenvio, lugarrecogida, vehiculomatricula from envios where transportistadni = ?");
		pst.setString(1, dni);
		rs = pst.executeQuery();
		while(rs.next()) {
			String[] resultSingle = {String.valueOf(rs.getInt(1)), rs.getString(3), rs.getString(2), rs.getString(4)};
			result.add(resultSingle);
		}
		return result;
	}

	public static void updateEstadoEnvio(Envio envio) throws SQLException {
		PreparedStatement pst = null;
		int id = envio.getId();
		String estado = envio.getEstado();
		getConnection();
		pst = con.prepareStatement("update envios set estado = ? where id = ?");
		pst.setString(1, estado);
		pst.setInt(2, id);
		pst.execute();
	}

	public static void updateEstadoYTVEnvio(Envio envio) throws SQLException {
		PreparedStatement pst = null;
		int id = envio.getId();
		String estado = envio.getEstado();
		String transportista = envio.getTransportista();
		String vehiculo = envio.getVehiculo();
		getConnection();
		pst = con.prepareStatement("update envios set estado = ?, transportistadni = ?, vehiculomatricula = ?, localizacionactual = ? where id = ?");
		pst.setString(1, estado);
		pst.setString(2, transportista);
		pst.setString(3, vehiculo);
		pst.setString(4, envio.getUbicacionActual());
		pst.setInt(5, id);
		pst.execute();
		
	}
	
	public static void updateLugarEntregaEnvio(Envio envio) throws SQLException {
		PreparedStatement pst = null;
		int id = envio.getId();
		String lugarEntrega = envio.getLugarEnvio();
		getConnection();
		pst = con.prepareStatement("update envios set lugarenvio = ? where id = ?");
		pst.setString(1, lugarEntrega);
		pst.setInt(2, id);
		pst.execute();
	}

	public static Vehiculo getVehiculoByMatricula(String matriculaElegida) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		getConnection();
		pst = con.prepareStatement("select marca, tipo, edificioid from vehiculos "
				+ "where matricula = ?");
		pst.setString(1, matriculaElegida);
		rs = pst.executeQuery();
		Vehiculo v = null;
		if(rs.next()) {
			v = new Vehiculo(matriculaElegida, rs.getString(1), rs.getString(2), rs.getInt(3));
		}
		return v;
	}
	
	public static Envio getEnvioByMatricula(String matriculaElegida) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		getConnection();
		pst = con.prepareStatement("select id, busquedaadomicilio, envioadomicilio, receptordni,"
				+ " emisordni, transportistadni, provinciadestino, provinciaorigen, lugarenvio, "
				+ "estado, precio, lugarrecogida, localizacionactual from envios "
				+ "where vehiculomatricula = ?");
		pst.setString(1, matriculaElegida);
		rs = pst.executeQuery();
		Envio e = null;
		if(rs.next()) {
			boolean bad = false;
			boolean ead = false;
			if(rs.getString(2).equals("Si")) {
				bad = true;
			}
			if(rs.getString(3).equals("Si")) {
				ead = true;
			}
//			Integer id, boolean busquedaADomicilio, boolean envioADomicilio, String receptor, String emisor, String transportista, String vehiculo,
//			String provinciaDestino, String provinciaOrigen, String lugarEnvio, String lugarRecogida, String estado, Double precio
			e = new Envio(rs.getInt(1), bad, ead, rs.getString(4), rs.getString(5), rs.getString(6), matriculaElegida, rs.getString(7), rs.getString(8),
					rs.getString(9), rs.getString(12), rs.getString(10), rs.getDouble(11), rs.getString(13));
			
		}
		return e;
		
	}

	public static Edificio getEdificioById(int edificioId) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		getConnection();
		pst = con.prepareStatement("select id, nombre, provincialocalizacion, tipo from edificios "
				+ "where id = ?");
		pst.setInt(1, edificioId);
		rs = pst.executeQuery();
		Edificio e = null;
		if(rs.next()) {
			if(rs.getString(4).equals("Oficina"))
				e = new Oficina(edificioId, rs.getString(3), rs.getString(2));
			else if (rs.getString(4).equals("Almacen")) {
				e = new Almacen(edificioId, rs.getString(3), rs.getString(2));
			}
		}
		return e;
	}
	
	public static boolean enviosPendientes(String dni) throws SQLException {
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		boolean result = false;
		getConnection();
		pst = con.prepareStatement("select id, estado from envios "
				+ "where emisordni = ?");
		pst.setString(1, dni);
		rs = pst.executeQuery();
		pst2 = con.prepareStatement("select id, estado from envios "
				+ "where receptordni = ?");
		rs2 = pst2.executeQuery();
		while(rs.next()) {
			String estado = rs.getString(2);
			if(estado.equals("Entregado-Domicilio") || estado.equals("Entregado-Edificio")) { //si esta entregado en la casa o en el almacen sea porque es ahi o por fallos
				result = true;
			}
		}
		while(rs2.next()) {
			String estado = rs.getString(2);
			if(estado.equals("Entregado-Domicilio") || estado.equals("Entregado-Edificio")) { //si esta entregado en la casa o en el almacen sea porque es ahi o por fallos
				result = true;
			}
		}
		return result;
	}
	
	public static void updateCliente(String dni, String nombre, String apellidos, String password, String direccion, String provincia) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		if(nombre.length()==0 && apellidos.length()==0 && password.length() == 0 && direccion.length()==0 && provincia.length()==0) {
			
		}
		else {
			if(nombre.length()!=0) {
				pst = con.prepareStatement("update clientes set nombre = ? where dni = ?");
				pst.setString(1, nombre);
				pst.setString(2, dni);
				pst.execute();
			}
			if(apellidos.length()!=0) {
				pst = con.prepareStatement("update clientes set apellidos = ? where dni = ?");
				pst.setString(1, apellidos);
				pst.setString(2, dni);
				pst.execute();
			}
			if(password.length()!=0) {
				pst = con.prepareStatement("update clientes set contrasenna = ? where dni = ?");
				pst.setString(1, password);
				pst.setString(2, dni);
				pst.execute();
			}
			if(direccion.length()!=0) {
				pst = con.prepareStatement("update clientes set direccion = ? where dni = ?");
				pst.setString(1, direccion);
				pst.setString(2, dni);
				pst.execute();
			}
			if(provincia.length()!=0) {
				pst = con.prepareStatement("update clientes set provincia = ? where dni = ?");
				pst.setString(1, provincia);
				pst.setString(2, dni);
				pst.execute();
			}
		}
		
	}

	public static void addFallo(Fallo f) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		pst = con.prepareStatement("insert into fallosentregas values(?, ?, ?, ?, ?, ?, ?)");
		pst.setInt(1, f.getId());
		pst.setString(2, f.getReceptorDni());
		pst.setString(3, f.getLugarEntrega());
		pst.setString(4, f.getRazon());
		pst.setString(5, f.getDniTransportista());
		pst.setInt(6, f.getNumeroFallos());
		pst.setDate(7, f.getProximaEntrega());
		pst.execute();
	}
	
	public static void updateFallo(Fallo f) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		pst = con.prepareStatement("update fallosentregas set lugarentrega=?, "
				+ "razon = ?, numerofallos= ?, fechaproximaentrega = ? where id = ?");
		pst.setString(1, f.getLugarEntrega());
		pst.setString(2, f.getRazon());
		pst.setInt(3, f.getNumeroFallos());
		pst.setDate(4, f.getProximaEntrega());
		pst.setInt(5, f.getId());
		pst.execute();
	}
	
	public static List<String[]> getVehiculos() throws SQLException{
		PreparedStatement pst = null;
		getConnection();
		List<String[]> sol = new ArrayList<String[]>();
		pst = con.prepareStatement("select matricula, marca, tipo, edificioId from vehiculos");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String[] s = {rs.getString(1), rs.getString(2), rs.getString(3), Integer.toString(rs.getInt(4))};
			sol.add(s);
		}
		return sol;
	}
	
	public static List<String[]> getEnviosARecoger() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, receptordni from envios where estado = 'En Oficina' and transportistadni = '' "
					+ "or estado = 'En Almacen' and transportistadni = ''");
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String dniR = rs.getString(2);
				String[] in = {String.valueOf(id), dniR};
				result.add(in);
			}
			return result;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}
	
	public static List<String[]> getEnviosAEntregar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, emisordni from envios where estado = '' and busquedaadomicilio='No'");
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String dniE = rs.getString(2);
				String[] in = {String.valueOf(id), dniE};
				result.add(in);
			}
			return result;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}
	
	public static boolean isEntregaADomicilio(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean sol = false;
		try {
			getConnection();
			pst = con.prepareStatement("select envioadomicilio from envios where id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String envioADomicilio = rs.getString(1);
				if(envioADomicilio.equals("Si")) {
					sol = true;
				}
			}
			return sol;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}

	public static List<String[]> getEnviosPorRecogerDeTransportista(String dni) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, receptordni, lugarenvio from envios where estado='Recogida a domicilio' and TRANSPORTISTADNI = ? or estado = 'En Oficina' and TRANSPORTISTADNI = ?"
					+ " or estado = 'En Almacen' and TRANSPORTISTADNI = ?");
			pst.setString(1, dni);
			pst.setString(2, dni);
			pst.setString(3, dni);
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String dniE = rs.getString(2);
				String lugarEnvio = rs.getString(3);
				String[] in = {String.valueOf(id), dniE, lugarEnvio};
				result.add(in);
			}
			return result;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}

	public static List<String[]> getEnviosPorEntregarDeTransportista(String dni) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, receptordni, lugarenvio from envios where estado='En Transporte' and TRANSPORTISTADNI = ?");
			pst.setString(1, dni);
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String dniR = rs.getString(2);
				String lugarEnvio = rs.getString(3);
				String[] in = {String.valueOf(id), dniR, lugarEnvio};
				result.add(in);
			}
			return result;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
			pst.close();
		}
	}

	public static void añadirRegistro(RegistroMovimiento registroMovimiento) throws SQLException {
		PreparedStatement pst = null;
		try {
			getConnection();
			pst = con.prepareStatement("insert into registros values (?, ?, ?, ?, ?)");
			pst.setString(1, registroMovimiento.getDniTransportista());
			pst.setString(2, registroMovimiento.getVehiculo());
			pst.setInt(3, registroMovimiento.getIdEnvio());
			pst.setString(4, registroMovimiento.getUbicacionActual());
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pst.setDate(5, sqlDate);
			pst.execute();
		} catch(SQLException e) {
			throw new SQLException(e);
		}finally {
//			pst.close();
		}
		
	}

	public static List<String[]> getEnviosEntreProvincias() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();
		try {
			getConnection();
			pst = con.prepareStatement("select id, provinciaorigen, provinciadestino, localizacionactual from envios where provinciaorigen<>provinciadestino and estado='En Oficina' or "
					+ "provinciaorigen<>provinciadestino and estado='En Almacen'");
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String provinciaEmisor = rs.getString(2);
				String provinciaReceptor = rs.getString(3);
				String[] in = {String.valueOf(id), provinciaEmisor, provinciaReceptor};
				if(rs.getString(4).contains(provinciaEmisor))
					result.add(in);
			}
			return result;
		}catch(SQLException e) {
			throw new SQLException(e);
		}finally {
//			pst.close();
		}
	}

	public static List<String[]> getRegistros() throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		List<String[]> sol = new ArrayList<String[]>();
		pst = con.prepareStatement("select idenvio, transportistadni, vehiculomatricula, ubicacionactual, fecha from registros");
		ResultSet rs = pst.executeQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			String[] s = {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), df.format(rs.getDate(5))};
			sol.add(s);
		}
		return sol;
	}

	public static Fallo getFalloById(int idEntero) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		pst = con.prepareStatement("select id, receptordni, lugarentrega, razon, dnitransportista, numerofallos, fechaproximaentrega "
				+ "from fallosentregas where id = ?");
		pst.setInt(1, idEntero);
		ResultSet rs = pst.executeQuery();
		Fallo e = null;
		while(rs.next()) {
			e = new Fallo(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getDate(7), rs.getInt(6));
		}
		return e;
	}
	
	public static List<String[]> getFallos(String cliente) throws SQLException{
		PreparedStatement pst = null;
		getConnection();
		List<String[]> sol = new ArrayList<String[]>();
		pst = con.prepareStatement("select id ,lugarentrega, razon, numerofallos, fechaProximaEntrega from fallosentregas");
		ResultSet rs = pst.executeQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			PreparedStatement pst2 = con.prepareStatement("select emisordni from envios where id = ?");
			int id = rs.getInt(1);
			pst2.setInt(1, id);
			ResultSet rs2 = pst2.executeQuery();
			while(rs2.next()) {
				if(rs2.getString(1).equals(cliente)) {
					String[] s = {rs.getString(2), rs.getString(3), Integer.toString(rs.getInt(4)), df.format(rs.getDate(5))};
					sol.add(s);
				}
			}
		}
		return sol;
	}

	public static List<String[]> getFallosWithConditions(String dni) throws SQLException {
		PreparedStatement pst = null;
		getConnection();
		List<String[]> sol = new ArrayList<String[]>();
		pst = con.prepareStatement("select id, receptordni, lugarentrega, razon, numerofallos, fechaProximaEntrega from fallosentregas "
				+ "where dnitransportista = ?");
		pst.setString(1, dni);
		ResultSet rs = pst.executeQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date x = java.util.Calendar.getInstance().getTime();
		java.sql.Date sqlDate = new java.sql.Date(x.getTime());
		while(rs.next()) {
			Envio e = getEnvioById(rs.getInt(1));
			if(rs.getInt(5)!=4 && (sqlDate.compareTo(rs.getDate(6))==-1 || sqlDate.toString().equals(rs.getDate(6).toString())) && (!e.getEstado().equals("Entregado al Cliente") ||
					!e.getEstado().equals("Recogido-Cliente") || !e.getLugarEnvio().equals(e.getUbicacionActual()))) {
				String[] s = {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), df.format(rs.getDate(6)), rs.getString(5)};
				sol.add(s);
			}
		}
		return sol;
	}
	
//	public static List<String[]> getEnviosFallidosDeCliente(String dni) throws SQLException {
//		PreparedStatement pstE = null; //pst cliente emisor
//		PreparedStatement pstR = null; //pst cliente receptor
//		getConnection();
//		List<String[]> sol = new ArrayList<String[]>();
//		pstE = con.prepareStatement("select id, emisordni, receptordni, estado, lugarrecogida from envios where emisordni = ?");
//		pstE.setString(1, dni);
//		pstR = con.prepareStatement("select id, emisordni, receptordni, estado, lugarrecogida from envios where receptordni = ?");
//		pstR.setString(1, dni);
//		ResultSet rs = null;
//		rs = pstE.executeQuery();
//		while (rs.next()) {
//			int numfallos = 0;
//			int idEnvio = rs.getInt(1);
//			String estado = rs.getString(4);
//			PreparedStatement pstFallos = con.prepareStatement("select count(id) from fallosentregas where id = ?");
//			pstFallos.setInt(1, idEnvio);
//			ResultSet rst = pstFallos.executeQuery();
//			if(rst.next()) {
//				numfallos = rst.getInt(1);
//			}
//			if(numfallos>0) {
//				if(estado.equals("En Oficina") || estado.equals("En Almacen")) {
//					numfallos++;
//				}
//				String[] x = {String.valueOf(idEnvio), rs.getString(2), rs.getString(3), String.valueOf(numfallos), estado, rs.getString(5)};
//				sol.add(x);
//			}
//		}
//		return sol;
//	}
}
	
