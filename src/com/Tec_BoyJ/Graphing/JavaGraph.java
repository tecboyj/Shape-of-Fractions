package com.Tec_BoyJ.Graphing;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

import static com.Tec_BoyJ.Python.arrX;
import static com.Tec_BoyJ.Python.arrY;

public class JavaGraph extends JFrame {
    public JavaGraph() {
        //testing();

        this.add(new JComponent() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                for (int i = 0; i < arrX.length - 1; i++) {
                    Shape shape = new Line2D.Float(arrX[i] * 100, arrY[i] * 100, arrX[i + 1] * 100, arrY[i + 1] * 100);
                    g2.draw(shape);
                }
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setVisible(true);
    }
    public void testing() {
        arrX = new float[5];
        arrY = new float[5];
        arrX[0] = 0;
        arrY[0] = 0;
        arrX[1] = 1;
        arrY[1] = 1;
        arrX[2] = 2;
        arrY[2] = 2;
        arrX[3] = 3;
        arrY[3] = 3;
        arrX[4] = 4;
        arrY[4] = 4;
    }

    public static void main(String[] args) {
        new JavaGraph();
    }
}
