import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class C here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class D extends Enemyfolloxer
{
    int start; 
    int animationE;
    int flag;
    int liveD;
    int puntaje;
    
    boolean canM;
    boolean track;
    boolean canbullet;
    
    private GreenfootImage padela1; 
    private GreenfootImage padela2; 
    private GreenfootImage padela3; 
    private GreenfootImage patras1;
    private GreenfootImage patras2; 
    private GreenfootImage patras3;
    private GreenfootImage pizq1; 
    private GreenfootImage pizq2;
    private GreenfootImage pizq3;
    private GreenfootImage pder1;
    private GreenfootImage pder2;
    private GreenfootImage pder3;
    smartbom crem;
       
    /**
     * Act - do whatever the C wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public D()
    {
        super();
        
        padela1 = new GreenfootImage("padela1.png");
        padela2 = new GreenfootImage("padela2.png");
        padela3 = new GreenfootImage("padela3.png");  
        patras1 = new GreenfootImage("patras1.png");
        patras2 = new GreenfootImage("patras2.png");
        patras3 = new GreenfootImage("patras3.png");
        pizq1 = new GreenfootImage("pizq1.png");
        pizq2 = new GreenfootImage("pizq2.png");
        pizq3 = new GreenfootImage("pizq3.png");
        pder1 = new GreenfootImage("pder1.png");
        pder2 = new GreenfootImage("pder2.png");
        pder3 = new GreenfootImage("pder3.png");
        
        animationE = 0;
        start = 1;        
        steps = 1;
        flag = 0;  
        liveD = 5;        
        
        canM = true;  
        track= true;
        canbullet = true;
         
    }    
    
    public void act(){
        timerDir();                 
         canM = true;            
         follow();
        checkanimation();                 
         
         bulletD();
         if(contDir.getValue() % 50 == 0){                      
                track = true;
            }
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
            setImage(padela1);
        else if(start == 2)
            setImage(padela2);
          else if(start == 3){
            setImage(padela3);
            start = 1;
            return;
        }
        start++;
    
    }
    
    public void animationdown(){
         if(start == 1)
            setImage(patras1);
        else if(start == 2)
            setImage(patras2);
          else if(start == 3){
            setImage(patras3);
            start = 1;
            return;
        }
        start++;
    
    }
    
     public void animationleft(){
         if(start == 1)
            setImage(pizq1);
        else if(start == 2)
            setImage(pizq2);
          else if(start == 3){
            setImage(pizq3);
            start = 1;
            return;
        }
        start++;
    
    }
    
       public void animationright(){
         if(start == 1)
            setImage(pder2);
        else if(start == 2)
            setImage(pder1);
          else if(start == 3){
            setImage(pder3);
            start = 1;
            return;
        }
        start++;
    
    }
    
    
    public void lessLife(){
        lesslife = checkfireCD();
        if(lesslife == true && canM == true){
            liveD--;                      
        }                         
        if(liveD <= 0){
            getWorld().removeObject(this);            
            }                         
    }
    
    public void bulletD(){
        Level3 lev = new Level3();
         //= lev.stillAlive();
        if(track == true){
            if(contDir.getValue() % 5 == 0 && canbullet == true){     
                crem = new smartbom();
                getWorld().addObject(crem, getX() +5, getY()); 
                
                canbullet = false;
            }
            track = false;
        }                                
      } 
    
    
}
 