import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave extends Player
{   
    private GreenfootImage imgNormal;
    private GreenfootImage imgAvanzando;

    private static final int Ancho = 60;
    private static final int Alto = 60;
    private static final int Rot = 0;

    private int disparoDelay = 0;
    private int disparoMaxDelay = 30;

    /**
     * Act - do whatever the Nave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Nave()
    {
        imgNormal = preparar("NaveJugador.png", Ancho, Alto, Rot);
        imgAvanzando = preparar("NaveJugadorAvanzando.png", Ancho, Alto, Rot);

        setImage(imgNormal);
        setRotation(0);

    }

    public void act()
    {
        movimientoJugador();
        tocarBorde();
        rotacionJugador();
        actualizarImagen();
        disparoJugador();
        tocarAsteroide();
    }

    private void actualizarImagen()
    {
        if (Greenfoot.isKeyDown("w")){
            setImage(imgAvanzando);
        }else{
            setImage(imgNormal);
        }
    }

    private GreenfootImage preparar(String archivo, int w, int h, int rot){
        GreenfootImage img = new GreenfootImage(archivo);
        img.scale(w,h);
        if (rot != 0){
          img.rotate(rot);  
        }
        return img;
    }

    private void disparoJugador(){
        if (disparoDelay > 0)
        {
            disparoDelay--;
        }
        if (Greenfoot.isKeyDown("space") && disparoDelay == 0)
        {
            BalaJugador bala = new BalaJugador(getRotation(), getDX(), getDY());
            getWorld().addObject(bala, getX(), getY());
            disparoDelay = disparoMaxDelay;
        }
    }
}
