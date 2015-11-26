import greenfoot.*;

/**
 * Write a description of class Tablero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero extends World
{
    private static int tempo = 15;
    
    private int numJug; /** Indica el numero de jugadores **/
    private Casilla[] casilla = new Casilla[40]; /** Casillas del tablero **/
    private int numMov1, numMov2; /** Numero de los dados **/
    
    private int estado; /** Indica el estado del juego (inicio, turno de algun jugador o fin del juego) **/
    private boolean tiroDado; /** Indica si se han tirado los dados **/
    
    private Jugador j1, j2, j3, j4; /** Jugadores **/
    private Torre t1, t2, t3, t4;  /** Torres **/
    private Dado d1,d2; /** Dados **/
    
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
        super(800, 600, 1);
        estado = 0;
        tiroDado = false;
        addObject(v,300,300);
        addObject(b2,300,250);
        addObject(b3,300,350);
        addObject(b4,300,450);
        iniCasillas();
    }
    
    public void act()
    {
       if(estado == 0)
       {
           if(Greenfoot.mouseClicked(b2))
            {
                numJug = 2;
                estado = 1;
                borraVentana();
                colocaPiezas();
            }
           if(Greenfoot.mouseClicked(b3))
           {
               numJug = 3;
               estado = 1;
               borraVentana();
               colocaPiezas();
           }
           if(Greenfoot.mouseClicked(b4))
           {
               numJug = 4;
               estado = 1;
               borraVentana();
               colocaPiezas();
           }
       }
       else if(estado == 1) /** Turno del jugador 1 **/
       {
          if(Greenfoot.mouseClicked(d1)||Greenfoot.mouseClicked(d2))
          {
              tiraDados();
          }
          if(tiroDado)
          {
              moverJugador(j1,numMov1+numMov2);
              /** Acciones j1 **/
              tiroDado = false;
              estado++;
          }          
       }
       else if(estado == 2) /** Turno del jugador 2 **/
       {
           if(Greenfoot.mouseClicked(d1)||Greenfoot.mouseClicked(d2))
          {
              tiraDados();
          }
          if(tiroDado)
          {
              moverJugador(j2,numMov1+numMov2);
              /** Acciones j2 **/
              tiroDado = false;
              estado=(estado == numJug ? 1 : (estado+1));
          }          
       }
       else if(estado == 3) /** Turno del jugador 3 **/
       {
           if(Greenfoot.mouseClicked(d1)||Greenfoot.mouseClicked(d2))
          {
              tiraDados();
          }
          if(tiroDado)
          {
              moverJugador(j3,numMov1+numMov2);
              /** Acciones j3 **/
              tiroDado = false;
              estado=(estado == numJug ? 1 : (estado+1));
          }         
       }
       else /** Turno del jugador 4 **/
       {
           if(Greenfoot.mouseClicked(d1)||Greenfoot.mouseClicked(d2))
          {
              tiraDados();
          }
          if(tiroDado)
          {
              moverJugador(j4,numMov1+numMov2);
              /** Acciones j4 **/
              tiroDado = false;
              estado = 1;
          }
       }
    }
    
    /**
     * Asigna las coordenadas de cada casilla 
     */
    private void iniCasillas()
    {
        /** casilla[numero] = new Casilla(costo,puntos,x,y) **/        
        casilla[0] = new Casilla(0,0,563,563);
        casilla[1] = new Casilla(150,1,500,563);
        casilla[2] = new Casilla(0,0,450,563);
        casilla[3] = new Casilla(150,1,400,563);
        casilla[4] = new Casilla(-150,0,350,563);
        casilla[5] = new Casilla(150,1,300,563);
        casilla[6] = new Casilla(250,1,250,563);
        casilla[7] = new Casilla(0,0,200,563);
        casilla[8] = new Casilla(250,1,150,563);
        casilla[9] = new Casilla(250,1,100,563);
        casilla[10] = new Casilla(0,0,38,563);
        casilla[11] = new Casilla(300,1,38,500);
        casilla[12] = new Casilla(200,1,38,450);
        casilla[13] = new Casilla(300,1,38,400);
        casilla[14] = new Casilla(300,2,38,350);
        casilla[15] = new Casilla(150,1,38,300);
        casilla[16] = new Casilla(350,2,38,250);
        casilla[17] = new Casilla(0,0,38,200);
        casilla[18] = new Casilla(350,2,38,150);
        casilla[19] = new Casilla(350,2,38,100);
        casilla[20] = new Casilla(0,0,38,38);
        casilla[21] = new Casilla(400,2,100,38);
        casilla[22] = new Casilla(0,0,150,38);
        casilla[23] = new Casilla(400,2,200,38);
        casilla[24] = new Casilla(400,2,250,38);
        casilla[25] = new Casilla(150,1,300,38);
        casilla[26] = new Casilla(450,2,350,38);
        casilla[27] = new Casilla(450,3,400,38);
        casilla[28] = new Casilla(200,1,450,38);
        casilla[29] = new Casilla(450,3,500,38);
        casilla[30] = new Casilla(0,0,563,38);
        casilla[31] = new Casilla(550,3,563,100);
        casilla[32] = new Casilla(550,3,563,150);
        casilla[33] = new Casilla(0,0,563,200);
        casilla[34] = new Casilla(550,3,563,250);
        casilla[35] = new Casilla(150,1,563,300);
        casilla[36] = new Casilla(0,0,563,350);
        casilla[37] = new Casilla(600,3,563,400);
        casilla[38] = new Casilla(-400,0,563,450);
        casilla[39] = new Casilla(600,3,563,500);
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
    private void colocaPiezas()
    {
        j1 = new Jugador(1);
        j2 = new Jugador(2);
        t1 = new Torre();
        t2 = new Torre();
        d1 = new Dado();
        d2 = new Dado();
        addObject(d1,662,524);
        addObject(d2,750,524);
        addObject(j1,casilla[0].dameX()-13,casilla[0].dameY()-13);
        addObject(t1,134,365);
        addObject(j2,casilla[0].dameX()+13,casilla[0].dameY()-13);
        addObject(t2,244,365);
        if(numJug >= 3)
        {
            j3 = new Jugador(3);
            t3 = new Torre();
            addObject(j3,casilla[0].dameX()-13,casilla[0].dameY()+13);
            addObject(t3,354,365);
        }
        if(numJug == 4)
        {
            j4 = new Jugador(4);
            t4 = new Torre();
            addObject(j4,casilla[0].dameX()+13,casilla[0].dameY()+13);
            addObject(t4,464,365);
        }
    }
    
    /**
     * Regresa la coordenada X de la casilla
     */
    public int dameX(int cas)
    {
        return casilla[cas].dameX();
    }
    
    /**
     * Regresa la coordenada Y de la casilla
     */
    public int dameY(int cas)
    {
        return casilla[cas].dameY();
    }
    
    /**
     * Elige un numero al azár para los dados y cambia sus imagenes
     */
    public void tiraDados()
    {
        numMov1 = Greenfoot.getRandomNumber(6) + 1;
        numMov2 = Greenfoot.getRandomNumber(6) + 1;
        d1.tomaValor(numMov1);
        d2.tomaValor(numMov2);
        tiroDado = true;
    }
    
    public void moverJugador(Jugador J, int num)
    {
        for(; num != 0; num --)
        {
            J.moveOnce();
            Greenfoot.delay(20);
        }
    }    
}    