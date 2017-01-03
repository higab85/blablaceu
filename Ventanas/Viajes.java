package Ventanas;
// package blablaceu.Ventanas;
import Usuarios.UsuarioCorriente;
//import blablaceu.Usuarios.UsuarioCorriente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Viajes extends JFrame{

	public Viajes(UsuarioCorriente usuario) {
		
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        //Configurar layout
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        
        content.add(new JLabel("Bienvenido " + usuario.getUsuario()), BorderLayout.NORTH);
        add(content);
        
        
        JPanel tablaViajes = new JPanel();
        tablaViajes.setLayout(new GridLayout());
        
        
        for(ArrayList<String> viajeData : usuario.verViajes()){
        	
            JPanel viaje = new JPanel();
            viaje.setLayout(new GridLayout(1,5));
            
            for(String data : viajeData)
            	viaje.add(new JLabel(data));
            
			JButton seleccionar_plaza = new JButton("seleccionar");
			
			// listens for button press and launches registro instance if pressed
			seleccionar_plaza.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						 System.out.println("we're in");
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
        add(tablaViajes);
        
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
	}
	
	
}
