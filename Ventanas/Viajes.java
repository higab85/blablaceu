// package Ventanas;
package blablaceu.Ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

// import Usuarios.UsuarioCorriente;
import blablaceu.Usuarios.UsuarioCorriente;

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
            viaje.setLayout(new GridLayout(1,4));
            
            for(String data : viajeData)
            	viaje.add(new JLabel(data));
            
            tablaViajes.add(viaje);
        	
        }
        add(tablaViajes);
        
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
	}
	
	
}
