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
	
	private void verificarUsuario() throws Exception{
		if( !this.nombre.matches("[a-zA-Z]+"))
			throw new Exception("Nombre contiene valores no permitidos. Por favor use solamente letras para su nombre.");
		if(!this.direccion.matches("[a-zA-Z0-9]+"))
			throw new Exception("Solo aceptamos numeros y letras para direcciones");
	}
	
	public void reservarPlaza(String matricula) throws SQLException{
		db.reservarPlaza(this, matricula);
	}
	
	public ArrayList<ArrayList<String>> verViajes(){
		
		ArrayList<ArrayList<String>> placeholder = new ArrayList<ArrayList<String>>();
		return placeholder;
	}
	
	public int contarViajesDisponibles(){
		
		int viajes = 0;
		
		for(ArrayList<String> viaje : this.verViajes())
			viajes++;
		
		return viajes;
	}
	
}
