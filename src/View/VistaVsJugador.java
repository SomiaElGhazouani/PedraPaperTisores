package src.View;

import src.Controller.CtrlPresentacio;
import src.Model.Figura;

import javax.swing.*;

public class VistaVsJugador extends JFrame {

    private final CtrlPresentacio ctrlPresentacio;
    private JButton tisoresButton;
    private JButton pedraButton;
    private JButton paperButton;
    private JButton sortirButton;
    private JButton resetButton;
    private JPanel J1vsJ2Panel;
    private JLabel puntuacioJ1Label;
    private JLabel puntuacioJ2Label;
    private JLabel figuraJ1Label;
    private JLabel figuraJ2Label;
    private JLabel aQuiLiTocaLabel;
    private boolean turn;
    private Figura figuraJugador1;


    public VistaVsJugador(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
        turn = false;

        aQuiLiTocaLabel.setText("Li toca al jugador 1");

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
            ctrlPresentacio.jugarRonda(figuraJugador1, figuraSelecionada);

            String pathFiguraJ2 = "resources/" + figuraSelecionada.toString().toLowerCase() + ".png";
            figuraJ2Label.setIcon(new ImageIcon(pathFiguraJ2));
            figuraJ2Label.repaint();

            String pathFiguraJ1 = "resources/" + figuraJugador1.toString().toLowerCase() + ".png";
            figuraJ1Label.setIcon(new ImageIcon(pathFiguraJ1));
            figuraJ1Label.repaint();


            puntuacioJ1Label.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
            puntuacioJ2Label.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));
            aQuiLiTocaLabel.setText("Li toca al jugador 1");
            turn = false;
        } else {
            figuraJugador1 = figuraSelecionada;
            aQuiLiTocaLabel.setText("Li toca al jugador 2");
            turn = true;
        }
    }

    public void activar() {
        setVisible(true);
        turn = false;
        puntuacioJ1Label.setText("0");
        puntuacioJ2Label.setText("0");
    }

    public void desactivar() {
        setVisible(false);
        ctrlPresentacio.reiniciarPuntuacion();
        ctrlPresentacio.start();
    }

    private void reiniciarPuntuacion() {
        ctrlPresentacio.reiniciarPuntuacion();
        turn = false;
        puntuacioJ1Label.setText("0");
        puntuacioJ2Label.setText("0");
    }

    private void createUIComponents() {
        figuraJ1Label = new JLabel();
        figuraJ2Label = new JLabel();
    }
}
