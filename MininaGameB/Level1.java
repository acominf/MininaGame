import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MyWorld
{
    private boolean crear;
    private boolean prepareenemy;
    private boolean item;
    Items items;
    Balas bala ;
    Pez pez;
    Estambre estambre ;
    Croqueta croqueta ;     
    Player player ;    
    private A[] arrayEneA; 
    int level;
    int tiempo;
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
        super();
        which = true;
        prepareEnemies(which);
        tiempo = 30;
        level = 2;   
        casa.setLevel(level);
        
    } 
    
    
    
}
