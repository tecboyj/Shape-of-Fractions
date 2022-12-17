package com.Tec_BoyJ;

import javax.swing.*;
import java.io.File;

public class DisplayGraph {
    public static void main(String[] args) {
        // Path of the file to be displayed
        String filePath = "/home/jc515081/Coding/Java/ShapeOfFractions/res/index.html";
        // Create a frame
        JFrame frame = new JFrame("Display Graph");
        // Create a scroll pane
        JScrollPane scrollPane = new JScrollPane();
        // Create an editor pane
        JEditorPane editorPane = new JEditorPane();
        try {
            // Read the file
            editorPane.setPage(new File(filePath).toURI().toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Add the editor pane to the scroll pane
        scrollPane.setViewportView(editorPane);
        // Add the scroll pane to the frame
        frame.getContentPane().add(scrollPane);
        // Display the frame
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}