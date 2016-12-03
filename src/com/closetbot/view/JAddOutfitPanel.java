package com.closetbot.view;

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
public class JAddOutfitPanel extends JPanel {
    private JLabel typeLabel;
    private JLabel subTypeLabel;
    private JLabel colorLabel;
    private JLabel patternLabel;
    private JLabel seasonLabel;
    private JButton saveButton;

    public JAddOutfitPanel()
    {
        super();
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
                Object selected = typeList.getSelectedItem();
                if( selected.toString().equals("Accessories") ){
                    subTypeList.setModel( new DefaultComboBoxModel<AccessoryTypes>(AccessoryTypes.values()));
                }
                else if( selected.toString().equals("Bottom") ){
                    subTypeList.setModel( new DefaultComboBoxModel<BottomTypes>(BottomTypes.values()));
                }
                else if( selected.toString().equals("Top") ){
                    subTypeList.setModel( new DefaultComboBoxModel<TopTypes>(TopTypes.values()));
                }
                else if( selected.toString().equals("Shoes") ){
                    subTypeList.setModel( new DefaultComboBoxModel<ShoeTypes>(ShoeTypes.values()));
                }
                else{
                    JComboBox subTypeList = new JComboBox();
                }
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
        bodyPanel.add(saveButton);

        // add all panels
        add(titlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }
}
