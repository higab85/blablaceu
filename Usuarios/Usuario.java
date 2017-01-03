package Usuarios;
// package blablaceu.Usuarios;

import java.util.ArrayList;

import Database.DatabaseWhisperer;
// import blablaceu.Database.DatabaseWhisperer;

public class Usuario {
	
	protected String usuario = new String();
	protected String nombre = new String();
	protected String telefono = new String();
	protected String direccion = new String();
	

	DatabaseWhisperer db = DatabaseWhisperer.getInstance();
	
	ArrayList<Coche> coches = new ArrayList<Coche>();

	private void actualizarInformacion(){
		
	}
	
	// log in
	public Usuario(String user){
		usuario = user;
		actualizarInformacion();
	}
	// registro
	protected Usuario(){}
	
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
