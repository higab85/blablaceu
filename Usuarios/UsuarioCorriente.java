// package Usuarios;
package blablaceu.Usuarios;
import java.util.ArrayList;


public class UsuarioCorriente extends Usuario {

	// log in
	public UsuarioCorriente(String user) {
		super(user);		
	}
	
	// registro
	public UsuarioCorriente(String user, String nombre, String telefono, String direccion, String password) throws Exception {
		super();
		this.usuario = user;
		this.nombre = nombre;
		this.telefono = telefono;
		db.registrarUsuario(this);
	}
	
	public void reservarPlaza(Coche coche){
		db.reservarPlaza(this, coche);
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
