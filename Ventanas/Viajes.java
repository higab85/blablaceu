package Ventanas;
// package blablaceu.Ventanas;
import Usuarios.Coche;
import Usuarios.Usuario;
//import blablaceu.Usuarios.UsuarioCorriente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;


public class Viajes extends JFrame{

	public Viajes(Usuario usuario) throws SQLException {
		super("SELECCIÓN DE VIAJES");
                System.out.println("hustle: " + usuario.getNombre());
                
        //final JFrame frame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //Configurar layout
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        
        JPanel decoracion = new JPanel();
        decoracion.setLayout(new BorderLayout());
        
        decoracion.add(new JLabel("Bienvenido " + usuario.getUsuario()), BorderLayout.NORTH);
        
        JPanel tablaViajes = new JPanel();
        tablaViajes.setLayout(new GridLayout(5,1));
        
        JComboBox bx = new JComboBox();
        
        JButton seleccionar_plaza = new JButton("seleccionar");
             
      for(ArrayList<String> viajeData : usuario.verViajes()){
       // System.out.println("hello "+ viajeData);
         Object elem = viajeData;
         
          bx.addItem(elem);
          
            JPanel viaje = new JPanel();
            viaje.setLayout(new GridLayout(1,5));
            
          /*  for(String data : viajeData){
            	System.out.println(data);
                bx.add(new JLabel(data));
            	//viaje.add(new JLabel(data));
            }*/
          
        
            
			
			
			// listens for button press and launches registro instance if pressed
			
            
          //  viaje.add(seleccionar_plaza);
            tablaViajes.add(viaje);
            tablaViajes.add(bx);
            tablaViajes.add(seleccionar_plaza);
        	
        }
      
      
      seleccionar_plaza.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
						// System.out.println("implementar metodo de reservar plaza");
//                                                UsuarioCorriente usuarioC = new UsuarioCorriente(usuario.getText(), nombre.getText(), 
//								direccion.getText(), password.getText().toString());
//		
//						Viajes viajes = new Viajes(usuarioC);
                                                Object matricula_coche = bx.getSelectedItem();
                                                
                                              //  Coche cr = (Coche)matricula_coche;
                                                System.out.println(matricula_coche);
					}
				
				
			});
        content.add(tablaViajes, BorderLayout.CENTER);
        content.add(decoracion, BorderLayout.NORTH);
        
        
        add(content);
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 
        
       
      
	}
	
	
}
