package Ventanas;

import Usuarios.Usuario;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;



public class Viajes extends JFrame{
    private   JLabel infoR;

    private class KeyValue{
        private String value;
        private String display;
        
        public KeyValue(String value, String display){
            this.value = value;
            this.display = display;
        }
        
        public String getValue(){
            return value;
        }
        
        public String getDisplay(){
            return display;
        }
        
        @Override
        public String toString(){
            return display;
        }
    }
    
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

        ArrayList infoRuta =  usuario.mostrarInfoRutas();
        Iterator it = infoRuta.iterator();

        // ITERATOR
        while(it.hasNext()){
           String x = (String)it.next();
           infoR = new JLabel(x);
        }




        JComboBox bx = new JComboBox();
        
        JButton seleccionar_plaza = new JButton("seleccionar");

        for(ArrayList<String> viajeData : usuario.verViajes()){
            
            JPanel tiledInfo = new JPanel();
            tiledInfo.setLayout(new GridLayout(1,5));
           
            KeyValue kv = new KeyValue(viajeData.get(4), viajeData.get(3));
            
            bx.addItem(kv);
            
            tablaViajes.add(bx);
            tablaViajes.add(seleccionar_plaza);


        }


        seleccionar_plaza.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                KeyValue coche = (KeyValue) bx.getSelectedItem();
                String matricula = coche.getValue();
                try {
                    usuario.reservarPlaza(matricula);
                } catch (SQLException ex) {
                    Logger.getLogger(Viajes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Configurar layout
        JPanel pilotos = new JPanel();
        pilotos.setLayout(new GridLayout());
        
        for(String piloto : usuario.mostrarPilotos()){
            pilotos.add(new JLabel(piloto));
        }
       
        JPanel contentSouth = new JPanel();
        contentSouth.setLayout(new GridLayout(2, 1));
        
        contentSouth.add(tablaViajes);
        contentSouth.add(pilotos);
        
        content.add(contentSouth, BorderLayout.SOUTH);
        content.add(decoracion, BorderLayout.NORTH);

        content.add(infoR, BorderLayout.WEST);


        add(content);

        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 



    }
	
	
}
