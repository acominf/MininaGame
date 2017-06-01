import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int start = 1;
    int move = 12;
    int animation = 0;
    int contVidas;
    int x;
    int control;
    boolean vidaB ;
    boolean made;
    private GreenfootImage gadela1;
    private GreenfootImage gadela2;
    private GreenfootImage gadela3;
    private GreenfootImage gatras1;
    private GreenfootImage gatras2;
    private GreenfootImage gatras3;
    private GreenfootImage gizq1;
    private GreenfootImage gizq2;
    private GreenfootImage gizq3;
    private GreenfootImage gder1;
    private GreenfootImage gder2;
    private GreenfootImage gder3;
   
    Vida stamina;
    Carga carga;
    public Counter lives;
    public Counter bullet;
    Balas bala; 
   
    
    public Player(World world){
        gadela1 = new GreenfootImage("gadela1.png");
        gadela2 = new GreenfootImage("gadela2.png");
        gadela3 = new GreenfootImage("gadela3.png");
        gatras1 = new GreenfootImage("gatras1.png");
        gatras2 = new GreenfootImage("gatras2.png");
        gatras3 = new GreenfootImage("gatras3.png");
        gizq1 = new GreenfootImage("gizq1.png");
        gizq2 = new GreenfootImage("gizq2.png");
        gizq3 = new GreenfootImage("gizq3.png");
        gder1 = new GreenfootImage("gder1.png");
        gder2 = new GreenfootImage("gder2.png");
        gder3 = new GreenfootImage("gder3.png");
        stamina = new Vida();
        lives = new Counter("Vidas: ");
        bullet = new Counter("Balas: ");
        carga = new Carga();
        lives.setValue(3);        
        world.addObject(lives , 769 , 22);
        //world.addObject(bullet , 325 , 22);
        
        x = 200;
        contVidas = 1000;
        control = 10;
        made = true;
        vidaB = true;
        
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int flag = 0;
        animation++;
        flag = leerTeclado();
        
        fire(flag);       
        vidaB = true;
        checkVida();
        if(vidaB == false)
        {
            contVidas--;
            if(contVidas == 0)
            {
                vidaB = true;
                
                contVidas = 1000;
            }
        }      
    
        
    }  
    
        public int leerTeclado(){
        int flagM =0;
        
         if(Greenfoot.isKeyDown("w")){
             flagM = 1;
             movecheck(flagM);
             return 1;
             
            }else if (Greenfoot.isKeyDown("s")){
             flagM = 2;
             movecheck(flagM);
             return 2;
             
            }else if (Greenfoot.isKeyDown("a")){               
                flagM = 3;
                movecheck(flagM);
                return 3;
                
            }else if (Greenfoot.isKeyDown("d")){
             flagM = 4;
             movecheck(flagM); 
              return 4;
             
       }
       else {
        return 0;
        }
       
       //checkTouch(flag);
    }
    
    public void movecheck(int flagM){
        if(animation % 4 == 0){
            
            if(flagM == 1)
                moveup();
            if(flagM == 2)
                movedown();
            if(flagM == 3)
                moveleft();
            if(flagM == 4)
                moveright();
        }
        
    }
    
    public void moveright(){
        setLocation(getX() + move, getY());     
         aniRight();
    }
    
    public void aniRight(){
        
            if(start == 1)
            setImage(gder2);
        else if(start == 2)
            setImage(gder1);
          else if(start == 3){
            setImage(gder3);
            start = 1;
            return;
        }
        start++;
    }
    
    public void moveleft(){
        setLocation(getX() - move, getY());     
         aniLeft();
    }
    
    public void aniLeft(){
           if(start == 1)
            setImage(gizq2);
        else if(start == 2)
            setImage(gizq1);
          else if(start == 3){
            setImage(gizq3);
            start = 1;
            return;
        }
        start++;
    }
    
    public void moveup(){
        setLocation(getX(), getY() - move ); 
        aniUp();
    }
    
    public void aniUp(){
            if(start == 1)
            setImage(gatras1);
        else if(start == 2)
            setImage(gatras3);
          else if(start == 3){
            setImage(gatras1);
            start = 1;
            return;
        }
        start++;
    }
    
    
    public void movedown(){
        setLocation(getX(), getY() + move );     
            aniDown();
    }
    
    public void aniDown(){
            if(start == 1)
            setImage(gadela1);
        else if(start == 2)
            setImage(gadela2);    
          else if(start == 3){
            setImage(gadela3);
            start = 1;
            return;
        }
        start++;
    }  
    
    public void addScore(int puntos){       
       World w = getWorld();
       MyWorld my = (MyWorld)w;
       my.addScoreM(puntos);
       my.addObject(carga,325,23);
       bullet.add(1);
       made = true;
    }
    
    public void fire(int flag){
        if(Greenfoot.isKeyDown("l") && made == true){
            if(bullet.getValue() >= 0){
                MyWorld mw = (MyWorld)getWorld();
                bala = new Balas();
                mw.addObject(bala,0,0);
                bala.setLocation(getX()+5,getY()+5);
                bala.checkDirection(flag);
                Greenfoot.playSound("fire.wav");
                mw.removeObject(carga);
                bullet.add(-1);
                made = false;
            }
        }
    }
    
    public void checkVida(){        
        Actor a = this.getOneIntersectingObject(Enemy.class);  
        getWorld().addObject(stamina, 845,23);
         Actor b = this.getOneIntersectingObject(Estambre.class);
        removeTouching(Estambre.class);
        if(a != null && vidaB == true){   
            setLocation(445,266);
            addVidas();  
            setVidas();
            vidaB = false; 
            
        }  
         
        
        if(b != null && vidaB == true){
            setLocation(445,266);
             Bonus();
            setVidas();    
          
        }

    }
    
    public void setVidas(){
        
        if(lives.getValue() == 3){
            getWorld().addObject(stamina, 845,23);
            
        }
        
        if(lives.getValue() == 2){
            stamina.setHalf();
            
        }
    
        if(lives.getValue() == 1){
            stamina.setEmpty();
            
        }
        
        if(lives.getValue() <= 0){
           end fin = new end();
          Greenfoot.setWorld(fin);
              
        }
    }
    
    public void addVidas(){        
        lives.add(-1);
        
    }
    
 
    public void Bonus()
    {
        if(lives.getValue() <=2){
         lives.add(+1);
        }
    }
 
    
        
    
    }
