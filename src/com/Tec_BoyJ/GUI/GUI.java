package com.Tec_BoyJ.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Tec_BoyJ.Main.GUISource;

public class GUI implements ActionListener {
    JFrame frame = new JFrame("Tec_BoyJ");
    JPanel panel = new JPanel();
    Font font = new Font("Arial", Font.PLAIN, 24);


    JLabel label = new JLabel("/");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();

    JLabel labelGUI = new JLabel("GUI Interface");
    JButton GUI = new JButton("Python");
    JButton stop = new JButton("EXIT");

    JButton button = new JButton("GO!");
    int yValue = 200;

    FractionButton b1d3 = new FractionButton(yValue, 1, 3, 16);
    FractionButton b1d6 = new FractionButton(yValue, 1, 6, 16);
    FractionButton b1d7 = new FractionButton(yValue, 1, 7, 64);
    FractionButton b1d9 = new FractionButton(yValue, 1, 9, 16);
    FractionButton b1d12 = new FractionButton(yValue, 1, 12, 32);
    FractionButton b1d13 = new FractionButton(yValue, 1, 13, 64);
    FractionButton b1d14 = new FractionButton(yValue, 1, 14, 64);
    FractionButton b1d17 = new FractionButton(yValue, 1, 17, 1000);
    FractionButton b1d19 = new FractionButton(yValue, 1, 19, 1000);
    FractionButton b1d21 = new FractionButton(yValue, 1, 21, 64);
    FractionButton b1d23 = new FractionButton(yValue, 1, 23, 1000);
    FractionButton b1d47 = new FractionButton(yValue, 1, 47, 1000);
    FractionButton b1d49 = new FractionButton(yValue, 1, 49, 1000);
    FractionButton b1d365 = new FractionButton(yValue, 1, 365, 64);


    /*
    FractionButton b2d49 = new FractionButton(400, 2, 49);
    FractionButton b100d49 = new FractionButton(450, 100, 49);
    FractionButton b3d7 = new FractionButton(500, 3, 7);
    FractionButton b56d43 = new FractionButton(550, 56, 43);

     */
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
        button.addActionListener(this);
        panel.add(button);

        labelGUI.setBounds(90, 125, 200, 40);
        labelGUI.setFont(font);
        labelGUI.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelGUI);

        GUI.setBounds(90, 175, 200, 40);
        GUI.setFont(font);
        GUI.addActionListener(this);
        panel.add(GUI);

        stop.setBounds(710, 125, 200, 40);
        stop.setFont(font);
        stop.addActionListener(this);
        panel.add(stop);

        frame.setSize(1000, 1000);
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
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
        } else if (e.getSource() == stop) System.exit(0);
        else if (e.getSource() == button) {
            int x = Integer.parseInt(textField1.getText());
            int y = Integer.parseInt(textField2.getText());
            new MultiThreading(x, y, 64).start();
        }
    }
    private void add50() {yValue += 50;}
    private class FractionButton extends JButton implements ActionListener {
        int num;
        int den;
        int scale;
        public FractionButton(int yValue, int num, int den, int scale) {
            this.num = num;
            this.den = den;
            this.scale = scale;

            this.setText(num + "/" + den);
            this.addActionListener(this);
            this.setBounds(380, yValue, 240, 40);
            this.setFont(new Font("Arial", Font.PLAIN, 24));
            panel.add(this);
            GUI.this.add50();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new MultiThreading(num, den, scale).start();
        }
    }
}
