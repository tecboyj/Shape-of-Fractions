package com.Tec_BoyJ;

import java.io.IOException;

public class PythonGUI extends Thread {

    int x;
    int y;
    public PythonGUI(int x, int y) {
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
