package co.edu.Ensamble.Vista;

import co.edu.Ensamble.Modelo.DatosDelJuego;
import co.edu.Ensamble.Modelo.Recurso;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author marioh.ramirez
 */
public class Tablero extends JFrame implements MouseListener
{
    PanelTablero panelTablero;
    //JPanel panelEste;
    Recurso recurso = new Recurso();
    Map<Integer,Image> imagenes = new HashMap<Integer,Image>();      
    JPanel panelPrincipal = new JPanel(new BorderLayout());
    Color colorFondo = Color.decode("#efd39c");
    
    public Tablero()//Listo
    {
        super("Ensamble "+DatosDelJuego.Version);                                  
        setContentPane(panelPrincipal);    
        cargarImagenesTablero();        
        panelTablero = new PanelTablero();
        panelPrincipal.add(panelTablero,BorderLayout.CENTER);  
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
    
    
    public void nuevoJuego()
    {                
        
    }   
   
    @Override
    public void mouseClicked(MouseEvent e) 
    {     
    }    

    @Override
    public void mouseEntered(MouseEvent e) 
    {
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {       
    }
    
    @Override
    public void mousePressed(MouseEvent e) 
    {
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }
    
    public class PanelTablero extends JPanel
    {     
        public PanelTablero()
        {
            setPreferredSize(new Dimension(450,495));
            setBackground(colorFondo);
        }
        @Override
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);  
            g.drawImage(imagenes.get(DatosDelJuego.Ambiente),125,36,this);
            g.drawImage(imagenes.get(DatosDelJuego.ImagenTablero),125,75,this);            
        }
    }   
    
    public void cargarImagenesTablero()
    {
        try
        { 
            imagenes.put(DatosDelJuego.ImagenTablero,ImageIO.read(recurso.obtenerRecurso("tablero")));
            imagenes.put(DatosDelJuego.Ambiente,ImageIO.read(recurso.obtenerRecurso("ambiente")));
        }catch(IOException ex){
            ex.printStackTrace();
        }       
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
    
}
