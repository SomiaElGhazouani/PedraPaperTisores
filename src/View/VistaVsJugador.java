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


    /**
     *
     * @param ctrlPresentacio bidireccional
     */
    public VistaVsJugador(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;

        // Turn a false és turn de la Somia, primer jugador.
        turn = false;

        aQuiLiTocaLabel.setText("Li toca a la Somia");

        add(J1vsJ2Panel);
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

    public void jugarRonda(Figura figuraSelecionada) {
        if (turn) {
            // True, li toca al jugador 2
            ctrlPresentacio.jugarRonda(figuraJugador1, figuraSelecionada);

            String pathFiguraJ2 = "resources/" + figuraSelecionada.toString().toLowerCase() + ".png";
            figuraJ2Label.setIcon(new ImageIcon(pathFiguraJ2));
            figuraJ2Label.repaint();

            String pathFiguraJ1 = "resources/" + figuraJugador1.toString().toLowerCase() + ".png";
            figuraJ1Label.setIcon(new ImageIcon(pathFiguraJ1));
            figuraJ1Label.repaint();

            // Actualitzar puntuació
            puntuacioJ1Label.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(1)));
            puntuacioJ2Label.setText(String.valueOf(this.ctrlPresentacio.getPuntuacioJugador(2)));

            aQuiLiTocaLabel.setText("Li toca a la Somia");
            turn = false;
            JOptionPane.showMessageDialog(null, "Li toca a la Somia, no miri sisplau!");

        } else {
            // False, li toca a la Somia

            figuraJugador1 = figuraSelecionada;

            aQuiLiTocaLabel.setText("Li toca al jugador 2");
            turn = true;

            JOptionPane.showMessageDialog(null, "Li toca al jugador 2, no miri sisplau!");
        }
    }


    /**
     * Mostra la vista jugador vs jugador, turn de la Somia, i puntuació a 0 en els labels.
     */
    public void activar() {
        setVisible(true);
        turn = false;
        puntuacioJ1Label.setText("0");
        puntuacioJ2Label.setText("0");
    }


    /**
     * Mostra la vista jugador vs jugador, turn de la Somia, i puntuació a 0 en els labels.
     */
    public void desactivar() {
        setVisible(false);
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
