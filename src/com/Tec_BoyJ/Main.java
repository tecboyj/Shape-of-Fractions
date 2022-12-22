package com.Tec_BoyJ;

import com.Tec_BoyJ.GUI.GUI;

import java.io.IOException;
import java.math.*;

public class Main {
    public static int GUISource = 0;
    public static void main(String[] args) throws IOException { new GUI(); }

    public static void mainInput(int x, int y, int scale) throws IOException, IOException {
        BigDecimal value = new BigDecimal(x).divide(new BigDecimal(y), scale, RoundingMode.DOWN);
        String string = value.toString().replace(".", "");
        if (GUISource == 0) Python.python(string);
        //if (GUISource == 1) ;
        //if (GUISource == 2) ;
    }
}