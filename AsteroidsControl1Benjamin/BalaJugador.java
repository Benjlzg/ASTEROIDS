import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaJugador extends Bala {
    public BalaJugador(int rotation, double dx, double dy) {
        setRotation(rotation); 
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
        int vBala = (int)(Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2))));

        // Usamos los heredados de Bala
        speed = 10 + vBala;  // ajusta velocidad
        vida = 40;   // ajusta rango
    }
}
