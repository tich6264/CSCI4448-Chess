package com.closetbot.view;

import com.closetbot.model.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Owner on 11/18/2016.
 */
public class JLoginPanel extends JPanel {

    private JTextField userField;
    private JTextField passwordField;


    public JLoginPanel() {
        /*Local Variables*/
        JLabel userLabel;
        JLabel passwordLabel;
        JButton btnLogin;
        JButton btnRegister;
        this.setLayout(new BorderLayout());

        /*Username Panel*/
        JPanel userNamePanel = new JPanel();

        //Username Label
        userLabel = new JLabel("Username: ");
        userNamePanel.add(userLabel);

        //Username Field
        userField = new JTextField(20);
        userNamePanel.add(userField);


        /*Password Panel*/
        JPanel passwordPanel = new JPanel();

        //Password Label
        passwordLabel = new JLabel("Password: ");
        passwordPanel.add(passwordLabel);

        //Password Field
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordField);

        /*Button Panel*/
        JPanel bottomPanel = new JPanel();

        /*Login Button*/
        btnLogin = new JButton("Login");
        bottomPanel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Login.authentication(getUsername(), getPassword())) {
                    javax.swing.SwingUtilities.invokeLater((Runnable) () -> {
                                JClosetFrame frame = new JClosetFrame();
                                frame.setBounds(200, 200, 3000, 2000);
                                frame.setVisible(true);
                            }
                    );

                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(JLoginPanel.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    userField.setText("");
                    passwordField.setText("");
                }
            }
        });

        /*Register Button*/
        btnRegister = new JButton("Register");
        bottomPanel.add(btnRegister);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userField.getText() != "" || passwordField.getText() != "" ){//(add check: not already in database => successful add to databse) {
                    javax.swing.SwingUtilities.invokeLater((Runnable) () -> {
                                JClosetFrame frame = new JClosetFrame();
                                frame.setVisible(true);
                            }
                    );
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(JLoginPanel.this,
                            "Required fields, username and password, not filled in",
                            "Registration",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    userField.setText("");
                    passwordField.setText("");
                }
            }
        });

        //Add Components to frame
        this.add(userNamePanel, BorderLayout.NORTH);
        this.add(passwordPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
    private String getUsername(){
        return userField.getText().trim();
    }
    private String getPassword(){
        return new String(passwordField.getText());
    }
    private static void createAndShowGui() {
        //Create and Setup frame/window
        JFrame frame = new JFrame("LoginFrame");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

