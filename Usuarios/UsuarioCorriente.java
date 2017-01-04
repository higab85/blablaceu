package Usuarios;
import java.sql.SQLException;
// package blablaceu.Usuarios;
import java.util.ArrayList;


public class UsuarioCorriente extends Usuario {

	// log in
	public UsuarioCorriente(String user, String password) throws Exception {
		super(user, password);		
	}
	
	// registro
	public UsuarioCorriente(String user, String nombre, String direccion, String password) throws Exception {
		super();
		this.usuario = user;
		this.nombre = nombre;
		this.direccion = direccion;
		verificarUsuario();
		
		db.registrarUsuario(this, password);
	}
	
	public void reservarPlaza(String matricula) throws SQLException{
		db.reservarPlaza(this, matricula);
	}
	
	public ArrayList<ArrayList<String>> verViajes() throws SQLException{
		
		return db.parsearViajes();
	}
	
	public int contarViajesDisponibles() throws SQLException{
		
		int viajes = 0;
		
		for(ArrayList<String> viaje : this.verViajes())
			viajes++;
		
		return viajes;
	}
	
}
