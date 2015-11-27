import greenfoot.*;

/**
 * Write a description of class Cromo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cromo extends Actor
{
    public Cromo(int tipo) 
    {
        GreenfootImage imagen;
        switch(tipo) {
            case 1:
                imagen = new GreenfootImage("Cromo1.png");
                break;
            case 2:
                imagen = new GreenfootImage("Cromo2.png");
                break;
            case 3:
                imagen = new GreenfootImage("Cromo3.png");
                break;
            case 4:
                imagen = new GreenfootImage("Cromo4.png");
                break;
            case 5:
                imagen = new GreenfootImage("Cromo5.png");
                break;
            case 6:
                imagen = new GreenfootImage("Cromo6.png");
                break;
            case 7:
                imagen = new GreenfootImage("Cromo7.png");
                break;
            case 8:
                imagen = new GreenfootImage("Cromo8.png");
                break;
            default:
                imagen = new GreenfootImage("CromoC.png");
                break;
        }
        setImage(imagen);
    }
    
    public void act()
    {
        
    }
}
