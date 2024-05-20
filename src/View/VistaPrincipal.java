package src.View;

import src.Controller.CtrlPresentacio;

import javax.swing.*;

public class VistaPrincipal extends JFrame {

    private final CtrlPresentacio ctrlPresentacio;
    private JPanel mainPanel;
    private JButton jugarVsIAButton;
    private JButton jugar1Vs1Button;
    private JButton sortirButton;
    private JButton repositoriButton;

    public VistaPrincipal(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
        add(mainPanel);
        setTitle("Joc de pedra paper tisores");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortirButton.addActionListener(actionEvent -> System.exit(0));
        jugarVsIAButton.addActionListener(actionEvent -> ctrlPresentacio.vistaJugarVsIA());
        jugar1Vs1Button.addActionListener(actionEvent -> ctrlPresentacio.vistaJugar1vs1());
//        repositoriButton.addActionListener(actionEvent -> cp.obreLink());
    }

    public void activar() {
        setVisible(true);
    }

    public void desactivar() {
        setVisible(false);
    }
}
