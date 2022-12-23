package com.Tec_BoyJ.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class CustomClasses extends GUI{
    protected static class popUp {
        public popUp() {
            JFrame frame = new JFrame();
            JTextField textField = new JTextField();
            textField.setBounds(100, 5, 100, 40);
            CustomButton button = new CustomButton("OK", 100, 55, 100, 40);
            button.addActionListener(e -> {
                inputScale = Integer.parseInt(textField.getText());
                try {
                    //File file = new File("config.txt");
                    //FileWriter fileWriter = new FileWriter(file);
                    FileWriter fileWriter = new FileWriter(Objects.requireNonNull(getClass().getResource("/config.txt")).getPath(), true);
                    fileWriter.write("\n" + textField1.getText() + "," + textField2.getText() + "," + inputScale);
                    fileWriter.close();
                    new FractionButton(yValueFraction, Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()), inputScale);
                    panel.repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                inputScale = 1000;
                frame.dispose();
            });

            frame.add(textField);
            frame.add(button);

            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }

    protected static class CustomButton extends JButton {
        public CustomButton(String text, int x, int y, int width, int height) {
            super(text);
            this.setBounds(x, y, width, height);
            this.setFont(new Font("Arial", Font.PLAIN, 24));
            this.setFocusPainted(false);
            panel.add(this);
        }
    }

    protected static class FractionButton extends CustomButton implements ActionListener {
        int num;
        int den;
        int scale;
        public FractionButton(int yValue, int num, int den, int scale) {
            super(num + "/" + den, 380, yValue, 240, 40);

            this.num = num;
            this.den = den;
            this.scale = scale;
            this.addActionListener(this);

            stack.add(scale);
            stack.add(den);
            stack.add(num);

            yValueFraction += 50;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new MultiThreadingBigDecimal(num, den, scale).start();
        }
    }
    protected static class OtherDecimal extends CustomButton implements ActionListener {
        String string;
        public OtherDecimal(int yValue, String name, String string) {
            super(name, 710, yValue, 200, 40);

            this.string = string;
            this.addActionListener(this);

            yValueOther += 50;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new MultiThreadingOther(this.string).start();
        }
    }
}
