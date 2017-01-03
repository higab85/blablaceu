package Ventanas;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Usuarios.UsuarioCorriente;


public class Registro extends JFrame  {
	
	public Registro(){
	    	
	        super("BLABLACEU | Registro");
	
	        final JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	        //Configurar layout
	        JPanel content = new JPanel();
	        content.setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();

	        c.gridheight = 1;
	        c.gridwidth = GridBagConstraints.REMAINDER; //end row
	        c.weighty = 0.0;
	        
	        final JTextField usuario = new JTextField(10);
	        final JTextField nombre = new JTextField(10);
	        final JTextField direccion = new JTextField(10);
	        final JTextField telefono = new JTextField(10);
	        final JPasswordField password = new JPasswordField(10);
	        
	        
	        JPanel content1 = new JPanel();
	        content1.setLayout(new GridBagLayout());
	        content1.add(new JLabel("usuario"));
	        content1.add(usuario);
	
	        JPanel content2 = new JPanel();
	        content2.setLayout(new GridBagLayout());
	        content2.add(new JLabel("nombre"));
	        content2.add(nombre);
	        
	        JPanel content3 = new JPanel();
	        content3.setLayout(new GridBagLayout());
	        content3.add(new JLabel("direccion"));
	        content3.add(direccion);
	        
	        JPanel content4 = new JPanel();
	        content4.setLayout(new GridBagLayout());
	        content4.add(new JLabel("telefono"));
	        content4.add(telefono);
	        
	        
	        JPanel content5 = new JPanel();
	        content5.setLayout(new GridBagLayout());
	        content5.add(new JLabel("contrasenia"));
	        content5.add(password);

	        
	        content.add( content1, c);
	        content.add( content2, c);
	        content.add( content3, c);
	        content.add( content4, c);
	        content.add( content5, c);
	        
			JButton register = new JButton("Registrarse");
			
			// listens for button press and launches registro instance if pressed
			register.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						 UsuarioCorriente usuarioC = new UsuarioCorriente(usuario.getText(), nombre.getText(), 
								 telefono.getText(), direccion.getText(), password.getPassword().toString());
						 Viajes viajes = new Viajes(usuarioC);
					}
					catch(Exception exc){
//						JOptionPane.showMessageDialog(this,
//								"El usuario escogido no esta disponible, por favor elija otro.", 
//								"Warning",
//								JOptionPane.WARNING_MESSAGE);
					}
				} 
			});
			
			content.add(register, c);
	        
	        add(content);
	
	        
	
	        setSize(1000, 500);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	    }
	
    public static void main(String[] args) {
        Registro aplicacion = new Registro();
    }

}
