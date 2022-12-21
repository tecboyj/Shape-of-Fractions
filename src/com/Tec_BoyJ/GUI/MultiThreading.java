package com.Tec_BoyJ.GUI;

import com.Tec_BoyJ.Python;

import java.io.IOException;

public class MultiThreading extends Thread {

    int x;
    int y;
    int scale;
    public MultiThreading(int x, int y, int scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    @Override
    public void run() {
        try {
            Python.python(this.x, this.y, this.scale);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
