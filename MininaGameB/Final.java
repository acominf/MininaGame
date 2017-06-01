import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final extends World
{
   private Volver volver;
   private Ret ret;
    /**
     * Constructor for objects of class Final.
     * 
     */
    public Final()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 350, 1); 
        volver=new Volver();
        ret=new Ret();
        addObject(ret,470,290);
        
    }
}
