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
public class Usuario extends Thing {
    
    private int pisoDeseado;

    public Usuario(City city, int i, int i1, int pisoDeseado) {
        super(city, i, i1);
        this.pisoDeseado = pisoDeseado;
    }

    public int getPisoDeseado() {
        return pisoDeseado;
    }

    public void setPisoDeseado(int pisoDeseado) {
        this.pisoDeseado = pisoDeseado;
    }
    
    
    
    
}
