import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class C here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class C extends Enemyfolloxer
{
    int start; 
    int animationE;
    int flag;
    int control;
    int liveC;
    boolean alive;
    boolean canM;
    
    
    private GreenfootImage radela1; 
    private GreenfootImage radela2;
    private GreenfootImage radela3;
    private GreenfootImage ratras1;
    private GreenfootImage ratras2;
    private GreenfootImage ratras3;
    private GreenfootImage rizq1;
    private GreenfootImage rizq2;
    private GreenfootImage rizq3;
    private GreenfootImage rder1;
    private GreenfootImage rder2;
    private GreenfootImage rder3;
    
   
    
    /**
     * Act - do whatever the C wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public C() 
    {
        //super();
        
        radela1 = new GreenfootImage("radela1.png");
        radela2 = new GreenfootImage("radela2.png");
        radela3 = new GreenfootImage("radela3.png");
        ratras1 = new GreenfootImage("ratras1.png");
        ratras2 = new GreenfootImage("ratras2.png");
        ratras3 = new GreenfootImage("ratras3.png");
        rder1 = new GreenfootImage("rder1.png");
        rder2 = new GreenfootImage("rder2.png");
        rder3 = new GreenfootImage("rder3.png");
        rizq1 = new GreenfootImage("rizq1.png");
        rizq2 = new GreenfootImage("rizq2.png");
        rizq3 = new GreenfootImage("rizq3.png");
        
        animationE = 0;
        start = 1;        
        steps = 1;
        flag = 0;  
        liveC = 3;
        
        canM = true; 
        alive = true;
        control =50;         
    }    
    
    public void act(){
        timerDir();                 
         canM = true;            
         follow();
        checkanimation();                 
        setUbicacion();
         lessLife();
        animationE++;
        }            
    
        public void checkanimation(){
       int ani = follow();
        if(ani == 1)
            animationup();
        if( ani== 2)
            animationdown();
        if(ani == 3)
            animationleft();
        if(ani== 4)
            animationright();       
    }
    
    public void animationup(){
         if(start == 1)
            setImage(ratras1);
        else if(start == 2)
            setImage(ratras2);
          else if(start == 3){
            setImage(ratras3);
            start = 1;
            return;
        }
        start++;
    }
    
    public void animationdown(){
         if(start == 1)
            setImage(radela1);
        else if(start == 2)
            setImage(radela2);
          else if(start == 3){
            setImage(radela3);
            start = 1;
            return;
        }
        start++;    
    }
    
     public void animationleft(){
         if(start == 1)
            setImage(rizq1);
        else if(start == 2)
            setImage(rizq2);
          else if(start == 3){
            setImage(rizq3);
            start = 1;
            return;
        }
        start++;    
    }
    
       public void animationright(){
         if(start == 1)
            setImage(rder1);
        else if(start == 2)
            setImage(rder2);
          else if(start == 3){
            setImage(rder3);
            start = 1;
            return;
        }
        start++;    
    }    
    
    public void lessLife(){
        lesslife = checkfireCD();
        if(lesslife == true && canM == true){
            liveC--;                      
        } 
        
        if(liveC <= 0){
            getWorld().removeObject(this);            
            }                         
    }      
}


