package Database;

import java.util.ArrayList;

import Usuarios.Coche;
import Usuarios.Usuario;

public final class DatabaseWhisperer {

	private static DatabaseWhisperer db = null;
	
	private DatabaseWhisperer(){};
	
	// Singleton
	public static DatabaseWhisperer getInstance(){
		if(db == null)
			db = new DatabaseWhisperer();
		return db;
	}
	
	
	// reserva una plaza en el coche
	public static void reservarPlaza(Usuario user, Coche coche){
		
	}
	
	// registra un usuario nuevo en la base de datos a menos que el nombre de usuario
	// ya haya sido escogido. 
	public static void registrarUsuario(Usuario usuario) throws Exception{
		comprobarDisponibilidad(usuario);
		// ...
	}

	// comprueba si el nombre de un usuario ya ha sido elegido. En el caso de que el 
	// nombre ya no este disponible, se tirara una excepcion
	private static void comprobarDisponibilidad(Usuario usuario) throws Exception{
		
	}
	
	// devuelve un viaje de la base de datos parseado en arraylist. Los elementos estaran
	// en el siguiente orden: nombre, coche, ruta, plazas disponibles
	public static ArrayList<String> parsearViaje(){
		
		ArrayList<String> parseado = new ArrayList<String>();
		
		// ... 
		
		return parseado;
	}
	
	public static ArrayList<ArrayList<String>> parsearViajes(){
		
		ArrayList<ArrayList<String>> parseado = new ArrayList<ArrayList<String>>();
		
		// ... 
		
		return parseado;
		
	}
}
