package com.Tec_BoyJ;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Python {
    static Python python;

    Process process;

    public Python(String command) throws IOException {
        this.process = Runtime.getRuntime().exec(command);
    }

    public static void terminate() {
        python.process.destroy();
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

        String[] arr1 = new String[arr.length];
        String[] arr2 = new String[arr.length];
        for (int j = 0; j < arr.length; j++) {
            arr1[j] = arr[j][0];
            arr2[j] = arr[j][1];
        }
        /*
        FileWriter myWriter = new FileWriter("/home/jc515081/Coding/Java/ShapeOfFractions/res/arrays.txt");
        myWriter.write(Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
        myWriter.close();

         */
    }
}
