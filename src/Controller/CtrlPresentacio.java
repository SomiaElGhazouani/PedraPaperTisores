package src.Controller;

import src.Model.Figura;
import src.View.VistaPrincipal;
import src.View.VistaVsJugador;
import src.View.VistaVsMaquina;

public class CtrlPresentacio {

    private final CtrlDomini ctrlDomini;
    private final VistaPrincipal vistaPrincipal;
    private final VistaVsMaquina vistaVsMaquina;
    private final VistaVsJugador vistaVsJugador;

    public CtrlPresentacio() {
        this.ctrlDomini = new CtrlDomini();
        this.vistaPrincipal = new VistaPrincipal(this);
        this.vistaVsMaquina = new VistaVsMaquina(this);
        this.vistaVsJugador = new VistaVsJugador(this);
    }

    public void start() {
        vistaPrincipal.activar();
    }

    public void vistaJugarVsIA() {
        vistaPrincipal.desactivar();
        ctrlDomini.partidaVsIA("Somia");
        vistaVsMaquina.activar();
    }

    public void vistaJugar1vs1() {
        vistaPrincipal.desactivar();
        ctrlDomini.partida1vs1("Somia", "Jugador 2");
        vistaVsJugador.activar();
    }

    public void jugarRonda(Figura figuraJugador1, Figura figuraIA) {
        ctrlDomini.jugarRonda(figuraJugador1, figuraIA);
    }

    public int getPuntuacioJugador(int numJugador) {
        return ctrlDomini.getPuntuacioJugardor(numJugador);
    }

    public void reiniciarPuntuacion() {
        ctrlDomini.reiniciarPuntuacion();
    }
}
