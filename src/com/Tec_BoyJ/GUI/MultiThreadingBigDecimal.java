package com.Tec_BoyJ.GUI;

import com.Tec_BoyJ.Python;

import java.io.IOException;

public class MultiThreadingBigDecimal extends Thread {

    int x;
    int y;
    int scale;
    public MultiThreadingBigDecimal(int x, int y, int scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    @Override
    public void run() {
        try {
            Python.bigDeci(this.x, this.y, this.scale);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
