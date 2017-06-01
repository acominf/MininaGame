import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class end here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class end extends World
{
    Ret retorno;
    /**
     * Constructor for objects of class End.
     * 
     */
    public end()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        retorno = new Ret();
        addObject(retorno,470,240);
    }
}
