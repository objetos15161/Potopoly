import greenfoot.*;

/**
 * Write a description of class Tablero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero extends World
{
    private int numJug; //Indica el numero de jugadores
    private int [] casillaX = new int [40]; //Coordenadas X y Y del centro de cada casilla
    private int [] casillaY = new int [40];
    private boolean inicio = false;
    private Jugador j1, j2, j3, j4;
    
    private Ventana v = new Ventana();
    private Boton b2 = new Boton(100,50,"2");
    private Boton b3 = new Boton(100,50,"3");
    private Boton b4 = new Boton(100,50,"4");
    
    /**
     * Constructor para la clase Tablero.
     * 
     */
    public Tablero()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(v,300,300);
        addObject(b2,300,250);
        addObject(b3,300,350);
        addObject(b4,300,450);
        iniCasillas();
    }
    
    public void act()
    {
       if(!inicio)
       {
           if(Greenfoot.mouseClicked(b2))
            {
                numJug = 2;
                inicio = true;
                borraVentana();
                colocaJugadores();
            }
           if(Greenfoot.mouseClicked(b3))
           {
               numJug = 3;
               inicio = true;
               borraVentana();
               colocaJugadores();
           }
           if(Greenfoot.mouseClicked(b4))
           {
               numJug = 4;
               inicio = true;
               borraVentana();
               colocaJugadores();
           }
       }
       else
       {
           /*turnoJ1();
           turnoJ2();
           if(numJug >= 3)
               turnoJ3();
           if(numJug == 4)
               turnoJ4();*/
       }
    }
    
    /**
     * Asigna las coordenadas de cada casilla
     */
    private void iniCasillas()
    {
        casillaX[0]=563; casillaY[0]=563;
        casillaX[1]=500; casillaY[1]=563;
        casillaX[2]=450; casillaY[2]=563;
        casillaX[3]=400; casillaY[3]=563;
        casillaX[4]=350; casillaY[4]=563;
        casillaX[5]=300; casillaY[5]=563;
        casillaX[6]=250; casillaY[6]=563;
        casillaX[7]=200; casillaY[7]=563;
        casillaX[8]=150; casillaY[8]=563;
        casillaX[9]=100; casillaY[9]=563;
        casillaX[10]=38; casillaY[10]=563;
        casillaX[11]=38; casillaY[11]=500;
        casillaX[12]=38; casillaY[12]=450;
        casillaX[13]=38; casillaY[13]=400;
        casillaX[14]=38; casillaY[14]=350;
        casillaX[15]=38; casillaY[15]=300;
        casillaX[16]=38; casillaY[16]=250;
        casillaX[17]=38; casillaY[17]=200;
        casillaX[18]=38; casillaY[18]=150;
        casillaX[19]=38; casillaY[19]=100;
        casillaX[20]=38; casillaY[20]=38;
        casillaX[21]=100; casillaY[21]=38;
        casillaX[22]=150; casillaY[22]=38;
        casillaX[23]=200; casillaY[23]=38;
        casillaX[24]=250; casillaY[24]=38;
        casillaX[25]=300; casillaY[25]=38;
        casillaX[26]=350; casillaY[26]=38;
        casillaX[27]=400; casillaY[27]=38;
        casillaX[28]=450; casillaY[28]=38;
        casillaX[29]=500; casillaY[29]=38;
        casillaX[30]=563; casillaY[30]=38;
        casillaX[31]=563; casillaY[31]=100;
        casillaX[32]=563; casillaY[32]=150;
        casillaX[33]=563; casillaY[33]=200;
        casillaX[34]=563; casillaY[34]=250;
        casillaX[35]=563; casillaY[35]=300;
        casillaX[36]=563; casillaY[36]=350;
        casillaX[37]=563; casillaY[37]=400;
        casillaX[38]=563; casillaY[38]=450;
        casillaX[39]=563; casillaY[39]=500;
    }
    
    /**
     * Borra la ventana de seleccion
     */
    private void borraVentana()
    {
        removeObject(v);
        removeObject(b2);
        removeObject(b3);
        removeObject(b4);
    }
    
    /**
     * Coloca los jugadores activos en sus respectivos lugares
     */
    private void colocaJugadores()
    {
        j1 = new Jugador(1);
        j2 = new Jugador(2);
        addObject(j1,casillaX[0]-13,casillaY[0]-13);
        addObject(j2,casillaX[0]+13,casillaY[0]-13);
        if(numJug >= 3)
        {
            j3 = new Jugador(3);
            addObject(j3,casillaX[0]-13,casillaY[0]+13);
        }
        if(numJug == 4)
        {
            j4 = new Jugador(4);
            addObject(j4,casillaX[0]+13,casillaY[0]+13);
        }
    }
    
    /**
     * Regresa la coordenada X de la casilla
     */
    public int dameX(int cas)
    {
        return casillaX[cas];
    }
    
    /**
     * Regresa la coordenada Y de la casilla
     */
    public int dameY(int cas)
    {
        return casillaY[cas];
    }
}    