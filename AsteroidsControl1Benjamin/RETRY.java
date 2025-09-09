import greenfoot.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class RETRY extends Actor {

    public RETRY() {
        setImage(crearImagenGameOver());
    }
    public void act(){
        IniciarJuego();
    }
    private GreenfootImage crearImagenGameOver() {
        GreenfootImage img = new GreenfootImage(800, 200);

        try {
            // Cargar y registrar la fuente ArcadeClassic.ttf
            File f = new File("fonts/ArcadeClassic.ttf");
            Font awt = Font.createFont(Font.TRUETYPE_FONT, f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(awt);

            // Usa el nombre de familia de la fuente registrada
            String family = awt.getFamily();  
            System.out.println("Fuente cargada: " + family);

            // Crear un greenfoot.Font con ese nombre
            greenfoot.Font gf = new greenfoot.Font(family, false, false, 30);

            img.setFont(gf);
            img.setColor(greenfoot.Color.WHITE);
            img.drawString("PRESS ENTER TO PLAY", 40, 140);

        } catch (Exception e) {
            // Si falla, usar fuente por defecto
            img = new GreenfootImage("PRESS ENTER TO PLAY", 30, greenfoot.Color.WHITE, new greenfoot.Color(0,0,0,0));
        }

        return img;
    }
    public void IniciarJuego()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new JuegoAsteroids());
        }
    }
}
