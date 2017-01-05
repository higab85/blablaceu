package Usuarios;
// package blablaceu.Usuarios;

public class Coche {
	
	private String nombre = new String();
	private String matricula = new String();
	private int plazas;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the plazas
     */
    public int getPlazas() {
        return plazas;
    }

    /**
     * @param plazas the plazas to set
     */
    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
	
     
    public String toString(){
            return "Coche es:" + nombre + " con matricula: " + matricula + " y tiene: " + plazas + "plazas.s";
    
    
    }
        
	
}
