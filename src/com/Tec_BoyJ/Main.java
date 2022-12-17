package com.Tec_BoyJ;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    static getPythonFile main = new getPythonFile("/python.py");
    static File file = new File("python.py");
    static int GUISource = 0;

    public static void main(String[] args) throws IOException {
        new GUI();
        //nonGUIInput();
    }

    public static void nonGUIInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a fraction:");

        String string = scanner.nextLine();
        int x = Integer.parseInt(string.substring(0, string.indexOf("/")));
        int y = Integer.parseInt(string.substring(string.indexOf("/") + 1));

        String command = "python3 " + main.string + " " + x + " " + y;
        //String command = "python3 " + file.getAbsolutePath() + " " + x + " " + y;

        Python.python(command);
    }
    public static void GUIInput(int x, int y) throws IOException {
        String command = "python3 " + main.string + " " + x + " " + y;
        //String command = "python3 " + file.getAbsolutePath() + " " + x + " " + y;
        if (GUISource == 0) command = command.replace("python.py", "pythonGUI.py");
        Python.python(command);
        //if (GUISource == 1) new DesmosGraph();
    }



    private static class getPythonFile {
        String string;
        public getPythonFile(String python) {
            this.string = Objects.requireNonNull(getClass().getResource(python)).getPath();
        }
    }
}