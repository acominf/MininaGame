import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Write a description of class smartbom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class smartbom extends Actor
{
    /**
     * Act - do whatever the smartbom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here. 
        masCercano();
        collision();
        move(1);
    }
    
    public double distance(Actor a){
        int x= getX();
        int y = getY();
        
        int dx = x- a.getX();
        int dy = y- a.getY();
        
        return Math.sqrt( dx * dx + dy * dy);
    }
    
    public void masCercano(){
        double distancia;
        Player cercano;
        World my = getWorld();
        List<Player> theplayer = my.getObjects(Player.class);
        ListIterator<Player>  iter = theplayer.listIterator();
        if(theplayer.isEmpty()){
            return;
        }
        
        Player current = iter.next();
        distancia = distance(current);
        cercano = current;
        while(iter.hasNext()){
            current = iter.next();
            double cDst = distance(current);
            if(cDst < distancia){
                distancia = cDst;
                cercano = current;
            }
        }
        
        turnTowards(cercano.getX(), cercano.getY());
        
    }
    
    public void collision(){
        if(isTouching(Balas.class)){
            getWorld().removeObject(this);
        }
        
 
    }
    
    
}
