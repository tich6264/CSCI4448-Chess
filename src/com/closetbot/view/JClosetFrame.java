package com.closetbot.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JClosetFrame extends JFrame {

    private JPanel jAddOutfitPanel = new JAddOutfitPanel();
    private JPanel jEditOutfitPanel = new JEditOutfitPanel();
    private JPanel jGenerateOutfitPanel = new JGenerateOutfitPanel();
    private JPanel jViewClosetPanel = new JViewClosetPanel();
    private JPanel jViewOutfitClosetPanel = new JViewOutfitClosetPanel();

    public JClosetFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenu();
        setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        JClosetFrame frame = new JClosetFrame();
        frame.setBounds(200, 200, 300, 200);
        frame.setVisible(true);

    }

    private void initMenu() {
        JMenuBar  menubar   = new JMenuBar();
        JMenu     menu      = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Add Outfit");
        JMenuItem menuItem2 = new JMenuItem("Edit Outfit");
        JMenuItem menuItem3 = new JMenuItem("Generate Outfit");
        JMenuItem menuItem4 = new JMenuItem("View Closet");
        JMenuItem menuItem5 = new JMenuItem("View Outfit Closet");

        menubar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menu.add(menuItem5);

        setJMenuBar(menubar);
        menuItem1.addActionListener(new MenuAction(jAddOutfitPanel));
        menuItem2.addActionListener(new MenuAction(jEditOutfitPanel));
        menuItem3.addActionListener(new MenuAction(jGenerateOutfitPanel));
        menuItem4.addActionListener(new MenuAction(jViewClosetPanel));
        menuItem5.addActionListener(new MenuAction(jViewOutfitClosetPanel));
    }

    private void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
    }

    private class MenuAction implements ActionListener {
        private JPanel panel;

        private MenuAction(JPanel pnl) {
            this.panel = pnl;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            changePanel(panel);
        }

    }
}
