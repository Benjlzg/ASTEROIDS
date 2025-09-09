import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroideGrande here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroideGrande extends Asteroides
{
    /**
     * Act - do whatever the AsteroideGrande wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AsteroideGrande(){
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
        direccionAsteroide();
    }
    public void act()
    {
        movAsteroideGrande();
        tocarBorde();
        romperAstGrande();
    }
}
