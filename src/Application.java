package src;

import src.Controller.CtrlPresentacio;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear nova instancia de ctrlPresentació, que crearà instancies de les 3 vistes + 1 de ctrlDomini
                CtrlPresentacio ctrlPresentacio = new CtrlPresentacio();
                // Mostrarà la vista Principal
                ctrlPresentacio.start();
            }
        });

    }
}