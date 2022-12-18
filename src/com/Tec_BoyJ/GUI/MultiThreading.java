package com.Tec_BoyJ.GUI;

import com.Tec_BoyJ.Main;

import java.io.IOException;

public class MultiThreading extends Thread {

    int x;
    int y;
    public MultiThreading(int x, int y) {
        this.x = x;
        this.y = y;
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
