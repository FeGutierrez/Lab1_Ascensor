/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;
import becker.robots.*;
/**
 *
 * @author Flexxo333
 */
public class Ascensor extends Robot{
    
    private int avenidaOrigen;
    private int calleOrigen;
    
    public Ascensor(City city, int i, int i1, Direction drctn, int i2) {
        
        super(city, i, i1, drctn, i2);
        this.avenidaOrigen =i1;
        this.calleOrigen=i;
    
    }

    public int getAvenidaOrigen() {
        return avenidaOrigen;
    }

    public int getCalleOrigen() {
        return calleOrigen;
    }
    
    

    
    
    
}
