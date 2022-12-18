package com.Tec_BoyJ.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Tec_BoyJ.Main.GUISource;

public class GUI {
    JFrame frame = new JFrame("Tec_BoyJ");
    JPanel panel = new JPanel();
    Font font = new Font("Arial", Font.PLAIN, 24);


    JLabel label = new JLabel("/");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();

    FractionButton button = new FractionButton("GO!", 150);
    FractionButton b23 = new FractionButton("1/23", 200);
    FractionButton b365 = new FractionButton("1/365", 250);
    FractionButton b47 = new FractionButton("1/47", 300);
    FractionButton b3 = new FractionButton("1/3", 350);
    FractionButton b2d49 = new FractionButton("2/49", 400);
    FractionButton b100d49 = new FractionButton("100/49", 450);
    FractionButton b3d7 = new FractionButton("3/7", 500);
    FractionButton b56d43 = new FractionButton("56/43", 550);

    JLabel labelGUI = new JLabel("GUI Interface");
    JButton GUI = new JButton("Python");
    JButton stop = new JButton("EXIT");
    public GUI() {
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);

        textField1.setBounds(380, 100, 100, 40);
        textField1.setFont(font);
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textField1);

        label.setBounds(480, 100, 40, 40);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        textField2.setBounds(520, 100, 100, 40);
        textField2.setFont(font);
        textField2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textField2);

        labelGUI.setBounds(90, 125, 200, 40);
        labelGUI.setFont(font);
        labelGUI.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelGUI);

        GUI.setBounds(90, 175, 200, 40);
        GUI.setFont(font);
        GUI.addActionListener(actionListener);
        panel.add(GUI);

        stop.setBounds(710, 125, 200, 40);
        stop.setFont(font);
        stop.addActionListener(actionListener);
        panel.add(stop);


        frame.setSize(1000, 1000);
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == GUI) {
                if (GUISource == 0) {
                    GUI.setText("<html>Desmos <font color='red'>(WIP!)</font></html>");
                    GUISource++;
                } else if (GUISource == 1) {
                    GUI.setText("<html>Java <font color='red'>(WIP!)</font></html>");
                    GUISource++;
                } else {
                    GUI.setText("Python");
                    GUISource = 0;
                }
            } else if (e.getSource() == stop) {
                System.exit(0);
            } else if (e.getSource() == button) {
                int x = Integer.parseInt(textField1.getText());
                int y = Integer.parseInt(textField2.getText());
                multiThreading(x, y);
            } else if (e.getSource() == b23) multiThreading(1, 23);
            else if (e.getSource() == b365) multiThreading(1, 365);
            else if (e.getSource() == b47) multiThreading(1, 47);
            else if (e.getSource() == b3) multiThreading(1, 3);
            else if (e.getSource() == b2d49) multiThreading(2, 49);
            else if (e.getSource() == b100d49) multiThreading(100, 49);
            else if (e.getSource() == b3d7) multiThreading(3, 7);
            else if (e.getSource() == b56d43) multiThreading(56, 43);
        }
    };

    public static void multiThreading(int x, int y) {
        new MultiThreading(x, y).start();
    }

    public class FractionButton extends JButton {
        public FractionButton(String buttonName, int yValue) {
            this.setText(buttonName);
            this.addActionListener(actionListener);
            this.setBounds(380, yValue, 240, 40);
            this.setFont(new Font("Arial", Font.PLAIN, 24));
            panel.add(this);
        }
    }
}
