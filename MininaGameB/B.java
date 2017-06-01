import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class B extends Enemy
{
    boolean check;
    boolean alive;
    int start; 
    int animationE;
    private GreenfootImage paadela1; 
    private GreenfootImage paadela2;
    private GreenfootImage paadela3;
    private GreenfootImage paatras1;
    private GreenfootImage paatras2;
    private GreenfootImage paatras3;
    private GreenfootImage paizq1;
    private GreenfootImage paizq2;
    private GreenfootImage paizq3;
    private GreenfootImage pader1;
    private GreenfootImage pader2;
    private GreenfootImage pader3;
    
    /**
     * Act - do whatever the B wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public B() 
    {
        super();
        
        paadela1 = new GreenfootImage("paadela1.png");
        paadela2 = new GreenfootImage("paadela2.png");
        paadela3 = new GreenfootImage("paadela3.png");
        paatras1 = new GreenfootImage("paatras1.png");
        paatras2 = new GreenfootImage("paatras2.png");
        paatras3 = new GreenfootImage("paatras3.png");
        paizq1 = new GreenfootImage("paizq1.png");
        paizq2 = new GreenfootImage("paizq2.png");
        paizq3 = new GreenfootImage("paizq3.png");
        pader1 = new GreenfootImage("pader1.png");
        pader2 = new GreenfootImage("pader2.png");
        pader3 = new GreenfootImage("pader3.png");
        
        animationE = 0;
        start = 1;
        steps = 1;
    }   
    
    public void act(){
        check = borde(flag);
        if(check == true )
            restaura();
        moveRandom(move);
        if(animationE % 3 == 0){
            checkanimation();
        }
        alive=checkfire();
        if(alive == true){
            enemyoff();
        }
        animationE++;
        
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
            setImage(paatras2);
        else if(start == 2)
            setImage(paatras1);
          else if(start == 3){
            setImage(paatras3);
            start = 1;
            return;
        }
        start++;
    
    }
    
    public void animationdown(){
         if(start == 1)
            setImage(paadela2);
        else if(start == 2)
            setImage(paadela1);
          else if(start == 3){
            setImage(paadela3);
            start = 1;
            return;
        }
        start++;  
    
    }
    
     public void animationleft(){
         if(start == 1)
            setImage(paizq2);
        else if(start == 2)
            setImage(paizq1);
          else if(start == 3){
            setImage(paizq3);
            start = 1;
            return;
        }
        start++;
    
    }
    
       public void animationright(){
         if(start == 1)
            setImage(pader2);
        else if(start == 2)
            setImage(pader1);
          else if(start == 3){
            setImage(pader3);
            start = 1;
            return;
        }
        start++;
    
    }
    
    public void restaura(){     
        super.restauraE();
        setImage("paadela2.png"); 
        check = false;
    
    }
    
     public void enemyoff(){
        getWorld().removeObject(this);
    }
}
