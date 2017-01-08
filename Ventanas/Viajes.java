package Ventanas;

import Database.DatabaseWhisperer;
import Usuarios.Usuario;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;


public class Viajes extends JFrame{
    private   JLabel infoR;
	public Viajes(Usuario usuario) throws SQLException {
		super("SELECCIÓN DE VIAJES");
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //Configurar layout
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        
        JPanel decoracion = new JPanel();
        decoracion.setLayout(new BorderLayout());
        
        decoracion.add(new JLabel("Bienvenido " + usuario.getUsuario()), BorderLayout.NORTH);
        
        JPanel tablaViajes = new JPanel();
        tablaViajes.setLayout(new GridLayout(5,1));
        
        JPanel info_rutas  = new JPanel();
        info_rutas.setLayout(new GridLayout(5,1));
        
        DatabaseWhisperer dw = DatabaseWhisperer.getInstance();
         ArrayList infoRuta =  dw.mostrarInfoRutas();
         Iterator it = infoRuta.iterator();
         
         
         while(it.hasNext()){
            String x = (String)it.next();
            infoR = new JLabel(x);
         }
         
         
        
        
        JComboBox bx = new JComboBox();
        
        JButton seleccionar_plaza = new JButton("seleccionar");
             
      for(ArrayList<String> viajeData : usuario.verViajes()){
         Object elem = viajeData;
         
          bx.addItem(elem);
          
            JPanel viaje = new JPanel();
            viaje.setLayout(new GridLayout(1,5));
         
            tablaViajes.add(viaje);
            tablaViajes.add(bx);
            tablaViajes.add(seleccionar_plaza);
            
        	
        }
      
      
      seleccionar_plaza.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
			                      Object info_coche = bx.getSelectedItem();
                                             String string = info_coche.toString();
                                                System.out.println(string);
                                                try{
                                                    DatabaseWhisperer dw = DatabaseWhisperer.getInstance();
                                                    dw.reservarPlaza(usuario,string);
                                                
                                                }catch(SQLException ex){
                                                    System.out.println("Error de SQL: " + ex);
                                                }
                                                
                                                
                                               
					}
				
				
			});
        content.add(tablaViajes, BorderLayout.CENTER);
        content.add(decoracion, BorderLayout.NORTH);
        
       content.add(infoR, BorderLayout.WEST);

        
        add(content);
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 
        
       
      
	}
	
	
}
