package co.edu.Ensamble.Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Mario
 */
public class PanelPreferencias extends JFrame implements ActionListener{
     JSlider sliderDificultad;
     JTextField campoUsuario;
     JButton aceptar;
     JButton cancelar;
     Inicio inicio;

    public PanelPreferencias(Inicio inicio)
    {
        super("Opciones");
        this.inicio = inicio;
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(crearPanelUsuario(),BorderLayout.NORTH);//Crea un panel arriba en el formulario principal del panel preferencias
        panelPrincipal.add(crearPanelDificultad(),BorderLayout.CENTER);//Crea un panel al centro en el formulario principal del panel preferencias
        panelPrincipal.add(crearPanelBoton(),BorderLayout.SOUTH);//Crea un panel al abajo en el formulario principal del panel preferencias
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        aceptar.addActionListener(this);
        cancelar.addActionListener(this);
    }
    
    public JPanel crearPanelUsuario()//Crea el panel para el ingreso del usuario
    {
        campoUsuario = new JTextField(20); //Campo de texto para ingresar Usuario
        JPanel panelUsuario = new JPanel();
        panelUsuario.add(campoUsuario); //Añade el campo de texto al panel
        panelUsuario.setBorder(BorderFactory.createCompoundBorder( //Define el borde del panel
              BorderFactory.createEmptyBorder(5,5,5,5),
              BorderFactory.createTitledBorder("Usuario")));
        return panelUsuario;
    }
    public JPanel crearPanelDificultad()//Crea el panel de dificultad
    {        
        sliderDificultad = new JSlider(JSlider.HORIZONTAL,1,3,2); //Crea un slider para la dificultad   
        JPanel panelDificultad = new JPanel();        
        sliderDificultad.setMajorTickSpacing(1);
        sliderDificultad.setPaintTicks(true);
        sliderDificultad.setPaintLabels(true);
        panelDificultad.add(sliderDificultad); //Añade el Slider al Panel de Dificultad
        panelDificultad.setBorder(BorderFactory.createCompoundBorder( //Define el Borde del panel de dificultad
                BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("Dificultad")));
        return panelDificultad;
    }
    
    public JPanel crearPanelBoton() //Crea un panel para los botones aceptar y cancelar
    {        
        JPanel panelBoton = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(1,2,5,0));
        panel.add(aceptar = new JButton("Aceptar"));
        panel.add(cancelar = new JButton("Cancelar"));
        panelBoton.add(panel,BorderLayout.EAST);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        return panelBoton;
    }
    public void actionPerformed(ActionEvent e){ //Recibe la acción al hacer click en alguno de los botones
        if(e.getSource() == aceptar)
        {
            inicio.nuevoJuego();           
        }
        setVisible(false);
    }
}
