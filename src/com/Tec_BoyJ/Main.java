package com.Tec_BoyJ;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    String string;
    public Main(String python) {
        this.string = getClass().getResource(python).getPath();
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main("/python.py");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a fraction:");

        //String string = scanner.nextLine();
        String string = "2/5";
        int x = Integer.parseInt(string.substring(0, string.indexOf("/")));
        int y = Integer.parseInt(string.substring(string.indexOf("/") + 1));

        File file = new File("python.py");
        String command = "python3 " + main.string + " " + x + " " + y;
        //String command = "python3 " + file.getAbsolutePath() + " " + x + " " + y;
        Process process = Runtime.getRuntime().exec(command);

        scanner = new Scanner(process.getInputStream());
        String pythonOutput = scanner.nextLine();
        pythonOutput = pythonOutput.substring(1, pythonOutput.length() - 1);
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

        FileWriter myWriter = new FileWriter("/home/jc515081/Coding/Java/PythonShapeOfFractions/res/arrays.txt");
        myWriter.write(Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
        myWriter.close();
    }
}