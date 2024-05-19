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
    private JLabel puntuacioJ1;
    private JLabel puntuacioIA;
    private JLabel figuraJ1Label;
    private JLabel figuraIALabel;

    public VistaVsMaquina(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;

        puntuacioJ1.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
        puntuacioIA.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));

        add(IAPanel);
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
        Figura figuraIA = Figura.values()[new Random().nextInt(Figura.values().length)];
        ctrlPresentacio.jugador1vsIA(figuraJugador1, figuraIA);


        String pathFiguraIA = "resources/" + figuraIA.toString().toLowerCase() + ".png";
        figuraIALabel.setIcon(new ImageIcon(pathFiguraIA));
        //figuraIALabel.revalidate();
        figuraIALabel.repaint();

        String pathFiguraJ1 = "resources/" + figuraJugador1.toString().toLowerCase() + ".png";
        figuraJ1Label.setIcon(new ImageIcon(pathFiguraJ1));
        //figuraJ1Label.revalidate();
        figuraJ1Label.repaint();


        puntuacioJ1.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
        puntuacioIA.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));
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
        puntuacioIA.setText("0");
    }

    private void createUIComponents() {
        figuraIALabel = new JLabel();
        figuraJ1Label = new JLabel();
    }
}
