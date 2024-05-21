package src.View;

import src.Controller.CtrlPresentacio;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class VistaPrincipal extends JFrame {

    private final CtrlPresentacio ctrlPresentacio;
    private JPanel mainPanel;
    private JButton jugarVsIAButton;
    private JButton jugar1Vs1Button;
    private JButton sortirButton;
    private JButton repositoriButton;

    /**
     * Constructor de VistaPrincipal
     * @param ctrlPresentacio bidireccional
     */
    public VistaPrincipal(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
        add(mainPanel);
        setTitle("Joc de pedra paper tisores");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botons amb actionListener, pendents d'acció / esdeveniment.
        sortirButton.addActionListener(actionEvent -> System.exit(0));
        jugarVsIAButton.addActionListener(actionEvent -> this.ctrlPresentacio.activaVistaJugarVsIA());
        jugar1Vs1Button.addActionListener(actionEvent -> this.ctrlPresentacio.activaVistaJugar1vs1());
        // Obrir link en cas de donar-li al botó Repositori.
        repositoriButton.addActionListener(actionEvent -> {
            try {
                this.ctrlPresentacio.obrirLink("https://github.com/SomiaElGhazouani/PedraPaperTisores");
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Mostra la vista Principal
     */
    public void activar() {
        setVisible(true);
    }

    /**
     * Oculta la vista Principal
     */
    public void desactivar() {
        setVisible(false);
    }
}
