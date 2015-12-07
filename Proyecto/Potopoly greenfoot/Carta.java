import greenfoot.*;

/**
 * Carta de comunidad o de oportunidad
 * 
 * @author Equipo potopoly 
 * @version 26-Nov-15
 */
public class Carta extends Actor
{
    public Carta()
    {
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Este metodo cambia la imagen de la carta
     * 
     * @param num Numero id de la carta
     * 
     */
    public void tomaImagen(int num)
    {
        GreenfootImage imagen;
        switch(num) {
            case 1:
                imagen = new GreenfootImage("comu1.png");
                break;
            case 2:
                imagen = new GreenfootImage("comu2.png");
                break;
            case 3:
                imagen = new GreenfootImage("comu3.png");
                break;
            case 4:
                imagen = new GreenfootImage("comu4.png");
                break;
            case 5:
                imagen = new GreenfootImage("op1.png");
                break;
            case 6:
                imagen = new GreenfootImage("op2.png");
                break;
            case 7:
                imagen = new GreenfootImage("op3.png");
                break;
            case 8:
                imagen = new GreenfootImage("op4.png");
                break;
            case 9:
                imagen = new GreenfootImage("op5.png");
                break;
            case 10:
                imagen = new GreenfootImage("op6.png");
                break;
            case 11:
                imagen = new GreenfootImage("op7.png");
                break;
            case 12:
                imagen = new GreenfootImage("op8.png");
                break;
            case 13:
                imagen = new GreenfootImage("op9.png");
                break;
            case 14:
                imagen = new GreenfootImage("VeCarcel.png");
                break;
            default:
                imagen = new GreenfootImage("SalCarcel.png");
                break;
        }
        setImage(imagen);
    }
}
