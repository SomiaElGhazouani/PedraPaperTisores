package src.Controller;

import src.Model.Figura;
import src.Model.Partida;

public class CtrlDomini {

    private Partida partida;

    public CtrlDomini() {
    }

    public void crearPartidaVsIA(String nomJugador) {
        this.partida = new Partida(nomJugador);
    }

    public void crearPartida1vs1(String nomPrimerJugador, String nomSegonJugador) {
        this.partida = new Partida(nomPrimerJugador, nomSegonJugador);
    }

    /*
    en cas d'haverhi un guanyador li suma la seva puntuació
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

    public int getPuntuacioJugardor(int numJugador) {
        if (numJugador == 1) {
            return partida.getPuntuacioJ1();
        }
        if (numJugador == 2) {
            return partida.getPuntuacioJ2();
        }
        return 0;
    }

    public void reiniciarPuntuacion() {
        partida.reiniciarPuntuacion();
    }
}
