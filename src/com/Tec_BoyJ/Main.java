package com.Tec_BoyJ;

import com.Tec_BoyJ.GUI.GUI;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    static getPythonFile main = new getPythonFile("/Python/python.py");
    //static File file = new File("python.py");
    public static int GUISource = 0;

    public static void main(String[] args) {
        new GUI();
    }

    public static void GUIInput(int x, int y) throws IOException {
        String command = "python3 " + main.string + " " + x + " " + y;
        //String command = "python3 " + file.getAbsolutePath() + " " + x + " " + y;
        if (GUISource == 0) command = command.replace("Python/python.py", "Python/pythonGUI.py");
        Python.python(command);
    }



    private static class getPythonFile {
        String string;
        public getPythonFile(String python) {
            this.string = Objects.requireNonNull(getClass().getResource(python)).getPath();
        }
    }
}