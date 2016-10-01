/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.Ensamble.Modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sebastián
 */
public class AdmPersistencia {

    private ArrayList<Usuario> Partidas;

    public AdmPersistencia() {
        this.Partidas = new ArrayList<>();
    }

    //true si existe el usuario, false en el caso contrario
    public boolean existe(String nombre) {
        boolean b = false;
        Iterator<Usuario> iterator = Partidas.iterator();
        while (iterator.hasNext()) {
            Usuario aux = iterator.next();
            if (aux.getNombre().equals(nombre)) {
                b = true;
                break;
            }
        }
        return b;
    }

    //retorna un arrayList con todas los usuarios guardados en un archivo
    private void recuperarPartidas() {
        try {
            FileInputStream fis = new FileInputStream("partidas.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Usuario aux = (Usuario) ois.readObject();
            while (aux != null) {
                Partidas.add(aux);
                try {
                    aux = (Usuario) ois.readObject();
                } catch (EOFException e) {
                    break;
                }

            }
            ois.close();
            fis.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

    }

    //guarda en un archivo todos los usuarios en la ArrayList Partidas
    private void guardarPartidas() {
        try {
            FileOutputStream fos = new FileOutputStream("partidas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Iterator<Usuario> iterator = Partidas.iterator();
            while (iterator.hasNext()) {
                Usuario aux = new Usuario();
                aux = iterator.next();
                oos.writeObject(aux);
            }

            oos.close();
            fos.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    //retorna el usuario cuyo nombre sea igual al párametro
    public Usuario recuperarPartida(String nombre) {
        Usuario usr = new Usuario();
        recuperarPartidas();
        Iterator<Usuario> iterator = Partidas.iterator();
        while (iterator.hasNext()) {
            Usuario aux = iterator.next();
            if (aux.getNombre().equals(nombre)) {
                return aux;
            }
        }
        return usr;
    }

    //agrega un usuario a la lista de partidas y almacena todos las partidas
    public void guardarPartida(Usuario usr) {
        Partidas.add(usr);
        guardarPartidas();
    }

    public void pruebaG() {
        for (int i = 0; i <= 5; i++) {
            Partidas.add(new Usuario("" + i));
        }
        guardarPartidas();
    }

    public void pruebaC() {
        recuperarPartidas();
        for (int i = 0; i <= 5; i++) {
            System.out.println(Partidas.get(i).getNombre());
        }
    }
}
