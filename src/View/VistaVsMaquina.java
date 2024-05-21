package src.View;

import src.Controller.CtrlPresentacio;
import src.Model.Figura;

import javax.swing.*;
import java.util.Random;

public class VistaVsMaquina extends JFrame {
    private final CtrlPresentacio ctrlPresentacio;
    private JButton tisoresButton;
    private JButton pedraButton;
    private JButton paperButton;
    private JButton sortirButton;
    private JButton resetButton;
    private JPanel IAPanel;
    private JLabel puntuacioJ1Label;
    private JLabel puntuacioIALabel;
    private JLabel figuraJ1Label;
    private JLabel figuraIALabel;

    public VistaVsMaquina(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;

        add(IAPanel);
        setTitle("Joc de pedra paper tisores");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botons amb actionListener, pendents d'acció / esdeveniment.
        sortirButton.addActionListener(actionEvent -> desactivar());
        resetButton.addActionListener(actionEvent -> reiniciarPuntuacion());
        // Si es clica una botó d'alguna figura, es jugarà una ronda:
        tisoresButton.addActionListener(actionEvent -> jugarRonda(Figura.TISORES));
        pedraButton.addActionListener(actionEvent -> jugarRonda(Figura.PEDRA));
        paperButton.addActionListener(actionEvent -> jugarRonda(Figura.PAPER));
    }


    /**
     *
     * @param figuraJugador1 la figura seleccionada per la Somia
     */
    public void jugarRonda(Figura figuraJugador1) {
        // Obtenim una figura random que serà la figura de la màquina
        Figura figuraIA = Figura.values()[new Random().nextInt(Figura.values().length)];
        ctrlPresentacio.jugarRonda(figuraJugador1, figuraIA);


        // Mostrar les figures imatges:
        String pathFiguraIA = "resources/" + figuraIA.toString().toLowerCase() + ".png";
        figuraIALabel.setIcon(new ImageIcon(pathFiguraIA));
        figuraIALabel.repaint();

        String pathFiguraJ1 = "resources/" + figuraJugador1.toString().toLowerCase() + ".png";
        figuraJ1Label.setIcon(new ImageIcon(pathFiguraJ1));
        figuraJ1Label.repaint();

        // Actualitzar puntuació
        puntuacioJ1Label.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
        puntuacioIALabel.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));
    }


    /**
     * Mostra la vista jugador vs màquina i puntuació a 0 en els Labels.
     */
    public void activar() {
        setVisible(true);
        puntuacioJ1Label.setText("0");
        puntuacioIALabel.setText("0");
    }


    /**
     * Desactiva la vista jugador vs màquina i es mostrará VistaPrincipal gracies a ctrlPresentacio
     */
    public void desactivar() {
        setVisible(false);
        ctrlPresentacio.start();
    }

    private void reiniciarPuntuacion() {
        ctrlPresentacio.reiniciarPuntuacion();
        puntuacioJ1Label.setText("0");
        puntuacioIALabel.setText("0");
    }


    /**
     * Funció auxiliar per iniciar les imatges a null.
     */
    private void createUIComponents() {
        figuraIALabel = new JLabel();
        figuraJ1Label = new JLabel();
    }
}
