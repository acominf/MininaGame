import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int steps = 1;    
    int move;
    int flag = 0; 
    int lifeC;
    boolean moveX;
    boolean moveY;
    boolean lesslife;
    
    Balas bala;
    Counter contDir; 
    public SimpleTimer timer; 
    
    public Enemy(){      
        move = Greenfoot.getRandomNumber(4)+1;  
        timer = new SimpleTimer();
        bala = new Balas();
        contDir = new Counter();
        
        moveX = true;
        moveY = true; 
              

    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){        
        moveRandom(move);         
    } 
    
    public void moveRandom(int move){
        
        if(move  == 1 ) {
            flag = 1;
            movecheck(flag);
        }
        if(move == 2){
            flag = 2;
            movecheck(flag);            
        }
        if(move == 3){
            flag = 3;
            movecheck(flag);            
        }
        if(move == 4){            
            flag = 4;
            movecheck(flag);
        }
        
    }
    
    public int movecheck(int flag){        
        
             if(flag == 1){
                moveup();
                return 1;
            }
            if(flag == 2){
                movedown();
                return 2;
            }
            if(flag == 3){
                moveleft();
                return 3;
            }
            if(flag == 4){
                moveright();
                return 4;
            }        
        return 0;
    }   
    
    public void moveright(){
        setLocation(getX() + steps, getY()); 

    }    
    
     public void moveup(){
        setLocation(getX(), getY() - steps);    
   
    }
    
    public void moveleft(){
        setLocation(getX() - steps , getY());    
   
    }
    
    public void movedown(){
        setLocation(getX(), getY() + steps);    
   
    }    
       
    public boolean borde(int flag){
        
        if(isAtEdge() || getY() < 82){
           if(flag ==1){
               flag =2;
               movecheck(flag);
           }
           if(flag ==2){
               flag = 1;
               movecheck(flag);
           }
           if(flag ==3){
               flag = 4;
               movecheck(flag);
           }
           if(flag ==4){
               flag = 3;
               movecheck(flag);
           }
           return true;
        }         
        return false;   
    }    
    
    public void restauraE(){
        setLocation(Greenfoot.getRandomNumber(890),Greenfoot.getRandomNumber(460)+50);
    }
    
     public boolean checkfire(){
        if(isTouching(Balas.class)){            
            getWorld().removeObject(bala);
            return true;
        }
        return false;
    }
    
      
 
}
