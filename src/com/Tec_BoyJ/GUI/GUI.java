package com.Tec_BoyJ.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Tec_BoyJ.Main.GUISource;

public class GUI implements ActionListener {
    JFrame frame = new JFrame("Tec_BoyJ");
    JPanel panel = new JPanel();
    Font font = new Font("Arial", Font.PLAIN, 24);
    int inputScale = 1000;
    int defaultHeight = 25;

    JLabel label = new JLabel("/");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();

    JLabel labelGUI = new JLabel("GUI Interface");

    CustomButton GUI = new CustomButton("Python", 90, defaultHeight + 75, 200, 40);
    CustomButton button = new CustomButton("GO!", 380, defaultHeight + 50, 240, 40);
    CustomButton save = new CustomButton("Save", 380, defaultHeight + 100, 240, 40);

    CustomButton stop = new CustomButton("EXIT", 710, defaultHeight + 25, 200, 40);
    CustomButton all = new CustomButton("ALL", 710, defaultHeight + 75, 200, 40);

    CustomButton test = new CustomButton("Normal Mode", 710, 950, 200, 40);
    boolean testing = false;
    int yValueFraction = defaultHeight + 200;
    int yValueOther = defaultHeight + 200;

    Stack<Integer> stack = new Stack<>();
    /*
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
    FractionButton b1d31 = new FractionButton(yValueFraction, 1, 31, 64);
    FractionButton b1d34 = new FractionButton(yValueFraction, 1, 34, 96);
    FractionButton b1d38 = new FractionButton(yValueFraction, 1, 38, 1000);
    FractionButton b1d42 = new FractionButton(yValueFraction, 1, 42, 64);
    FractionButton b1d46 = new FractionButton(yValueFraction, 1, 46, 1000);
    FractionButton b1d47 = new FractionButton(yValueFraction, 1, 47, 1000);
    FractionButton b1d49 = new FractionButton(yValueFraction, 1, 49, 1000);
    FractionButton b1d53 = new FractionButton(yValueFraction, 1, 53, 1000);
    FractionButton b1d58 = new FractionButton(yValueFraction, 1, 58, 1000);
    FractionButton b1d59 = new FractionButton(yValueFraction, 1, 59, 1000);
    FractionButton b1d81 = new FractionButton(yValueFraction, 1, 81, 1000);
    FractionButton b1d83 = new FractionButton(yValueFraction, 1, 83, 1000);
    FractionButton b1d87 = new FractionButton(yValueFraction, 1, 87, 1000);
    FractionButton b1d89 = new FractionButton(yValueFraction, 1, 89, 1000);
    FractionButton b1d93 = new FractionButton(yValueFraction, 1, 93, 1000);
    FractionButton b1d94 = new FractionButton(yValueFraction, 1, 94, 1000);
    FractionButton b1d97 = new FractionButton(yValueFraction, 1, 97, 1000);
    FractionButton b1d98 = new FractionButton(yValueFraction, 1, 98, 1000);
    FractionButton b1d365 = new FractionButton(yValueFraction, 1, 365, 64);

     */



    OtherDecimal pi = new OtherDecimal(yValueOther, "Pi", "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171");
    OtherDecimal root2 = new OtherDecimal(yValueOther, "Root 2", squareRoot(2, 0, 1));
    OtherDecimal goldenRatio = new OtherDecimal(yValueOther, "Golden Ratio", squareRoot(5, 1, 2));

    public GUI() throws IOException {
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        panel.setSize(1000, yValueFraction + 50);
        panel.setPreferredSize(new Dimension(1000, yValueFraction + 50));
        frame.add(panel);

        initialize();
        actionListener();
        buttons();


        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        frame.add(scrollPane);


        frame.setSize(panel.getWidth() + scrollPane.getVerticalScrollBar().getWidth() + 30, 1000);
        frame.setPreferredSize(new Dimension(panel.getWidth() + scrollPane.getVerticalScrollBar().getWidth() + 30, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void initialize() {
        textField1.setBounds(380, defaultHeight, 100, 40);
        textField1.setFont(font);
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textField1);

        label.setBounds(480, defaultHeight, 40, 40);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        textField2.setBounds(520, defaultHeight, 100, 40);
        textField2.setFont(font);
        textField2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textField2);

        labelGUI.setBounds(90, defaultHeight + 25, 200, 40);
        labelGUI.setFont(font);
        labelGUI.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelGUI);
    }
    private void actionListener() {
        button.addActionListener(this);
        save.addActionListener(this);
        GUI.addActionListener(this);
        stop.addActionListener(this);
        test.addActionListener(this);
        all.addActionListener(this);
    }
    private void buttons() throws IOException {
        Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getResource("/config.txt")).openStream());
        while (scanner.hasNextLine()) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            new FractionButton(yValueFraction, arr[0], arr[1], arr[2]);
        }
    }

    private String squareRoot(int number, int additional, int divisor) {
        BigDecimal bNumber = new BigDecimal(number);
        BigDecimal sqrtNumber = bNumber.sqrt(new MathContext(1000)).add(new BigDecimal(additional)).divide(new BigDecimal(divisor), RoundingMode.DOWN);
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
            new MultiThreadingBigDecimal(x, y, 1000).start();
        } else if (e.getSource() == test) {
            if (!testing) {
                test.setText("<html><font color='red'>Testing Mode</font></html>");
                testing = true;
            } else {
                test.setText("Normal Mode");
                testing = false;
            }
        } else if (e.getSource() == all) {
            while (!stack.empty()) {
                new MultiThreadingBigDecimal(stack.pop(), stack.pop(), stack.pop()).start();
            }
        } else if (e.getSource() == save) {
            new popUp();
        }
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
    private class popUp {
        public popUp() {
            JFrame frame = new JFrame();
            JTextField textField = new JTextField();
            textField.setBounds(100, 5, 100, 40);
            CustomButton button = new CustomButton("OK", 100, 55, 100, 40);
            button.addActionListener(e -> {
                inputScale = Integer.parseInt(textField.getText());
                try {
                    FileWriter fileWriter = new FileWriter(Objects.requireNonNull(getClass().getResource("/config.txt")).getPath(), true);
                    fileWriter.write(textField1.getText() + "," + textField2.getText() + "," + inputScale);
                    fileWriter.close();
                    System.out.println("Saved!");
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

            stack.add(scale);
            stack.add(den);
            stack.add(num);

            yValueFraction += 50;
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

            yValueOther += 50;
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
