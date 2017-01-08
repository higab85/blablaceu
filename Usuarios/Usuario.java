package Usuarios;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.DatabaseWhisperer;

public class Usuario {
	
    protected String usuario = new String();
    protected String nombre = new String();
    protected String direccion = new String();


    DatabaseWhisperer db = null;

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
            this.usuario = user;
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
    public Usuario(String user, String nombre, String direccion, String password) throws Exception {
        try{
            db = DatabaseWhisperer.getInstance();
        }
        catch(SQLException e){
            System.out.println("SQLException: " + e);
        }
            this.usuario = user;
            this.nombre = nombre;
            this.direccion = direccion;
            verificarUsuario();

            db.registrarUsuario(this, password);
    }


    private void actualizarInformacion() throws SQLException{

        ArrayList<String> datosPersonales = db.getDatosPersonales(this);
        this.nombre = datosPersonales.get(0);
        this.direccion = datosPersonales.get(1);

    }

    public ArrayList<ArrayList<String>> verViajes() throws SQLException{
        return db.parsearViajes();
    }


    protected void verificarUsuario() throws Exception{
        if( !this.nombre.matches("[a-zA-Z]+"))
            throw new Exception("Nombre contiene valores no permitidos. Por favor use solamente letras para su nombre.");
        if(!this.direccion.matches("[a-zA-Z0-9]+"))
            throw new Exception("Solo aceptamos numeros y letras para direcciones");
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

        
}
