package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager 
{
	private static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/labdb";
	private static String PASSWORD = "";
	private static String USERNAME = "SA";
	
	public static Connection getConnection() throws SQLException
	{			
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			return DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
	}
		
	public static ArrayList<String[]> getNombresEquipo() throws SQLException
	{
		ArrayList<String[]> results = new ArrayList<String[]>();
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		String texto = "select * from miembros_equipo;";
		ResultSet rs = st.executeQuery(texto);
		while(rs.next())
		{
			String[] result = new String[3];
			result[0] = rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS");
			result[1] = rs.getString("DNI");
			result[2] = rs.getString("UO");
			results.add(result);
//			System.out.println("Nombre: " + rs.getString("NOMBRE")+ " APELLIDO: " 
//					+ rs.getString("APELLIDOS") + "DNI: " + rs.getString("DNI")
//					+ "UO: "+rs.getString("UO") );
		}
		rs.close();
		st.close();
		con.close();
		
		return results;
		
	}
	
	public static ArrayList<String[]> getAtletasSinPagar() throws SQLException
	{
		ArrayList<String[]> results = new ArrayList<String[]>();
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		String texto = "select a.nombre as nombre, a.apellidos as apellidos, a.dni as DNI, c.nombre as carrera "
				+ "from atleta a, carrera c "
				+ "where a.estado = 'inscrito' and a.fk_carrera = c.nombre";
		ResultSet rs = st.executeQuery(texto);
		while(rs.next())
		{
			String[] result = new String[4];
			result[0] = rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS");
			result[1] = rs.getString("DNI");
			result[2] = rs.getString("CARRERA");
			result[3] = "En plazo";
			results.add(result);
		}
		rs.close();
		st.close();
		con.close();
		
		return results;
	}
	
	public static ArrayList<String[]> getAtletasFueraPlazoPago() throws SQLException
	{
		ArrayList<String[]> results = new ArrayList<String[]>();
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		String texto = "select dni, fk_carrera "
				+ "from atleta "
				+ "where (current_date - fecha_inscripcion) >= 2 "
				+ "and estado = 'inscrito'";
		ResultSet rs = st.executeQuery(texto);
		while(rs.next())
		{
			String[] result = new String[2];
			result[0] = rs.getString("DNI");
			result[1] = rs.getString("FK_CARRERA");
			results.add(result);
		}
		rs.close();
		st.close();
		con.close();
		
		return results;
	}
	
	public static void actualizarPagado(String DNI, String carrera) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("update atleta set estado = 'pagado' where dni = ? and fk_carrera = ?");
		
		st.setString(1, DNI);
		st.setString(2, carrera);
		
		st.execute();

		st.close();
		con.close();
	}
	
	
	//Con este metodo cogemos los corredores de la bbdd ya ordenados por tiempo
		public static List<String[]> getCorredores() throws SQLException
		{
			List<String[]> results = new ArrayList<String[]>();
			
			Connection con = getConnection();
			Statement st = con.createStatement();
			String texto = "select * from atleta order by tiempo asc;";
			ResultSet rs = st.executeQuery(texto);
			while(rs.next())
			{
				String[] result = new String[10];
				result[0] = rs.getString("DNI");	
				result[1] = rs.getString("NOMBRE");
				result[2] = rs.getString("APELLIDOS");
				result[3] = rs.getString("SEXO");
				result[4] = rs.getString("FECHA_NACIMIENTO");
				result[5] = rs.getString("FK_CARRERA");
				result[6] = rs.getString("FECHA_INSCRIPCION");
				result[7] = rs.getString("ESTADO");
				result[8] = rs.getString("TIEMPO");
				result[9] = rs.getString("DORSAL");
				results.add(result);
			}
			rs.close();
			st.close();
			con.close();
			
			return results;
			
		}
		
		public static ArrayList<String> getCarreras() throws SQLException
		{
			ArrayList<String> carreras = new ArrayList<String>();
			
			Connection con = getConnection();
			Statement st = con.createStatement();
			String texto = "select nombre from carrera";
			ResultSet rs = st.executeQuery(texto);
			while(rs.next())
			{
				String result = rs.getString(1);
				carreras.add(result);
			}
			rs.close();
			st.close();
			con.close();
			
			return carreras;
		}
		
		/*
		 * Devuelve un array de arrays con los datos de todos los atletas en la base de datos. No muy Ãºtil.
		 */
		
		public static ArrayList<String[]> getAtletas() throws SQLException
		{
			ArrayList<String[]> results = new ArrayList<String[]>();
			Connection con = getConnection();
			Statement st = con.createStatement();
			String texto = "select dni,nombre,apellidos,fecha_nacimiento,fk_carrera,estado from atletas";
			ResultSet rs = st.executeQuery(texto);
			while(rs.next())
			{
				String[] result = new String[6];
				result[0] = rs.getString("DNI");
				result[1] = rs.getString("NOMBRE");
				result[2] = rs.getString("APELLIDOS");
				//result[3] = rs.getDate("FECHA_NACIMIENTO");
				result[4] = rs.getString("FK_CARRERA");
				result[5] = rs.getString("ESTADO");
				results.add(result);
			}
			rs.close();
			st.close();
			con.close();		
			return results;
		}
		
		/*
		 * Para un atleta pasado como parÃ¡metro (dni) confirma si estÃ¡ o no registrado en cierta carrera(pasada como parÃ¡metro)
		 */
		public static boolean atletaEstaEnCarrera(String dniAtleta, String fk_carrera) throws SQLException {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement("select dni,fk_carrera from atleta where dni = ? and fk_carrera = ?");
			ps.setString(1, dniAtleta);
			ps.setString(2, fk_carrera);
			
			ResultSet rs = ps.executeQuery();
			if(rs.getRow() == 0) {
				rs.close();
				ps.close();
				con.close();	
				return false;
				
			}
			else {
				rs.close();
				ps.close();
				con.close();
				return true;
				
			}
//			String dni = rs.getString("DNI");
//			
//			String fk_carrera1 = rs.getString("fk_carrera");
			
			
			
//			if ((!dni.isEmpty() && fk_carrera1.isEmpty()) || (dni.equals(null) && fk_carrera1.equals(null))) {
//				
//			}
//			else {
//				
//			}
		}
			
		public static boolean a�adirCiertoAtleta(Atleta atleta) throws SQLException {
			Connection con = getConnection();
			String dni = atleta.getDni();
			String nombre = atleta.getNombre();
			String apellidos = atleta.getApellidos();
			String sexo = atleta.getSexo();
			java.sql.Date fechaDeNacimiento = java.sql.Date.valueOf(atleta.getFechaDeNacimiento());
			String fk_carrera = atleta.getFk_carrera();
			java.sql.Date fecha_inscripcion = java.sql.Date.valueOf(atleta.getFecha_inscripcion());
			String estado = atleta.getEstado();
			String tiempo = atleta.getTiempo();
			String dorsal = atleta.getDorsal();
			
			PreparedStatement ps = con.prepareStatement("insert into atleta values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setString(4, sexo);
			ps.setDate(5, fechaDeNacimiento);
			ps.setString(6, fk_carrera);
			ps.setDate(7, fecha_inscripcion);
			ps.setString(8, estado);
			ps.setString(9 , dorsal);
			ps.setString(10, tiempo);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}
			else
				return false;
				
		}
		
		public static void a�adirTiempoAtleta(String carrera, String tiempo, String dni) throws SQLException {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement("UPDATE ATLETA SET tiempo = ? WHERE dni = ? and fk_carrera = ?");
			if(tiempo.equals("---")) {
				ps.setString(1, null);
			}
			else {
				ps.setString(1, tiempo);
			}
			ps.setString(2, dni);
			ps.setString(3, carrera);
			
			ps.executeUpdate();
			
			con.close();
		}
		
		public static ArrayList<String> getDNIs(String carrera) throws SQLException
		{
			ArrayList<String> dnis = new ArrayList<String>();
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select dni from atleta where fk_carrera = ?");
			ps.setString(1, carrera);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				dnis.add(rs.getString("DNI"));
			}
			con.close();		
			return dnis;
		}
		
		/*
		 * Lista atletas segÃºn una carrera pasada como parÃ¡metro
		 */
		public static ArrayList<String[]> listarAtletas(String fk_carrera) throws SQLException {
			ArrayList<String[]> c = new ArrayList<String[]>();
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select dni, nombre, sexo, fecha_inscripcion, estado, dorsal"
					+ " from atleta where fk_carrera= ? order by fecha_inscripcion, estado");
			ps.setString(1, fk_carrera);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String[] a = new String[6];
				a[0] = rs.getString("dni");
				a[1] = rs.getString("nombre");
				a[2] = rs.getString("sexo");
				a[3] = rs.getString("fecha_inscripcion");
				a[4] = rs.getString("estado");
				a[5] = rs.getString("dorsal");
				c.add(a);
				
			}
			rs.close();
			ps.cancel();
			con.close();
			return c;
			
		}
		
		public static boolean existeCarrera(String carrera) throws SQLException
		{
			boolean coincide = false;
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select nombre from carrera where nombre = ?");
			ps.setString(1, carrera);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				coincide = rs.getString("nombre").equals(carrera);
			}
			return coincide;
		}
		
		//Recibe con el mismo formato con que listarAtletas devuelve
		public static void actualizarDorsales(ArrayList<String[]> atletas, String carrera) throws SQLException
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update atleta set dorsal = ? where dni = ? and fk_carrera = ?");
			for (String[] a : atletas)
			{
				ps.setString(1, a[5]);
				ps.setString(2, a[0]);
				ps.setString(3, carrera);
				ps.executeUpdate();
			}
		}
		
		public static int getSiguienteDorsalDisponible(String carrera) throws SQLException
		{
			ArrayList<String[]> c = new ArrayList<String[]>();
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select dorsal from atleta where fk_carrera = ? order by dorsal asc");
			ps.setString(1, carrera);
			ResultSet rs = ps.executeQuery();
			boolean haLlegadoADiez = false;
			int nextOne = 1;
			while(rs.next()) 
			{
				if(rs.getString("dorsal") != null)
				{
					int number = Integer.parseInt(rs.getString("dorsal"));
					if(!haLlegadoADiez)
					{
						if(number < 10) nextOne = number +1;
						else if (nextOne == 10) haLlegadoADiez = true;
					}
					else
						nextOne = number +1;
				}
			}
			rs.close();
			ps.cancel();
			con.close();
			return nextOne;
		}
		
		public static void a�adirDorsalCorredor(String dni, String carrera, String dorsal) throws SQLException
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update atleta set dorsal = ? where dni = ? and fk_carrera = ?");
			ps.setString(1, dorsal);
			ps.setString(2, dni);
			ps.setString(3, carrera);
			ps.executeUpdate();
		}
	
		public static ArrayList<String[]> getAtletasSinPagarCarrera(String carrera) throws SQLException
		{
			ArrayList<String[]> results = new ArrayList<String[]>();
			
			Connection con = getConnection();
			String texto = "select nombre as nombre, apellidos as apellidos, dni as DNI, fk_carrera as carrera "
					+ "from atleta  "
					+ "where estado = 'inscrito' and fk_carrera = ?";
			PreparedStatement st = con.prepareStatement(texto);
			st.setString(1, carrera);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				String[] result = new String[4];
				result[0] = rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS");
				result[1] = rs.getString("DNI");
				result[2] = rs.getString("CARRERA");
				result[3] = "En plazo";
				results.add(result);
			}
			rs.close();
			st.close();
			con.close();
			
			return results;
		}
	
		public static String comprobarAtletaPagado(String dni, String carrera) throws SQLException
		{
			String estado = "vacio";
			Connection con = getConnection();
			String texto = "select estado as estado "
					+ "from atleta  "
					+ "where dni = ? and fk_carrera = ?";
			PreparedStatement st = con.prepareStatement(texto);
			st.setString(1, dni);
			st.setString(2, carrera);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				String result = new String();
				result = rs.getString("estado");
				if(result.equals("pagado")) {
					estado = "pagado";
				}
			}
			return estado;
		}
		
<<<<<<< HEAD
		public static boolean comprobarAtletaPagado(String dni, String carrera) throws SQLException
		{
			boolean pagado = false;
			Connection con = getConnection();
			String texto = "select estado as estado "
					+ "from atleta  "
					+ "where dni = ? and fk_carrera = ?";
			PreparedStatement st = con.prepareStatement(texto);
			st.setString(1, dni);
			st.setString(2, carrera);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				String result = new String();
				result = rs.getString("estado");
				if(result.equals("pagado")) {
					pagado = true;
				}
			}
			return pagado;
		}
		
}
=======
}

>>>>>>> branch 'master' of https://github.com/Fireruner/IPSL4-4
