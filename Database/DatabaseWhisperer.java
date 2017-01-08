package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

import Usuarios.Usuario;

public final class DatabaseWhisperer {

	
	static Connection db = null;
	static DatabaseWhisperer dbw = null;
	
	private DatabaseWhisperer() throws SQLException{
		try{
                    Class.forName("org.sqlite.JDBC");
			db = DriverManager.getConnection("jdbc:sqlite:./blablaceu2.0.db");
                        
                        	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
        }
	
	// Singleton
	public static DatabaseWhisperer getInstance() throws SQLException{
		if(dbw == null)
			dbw = new DatabaseWhisperer();
		return dbw;
	}
	
	public static boolean loginVerification(String user, String pass) throws Exception{

		Statement myStatement = db.createStatement();
		ResultSet result = null;
		try{
			System.out.println(user);
			result = myStatement.executeQuery("SELECT * FROM usuarios WHERE nombre_usuario='" + user + "'");
			
		}
		catch(SQLException e){
			throw new Exception("Usuario no existe");
                        
		}
		
		if(result.getString("passwd").equals(pass)){
			System.out.println("passwords:" + result.getString("passwd") + ", " + pass);
			return true;
		}
		return false;
	}
	
	
	// reserva una plaza en el coche
	public void reservarPlaza(Usuario usuario, String info_coche) throws SQLException{
	
		try{
			
			Statement myStatement =  db.createStatement();
			myStatement.executeUpdate("update usuarios SET matricula_coche_en_el_que_viajo= '" +
			info_coche + "' WHERE nombre_usuario='" + usuario.getUsuario() + "';");
		}
		catch (SQLException ex) {
		    System.out.println("Error de SQL: " + ex);
		}
	}

	public ArrayList mostrarInfoRutas() throws SQLException{
		
		ArrayList<String> infoRuta = new ArrayList<String>();

                         StringBuilder sb = new StringBuilder();
		try{
			
			Statement myStatement =  db.createStatement();			
                        ResultSet rs = myStatement.executeQuery("select * from info_rutas" );
                        while(rs.next()){
                        String s1 = rs.getString("nombre_ruta");
                         String s2 = rs.getString("nombre_paradas");
                         
                         sb.append("<html> nombre de la ruta..... " + s1 + " | " + s2 + "<br>" + "<br> <br>");
                         infoRuta.add(sb.toString());
                         
                        }
                    	

			
		}
		catch (SQLException ex) {
		    System.out.println("Error de SQL: " + ex);
		}
		
		return infoRuta; 
		
	}
        
        
	// registra un usuario nuevo en la base de datos a menos que el nombre de usuario
	// ya haya sido escogido. 
	public static void registrarUsuario(Usuario usuario, String password) throws Exception{
		if(!comprobarDisponibilidad(usuario))
			throw new Exception("Nombre de usuario no disponible.");
		try{
			Statement mystatement =  db.createStatement();
			mystatement.executeUpdate("INSERT INTO usuarios (nombre, nombre_usuario, direccion, passwd) values ('" +
					usuario.getNombre() + "', '" +
					usuario.getUsuario() + "', '" +
					usuario.getDireccion() + "', '" +
					password + "')");
		}
		catch (SQLException ex) {
		    System.out.println("Error de SQL: " + ex);
		    System.out.println("No se pudo aniadir usuario a la db");
		}
	}

	// comprueba si el nombre de un usuario ya ha sido elegido. En el caso de que el 
	// nombre ya no este disponible, se devolvera false
	private static boolean comprobarDisponibilidad(Usuario usuario) throws Exception{
		
		try{
		    Statement myStatement = db.createStatement();
		    ResultSet result = myStatement.executeQuery("SELECT nombre_usuario FROM usuarios");
		    
		    while (result.next())
		    	if(usuario.getUsuario().equals(result.getString("nombre_usuario")))
		    		return false;
		    
		}
		catch (SQLException ex) {
		    System.out.println("Error de SQL: " + ex);
		}
		
		return true;
	}
	
	// devuelve todos los viajes de la base de datos parseados en arraylist. Los elementos estaran
	// en el siguiente orden: nombre, coche, ruta, plazas disponibles
	public static ArrayList<ArrayList<String>> parsearViajes() throws SQLException{
		
		ArrayList<ArrayList<String>> parseado = new ArrayList<ArrayList<String>>();

		try{
			
			Statement myStatement = db.createStatement();
		    ResultSet result = myStatement.executeQuery("SELECT plazas.modelo_coche, plazas.nombre_usuario, rutas.nombre_ruta," +
		    		" usuarios.nombre, coches.matricula " +
		    		"FROM plazas " +
		    		"INNER JOIN rutas, usuarios, coches " +
		    		"ON rutas.ID_ruta=plazas.ID_ruta AND" +
		    		" usuarios.nombre_usuario=plazas.nombre_usuario AND" +
		    		" coches.nombre_usuario=plazas.nombre_usuario;");
		    while(result.next()){
		    	ArrayList<String> unViaje = new ArrayList();
		    	unViaje.add(result.getString("nombre"));
		    	unViaje.add(result.getString("modelo_coche"));
		    	unViaje.add(result.getString("nombre_usuario"));
		    	unViaje.add(result.getString("nombre_ruta"));
		    	unViaje.add(result.getString("matricula"));
		    	parseado.add(unViaje);
		    }
			
		}
		catch (SQLException ex) {
		    System.out.println("Error de SQL: " + ex);
		}
		
		return parseado;
		
	}

	public ArrayList<String> getDatosPersonales(Usuario usuario) throws SQLException {
		
		ArrayList<String> parseado = new ArrayList<String>();
		
		Statement myStatement = db.createStatement();
		ResultSet result = myStatement.executeQuery("SELECT * FROM usuarios WHERE nombre_usuario='"+ usuario.getUsuario() +"'");
		
		while(result.next()){
			System.out.println("haka:" + result.getString("nombre"));
			parseado.add(result.getString("nombre"));
			parseado.add(result.getString("direccion"));
		}
			
		return parseado;
	}
        
        










}
