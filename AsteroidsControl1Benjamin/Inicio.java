import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class INICIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inicio extends Actor
{
    /**
     * Act - do whatever the INICIO wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        IniciarJuego();
    }
    public void IniciarJuego()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new JuegoAsteroids());
        }
    }
}
