package src.View;

import src.Controller.CtrlPresentacio;
import src.Model.Figura;

import javax.swing.*;
import java.util.Random;

public class VistaVsJugador extends JFrame {

    private final CtrlPresentacio ctrlPresentacio;
    private JButton tisoresButton;
    private JButton pedraButton;
    private JButton paperButton;
    private JButton sortirButton;
    private JButton resetButton;
    private JPanel J1vsJ2Panel;
    private JLabel puntuacioJ1;
    private JLabel puntuacioJ2;
    private JLabel figuraJ1Label;
    private JLabel figuraJ2Label;
    private JLabel ronda;
    private boolean turn;

    private Figura figuraAnterior;


    public VistaVsJugador(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
        turn = false;

        ronda.setText("Li toca al jugador 1");

        add(J1vsJ2Panel);
        setTitle("Joc de pedra paper tisores");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortirButton.addActionListener(actionEvent -> desactivar());
        resetButton.addActionListener(actionEvent -> reiniciarPuntuacion());
        tisoresButton.addActionListener(actionEvent -> jugarRonda(Figura.TISORES));
        pedraButton.addActionListener(actionEvent -> jugarRonda(Figura.PEDRA));
        paperButton.addActionListener(actionEvent -> jugarRonda(Figura.PAPER));
    }

    public void jugarRonda(Figura figuraSelecionada) {
        if (turn) {
            turn = false;
            ctrlPresentacio.jugarRonda(figuraAnterior, figuraSelecionada);

            String pathFiguraJ2 = "resources/" + figuraSelecionada.toString().toLowerCase() + ".png";
            figuraJ2Label.setIcon(new ImageIcon(pathFiguraJ2));
            figuraJ2Label.repaint();

            String pathFiguraJ1 = "resources/" + figuraAnterior.toString().toLowerCase() + ".png";
            figuraJ1Label.setIcon(new ImageIcon(pathFiguraJ1));
            figuraJ1Label.repaint();


            puntuacioJ1.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
            puntuacioJ2.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));
            ronda.setText("Li toca al jugador 1");
        } else {
            turn = true;
            figuraAnterior = figuraSelecionada;
            ronda.setText("Li toca al jugador 2");
        }

//        ctrlPresentacio.jugador1vsIA(figuraJugador1, figuraJ2Label);
//
//
//        String pathFiguraJ2 = "resources/" + figuraJ2Label.toString().toLowerCase() + ".png";
//        figuraJ2Label.setIcon(new ImageIcon(pathFiguraJ2));
//        figuraJ2Label.repaint();
//
//        String pathFiguraJ1 = "resources/" + figuraJugador1.toString().toLowerCase() + ".png";
//        figuraJ1Label.setIcon(new ImageIcon(pathFiguraJ1));
//        figuraJ1Label.repaint();
//
//
//        puntuacioJ1.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
//        puntuacioJ2.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));
    }

    public void activar() {
        setVisible(true);
        puntuacioJ1.setText("0");
        puntuacioJ2.setText("0");
    }

    public void desactivar() {
        setVisible(false);
        ctrlPresentacio.reiniciarPuntuacion();
        ctrlPresentacio.start();
    }

    private void reiniciarPuntuacion() {
        ctrlPresentacio.reiniciarPuntuacion();
        turn = false;
        puntuacioJ1.setText("0");
        puntuacioJ2.setText("0");
    }

    private void createUIComponents() {
        figuraJ1Label = new JLabel();
        figuraJ2Label = new JLabel();
    }
}
