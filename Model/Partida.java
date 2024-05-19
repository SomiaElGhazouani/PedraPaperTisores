package Model;

public class Partida {

    private String primerJugador;
    private String segonJugador;
    private int puntuacioJ1;
    private int puntuacioJ2;
    private int rondes;

    public Partida(String primerJugador, String segonJugador, int rondes) {
        this.primerJugador = primerJugador;
        this.primerJugador = segonJugador;
        this.puntuacioJ1 =  this.puntuacioJ2 = 0;
        this.rondes = rondes;
    }

    public Partida() {
        this.puntuacioJ1 =  this.puntuacioJ2 = 0;
    }

    public void setPrimerJugador(String primerJugador) {
        this.primerJugador = primerJugador;
    }

    public void setSegonJugador(String segonJugador) {
        this.segonJugador = segonJugador;
    }

    public String getPrimerJugador() {
        return primerJugador;
    }

    public String getSegonJugador() {
        return segonJugador;
    }

    public int getPuntuacioJ1() {
        return puntuacioJ1;
    }

    public int getPuntuacioJ2() {
        return puntuacioJ2;
    }

    public void sumarPuntacio(int numJugador) {
        if(numJugador == 1){
            this.puntuacioJ1++;
        }
        else if (numJugador == 2) {
            this.puntuacioJ2++;
        }
    }

    public void reiniciarPuntuacion() {
        this.puntuacioJ1 =  this.puntuacioJ2 = 0;
    }
}

