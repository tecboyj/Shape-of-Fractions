package com.Tec_BoyJ;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class GUIHtmlFile {

    public static void main(String[] args) {
        // create frame
        JFrame frame = new JFrame("GUI HTML File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 500));

        // create panel
        final JEditorPane htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        htmlPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        htmlPane.setPage(event.getURL());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // load local html file
        try {
            URL url = new URL("file:///home/jc515081/Coding/Java/ShapeOfFractions/res/index.html");
            htmlPane.setPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add panel to frame
        frame.getContentPane().add(new JScrollPane(htmlPane), BorderLayout.CENTER);

        // display frame
        frame.setVisible(true);
    }
}