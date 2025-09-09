import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroideChico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroideChico extends Asteroides
{
    /**
     * Act - do whatever the AsteroideChico wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AsteroideChico(){
        direccionAsteroide();
    }
    public void act()
    {
        movAsteroideChico();
        tocarBorde();
        romperAstChico();
    }
}
