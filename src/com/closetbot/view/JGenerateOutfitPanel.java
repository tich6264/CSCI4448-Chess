package com.closetbot.view;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Owner on 11/18/2016.
 */
public class JGenerateOutfitPanel extends JPanel {
    public JGenerateOutfitPanel() {
        this.setLayout(new BorderLayout());

        //Title
        JPanel topPanel  = new JPanel();
        topPanel.add(new JLabel("Your Generated Outfit!"));

        //Clothes Data
        JPanel middlepanel = new JPanel();
        middlepanel.setLayout(new BoxLayout(middlepanel, BoxLayout.Y_AXIS));

        middlepanel.add(new JLabel("Top:"));
        middlepanel.add(new JLabel(" "),"span, grow"); //create space
        middlepanel.add(new JLabel("Bottom:"));
        middlepanel.add(new JLabel(" "),"span, grow"); //create space
        middlepanel.add(new JLabel("Shoes:"));
        middlepanel.add(new JLabel(" "),"span, grow"); //create space
        middlepanel.add(new JLabel("Accessories:"));

        //Save Button
        JPanel bottomPanel = new JPanel();
        JButton saveButton;
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(saveButton = new JButton("Save"));
        saveButton.addActionListener(actionEvent -> {
            //TODO UIController save outfit
            System.out.println("Saving outfit");
        });


        //Add Components to frame
        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlepanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    private static void createAndShowGui() {
        //Create and Setup frame/window
        JFrame frame = new JFrame("myFrame");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create Content Pane
        frame.getContentPane().add(new JGenerateOutfitPanel());


        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
