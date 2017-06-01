import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   

    private SimpleTimer timer;   
    public Counter timerDisplay;
    public Counter timerItem;
    public Counter puntosI;
    private boolean crear;
    private boolean prepareenemy;
    private boolean item;
    private boolean made;
    private int startX; 
    private int startY;
    public boolean which;
    Items items;
    Balas bala ;
    Pez pez;
    Estambre estambre ;
    Casa casa;
    Croqueta croqueta ;   
    Player player ;  
    
    D enemyD;
    private A[] arrayEneA;   
    private B[] arrayEneB; 

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(890, 522, 1);
        startX = 445;
        startY = 266;

        crear = true;
        item = true;  
        made = true;
        prepareenemy = true;       
        

        timer = new SimpleTimer();
        items = new Items();
        bala = new Balas();
        arrayEneA = new A[2];
        arrayEneB = new B[2];
        estambre= new Estambre();        
        player = new Player(this);
        casa = new Casa();

        timerDisplay = new Counter("Time: ");                
        timerItem = new Counter("Timeaslknfaj: ");
        puntosI = new Counter("Puntos: "); 

        addObject(player,Greenfoot.getRandomNumber(50)+500,Greenfoot.getRandomNumber(500)+22);        
        addObject(timerDisplay , 200 , 22);  
        addObject(puntosI , 50 , 22);

        
    }
   

    public void prepareEnemies(boolean which){
        int enemyX = 50;
        int enemyY = 90; 
        if( prepareenemy == true && which == true){
            for(int x = 0; x < 2 ; x++){
                arrayEneA[x] = new A();            
                addObject(arrayEneA[x], enemyX, enemyY);               
                enemyX = enemyX * 3;            
            }           
            prepareenemy = false;
        }
        else{
            enemyX = 50;
            enemyY = 90;         
            if(which == false ){
                for( int c = 0; c < 2 ; c++){
                    arrayEneB[c] = new B();            
                    addObject(arrayEneB[c], enemyX, enemyY);               
                    enemyY = enemyY * 3;            
                }       

            }
        }

    }

    public void act(){
        timerIni();
        checkTimer();    
        //addMirror();

    }

    public void timerIni(){
        if(timer.millisElapsed() > 1000 ){
            crear = true;
            item = true;
            timerDisplay.add(1);
            timerItem.add(1);
            timer.mark();
        }

    }

    public void checkTimer(){

        if(timerItem.getValue() % 1 == 0 && crear == true && timerItem.getValue() != 0){            
            prepareE();
            crear = false;   

        }

        if(timerItem.getValue() % 6 == 0 && item == true  && timerItem.getValue() != 0){            
            prepareP();
            item = false;
        }
        
        if(timerItem.getValue() % 30 == 0 && made == true && timerItem.getValue() !=0){      
            
            addObject(casa, 822, 445); 
            made = false;

        }
        
             if(timerItem.getValue() % 20 == 0 && item == true  && timerItem.getValue() != 0){            
            prepareL();
            item = false;
            
        }
     
    }         
     
    public void addScoreM(int puntos){       
        if(puntos == 1)
            puntosI.add(1);
        if(puntos == 5)
            puntosI.add(5); 
        if(puntos == 30)
            puntosI.add(30); 
    }

    public void prepareE(){
        int coorX = Greenfoot.getRandomNumber(850);
        int coorY = Greenfoot.getRandomNumber(460)+50;   

        if(crear == true){  
            pez   = new Pez(); 
            addObject(pez, coorX, coorY);

        }

    }

    public void prepareP(){
        int coorX = Greenfoot.getRandomNumber(850); 
        int coorY = Greenfoot.getRandomNumber(460)+50;         

        if (item = true){
            croqueta = new Croqueta();
            addObject(croqueta,coorX,coorY);
        }

    }    
    
    public void prepareL(){
        int coorX = Greenfoot.getRandomNumber(850);
        int coorY = Greenfoot.getRandomNumber(460)+50;         

        if (item = true){
            estambre = new Estambre();
            addObject(estambre,coorX,coorY);
            
        }

    }  

    public int getPuntaje(){
        int puntos = puntosI.getValue();
        return puntos;
    }
    
    
       

    }
 