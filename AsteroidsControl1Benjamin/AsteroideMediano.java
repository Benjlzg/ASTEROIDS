import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroideMediano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroideMediano extends Asteroides
{
    /**
     * Act - do whatever the AsteroideMediano wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AsteroideMediano(){
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
        direccionAsteroide();
    }
    public void act()
    {
        movAsteroideMediano();
        tocarBorde();
        romperAstMediano();
    }
}
