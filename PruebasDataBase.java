package src;
import java.sql.*;
import java.util.*;




public class PruebasDataBase {
	
	
	private static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/labdb";
	private static String PASSWORD = "";
	private static String USERNAME = "SA";

	
	
	
	public static void main(String[] args) throws SQLException {
		
		//CrearTablaPrueba();
		//rellenarTablaPrueba();
		//rellenarConParametros();
		//getNombresEquipo();
		//getAtletasSinPagar();
		//getAtletasFueraPlazoPago();
		//existeCarrera("Iron Man");//true true
		//existeCarrera("IronMan");//false
		System.out.print(getSiguienteDorsalDisponible("Iron Man"));
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
	
	public static ArrayList<String[]> listarAtletas(String fk_carrera) throws SQLException {
		ArrayList<String[]> c = new ArrayList<String[]>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select dni, nombre, sexo, fecha_inscripcion, estado, dorsal"
				+ " from atleta where fk_carrera= ? order by fecha_inscripcion, estado");
		ps.setString(1, fk_carrera);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
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
			System.out.println(coincide);
		}
		System.out.println(coincide);
		return coincide;
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
			System.out.println(result[0] + " " + result[1]);
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
			String[] result = new String[3];
			result[0] = rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS");
			result[1] = rs.getString("DNI");
			result[2] = rs.getString("CARRERA");
			System.out.println(result[0] + " " + result[1] + " " + result[2]);
			results.add(result);
		}
		rs.close();
		st.close();
		con.close();
		
		return results;
	}
	
	public static ArrayList<String> getNombresEquipo() throws SQLException
	{
		ArrayList<String> results = new ArrayList<String>();
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		String texto = "select * from miembros_equipo;";
		ResultSet rs = st.executeQuery(texto);
		while(rs.next())
		{
			System.out.println("Nombre: " + rs.getString("NOMBRE")+ " APELLIDO: " 
					+ rs.getString("APELLIDOS") + "DNI: " + rs.getString("DNI")
					+ "UO: "+rs.getString("UO") );
		}
		rs.close();
		st.close();
		con.close();
		
		return results;
		
	}
	
	public static Connection getConnection() throws SQLException
	{			
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			return DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
	}
		
		
		
		
	
	public static void CrearTablaPrueba() throws SQLException{
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Create table TablaPrueba\r\n" + 
				"( Nombre varchar(50),\r\n" + 
				"Apellido varchar(30),\r\n" + 
				"Tiempo int\r\n" +
				" )")
				;
		rs.close();
		st.close();
		con.close();
		
	}
	
	public static void rellenarTablaPrueba() throws SQLException{
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Insert into TablaPrueba (Nombre, Apellido,Tiempo) VALUES ('Dani', 'Fuego', 1142)");
		rs.close();
		st.close();
		con.close();
	}
	
	public static void rellenarConParametros() throws SQLException {
		
		//Parámetros que se vayan a pedir
		
		System.out.println("Nombre del sujeto: ");
		String nombre = ReadString();
		System.out.println("Apellido del sujeto: ");
		String apellido = ReadString();
		System.out.println("Tiempo del sujeto: ");		
		int tiempo= ReadInt();
		
		
		//Consulta en si misma
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("Insert into TablaPrueba (Nombre, Apellido, Tiempo) Values"
				+ "(?,?,?)");
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setInt(3, tiempo);
		
		
		
		if(ps.executeUpdate() ==1)
			System.out.println("Se han introducido los datos correctamente");
		else
			System.out.println("Algún error ha ocurrido, inténtelo de nuevo");
		
		ps.close();
		con.close();
		
	}
	@SuppressWarnings("resource")
	private static String ReadString(){
		return new Scanner(System.in).nextLine();		
	}
	
	@SuppressWarnings("resource")
	private static int ReadInt(){
		return new Scanner(System.in).nextInt();			
	}	
	
	
	
}
