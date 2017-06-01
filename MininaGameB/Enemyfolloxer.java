import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemyfolloxer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemyfolloxer extends Enemy
{
    
    /**
     * Act - do whatever the Enemyfolloxer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
   
    
    public int follow(){
        Player user = lookingAt();
        if( user!= null){
            int px = user.getX();
            int py = user.getY();
            boolean can = setMove();
            if( contDir.getValue() % 3 == 0 && can == true){
                if(px < getX()){
                    moveX = false;
                    //Se va hacia la izquierda
                    flag = 3;
                    return 3;                    
                }
                else{
                    moveX = false;
                    flag = 4;
                    return 4;
                    // se va a la derecha
                }                
            }            
            if(contDir.getValue() % 5 == 0 && can == false){
                if( getY() < py){
                    moveY = false;
                    flag = 2; 
                    return 2;
                    //va hacia abajo
                }
                else{
                    moveY = false;
                    flag = 1;
                    return 1;
                    // va arriba
                }
            }
        }
        else
            return 0;
        movecheck(flag);        
        return 0;
    }
    
    public Player lookingAt(){
        List<Player> p;
        p = getObjectsInRange(400,Player.class);
        if(!p.isEmpty()){
            Player person = p.get(p.size()-1);           
            if(person != null){
                return person;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }              
    
     public void timerDir(){
        if(timer.millisElapsed() > 100 ){         
            contDir.add(1);            
            timer.mark();
        }        
    }
    
    public boolean setMove(){
        if(contDir.getValue() % 2 == 0 && contDir.getValue() != 0){
            moveX = true;
            moveY = true;      
            return true;
        }
        return false;               
    }        
    
    public boolean checkfireCD(){
        Actor a = this.getOneIntersectingObject(Balas.class);  
        if(a!= null){ 
            Balas bala = (Balas)a;
            bala.balasoff();
            return true;
            
        }
        return false;
    }      
    
    public void setUbicacion(){
        if(isTouching(Player.class)){ 
            setLocation(Greenfoot.getRandomNumber(150), 400);
        }
    }
}


