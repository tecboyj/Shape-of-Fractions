package com.Tec_BoyJ.GUI;

import javax.swing.*;
import java.awt.*;
import java.math.*;
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

    CustomButton GUI = new CustomButton("Python", 90, 175, 200, 40);
    CustomButton button = new CustomButton("GO!", 380, 150, 240, 40);
    CustomButton stop = new CustomButton("EXIT", 710, 125, 200, 40);
    CustomButton test = new CustomButton("Normal Mode", 710, 175, 200, 40);
    boolean testing = false;
    int yValueFraction = 200;
    int yValueOther = 250;

    FractionButton b1d3 = new FractionButton(yValueFraction, 1, 3, 16);
    FractionButton b1d6 = new FractionButton(yValueFraction, 1, 6, 16);
    FractionButton b1d7 = new FractionButton(yValueFraction, 1, 7, 64);
    FractionButton b1d9 = new FractionButton(yValueFraction, 1, 9, 16);
    FractionButton b1d12 = new FractionButton(yValueFraction, 1, 12, 32);
    FractionButton b1d13 = new FractionButton(yValueFraction, 1, 13, 64);
    FractionButton b1d14 = new FractionButton(yValueFraction, 1, 14, 64);
    FractionButton b1d17 = new FractionButton(yValueFraction, 1, 17, 1000);
    FractionButton b1d19 = new FractionButton(yValueFraction, 1, 19, 1000);
    FractionButton b1d21 = new FractionButton(yValueFraction, 1, 21, 64);
    FractionButton b1d23 = new FractionButton(yValueFraction, 1, 23, 1000);
    FractionButton b1d29 = new FractionButton(yValueFraction, 1, 29, 1000);
    FractionButton b1d42 = new FractionButton(yValueFraction, 1, 42, 64);
    FractionButton b1d47 = new FractionButton(yValueFraction, 1, 47, 1000);
    FractionButton b1d49 = new FractionButton(yValueFraction, 1, 49, 1000);
    FractionButton b1d365 = new FractionButton(yValueFraction, 1, 365, 64);

    OtherDecimal pi = new OtherDecimal(yValueOther, "Pi", "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171");
    OtherDecimal root2 = new OtherDecimal(yValueOther, "Root 2", squareRoot(2, 0, 1, 1000));
    OtherDecimal goldenRatio = new OtherDecimal(yValueOther, "Golden Ratio", squareRoot(5, 1, 2, 1000));
    /*
    FractionButton b2d49 = new FractionButton(400, 2, 49, 64);
    FractionButton b100d49 = new FractionButton(450, 100, 49, 64);
    FractionButton b3d7 = new FractionButton(500, 3, 7, 64);
    FractionButton b56d43 = new FractionButton(550, 56, 43, 64);

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

        labelGUI.setBounds(90, 125, 200, 40);
        labelGUI.setFont(font);
        labelGUI.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelGUI);

        button.addActionListener(this);
        GUI.addActionListener(this);
        stop.addActionListener(this);
        test.addActionListener(this);

        frame.setSize(1000, 1000);
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private String squareRoot(int number, int additional, int divisor, int precision) {
        BigDecimal bNumber = new BigDecimal(number);
        BigDecimal sqrtNumber = bNumber.sqrt(new MathContext(precision)).add(new BigDecimal(additional)).divide(new BigDecimal(divisor), RoundingMode.DOWN);
        return sqrtNumber.toString().replace(".", "");
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
            new MultiThreadingBigDecimal(x, y, 64).start();
        } else if (e.getSource() == test) {
            if (!testing) {
                test.setText("<html><font color='red'>Testing Mode</font></html>");
                testing = true;
            } else {
                test.setText("Normal Mode");
                testing = false;
                ReAdd();
            }
        }
    }

    private void ReAdd() {
        panel.add(b1d3);
        panel.add(b1d6);
        panel.add(b1d7);
        panel.add(b1d9);
        panel.add(b1d12);
        panel.add(b1d13);
        panel.add(b1d14);
        panel.add(b1d17);
        panel.add(b1d19);
        panel.add(b1d21);
        panel.add(b1d23);
        panel.add(b1d29);
        panel.add(b1d42);
        panel.add(b1d47);
        panel.add(b1d49);
        panel.add(b1d365);

        panel.add(pi);
        panel.add(root2);
        panel.add(goldenRatio);

        panel.repaint();
    }


    private class CustomButton extends JButton {
        public CustomButton(String text, int x, int y, int width, int height) {
            super(text);
            this.setBounds(x, y, width, height);
            this.setFont(font);
            this.setFocusPainted(false);
            panel.add(this);
        }
    }

    private class FractionButton extends CustomButton implements ActionListener {
        int num;
        int den;
        int scale;
        public FractionButton(int yValue, int num, int den, int scale) {
            super(num + "/" + den, 380, yValue, 240, 40);

            this.num = num;
            this.den = den;
            this.scale = scale;
            this.addActionListener(this);

            GUI.this.yValueFraction += 50;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (testing) panel.remove(this);
            panel.repaint();
            new MultiThreadingBigDecimal(num, den, scale).start();
        }
    }
    private class OtherDecimal extends CustomButton implements ActionListener {
        String string;
        public OtherDecimal(int yValue, String name, String string) {
            super(name, 710, yValue, 200, 40);

            this.string = string;
            this.addActionListener(this);

            GUI.this.yValueOther += 50;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(this.string);
            if (testing) panel.remove(this);
            panel.repaint();
            new MultiThreadingOther(this.string).start();
        }
    }
}
