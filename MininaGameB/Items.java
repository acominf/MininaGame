import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Items here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Items extends Actor
{
    private boolean valor;
    public int puntos;
    /**
     * Act - do whatever the Items wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Items(){
        valor= true;    
        puntos = 0;
    }
    
    public void act(){
        checkItems();
    }         
    
    public void checkItems(){        
        Actor a = this.getOneIntersectingObject(Player.class);       
        if(a != null && valor == true){    
            Greenfoot.playSound("Take.wav");
            addScorei();
            remuveItem();            
            valor = false;            
        }       

    }
    
    public void addScorei(){
        Actor a = this.getOneIntersectingObject(Player.class);
        Player p = (Player)a;
        p.addScore(puntos);
    }
    
    public void remuveItem(){
        getWorld().removeObject(this);
    }
}
