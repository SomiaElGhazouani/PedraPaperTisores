package src.Controller;

import src.Model.Figura;
import src.Model.Partida;

public class CtrlDomini {

    private Partida partida;

    public CtrlDomini() {
    }

    /**
     * S'utilitzarà el constructor de Partida d'un parametre, el segon jugador es dirà "Màquina", el primer es dirà Somia.
     * @param nomJugador del primer jugador
     */
    public void crearPartidaVsIA(String nomJugador) {
        this.partida = new Partida(nomJugador);
    }

    /**
     * S'utilitzarà el constructo de Partida de 2 paràmetres, noms dels dos jugadors
     * @param nomPrimerJugador
     * @param nomSegonJugador
     */
    public void crearPartida1vs1(String nomPrimerJugador, String nomSegonJugador) {
        this.partida = new Partida(nomPrimerJugador, nomSegonJugador);
    }

    /**
     * Suma puntació al guanyador en cas d'haver-hi.
     */
    public void jugarRonda(Figura jugador1, Figura jugador2) {
        switch (jugador1) {
            case PEDRA -> {
                if (jugador2 == Figura.TISORES) {
                    partida.sumarPuntacio(1);
                }
                if (jugador2 == Figura.PAPER) {
                    partida.sumarPuntacio(2);
                }
            }
            case PAPER -> {
                if (jugador2 == Figura.PEDRA) {
                    partida.sumarPuntacio(1);
                }
                if (jugador2 == Figura.TISORES) {
                    partida.sumarPuntacio(2);
                }
            }
            case TISORES -> {
                if (jugador2 == Figura.PAPER) {
                    partida.sumarPuntacio(1);
                }
                if (jugador2 == Figura.PEDRA) {
                    partida.sumarPuntacio(2);
                }
            }
        }

    }

    /**
     *
     * @param numJugador numero del jugador de qui volem la puntuacio.
     * @return retorna la puntuació del jugador passat per paràmetre, 1 o 2. Si és altre número, retorna 0.
     */
    public int getPuntuacioJugardor(int numJugador) {
        if (numJugador == 1) {
            return partida.getPuntuacioJ1();
        }
        if (numJugador == 2) {
            return partida.getPuntuacioJ2();
        }
        return 0;
    }

    /**
     * Assigna 0 a les dos puntuacions.
     */
    public void reiniciarPuntuacion() {
        partida.reiniciarPuntuacion();
    }
}
