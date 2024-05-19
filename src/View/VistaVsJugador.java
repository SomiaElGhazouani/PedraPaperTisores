package src.View;

import src.Controller.CtrlPresentacio;
import src.Model.Figura;

import javax.swing.*;
import java.util.Random;

public class VistaVsJugador extends JFrame{

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


    public VistaVsJugador(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;

        puntuacioJ1.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
        puntuacioJ2.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));

        add(J1vsJ2Panel);
        setTitle("Joc de pedra paper tisores");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortirButton.addActionListener(actionEvent -> System.exit(0));
        resetButton.addActionListener(actionEvent -> reiniciarPuntuacion());
        tisoresButton.addActionListener(actionEvent -> jugarRonda(Figura.TISORES));
        pedraButton.addActionListener(actionEvent -> jugarRonda(Figura.PEDRA));
        paperButton.addActionListener(actionEvent -> jugarRonda(Figura.PAPER));
    }

    public void jugarRonda(Figura figuraJugador1) {
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
    }

    public void desactivar() {
        setVisible(false);
    }

    private void reiniciarPuntuacion() {
        ctrlPresentacio.reiniciarPuntuacion();
        puntuacioJ1.setText("0");
        puntuacioJ2.setText("0");
    }

    private void createUIComponents() {
        figuraJ1Label = new JLabel();
        figuraJ2Label = new JLabel();
    }
}
