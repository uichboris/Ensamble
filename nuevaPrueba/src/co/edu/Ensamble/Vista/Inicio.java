package co.edu.Ensamble.Vista;

import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import co.edu.Ensamble.Modelo.DatosDelJuego;
import co.edu.Ensamble.Modelo.Recurso;

/**
 *
 * @author Mario
 */
public class Inicio extends JFrame implements MouseListener
{         
    JPanel panelEste;
    Recurso recurso = new Recurso();
    Map<Integer,Image> imagenes = new HashMap<Integer,Image>();
    Map<Integer,Icon> imagenesIconos = new HashMap<Integer,Icon>();  
    JLabel nuevoJuego,salir,informacion,continuar;    
    JPanel panelPrincipal = new JPanel(new BorderLayout());
    PanelPreferencias opcionesDeJuego;
    Color colorFondo = Color.decode("#efd39c");
    
    public Inicio()//Listo
    {
        super("Ensamble "+DatosDelJuego.Version);                                  
        setContentPane(panelPrincipal);    
        cargarIconosMenu();
        panelPrincipal.add(crearPanelMenu(),BorderLayout.SOUTH);  
        panelPrincipal.setBackground(colorFondo);      
        pack();
        Dimension tamaño = getSize();
        tamaño.height = 550;
        tamaño.width = 650;
        setSize(tamaño);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                salir();
            }
        });
    }
    
    public JPanel crearPanelMenu()
    {
        nuevoJuego = new JLabel(imagenesIconos.get(DatosDelJuego.NuevoBoton));
        informacion = new JLabel(imagenesIconos.get(DatosDelJuego.BotonInformacion));
        continuar = new JLabel(imagenesIconos.get(DatosDelJuego.BotonHistoria));
        salir = new JLabel(imagenesIconos.get(DatosDelJuego.BotonQuitar));
        nuevoJuego.addMouseListener(this);
        informacion.addMouseListener(this);
        continuar.addMouseListener(this);
        salir.addMouseListener(this);        
        JPanel panel = new JPanel(new GridLayout(4,1));
        panel.add(nuevoJuego);        
        panel.add(continuar);
        panel.add(informacion);
        panel.add(salir);             
        panel.setBackground(colorFondo);
        JPanel panelMenu = new JPanel(new BorderLayout());
        panelMenu.setBackground(colorFondo);
        panelMenu.add(panel,BorderLayout.SOUTH);
        panelMenu.setBorder(BorderFactory.createEmptyBorder(0,20,20,0));
        return panelMenu;
    }    
    
    public void nuevoJuego()
    {              
        Tablero t = new Tablero();
        //mcg.pack();
        t.setLocationRelativeTo(null);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setResizable(false);
        t.setVisible(true);
        this.setVisible(false);
    }   
   
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Object source = e.getSource();
        if(source == salir)
        {
            salir();
        }
        else if(source == nuevoJuego)
        {            
            if(opcionesDeJuego == null) 
            {
                opcionesDeJuego = new PanelPreferencias(this);
            }
            opcionesDeJuego.setVisible(true);
        }
        else if(source == informacion)
        {
            PanelInformacion.crearYMostrarIU();
        }
        else if(source == continuar)
        {
            JOptionPane.showMessageDialog(rootPane, "Todavía no hace nada");
        }        
    }    

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        Object source = e.getSource();
        if(source == nuevoJuego)
        {
            nuevoJuego.setIcon(imagenesIconos.get(DatosDelJuego.NuevoBoton2));
        }
        else if(source == informacion)
        {
            informacion.setIcon(imagenesIconos.get(DatosDelJuego.BotonInformacion2));
        }
        else if(source == continuar)
        {
            continuar.setIcon(imagenesIconos.get(DatosDelJuego.BotonHistoria2));
        }
        else if(source == salir)
        {
            salir.setIcon(imagenesIconos.get(DatosDelJuego.BotonQuitar2));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        Object source = e.getSource();
        if(source == nuevoJuego)
        {
            nuevoJuego.setIcon(imagenesIconos.get(DatosDelJuego.NuevoBoton));
        }
        else if(source == informacion)
        {
            informacion.setIcon(imagenesIconos.get(DatosDelJuego.BotonInformacion));
        }
        else if(source == continuar)
        {
            continuar.setIcon(imagenesIconos.get(DatosDelJuego.BotonHistoria));
        }
        else if(source == salir)
        {
            salir.setIcon(imagenesIconos.get(DatosDelJuego.BotonQuitar));
        }        
    }
    
    @Override
    public void mousePressed(MouseEvent e) 
    {
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }
    
    public void cargarIconosMenu()
    {
        imagenesIconos.put(DatosDelJuego.NuevoBoton,new ImageIcon(recurso.obtenerRecurso("nuevoJuego")));
        imagenesIconos.put(DatosDelJuego.NuevoBoton2,new ImageIcon(recurso.obtenerRecurso("nuevoJuegoSobre")));
        imagenesIconos.put(DatosDelJuego.BotonQuitar,new ImageIcon(recurso.obtenerRecurso("salir")));
        imagenesIconos.put(DatosDelJuego.BotonQuitar2,new ImageIcon(recurso.obtenerRecurso("salirSobre")));
        imagenesIconos.put(DatosDelJuego.BotonHistoria,new ImageIcon(recurso.obtenerRecurso("continuar")));
        imagenesIconos.put(DatosDelJuego.BotonHistoria2,new ImageIcon(recurso.obtenerRecurso("continuarSobre")));
        imagenesIconos.put(DatosDelJuego.BotonInformacion,new ImageIcon(recurso.obtenerRecurso("informacion")));
        imagenesIconos.put(DatosDelJuego.BotonInformacion2,new ImageIcon(recurso.obtenerRecurso("informacionSobre")));       
    }
    
    public void salir()
    {
        int opcion = JOptionPane.showConfirmDialog(null,"¿Seguro desea salir?", 
                    "Ensamble 1.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }            
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                try{
                    boolean nimbusFound = false;
                        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                            if(info.getName().equals("Nimbus")){
                                UIManager.setLookAndFeel(info.getClassName());
                                nimbusFound = true;
                                break;
                            }
                        }
                        if(!nimbusFound){
                            int option = JOptionPane.showConfirmDialog(null,
                                    "Nimbus no ha sido encontrado\n"+
                                    "¿Quieres continuar?",
                                    "Warning",JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                            if(option == JOptionPane.NO_OPTION){
                                System.exit(0);
                            }
                        }
                    Inicio mcg = new Inicio();
                   //mcg.pack();
                    mcg.setLocationRelativeTo(null);
                    mcg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mcg.setResizable(false);
                    mcg.setVisible(true); 
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getStackTrace());
                    e.printStackTrace();
                }
            }
        });
    }
}
