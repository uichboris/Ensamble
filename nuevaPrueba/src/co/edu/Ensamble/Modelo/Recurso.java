package co.edu.Ensamble.Modelo;


import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Mario
 */
public class Recurso 
{
    protected static ResourceBundle recursos;
    static{
        try{
            recursos = ResourceBundle.getBundle("co.edu.Ensamble.Modelo.res.PropiedadesTablero",Locale.getDefault());
        }catch(Exception e)
        {
            System.out.println("Propiedades del tablero, no encontradas");
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Propiedades del tablero, no encontradas",
                    "Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public String obtenerStringRecurso(String k)
    {
        String str;
        try{
            str = recursos.getString(k);
        }catch(Exception e){
            str = null;
        }
        return str;
    }
    
    public URL obtenerRecurso(String k)
    {
        String nombre = obtenerStringRecurso(k);
        if(nombre != null){
            URL url = this.getClass().getResource(nombre);
            return url;
        }
        return null;
    }
}
