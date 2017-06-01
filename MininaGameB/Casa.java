import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class casa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Casa extends Actor
{
    int level;
    int puntaje;
    /**
     * Act - do whatever the Mirror wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */       
    public void act() 
    {
       checkPlayer(); 
    }    
    
    public void setLevel(int level){
        this.level = level;        
    }
    
    
    public void checkPlayer(){
        World m = getWorld();
        MyWorld l = (MyWorld)m;
        if(isTouching(Player.class) ){
            if(level == 2){
                Level2 l2 = new Level2();
                Greenfoot.setWorld(l2); 
            }
            if(level == 3){
                Level3 l3 = new Level3();
                Greenfoot.setWorld(l3); 
            }
            if(level == 4){
                Final f =  new Final();
                Greenfoot.setWorld(f); 
            }
            
           
        }
        
    }
}
