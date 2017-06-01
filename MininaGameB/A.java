import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class A extends Enemy
{
    int start;   
    boolean check; 
    boolean alive;
    int animationE;
    private GreenfootImage gcadela1;
    private GreenfootImage gcadela2;
    private GreenfootImage gcadela3;
    private GreenfootImage gcatras1;
    private GreenfootImage gcatras2;
    private GreenfootImage gcatras3;
    private GreenfootImage gcizq1;
    private GreenfootImage gcizq2;
    private GreenfootImage gcizq3;
    private GreenfootImage gcder1;
    private GreenfootImage gcder2;
    private GreenfootImage gcder3;
    
    
    
    public A(){
        
        super();
        gcadela1 = new GreenfootImage("gcadela1.png");
        gcadela2 = new GreenfootImage("gcadela2.png");
        gcadela3 = new GreenfootImage("gcadela3.png");
        gcatras1 = new GreenfootImage("gcatras1.png");
        gcatras2 = new GreenfootImage("gcatras2.png");
        gcatras3 = new GreenfootImage("gcatras3.png");
        gcizq1 = new GreenfootImage("gcizq1.png");
        gcizq2 = new GreenfootImage("gcizq2.png");
        gcizq3 = new GreenfootImage("gcizq3.png");
        gcder1 = new GreenfootImage("gcder1.png");
        gcder2 = new GreenfootImage("gcder2.png");
        gcder3 = new GreenfootImage("gcder3.png");
        
        animationE = 0;
        start = 1; 

    }
    
    
    /**
     * Act - do whatever the A wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //enemyRandom(move);
        
        
        check = borde(flag);
        if(check == true )
            restaura();
        moveRandom(move);
        if(animationE % 3 == 0){
            checkanimation();
        }
        
        animationE++;
        
        alive=checkfire();
        if(alive == true){
            enemyoff();
        }
        
         if(isTouching(Items.class)){            
            removeTouching(Items.class);
            
        }
        
    }    
    
    public void checkanimation(){
       
        if(super.movecheck(flag) == 1)
            animationup();
        if( super.movecheck(flag)== 2)
            animationdown();
        if(super.movecheck(flag) == 3)
            animationleft();
        if(super.movecheck(flag)== 4)
            animationright();       

    }
    
    public void animationup(){
         if(start == 1)
            setImage(gcadela2);
        else if(start == 2)
            setImage(gcadela3);
          else if(start == 3){
            setImage(gcadela2);
            start = 1;
            return;
        }
        start++;
    
    }
    
    public void animationdown(){
         if(start == 1)
            setImage(gcadela2);
        else if(start == 2)
            setImage(gcadela1);
          else if(start == 3){
            setImage(gcadela3);
            start = 1;
            return;
        }
        start++;
    
    }
    
     public void animationleft(){
         if(start == 1)
            setImage(gcizq2);
        else if(start == 2)
            setImage(gcizq1);
          else if(start == 3){
            setImage(gcizq3);
            start = 1;
            return; 
        }
        start++;
    
    }
    
       public void animationright(){
         if(start == 1)
            setImage(gcder2);
        else if(start == 2)
            setImage(gcder1);
          else if(start == 3){
            setImage(gcder3);
            start = 1;
            return;
        }
        start++;
    
    }
    
    public void restaura(){     
        super.restauraE();
        setImage("gcadela2.png"); 
        check = false;
    
    }
    
    public void enemyoff(){
        getWorld().removeObject(this);
    }
}
