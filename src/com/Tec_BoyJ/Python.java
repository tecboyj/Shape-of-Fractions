package com.Tec_BoyJ;

import com.Tec_BoyJ.Graphing.JavaGraph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static com.Tec_BoyJ.Main.GUISource;

public class Python {
    static Python python;
    public static float[] arrX, arrY;

    Process process;

    public Python(String command) throws IOException {
        this.process = Runtime.getRuntime().exec(command);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            process.destroy();
        }));
    }

    public static void python(String command) throws IOException {
        python = new Python(command);

        Scanner scanner = new Scanner(python.process.getInputStream());
        String pythonOutput = scanner.nextLine();
        pythonOutput = pythonOutput.substring(1, pythonOutput.length() - 1);
        System.out.println(pythonOutput);


        List<String> list = Arrays.asList(pythonOutput.split(", "));
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("(")) stack.add(s.replace("(", ""));
            if (s.contains(")")) stack.add(s.replace(")", ""));
        }

        String[][] arr = new String[stack.size()/2][2];
        int i = stack.size()/2 - 1;
        while (!stack.empty()) {
            arr[i][1] = stack.pop();
            arr[i][0] = stack.pop();
            i--;
        }

        arrX = new float[arr.length];
        arrY = new float[arr.length];
        for (int j = 0; j < arr.length; j++) {
            arrX[j] = Float.parseFloat(arr[j][0]);
            arrY[j] = Float.parseFloat(arr[j][1]);
        }

        if (GUISource == 1) {
            write(arrX, arrY);
            //new DesmosGraph();
        }
        if (GUISource == 2) new JavaGraph();
    }
    public static void write(float[] arrX, float[] arrY) throws IOException {
        FileWriter myWriter = new FileWriter("/home/jc515081/Coding/Java/ShapeOfFractions/res/arrays.txt");
        myWriter.write(Arrays.toString(arrX) + "\n" + Arrays.toString(arrY));
        myWriter.close();
    }
}