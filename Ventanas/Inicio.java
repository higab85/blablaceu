package Ventanas;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Ventanas.Registro;


public class Inicio extends JFrame {
	
    public Inicio() {
    	
        super("BLABLACEU");
        
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        //Configurar layout
        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 1;
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        c.weighty = 0.0;

        JTextField usuario = new JTextField(10);
        JPasswordField password = new JPasswordField(10);
        
        JPanel content1 = new JPanel();
        content1.setLayout(new GridBagLayout());
        content1.add(new JLabel("usuario"));
        content1.add(usuario);

        JPanel content2 = new JPanel();
        content2.setLayout(new GridBagLayout());
        content2.add(new JLabel("contrasenia"));
        content2.add(password);
        
        content.add( content1, c);
        content.add( content2, c);
        
		JButton register = new JButton("Registrarse");
		
		// listens for button press and launches registro instance if pressed
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Registro registro = new Registro();
			}
		});
		content.add(register, c);
		
        
        add(content);
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Inicio aplicacion = new Inicio();
    }
}
