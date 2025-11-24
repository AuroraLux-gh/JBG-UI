package de.jbg.ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;

public class UI {

    private static int id=0;    //hier da sonst Probleme mit ActionListener - https://www.java-forum.org/thema/variablen-aus-action-listener-lesen-und-weiterverarbeiten.136661/

    public static void showUI() {

        memeClient client2 = new memeClient();

        JFrame frame = new JFrame("JBG 3.5");
        frame.setSize(1000, 700);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton buttonLoad = new JButton("Eintrag laden");
        buttonLoad.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(buttonLoad, gbc);

        JButton buttonNext = new JButton("nächstes Bild");
        buttonNext.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        panel.add(buttonNext, gbc);

        JButton buttonPrev = new JButton("vorheriges Bild");
        buttonPrev.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        panel.add(buttonPrev, gbc);

        JButton buttonPost = new JButton("Bild senden");
        buttonPost.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(buttonPost, gbc);

        JButton buttonUpdate = new JButton("Datum auf heute updaten");
        buttonUpdate.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(buttonUpdate, gbc);

        JButton buttonDelete = new JButton("Bild/Eintrag löschen");
        buttonDelete.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(buttonDelete, gbc);

        JLabel imageLabel = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(imageLabel, gbc);

        JTextField text = new JTextField("", 20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(text, gbc);

        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(text.getText().trim());
                    Icon icon = client2.findById(id);
                    imageLabel.setIcon(icon);
                    frame.revalidate();
                } catch (NumberFormatException | IOException | InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Bitte gib eine gültige Zahl ein.");
                }
            }
        });

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id += 1;
                    Icon icon = client2.findById(id);
                    imageLabel.setIcon(icon);
                    frame.revalidate();
                } catch (NumberFormatException | IOException | InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Bitte gib eine gültige Zahl ein.");
                }
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = String.valueOf(String.valueOf(Integer.parseInt(text.getText().trim())));
                    client2.updateDateToToday(id);
                } catch (NumberFormatException | IOException | InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Bitte eine gültige Zahl eingeben!");
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer id = Integer.parseInt(text.getText().trim());
                    client2.deleteMeme(id);
                } catch (NumberFormatException | IOException | InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Bitte eine gültige Zahl eingeben!");
                }
            }
        });

        buttonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id -= 1;
                    Icon icon = client2.findById(id);
                    imageLabel.setIcon(icon);
                    frame.revalidate();
                } catch (NumberFormatException | IOException | InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Bitte gib eine gültige Zahl ein.");
                }
            }
        });

        buttonPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client2.postImage("testbild.jpg");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.setVisible(true);
    }

    static String vHeight;
    static String vLength;
    static String vSize;
    static String vCategory;
    static String vTag;

    public static void inputFile() {
        JFrame inputFrame = new JFrame("Add a File to the DB");
        inputFrame.setSize(1000, 700);

        JPanel inputPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 1;
        JTextField height = new JTextField();
        TextFieldBackground.addBackground(height, "height");
        inputPanel.add(height);

        JTextField length = new JTextField();
        TextFieldBackground.addBackground(length, "length");
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(length);

        JTextField size = new JTextField();
        TextFieldBackground.addBackground(size, "size");
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(size);

        JTextField category = new JTextField();
        TextFieldBackground.addBackground(category, "category");
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(category);

        JTextField tag = new JTextField();
        TextFieldBackground.addBackground(tag, "tag");
        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(tag);

        inputFrame.add(inputPanel);

        JButton buttonAdd = new JButton("Add new Image");
        inputPanel.add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files","jpg", "png", "jpeg");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(inputPanel);
                File selectedFile = null;
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());
                    selectedFile = chooser.getSelectedFile();
                }
//                try {
//                    InputStream imageInput = new FileInputStream(selectedFile.getPath());
//                } catch (FileNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                }
                vHeight = height.getText().trim();
                vLength = length.getText().trim();
                vSize = size.getText().trim();
                vCategory = category.getText().trim();
                vTag = tag.getText().trim();
            }

        });
        inputFrame.setVisible(true);
        buttonAdd.setVisible(true);
    }
}