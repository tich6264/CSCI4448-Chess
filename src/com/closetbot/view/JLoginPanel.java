package com.closetbot.view;

import javax.swing.*;
import java.awt.*;
/**
 * Created by Owner on 11/18/2016.
 */
public class JLoginPanel extends JPanel {

    public JLoginPanel() {

        this.setLayout(new BorderLayout());

        //Username Panel
        JPanel userNamePanel = new JPanel();

        userNamePanel.add(new JLabel("Username:"));
        userNamePanel.add(new JTextField(20));

        //Password Panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(new JPasswordField(20));

        //Login and Register Buttons
        JPanel bottomPanel = new JPanel();

        //bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(new JButton("Login"));
        bottomPanel.add(new JButton("Register"));

        //Add Components to frame
        this.add(userNamePanel, BorderLayout.NORTH);
        this.add(passwordPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
    private static void createAndShowGui() {
        //Create and Setup frame/window
        JFrame frame = new JFrame("LoginFrame");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create Content Pane
        frame.getContentPane().add(new JLoginPanel());

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

