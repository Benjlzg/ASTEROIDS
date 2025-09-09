import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    // ===== Campos mínimos para inercia =====
    private double dx = 0;       // velocidad en X
    private double dy = 0;       // velocidad en Y

    // Ajustes sencillos
    private double accel = 0.20; // cuánto acelera con W
    private double fric  = 0.99; // fricción (1 = sin fricción)
    private double vmax  = 4.0;  // tope de velocidad

    int rotacion = 4;

    public double getDX() { 
        return dx; 
    }

    public double getDY() { 
        return dy; 
    }

    public void act()
    {
        // Add your action code here.
    }

    public void movimientoJugador(){
        // Acelera solo si W está presionado
        if (Greenfoot.isKeyDown("w")) {
            double rad = Math.toRadians(getRotation());
            dx += Math.cos(rad) * accel;
            dy += Math.sin(rad) * accel;
        } else {
            // aplica fricción cuando no aceleras (también puedes dejarla siempre)
            dx *= fric;
            dy *= fric;
        }

        // Limitar velocidad máxima
        double v = Math.hypot(dx, dy);
        if (v > vmax) {
            double s = vmax / v;
            dx *= s; dy *= s;
        }

        // Mover usando la velocidad acumulada (inercia)
        setLocation((int)Math.round(getX() + dx), (int)Math.round(getY() + dy));
    }

    public void rotacionJugador()
    {
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(getRotation() + rotacion);    
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setRotation(getRotation() - rotacion);    
        }
    }

    public void tocarBorde() {
        int x = getX();
        int y = getY();
        int width  = getWorld().getWidth();
        int height = getWorld().getHeight();

        // Eje X (usar <= y >=)
        if (x <= 0) {
            x = width - 1;
        } else if (x >= width - 1) {
            x = 0;
        }

        // Eje Y (usar <= y >=)
        if (y <= 0) {
            y = height - 1;
        } else if (y >= height - 1) {
            y = 0;
        }

        setLocation(x, y);
    }

    public void tocarAsteroide(){
        if (getOneIntersectingObject(Asteroides.class) != null) {
            Greenfoot.setWorld(new GameOver());
            return; // evita que se ejecute más código este turno
        }
    }
}
