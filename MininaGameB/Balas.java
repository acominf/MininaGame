import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balas extends Actor
{
    
    /**
     * Act - do whatever the Balas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 
     
    public void act() 
    {
        move(4); 
        collision();
        
        
    }   
    
    public void checkDirection(int flag){
        if(flag == 2){
          setRotation(90);
          setImage("bolita.png");
        }
        if(flag == 1){            
            setRotation(-90);
            setImage("bolita.png");
        }
        if(flag == 4){              
            setRotation(0);
            setImage("bolita.png");
        }
        if(flag == 3){            
            setRotation(180);          
            setImage("bolita.png");
        }

    }     
            
    public void collision(){
        if(isAtEdge()){
            balasoff();
        }
        
    } 
    
    public void balasoff(){
        getWorld().removeObject(this);
    }
    
     
    }

