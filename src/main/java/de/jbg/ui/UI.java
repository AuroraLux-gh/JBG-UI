package de.jbg.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class UI {
    public static void lossHihi() {
        JFrame frame = new JFrame("JBG 3.5");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        frame.add(panel, "Center");

        JButton buttonLoad = new JButton("Eintrag laden");
        panel.add(buttonLoad, "South");
        buttonLoad.setPreferredSize(new Dimension(150, 30));

        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File("testbild.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image1 = bImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(image1);
        panel.add(new JLabel(image));

        buttonLoad.setVisible(true);
        frame.setVisible(true);
    }
}
