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

    JButton button = new JButton("GO!");

    FractionButton b23 = new FractionButton("1/23", 200, 1, 23);
    FractionButton b365 = new FractionButton("1/365", 250, 1, 365);
    FractionButton b47 = new FractionButton("1/47", 300, 1, 47);
    FractionButton b3 = new FractionButton("1/3", 350, 1, 3);
    FractionButton b2d49 = new FractionButton("2/49", 400, 2, 49);
    FractionButton b100d49 = new FractionButton("100/49", 450, 100, 49);
    FractionButton b3d7 = new FractionButton("3/7", 500, 3, 7);
    FractionButton b56d43 = new FractionButton("56/43", 550, 56, 43);

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

        button.setBounds(380, 150, 240, 40);
        button.setFont(font);
        button.addActionListener(actionListener);
        panel.add(button);

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
                new MultiThreading(x, y);
            }
        }
    };

    public class FractionButton extends JButton implements ActionListener {
        int num;
        int den;
        public FractionButton(String buttonName, int yValue, int num, int den) {
            this.num = num;
            this.den = den;

            this.setText(buttonName);
            this.addActionListener(this);
            this.setBounds(380, yValue, 240, 40);
            this.setFont(new Font("Arial", Font.PLAIN, 24));
            panel.add(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new MultiThreading(num, den).start();
        }
    }
}
