package src.Controller;

import src.Model.Figura;
import src.View.VistaPrincipal;
import src.View.VistaVsJugador;
import src.View.VistaVsMaquina;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CtrlPresentacio {

    private final CtrlDomini ctrlDomini;
    private final VistaPrincipal vistaPrincipal;
    private final VistaVsMaquina vistaVsMaquina;
    private final VistaVsJugador vistaVsJugador;

    // Constructor que crea instancia de CtrlDomini i de les 3 vistes
    public CtrlPresentacio() {
        this.ctrlDomini = new CtrlDomini();
        this.vistaPrincipal = new VistaPrincipal(this);
        this.vistaVsMaquina = new VistaVsMaquina(this);
        this.vistaVsJugador = new VistaVsJugador(this);
    }

    public void start() {
        vistaPrincipal.activar();
    }

    public void activaVistaJugarVsIA() {
        vistaPrincipal.desactivar();
        // S'utilitzarà el constructor de Partida d'un parametre, el segon jugador es dirà "Màquina"
        ctrlDomini.crearPartidaVsIA("Somia");
        vistaVsMaquina.activar();
    }

    public void activaVistaJugar1vs1() {
        vistaPrincipal.desactivar();
        // S'utilitzarà el constructo de Partida de 2 paràmetres, noms dels dos jugadors
        ctrlDomini.crearPartida1vs1("Somia", "Jugador 2");
        vistaVsJugador.activar();
    }

    public void jugarRonda(Figura figuraJugador1, Figura figuraJugador2) {
        ctrlDomini.jugarRonda(figuraJugador1, figuraJugador2);
    }

    /**
     *
     * @param numJugador numero del jugador de qui volem la puntuacio
     * @return retorna la puntuació del jugador passat per paràmetre, 1 o 2. Si és altre número, torna 0.
     */
    public int getPuntuacioJugador(int numJugador) {
        return ctrlDomini.getPuntuacioJugardor(numJugador);
    }

    public void reiniciarPuntuacion() {
        ctrlDomini.reiniciarPuntuacion();
    }

    /**
     *
     * @param urlLink link a obrir amb el navegador per defecte.
     * @throws IOException
     * @throws URISyntaxException si hi ha Syntax error en link.
     */
    public void obrirLink(String urlLink) throws IOException, URISyntaxException {

        URI uri = new URI(urlLink);
        Desktop dt = Desktop.getDesktop();
        dt.browse(uri.toURL().toURI());
    }
}
