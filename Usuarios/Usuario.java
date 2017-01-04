package Usuarios;
// package blablaceu.Usuarios;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.DatabaseWhisperer;

public class Usuario {
	
	protected String usuario = new String();
	protected String nombre = new String();
	protected String direccion = new String();
	

	DatabaseWhisperer db = null;
	
	ArrayList<Coche> coches = new ArrayList<Coche>();

	private void actualizarInformacion(){
		
	}
	
	// log in
	public Usuario(String user, String password) throws Exception{
		try{
			db = DatabaseWhisperer.getInstance();
		}
		catch(Exception e){
			System.out.println(e);
			throw e;
		}
		this.usuario = user;
		if(db.loginVerification(user, password)){
			actualizarInformacion();
			try{
				db = DatabaseWhisperer.getInstance();
			}
			catch(SQLException e){
				System.out.println("SQLException: " + e);
				throw e;
			}
		}
		else throw new Exception("Contrasenia incorrecta");
	}
	// registro
	protected Usuario(){
		try{
			db = DatabaseWhisperer.getInstance();
		}
		catch(SQLException e){
			System.out.println("SQLException: " + e);
		}
	}
	
	public ArrayList<ArrayList<String>> verViajes() throws SQLException{
		return db.parsearViajes();
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}
}
