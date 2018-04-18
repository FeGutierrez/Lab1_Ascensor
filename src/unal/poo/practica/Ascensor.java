/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;
import becker.robots.*;
import java.util.ArrayList;
/**
 *
 * @author Flexxo333
 */
public class Ascensor extends Robot{
    
    private int avenidaOrigen;
    private int calleOrigen;
    private ArrayList<Usuario> pasajeros;
    
    public Ascensor(City city, int i, int i1, Direction drctn, int i2) {
        
        super(city, i, i1, drctn, i2);
        this.avenidaOrigen =i1;
        this.calleOrigen=i;
        this.pasajeros = new ArrayList<>();
    
    }

    public int getAvenidaOrigen() {
        return avenidaOrigen;
    }

    public int getCalleOrigen() {
        return calleOrigen;
    }

    public ArrayList<Usuario> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Usuario> pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    
    
    

    
    
    
}
