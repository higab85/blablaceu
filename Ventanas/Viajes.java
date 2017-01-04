package Ventanas;
// package blablaceu.Ventanas;
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

import javax.swing.*;


public class Viajes extends JFrame{

	public Viajes(Usuario usuario) throws SQLException {
		System.out.println("hustle: " + usuario.getNombre());
        //final JFrame frame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //Configurar layout
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        
        JPanel decoracion = new JPanel();
        decoracion.setLayout(new BorderLayout());
        
        decoracion.add(new JLabel("Bienvenido " + usuario.getUsuario()), BorderLayout.CENTER);
        
        JPanel tablaViajes = new JPanel();
        tablaViajes.setLayout(new GridLayout(5,1));
        
        
        for(ArrayList<String> viajeData : usuario.verViajes()){
        	
            JPanel viaje = new JPanel();
            viaje.setLayout(new GridLayout(1,5));
            
            for(String data : viajeData){
            	System.out.println(data);
            	viaje.add(new JLabel(data));
            }
            
			JButton seleccionar_plaza = new JButton("seleccionar");
			
			// listens for button press and launches registro instance if pressed
			seleccionar_plaza.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						 System.out.println("impementar metodo de reservar plaza");
					}
					catch(Exception exc){
//						JOptionPane.showMessageDialog(this,
//								"El usuario escogido no esta disponible, por favor elija otro.", 
//								"Warning",
//								JOptionPane.WARNING_MESSAGE);
					}
				} 
			});
            
            viaje.add(seleccionar_plaza);
            tablaViajes.add(viaje);
        	
        }
        content.add(tablaViajes, BorderLayout.CENTER);
        content.add(decoracion, BorderLayout.NORTH);
        
        add(content);
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 
        
       
      
	}
	
	
}
