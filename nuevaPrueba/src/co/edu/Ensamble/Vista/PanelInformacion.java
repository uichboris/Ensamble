package co.edu.Ensamble.Vista;

import javax.swing.*;
import java.awt.*;
import co.edu.Ensamble.Modelo.DatosDelJuego;
/**
 *
 * @author Mario
 */
public class PanelInformacion extends JPanel
{
    public PanelInformacion()
    {
        setLayout(new BorderLayout());
        JPanel panelNorte = new PanelNorte();       
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();        
        c.insets = new Insets(4,4,4,4);
        c.fill = GridBagConstraints.HORIZONTAL;
        String[][] valores = new String[][]{
            {"Proyecto: ","Ensamble "+DatosDelJuego.Version},
            {"Categoría: ","Juego"},
            {"Autores: ","Mario Ramírez"},
            {" ","Juan Pablo Taborda"},
            {" ","Sebastián Gomez"},
            {" ","Juan David Sanchez"},
            {" ","Duvan Benjumea Vargas"},
            {" ","Karpov Swether"},
            {" ","Emanuel Gaviria"},
            {" ","Sebastián Cadavid"},
            {"Fecha creación: ","Septiembre 2016"}
        };
        for(int i=0; i<valores.length; i++)
        {
            JLabel encabezado = new JLabel(valores[i][0]);
            encabezado.setFont(new Font(encabezado.getFont().getName(),Font.BOLD,13));
            JLabel datos = new JLabel(valores[i][1]);
            c.gridx = 0;
            c.gridy = i;
            panelCentral.add(encabezado,c);
            c.gridx = 1;
            panelCentral.add(datos,c);
        }
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(panelNorte,BorderLayout.NORTH);
        add(panelCentral,BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }
    
    public static void crearYMostrarIU()
    {                   
        JFrame info = new JFrame("Información");
        PanelInformacion pi = new PanelInformacion();
        info.getContentPane().add(pi);
        info.setResizable(false);
        info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        info.pack();
        info.setLocationRelativeTo(null);
        info.setVisible(true);
    }
    class PanelNorte extends JPanel
    {
        public PanelNorte() //Crea el panel que funciona como encabezado al panel de información
        {          
            JLabel etiqueta = new JLabel("Acerca del proyecto Ensamble",JLabel.LEFT);
            etiqueta.setFont(new Font(etiqueta.getFont().getName(),Font.BOLD,15));
            etiqueta.setForeground(Color.decode("#9900AF"));
            add(etiqueta);
        }
        
        @Override
        public void paintComponent(Graphics grafico) 
        {
            super.paintComponent(grafico);
            int ancho = this.getWidth()-5;
            int alto = this.getHeight() - 1;
            grafico.setColor(Color.decode("#9900FF"));
            grafico.drawLine(0, alto, ancho, alto);
        }
    }
}
