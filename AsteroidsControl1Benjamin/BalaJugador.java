import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaJugador extends Bala {
    public BalaJugador(int rotation) {
        setRotation(rotation); 
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);

        // Usamos los heredados de Bala
        speed = 10;  // ajusta velocidad
        vida = 40;   // ajusta rango
    }
}
