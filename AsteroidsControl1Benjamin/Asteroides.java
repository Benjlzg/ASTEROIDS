import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Asteroides extends Actor
{
    // Evita que el mismo asteroide se rompa 2 veces en el mismo frame
    private boolean destruido = false;

    public void act() {

    }

    public void movAsteroideGrande(){ 
        move(1); 
    }
    public void movAsteroideMediano(){ 
        move(1); 
    }
    public void movAsteroideChico(){ 
        move(1); 
    }

    public void direccionAsteroide(){
        setRotation(Greenfoot.getRandomNumber(360));
    }

    public void tocarBorde() {
        int x = getX();
        int y = getY();
        int width  = getWorld().getWidth();
        int height = getWorld().getHeight();

        if (x <= 0){
            x = width - 1;
        }else if (x >= width - 1){
            x = 0;
        }

        if (y <= 0){
            y = height - 1;
        } else if (y >= height - 1){
            y = 0;
        }

        setLocation(x, y);
    }

    public void romperAstGrande(){
        if (destruido) return;
        BalaJugador bala = (BalaJugador)getOneIntersectingObject(BalaJugador.class);
        if (bala != null){
            destruido = true;

            World w = getWorld();      
            int x = getX(), y = getY(); 

            w.removeObject(bala);       
            
            AsteroideMediano a1 = new AsteroideMediano();
            AsteroideMediano a2 = new AsteroideMediano();
            w.addObject(a1, x, y);
            w.addObject(a2, x, y);
            a1.direccionAsteroide();
            a2.direccionAsteroide();

            w.removeObject(this);       
        }
    }

    public void romperAstMediano(){
        if (destruido) return;
        BalaJugador bala = (BalaJugador)getOneIntersectingObject(BalaJugador.class);
        if (bala != null){
            destruido = true;

            World w = getWorld();
            int x = getX(), y = getY();

            w.removeObject(bala);
            AsteroideChico a1 = new AsteroideChico();
            AsteroideChico a2 = new AsteroideChico();
            w.addObject(a1, x, y);
            w.addObject(a2, x, y);
            a1.direccionAsteroide();
            a2.direccionAsteroide();

            w.removeObject(this);
        }
    }

    public void romperAstChico(){
        if (destruido) return;
        BalaJugador bala = (BalaJugador)getOneIntersectingObject(BalaJugador.class);
        if (bala != null){
            destruido = true;

            World w = getWorld();
            w.removeObject(bala);
            w.removeObject(this);
        }
    }
}
