import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    private Names names;
    private Ayuda ayuda;
    private Start start;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        names=new Names();
        ayuda=new Ayuda();
        start=new Start(); 
        
        addObject(names,300,50);
        addObject(ayuda, 200, 230);  
        addObject(start,450,230); 
    }
}
