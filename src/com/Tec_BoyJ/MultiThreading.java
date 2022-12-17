package com.Tec_BoyJ;

import java.io.IOException;

public class MultiThreading extends Thread {

    int x;
    int y;
    public MultiThreading(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void terminate() {
        Python.terminate();
        this.interrupt();
    }

    @Override
    public void run() {
        try {
            Main.GUIInput(this.x, this.y);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
