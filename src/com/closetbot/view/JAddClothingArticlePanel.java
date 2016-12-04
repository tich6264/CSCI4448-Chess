package com.closetbot.view;

import com.closetbot.controller.UIController;
import com.closetbot.model.*;
import com.closetbot.model.Color;

import javax.persistence.Access;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Caleb on 11/18/2016.
 */
public class JAddClothingArticlePanel extends JPanel {
    private JLabel typeLabel;
    private JLabel subTypeLabel;
    private JLabel colorLabel;
    private JLabel patternLabel;
    private JLabel seasonLabel;
    private JButton saveButton;
    private static UIController uiController = UIController.getUIController();

    public JAddClothingArticlePanel()
    {
        super();
        JPanel th = this;
        setLayout(new BorderLayout());

        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Add Your New Article of Clothing"));

        // Dropdowns
        String[] types = new String[] {"Accessories", "Bottom", "Top", "Shoes"};

        JComboBox<String> typeList = new JComboBox<String>(types);
        JComboBox<Color> colorList = new JComboBox(Color.values());
        JComboBox<Pattern> patternList = new JComboBox(Pattern.values());
        JComboBox<Season> seasonList = new JComboBox(Season.values());

        // this is empty until a type is selected
        JComboBox subTypeList = new JComboBox();

        // updates subtype dropdown based on type selection
        typeList.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ){
                JComboBox typeList = (JComboBox) event.getSource();
                Object selectedBox = typeList.getSelectedItem();

                updateSubTypeList( selectedBox, subTypeList );
            }
        } );

        // Creates panel for each attribute
        // TYPE
        JPanel typePanel = new JPanel();
        typeLabel = new JLabel("Type");

        typePanel.add(typeLabel);
        typePanel.add(typeList);

        // SUBTYPE
        JPanel subTypePanel = new JPanel();
        subTypeLabel = new JLabel("Subtype");

        subTypePanel.add(subTypeLabel);
        subTypePanel.add(subTypeList);

        // COLOR
        JPanel colorPanel = new JPanel();
        colorLabel = new JLabel("Color");

        colorPanel.add(colorLabel);
        colorPanel.add(colorList);

        // PATTERN
        JPanel patternPanel = new JPanel();
        patternLabel = new JLabel("Pattern");

        patternPanel.add(patternLabel);
        patternPanel.add(patternList);

        // SEASON
        JPanel seasonPanel = new JPanel();
        seasonLabel = new JLabel("Season");

        seasonPanel.add(seasonLabel);
        seasonPanel.add(seasonList);

        // Aligns labels and dropdowns down Y axis
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

        bodyPanel.add(typePanel);
        bodyPanel.add(subTypePanel);
        bodyPanel.add(colorPanel);
        bodyPanel.add(patternPanel);
        bodyPanel.add(seasonPanel);

        typePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        subTypePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        colorPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        patternPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        seasonPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Save
        saveButton = new JButton("Save");
        saveButton.addActionListener(actionEvent -> {
            uiController.addClothingArticle((Type) subTypeList.getSelectedItem(),(Color) colorList.getSelectedItem(),(Pattern) patternList.getSelectedItem(),(Season) seasonList.getSelectedItem());

            // switch to updated View Closet
            JClosetFrame frame = (JClosetFrame) SwingUtilities.getWindowAncestor(th);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new JViewClosetPanel());
            frame.revalidate();
            frame.repaint();
        });
        bodyPanel.add(saveButton);

        // add all panels
        add(titlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }

    private void updateSubTypeList( Object _selectedBox, JComboBox _subTypeList ){
        if( _selectedBox.toString().equals("Accessories") ){
            _subTypeList.setModel( new DefaultComboBoxModel<AccessoryTypes>(AccessoryTypes.values()));
        }
        else if( _selectedBox.toString().equals("Bottom") ){
            _subTypeList.setModel( new DefaultComboBoxModel<BottomTypes>(BottomTypes.values()));
        }
        else if( _selectedBox.toString().equals("Top") ){
            _subTypeList.setModel( new DefaultComboBoxModel<TopTypes>(TopTypes.values()));
        }
        else if( _selectedBox.toString().equals("Shoes") ){
            _subTypeList.setModel( new DefaultComboBoxModel<ShoeTypes>(ShoeTypes.values()));
        }
        else{
            JComboBox subTypeList = new JComboBox();
        }
    }
}
