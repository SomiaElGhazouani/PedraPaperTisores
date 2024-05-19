package View;

import Controller.CtrlPresentacio;

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
        jugarVsIAButton.addActionListener(actionEvent -> ctrlPresentacio.jugarVsIA());
//        jugar1Vs1Button.addActionListener(actionEvent -> cp.syncVP_VM());
//        repositoriButton.addActionListener(actionEvent -> cp.obreManual());
    }

    public void activar() {
        setVisible(true);
    }

    public void desactivar() {
        setVisible(false);
    }
}
