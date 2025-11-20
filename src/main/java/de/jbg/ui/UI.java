package de.jbg.ui;

import javax.swing.*;
import java.awt.*;

public class UI {
    public static void lossHihi() {
        JFrame frame = new JFrame("JBG 3.5");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        frame.add(panel, "Center");

        JButton buttonLoad = new JButton("Eintrag laden");
        panel.add(buttonLoad, "South");
        buttonLoad.setPreferredSize(new Dimension(150, 30));
        buttonLoad.setVisible(true);
    }
}
