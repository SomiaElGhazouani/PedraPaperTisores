package src.Model;

public class Partida {

    private String nomPrimerJugador;
    private String nomSegonJugador;
    private int puntuacioJ1;
    private int puntuacioJ2;

    public Partida() {
        this.puntuacioJ1 = this.puntuacioJ2 = 0;
    }


    /*
    Contructor per jugar vs IA.
     */
    public Partida(String nomJugador) {
        this.nomPrimerJugador = nomJugador;
        this.nomSegonJugador = "Màquina";
        this.puntuacioJ1 = this.puntuacioJ2 = 0;
    }


    /*
    Constructor per jugar 1vs1.
     */
    public Partida(String nomPrimerJugador, String nomSegonJugador) {
        this.nomPrimerJugador = nomPrimerJugador;
        this.nomSegonJugador = nomSegonJugador;
        this.puntuacioJ1 = this.puntuacioJ2 = 0;
    }

    public int getPuntuacioJ1() {
        return puntuacioJ1;
    }

    public int getPuntuacioJ2() {
        return puntuacioJ2;
    }

    public void sumarPuntacio(int numJugador) {
        if (numJugador == 1) {
            this.puntuacioJ1++;
        } else if (numJugador == 2) {
            this.puntuacioJ2++;
        }
    }

    public void reiniciarPuntuacion() {
        this.puntuacioJ1 = this.puntuacioJ2 = 0;
    }
}

