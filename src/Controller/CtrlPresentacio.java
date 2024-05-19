package src.Controller;

import src.Model.Figura;
import src.View.VistaPrincipal;
import src.View.VistaVsMaquina;

public class CtrlPresentacio {

    private final CtrlDomini ctrlDomini;
    private final VistaPrincipal vistaPrincipal;
    private final VistaVsMaquina vistaVsMaquina;

    public CtrlPresentacio() {
        this.ctrlDomini = new CtrlDomini();
        this.vistaPrincipal = new VistaPrincipal(this);
        this.vistaVsMaquina = new VistaVsMaquina(this);
    }

    public void start() {
        vistaPrincipal.activar();
    }

    public void jugarVsIA() {
        vistaPrincipal.desactivar();
        ctrlDomini.partidaVsIA();
        vistaVsMaquina.activar();
    }

    public void jugador1vsIA(Figura figuraJugador1, Figura figuraIA) {
        ctrlDomini.saberGuanyador(figuraJugador1, figuraIA);
    }

    public int getPuntuacioJugador(int numJugador) {
        return ctrlDomini.getPuntuacioJugardor(numJugador);
    }

    public void reiniciarPuntuacion() {
        ctrlDomini.reiniciarPuntuacion();
    }
}
