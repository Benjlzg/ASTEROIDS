import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int speed = 10;   // velocidad por defecto
    protected int vida = 60;   // rango en frames (ajústalo a gusto)
    
    public void act()
    {
        move(speed);
        tocarBorde();
        vida--;

        if (vida <= 0) {
            getWorld().removeObject(this);
        }
    }
    
    protected void tocarBorde() {
        int x = getX();
        int y = getY();
        int width  = getWorld().getWidth();
        int height = getWorld().getHeight();

        if (x <= 0) {
            x = width - 1;
        } else if (x >= width - 1) {
            x = 0;
        }

        if (y <= 0) {
            y = height - 1;
        } else if (y >= height - 1) {
            y = 0;
        }

        setLocation(x, y);
    }
    
}


