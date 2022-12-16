package com.Tec_BoyJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main implements ActionListener {
    static Main main;
    static File file = new File("python.py");
    static int GUISource = 0;

    String string;
    JFrame frame = new JFrame("Tec_BoyJ");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();

    JButton button = new JButton("GO!");
    JButton b23 = new JButton("1/23");
    JButton b365 = new JButton("1/365");
    JButton b47 = new JButton("1/47");
    JButton b3 = new JButton("1/3");
    JButton b2d49 = new JButton("2/49");
    JButton b100d49 = new JButton("100/49");

    JButton GUI = new JButton("Python");
    public Main(String python) {
        this.string = Objects.requireNonNull(getClass().getResource(python)).getPath();
        Font font = new Font("Arial", Font.PLAIN, 24);

        JLabel label = new JLabel("/");
        JLabel labelGUI = new JLabel("GUI Interface");
        JPanel panel = new JPanel();





        button.addActionListener(this);
        button.setBounds(380, 150, 240, 40);

        b23.addActionListener(this);
        b23.setBounds(380, 200, 240, 40);

        b365.addActionListener(this);
        b365.setBounds(380, 250, 240, 40);

        b47.addActionListener(this);
        b47.setBounds(380, 300, 240, 40);

        b3.addActionListener(this);
        b3.setBounds(380, 350, 240, 40);

        b2d49.addActionListener(this);
        b2d49.setBounds(380, 400, 240, 40);

        b100d49.addActionListener(this);
        b100d49.setBounds(380, 450, 240, 40);





        textField1.setBounds(380, 100, 100, 40);
        label.setBounds(480, 100, 40, 40);
        textField2.setBounds(520, 100, 100, 40);

        label.setFont(font);
        textField1.setFont(font);
        textField2.setFont(font);
        b23.setFont(font);
        b365.setFont(font);
        b47.setFont(font);
        b3.setFont(font);
        button.setFont(font);
        labelGUI.setFont(font);
        GUI.setFont(font);


        label.setHorizontalAlignment(SwingConstants.CENTER);
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        textField2.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setLayout(null);
        panel.setBackground(Color.GREEN);

        panel.add(textField1);
        panel.add(label);
        panel.add(textField2);

        panel.add(button);
        panel.add(b23);
        panel.add(b365);
        panel.add(b47);
        panel.add(b3);
        panel.add(b2d49);
        panel.add(b2d49);


        GUI.addActionListener(this);
        GUI.setBounds(90, 150, 200, 40);
        labelGUI.setHorizontalAlignment(SwingConstants.CENTER);
        labelGUI.setBounds(90, 100, 200, 40);

        panel.add(GUI);
        panel.add(labelGUI);

        frame.setSize(1000, 1000);
        panel.setSize(frame.getSize());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        main = new Main("/python.py");
        //nonGUIInput();
    }

    public static void nonGUIInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a fraction:");

        String string = scanner.nextLine();
        int x = Integer.parseInt(string.substring(0, string.indexOf("/")));
        int y = Integer.parseInt(string.substring(string.indexOf("/") + 1));

        String command = "python3 /home/jc515081/Coding/Java/Shape of Fractions/res/python.py" + " " + x + " " + y;
        //String command = "python3 " + file.getAbsolutePath() + " " + x + " " + y;
        Process process = Runtime.getRuntime().exec(command);

        scanner = new Scanner(process.getInputStream());
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

        FileWriter myWriter = new FileWriter("/home/jc515081/Coding/Java/ShapeOfFractions/res/arrays.txt");
        myWriter.write(Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
        myWriter.close();
        if (GUISource == 1) new GUIHtmlFile();
    }
    public static void GUIInput(int x, int y) throws IOException {
        String command = "python3 " + main.string + " " + x + " " + y;
        //String command = "python3 " + file.getAbsolutePath() + " " + x + " " + y;
        if (GUISource == 0) command = command.replace("python.py", "pythonGUI.py");
        Process process = Runtime.getRuntime().exec(command);

        Scanner scanner = new Scanner(process.getInputStream());
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

        FileWriter myWriter = new FileWriter("/home/jc515081/Coding/Java/ShapeOfFractions/res/arrays.txt");
        myWriter.write(Arrays.toString(arr1) + "\n" + Arrays.toString(arr2));
        myWriter.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GUI) {
            if (GUISource == 0) {
                GUI.setText("Desmos");
                GUISource++;
            } else {
                GUI.setText("Python");
                GUISource--;
            }
        } else if (e.getSource() == button) {
            int x = Integer.parseInt(textField1.getText());
            int y = Integer.parseInt(textField2.getText());
            PythonGUI pythonGUI = new PythonGUI(x, y);
            pythonGUI.start();
        } else if (e.getSource() == b23) {
            PythonGUI pythonGUI = new PythonGUI(1, 23);
            pythonGUI.start();
        } else if (e.getSource() == b365) {
            PythonGUI pythonGUI = new PythonGUI(1, 365);
            pythonGUI.start();
        } else if (e.getSource() == b47) {
            PythonGUI pythonGUI = new PythonGUI(1, 47);
            pythonGUI.start();
        } else if (e.getSource() == b3) {
            PythonGUI pythonGUI = new PythonGUI(1, 3);
            pythonGUI.start();
        } else if (e.getSource() == b2d49) {
            PythonGUI pythonGUI = new PythonGUI(2, 49);
            pythonGUI.start();
        } else if (e.getSource() == b100d49) {
            PythonGUI pythonGUI = new PythonGUI(100, 49);
            pythonGUI.start();
        }
    }
}