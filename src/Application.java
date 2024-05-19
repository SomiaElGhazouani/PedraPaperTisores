package src;

import src.Controller.CtrlPresentacio;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CtrlPresentacio ctrlPresentacio = new CtrlPresentacio();
                ctrlPresentacio.start();
            }
        });

    }
}