import greenfoot.*;

/**
 * Mundo del juego
 * 
 * @author Equipo potopoly
 * @version 26-Nov-15
 */
public class Tablero extends World
{
    private static int TEMPO; /** Velocidad a la que se mueven los jugadores **/
    
    private int numJug; /** Indica el numero de jugadores **/
    private Casilla[] casilla; /** Casillas del tablero **/
    private int numMov1, numMov2; /** Numero de los dados **/
    
    private int estado; /** Indica el estado del juego (inicio, turno de algun jugador o fin del juego) **/
    private boolean tiroDado; /** Indica si se han tirado los dados **/
    private boolean finDelJuego; /** Indicador del final del juego **/
    
    private Jugador j1, j2, j3, j4; /** Jugadores **/
    private Jugador ganador;    /** Ganador de la partida **/
    private Counter c1, c2, c3, c4; /** Contadores de dinero **/
    private Torre t1, t2, t3, t4;  /** Torres **/
    private Dado d1,d2; /** Dados **/
    private TiraD aux1; /** Texto tirar dados **/
    private Carta carta; /** Carta **/
    
    /**
     * Objetos de la pantalla de inicio
     */
    private Ventana v, sel;
    private Ventana ayuda;
    private Cadena cDinero;
    private Boton b2;
    private Boton b3;
    private Boton b4;
    
    /**
     * Sonidos del juego
     */
    private GreenfootSound fondo;
    private GreenfootSound dados;
    private GreenfootSound pasos;
    
    /**
     * Constructor para la clase Tablero.
     * 
     */
    public Tablero()
    {    
        super(800, 600, 1);
        
        TEMPO = 15;
        casilla = new Casilla[40];
        carta = new Carta();
        estado = 0;
        tiroDado = false;
        v = new Ventana();
        sel = new Ventana(2);
        ayuda = new Ventana(1);
        cDinero = new Cadena();
        finDelJuego = false;
        fondo = new GreenfootSound("MusicaFondoPoto.mp3");
        dados = new GreenfootSound("SonidoTiraDado.mp3");
        pasos = new GreenfootSound("Paso.mp3");
        b2 = new Boton(100,50,"2");
        b3 = new Boton(100,50,"3");
        b4 = new Boton(100,50,"4");
        
        addObject(v,300,300);
        addObject(b2,300,250);
        addObject(b3,300,350);
        addObject(b4,300,450);
        addObject(ayuda,700,300);
        addObject(carta,0,0);
        iniCasillas();
    }
    
    public void act()
    {
       Jugador ant, sig;
        if(estado == 0) {
           if(Greenfoot.mouseClicked(b2)) {
                numJug = 2;
                estado = 1;
                borraVentana();
                colocaPiezas();
                fondo.play();
            }
           if(Greenfoot.mouseClicked(b3)) {
               numJug = 3;
               estado = 1;
               borraVentana();
               colocaPiezas();
               fondo.play();
           }
           if(Greenfoot.mouseClicked(b4)) {
               numJug = 4;
               estado = 1;
               borraVentana();
               colocaPiezas();
               fondo.play();
           }
       }
       else if(estado == 1) {   /** Turno del jugador 1 **/
          sel.setLocation(680, 100);
           if(j1.daCarcel()) {
            j1.cambiaCarcel(false);
            estado++;
          }
          else if(Greenfoot.mouseClicked(d1) || Greenfoot.mouseClicked(d2) || Greenfoot.mouseClicked(aux1)) {
              tiraDados();
          }
          if(tiroDado) {
              moverJugador(j1,numMov1 + numMov2);
              /** Acciones j1 **/
              sig = j2;
              switch(numJug) {
                  case 2:
                    ant = sig;
                    break;
                  case 3:
                    ant = j3;
                    break;
                  default:
                    ant = j4;
                    break;
              }
              checaCasilla(j1,ant,sig);
              tiroDado = false;
              estado++;
              c1.setValue(j1.dameDinero());
          }          
       }
       else if(estado == 2) {   /** Turno del jugador 2 **/
          sel.setLocation(680, 141);
           if(j2.daCarcel()) {
            j2.cambiaCarcel(false);
            estado = (estado == numJug ? 1 : (estado + 1));
          }
          else if(Greenfoot.mouseClicked(d1) || Greenfoot.mouseClicked(d2) || Greenfoot.mouseClicked(aux1)) {
              tiraDados();
          }
          if(tiroDado) {
              moverJugador(j2,numMov1 + numMov2);
              /** Acciones j2 **/
              ant = j1;
              switch(numJug) {
                  case 2:
                    sig = j1;
                    break;
                  case 3:
                    sig = j3;
                    break;
                  default:
                    sig = j4;
                    break;
              }
              checaCasilla(j2,ant,sig);
              tiroDado = false;
              estado = (estado == numJug ? 1 : (estado + 1));
              c2.setValue(j2.dameDinero());
          }          
       }
       else if(estado == 3) {   /** Turno del jugador 3 **/
          sel.setLocation(680, 182);
          if(j3.daCarcel()) {
            j3.cambiaCarcel(false);
            estado = (estado == numJug ? 1 : (estado + 1));
          }
          else if(Greenfoot.mouseClicked(d1) || Greenfoot.mouseClicked(d2) || Greenfoot.mouseClicked(aux1))
          {
              tiraDados();
          }
          if(tiroDado) {
              moverJugador(j3,numMov1 + numMov2);
              /** Acciones j3 **/
              ant = j2;
              switch(numJug) {
                  case 3:
                    sig = j1;
                    break;
                  default:
                    sig = j4;
                    break;
              }
              checaCasilla(j3,ant,sig);
              tiroDado = false;
              estado = (estado == numJug ? 1 : (estado + 1));
              c3.setValue(j3.dameDinero());
          }         
       }
       else {   /** Turno del jugador 4 **/
          sel.setLocation(680, 223);
           if(j4.daCarcel()) {
            j4.cambiaCarcel(false);
            estado = 1;
          }
          else if(Greenfoot.mouseClicked(d1) || Greenfoot.mouseClicked(d2) || Greenfoot.mouseClicked(aux1)) {
              tiraDados();
          }
          if(tiroDado) {
              moverJugador(j4,numMov1 + numMov2);
              /** Acciones j4 **/
              ant = j3;
              sig = j1;
              checaCasilla(j4,ant,sig);
              tiroDado = false;
              estado = 1;
              c4.setValue(j4.dameDinero());
          }
       }
       if(finDelJuego) {
           gameOver();
        }
    }
    
    /**
     * Asigna las coordenadas de cada casilla 
     */
    private void iniCasillas()
    {
        /** casilla[numero] = new Casilla(costo,puntos,cromo,x,y) **/        
        
        casilla[0] = new Casilla(0,0,0,563,563);
        casilla[1] = new Casilla(150,1,1,500,563);
        casilla[2] = new Casilla(0,0,0,450,563);
        casilla[3] = new Casilla(150,1,1,400,563);
        casilla[4] = new Casilla(-150,0,0,350,563);
        casilla[5] = new Casilla(150,1,9,300,563);
        casilla[6] = new Casilla(250,1,2,250,563);
        casilla[7] = new Casilla(0,0,0,200,563);
        casilla[8] = new Casilla(250,1,2,150,563);
        casilla[9] = new Casilla(250,1,2,100,563);
        casilla[10] = new Casilla(0,0,0,38,563);
        casilla[11] = new Casilla(300,1,3,38,500);
        casilla[12] = new Casilla(200,1,9,38,450);
        casilla[13] = new Casilla(300,1,3,38,400);
        casilla[14] = new Casilla(300,2,3,38,350);
        casilla[15] = new Casilla(150,1,9,38,300);
        casilla[16] = new Casilla(350,2,4,38,250);
        casilla[17] = new Casilla(0,0,0,38,200);
        casilla[18] = new Casilla(350,2,4,38,150);
        casilla[19] = new Casilla(350,2,4,38,100);
        casilla[20] = new Casilla(0,0,0,38,38);
        casilla[21] = new Casilla(400,2,5,100,38);
        casilla[22] = new Casilla(0,0,0,150,38);
        casilla[23] = new Casilla(400,2,5,200,38);
        casilla[24] = new Casilla(400,2,5,250,38);
        casilla[25] = new Casilla(150,1,9,300,38);
        casilla[26] = new Casilla(450,2,6,350,38);
        casilla[27] = new Casilla(450,3,6,400,38);
        casilla[28] = new Casilla(200,1,9,450,38);
        casilla[29] = new Casilla(450,3,6,500,38);
        casilla[30] = new Casilla(0,0,0,563,38);
        casilla[31] = new Casilla(550,3,7,563,100);
        casilla[32] = new Casilla(550,3,7,563,150);
        casilla[33] = new Casilla(0,0,0,563,200);
        casilla[34] = new Casilla(550,3,7,563,250);
        casilla[35] = new Casilla(150,1,9,563,300);
        casilla[36] = new Casilla(0,0,0,563,350);
        casilla[37] = new Casilla(600,3,8,563,400);
        casilla[38] = new Casilla(-400,0,0,563,450);
        casilla[39] = new Casilla(600,3,8,563,500);
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
        removeObject(ayuda);
    }
    
    /**
     * Coloca los jugadores activos en sus respectivos lugares
     */
    private void colocaPiezas()
    {
        t1 = new Torre();
        t2 = new Torre();
        j1 = new Jugador(1,t1);
        j2 = new Jugador(2,t2);
        d1 = new Dado();
        d2 = new Dado();
        c1 = new Counter("Jugador 1: $");
        c2 = new Counter("Jugador 2: $");
        aux1 = new TiraD();
        
        addObject(d1,662,524);
        addObject(d2,750,524);
        addObject(j1,casilla[0].dameX() - 13,casilla[0].dameY() - 13);
        addObject(t1,134,365);
        addObject(j2,casilla[0].dameX()+13,casilla[0].dameY()-13);
        addObject(t2,244,365);
        addObject(aux1,708,449);
        addObject(cDinero,700,35);
        addObject(sel,680,100);
        addObject(c1,700,100);
        addObject(c2,700,141);
        
        c1.setValue(j1.dameDinero());
        c2.setValue(j2.dameDinero());
        
        if(numJug >= 3) {
            t3 = new Torre();
            j3 = new Jugador(3,t3);
            c3 = new Counter("Jugador 3: $");
            addObject(c3,700,182);
            c3.setValue(j3.dameDinero());
            addObject(j3,casilla[0].dameX() - 13,casilla[0].dameY() + 13);
            addObject(t3,354,365);
        }
        
        if(numJug == 4) {
            t4 = new Torre();
            j4 = new Jugador(4,t4);
            c4 = new Counter("Jugador 4: $");
            addObject(c4,700,223);
            c4.setValue(j4.dameDinero());
            addObject(j4,casilla[0].dameX() + 13,casilla[0].dameY() + 13);
            addObject(t4,464,365);
        }
    }
    
    /**
     * Regresa la coordenada X de la casilla
     * 
     * @cas Numero de la casilla
     * @return El valor de la coordenada X de la casilla
     * 
     */
    public int dameX(int cas)
    {
        return casilla[cas].dameX();
    }
    
    /**
     * Regresa la coordenada Y de la casilla
     * 
     * @cas Numero de la casilla
     * @return El valor de la coordenada Y de la casilla
     * 
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
        removeObject(carta);
        dados.play();
    }
    
    /**
     * Este metodo mueve a un jugador un determinado numero de casillas
     * 
     * @param J El jugador que se quiere mover
     * @param numPasos El numero de casillas a avanzar
     * 
     */
    public void moverJugador(Jugador J, int numPasos)
    {
        for( ; numPasos != 0; numPasos-- ) {
            J.moveOnce();
            pasos.play();
            Greenfoot.delay(20);
        }
    }
    
    /**
     * Este metodo realiza la accion correspondiente de la casilla en la que cae el jugador
     * 
     * @param J El jugador que quiere checar la casilla
     * @param ant El jugador anterior a J
     * @param sig El jugador sucesor de J
     * 
     */
    public void checaCasilla(Jugador J, Jugador ant, Jugador sig)
    {
        int cas;
        Jugador dno;
        cas = J.dameCasilla();
        if(cas == 2 || cas == 17 || cas == 33) {
            tomaComunitaria(J,ant,sig);
        }
        else if(cas == 7 || cas == 22 || cas == 36) {
            tomaOportunidad(J);
        }
        else if(cas == 0) {
            J.deltaDinero(200);
        }
        else if(cas == 4 || cas == 38) {
            J.deltaDinero(J.dameDinero() >= casilla[cas].dameCosto() * -1 ? casilla[cas].dameCosto() : J.dameDinero() * -1);
        }
        else if(cas == 30) {
            J.tomaCasilla(10);
            J.setLocation(casilla[10].dameX()+J.dameSX(),casilla[10].dameY()+J.dameSY());
            if(J.dameCarta() == false) {
                J.cambiaCarcel(true);
            }
            else {
                J.tomaCarta(false);
            }
        }
        else if(cas != 10 && cas != 20) {
            dno = casilla[cas].dameDuenio();
            if(dno != null && dno != J) {
                J.paga(dno, casilla[cas].dameCosto());
            }
            else if(J.dameDinero() >= casilla[cas].dameCosto()&& (J.dameCromos() + casilla[cas].damePuntos() <= 9)) {
                comprarCasilla(J);
            }
        }
    }
    
    /**
     * Este metodo elige una carta comunitaria al azar y realiza su accion ademas de mostrar la carta correspondiente
     * 
     * @param J El jugador que toma la carta
     * @param ant El jugador anterior a J
     * @param sig El jugador sucesor de J
     * 
     */
    public void tomaComunitaria(Jugador act, Jugador ant, Jugador sig)
    {
        int num = Greenfoot.getRandomNumber(6) + 1;
        carta.tomaImagen(num);
        if(num == 1) {
            act.paga(ant,50);
            carta.tomaImagen(1);
        }
        else if(num == 2) {            
            act.paga(j1,50);
            act.paga(j2,50);
            if(numJug >= 3) {
                act.paga(j3,50);
            }
            if(numJug == 4) {
                act.paga(j4,50);
            }
            carta.tomaImagen(2);
        }
        else if(num == 3) {
            act.cobra(ant,100);
            carta.tomaImagen(3);
        }
        else if(num == 4) {
            act.cobra(j1,50);
            act.cobra(j2,50);
            if(numJug >= 3) {
                act.cobra(j3,50);
            }
            if(numJug == 4) {
                act.cobra(j4,50);
            }
            carta.tomaImagen(4);
        }
        else if(num == 5) {
            if(act.dameCarta()) {
                act.tomaCarta(false);
            }
            else {
                act.setLocation(casilla[10].dameX() + act.dameSX(),casilla[10].dameY() + act.dameSY());
                act.cambiaCarcel(true);
                act.tomaCasilla(10);
                carta.tomaImagen(14);
            }
        }
        else {
            act.tomaCarta(true);
            carta.tomaImagen(15);
        }
        addObject(carta,176,130);
    }
    
    /**
     * Este metodo elige una carta de oportunidad al azar y realiza su accion ademas de mostrar la carta correspondiente
     * 
     * @param J El jugador que toma la carta
     * 
     */
    public void tomaOportunidad(Jugador J)
    {
        int num = Greenfoot.getRandomNumber(11) + 1;
        carta.tomaImagen(num);
        if(num == 1) {
            J.deltaDinero(-50);
            if(J.dameDinero() < 0) {
                J.tomaDinero(0);
            }
            carta.tomaImagen(5);
        }
        else if(num == 2) {
            J.deltaDinero(-100);
            if(J.dameDinero() < 0) {
                J.tomaDinero(0);
            }
            carta.tomaImagen(6);
        }
        else if(num == 3) {
            J.deltaDinero(-150);
            if(J.dameDinero() < 0) {
                J.tomaDinero(0);
            }
            carta.tomaImagen(7);
        }
        else if(num == 4) {
            J.deltaDinero(-200);
            if(J.dameDinero() < 0) {
                J.tomaDinero(0);
            }
            carta.tomaImagen(8);
        }
        else if(num == 5) {
            J.deltaDinero(25);
            carta.tomaImagen(9);
        }
        else if(num == 6) {
            J.deltaDinero(50);
            carta.tomaImagen(10);
        }
        else if(num == 7) {
            J.deltaDinero(100);
            carta.tomaImagen(11);
        }
        else if(num == 8) {
            J.deltaDinero(150);
            carta.tomaImagen(12);
        }
        else if(num == 9) {
            J.deltaDinero(200);
            carta.tomaImagen(13);
        }
        else if(num == 10) {
            if(J.dameCarta()) {
                J.tomaCarta(false);
            }
            else {
                J.setLocation(casilla[10].dameX() + J.dameSX(),casilla[10].dameY() + J.dameSY());
                J.cambiaCarcel(true);
                J.tomaCasilla(10);
                carta.tomaImagen(14);
            }
        }
        else {
            J.tomaCarta(true);
            carta.tomaImagen(15);
        }
        addObject(carta,423,130);
    }
    
    /**
     * Este metodo compra la casilla, le asigna su nuevo dueño
     * y coloca el cromo en la posicion correspondiente
     * 
     * @param J El jugador a comprar la casilla
     * 
     */
    public void comprarCasilla(Jugador J)
    {
        int i;
        Casilla cas = casilla[J.dameCasilla()];
        cas.tomaDuenio(J);
        J.deltaDinero(cas.dameCosto()* -1);        
        for(i = 0; i < cas.damePuntos(); i++) {
            añadeCromo(J);
        }
        if(J.dameCromos() == 9) {
            ganador = J;
            finDelJuego = true;
        }
    }
    
    /**
     * Añade el cromo correspondiente a la torre del jugador
     * 
     * @param J El jugador a recibir un cromo
     * 
     */
    public void añadeCromo(Jugador J)
    {
        Torre t = J.dameTorre();
        Cromo cr = J.dameCromo(J.dameCromos());
        cr = new Cromo(casilla[J.dameCasilla()].dameTipo());
        
        addObject(cr,t.getX(),t.getY() + 132 - 30 * J.dameCromos());
        
        J.tomaCromos(1);
    }
    
    /**
     * Actualiza los contadores con los valores respectivos de cada jugador
     */
    public void actConts()
    {
        c1.setValue(j1.dameDinero());
        c2.setValue(j2.dameDinero());
        if(numJug >= 3) {
            c3.setValue(j3.dameDinero());
        }
        if(numJug == 4) {
            c4.setValue(j4.dameDinero());
        }
    }
    
    /**
     * Muestra la pantalla de fin del juego junto con el jugador ganador y detiene el juego
     */
    public void gameOver()
    {
        Ventana g = new Ventana(2);
        addObject(g,300,300);
        ganador.setLocation(700,400);
        Greenfoot.stop();
    }
}   