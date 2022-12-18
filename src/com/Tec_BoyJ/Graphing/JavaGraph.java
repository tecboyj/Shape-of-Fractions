package com.Tec_BoyJ.Graphing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaGraph {

    private String[] x, y;

    public JavaGraph (String[] x, String[] y) {
        this.x = x;
        this.y = y;
        plot();
    }

    public void plot() {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new DrawGraph(x,y));
    }

    public static class DrawGraph extends JPanel {
        String[] x,y;

        public DrawGraph (String[] x, String[] y) {
            this.x = x;
            this.y = y;
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < x.length; i++) {
                float xCo = Float.parseFloat(x[i]);
                float yCo = Float.parseFloat(y[i]);
                g2d.drawOval((int) xCo, (int) yCo, 5, 5);
            }
        }
    }

}
