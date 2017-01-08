package Ventanas;
import Usuarios.UsuarioCorriente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


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

        final JTextField usuario = new JTextField(10);
        final JPasswordField password = new JPasswordField(10);
        
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
		JButton login = new JButton("Login");
		
		// listens for registro button press and launches registro instance if pressed
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Registro registro = new Registro();
			}
		});
		// listens for login button press and launches login instance if pressed
		// OBSERVER
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UsuarioCorriente personaNueva = null;
				try {
					personaNueva = new UsuarioCorriente(usuario.getText(), password.getText());
					System.out.println("usumusu: " + personaNueva.getNombre());
					Viajes viaje = new Viajes(personaNueva);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
        JPanel content3 = new JPanel();
        content3.setLayout(new GridBagLayout());
        
        content3.add(login);
        content3.add(register);

        
		content.add(content3, c);
		
        
        add(content);
        
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        Inicio aplicacion = new Inicio();
    }
}
