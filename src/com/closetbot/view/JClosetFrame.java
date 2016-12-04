package com.closetbot.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JClosetFrame extends JFrame {

    private JPanel jAddClothingArticlePanel = new JAddClothingArticlePanel();
    private JPanel jGenerateOutfitPanel     = new JGenerateOutfitPanel();

    public JClosetFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenu();
        setLayout(new BorderLayout());
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Add Outfit");
        JMenuItem menuItem2 = new JMenuItem("Generate Outfit");
        JMenuItem menuItem3 = new JMenuItem("View Closet");
        JMenuItem menuItem4 = new JMenuItem("View Outfit Closet");

        menubar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);

        setJMenuBar(menubar);
        menuItem1.addActionListener(new MenuAction(jAddClothingArticlePanel));
        menuItem2.addActionListener(new MenuAction(jGenerateOutfitPanel));
        //do the following because we want to create the panel on the fly in order to get the most accurate data
        menuItem3.addActionListener((e) -> {
            getContentPane().removeAll();
            getContentPane().add(new JViewClosetPanel(), BorderLayout.CENTER);
            getContentPane().revalidate();
            getContentPane().doLayout();
            getContentPane().repaint();
            update(getGraphics());
        });
        menuItem4.addActionListener((e) -> {
            getContentPane().removeAll();
            getContentPane().add(new JViewOutfitClosetPanel(), BorderLayout.CENTER);
            getContentPane().revalidate();
            getContentPane().doLayout();
            getContentPane().repaint();
            update(getGraphics());
        });
    }

    private void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().doLayout();
        getContentPane().repaint();
        update(getGraphics());
        if (panel instanceof JViewClosetPanel)
            ((JViewClosetPanel) panel).update();
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
