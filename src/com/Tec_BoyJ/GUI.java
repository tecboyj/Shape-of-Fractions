package com.Tec_BoyJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Tec_BoyJ.Main.GUISource;

public class GUI implements ActionListener {
    JFrame frame = new JFrame("Tec_BoyJ");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();

    JButton button = new JButton("GO!");
    JButton b23 = new JButton("1/23");
    JButton b365 = new JButton("1/365");
    JButton b47 = new JButton("1/47");
    JButton b3 = new JButton("1/3");
    JButton b2d49 = new JButton("2/49");
    JButton b100d49 = new JButton("100/49");

    JButton GUI = new JButton("Python");
    JButton stop = new JButton("EXIT");
    public GUI() {
        Font font = new Font("Arial", Font.PLAIN, 24);

        JLabel label = new JLabel("/");
        JLabel labelGUI = new JLabel("GUI Interface");
        JPanel panel = new JPanel();



        button.addActionListener(this);
        button.setBounds(380, 150, 240, 40);

        b23.addActionListener(this);
        b23.setBounds(380, 200, 240, 40);
        b23.setFont(font);

        b365.addActionListener(this);
        b365.setBounds(380, 250, 240, 40);
        b365.setFont(font);

        b47.addActionListener(this);
        b47.setBounds(380, 300, 240, 40);
        b47.setFont(font);

        b3.addActionListener(this);
        b3.setBounds(380, 350, 240, 40);
        b3.setFont(font);

        b2d49.addActionListener(this);
        b2d49.setBounds(380, 400, 240, 40);
        b2d49.setFont(font);

        b100d49.addActionListener(this);
        b100d49.setBounds(380, 450, 240, 40);
        b100d49.setFont(font);


        textField1.setBounds(380, 100, 100, 40);
        label.setBounds(480, 100, 40, 40);
        textField2.setBounds(520, 100, 100, 40);

        label.setFont(font);
        textField1.setFont(font);
        textField2.setFont(font);
        button.setFont(font);
        labelGUI.setFont(font);
        GUI.setFont(font);
        stop.setFont(font);


        label.setHorizontalAlignment(SwingConstants.CENTER);
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        textField2.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setLayout(null);
        panel.setBackground(Color.GREEN);

        panel.add(textField1);
        panel.add(label);
        panel.add(textField2);

        panel.add(button);
        panel.add(b23);
        panel.add(b365);
        panel.add(b47);
        panel.add(b3);
        panel.add(b2d49);
        panel.add(b100d49);


        GUI.addActionListener(this);
        GUI.setBounds(90, 175, 200, 40);
        labelGUI.setHorizontalAlignment(SwingConstants.CENTER);
        labelGUI.setBounds(90, 125, 200, 40);
        stop.addActionListener(this);
        stop.setBounds(710, 125, 200, 40);

        panel.add(GUI);
        panel.add(stop);
        panel.add(labelGUI);

        frame.setSize(1000, 1000);
        panel.setSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MultiThreading[] multiThreading = new MultiThreading[7];

        if (e.getSource() == GUI) {
            if (GUISource == 0) {
                GUI.setText("Desmos");
                GUISource++;
            } else {
                GUI.setText("Python");
                GUISource--;
            }
        } else if (e.getSource() == stop) {
            for (MultiThreading threading : multiThreading) if (threading != null) threading.terminate();
            System.exit(0);
        } else if (e.getSource() == button) {
            int x = Integer.parseInt(textField1.getText());
            int y = Integer.parseInt(textField2.getText());
            multiThreading[0] = new MultiThreading(x, y);
            multiThreading[0].start();
        } else if (e.getSource() == b23) {
            multiThreading[1] = new MultiThreading(1, 23);
            multiThreading[1].start();
        } else if (e.getSource() == b365) {
            multiThreading[2] = new MultiThreading(1, 365);
            multiThreading[2].start();
        } else if (e.getSource() == b47) {
            multiThreading[3] = new MultiThreading(1, 47);
            multiThreading[3].start();
        } else if (e.getSource() == b3) {
            multiThreading[4] = new MultiThreading(1, 3);
            multiThreading[4].start();
        } else if (e.getSource() == b2d49) {
            multiThreading[5] = new MultiThreading(2, 49);
            multiThreading[5].start();
        } else if (e.getSource() == b100d49) {
            multiThreading[6] = new MultiThreading(100, 49);
            multiThreading[6].start();
        }
    }
}
