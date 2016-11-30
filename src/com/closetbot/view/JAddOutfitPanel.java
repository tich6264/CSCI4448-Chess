package com.closetbot.view;

import com.closetbot.model.*;
import com.closetbot.model.Color;

import javax.persistence.Access;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Owner on 11/18/2016.
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

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // creates dropdowns
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
                    //JComboBox<AccessoryTypes> subTypeList = new JComboBox(AccessoryTypes.values());
                }
                else if( selected.toString().equals("Bottom") ){
                    subTypeList.setModel( new DefaultComboBoxModel<BottomTypes>(BottomTypes.values()));
                    // JComboBox<BottomTypes> subTypeList = new JComboBox(BottomTypes.values());
                }
                else if( selected.toString().equals("Top") ){
                    subTypeList.setModel( new DefaultComboBoxModel<TopTypes>(TopTypes.values()));
                    // JComboBox<TopTypes> subTypeList = new JComboBox(TopTypes.values());
                }
                else if( selected.toString().equals("Shoes") ){
                    subTypeList.setModel( new DefaultComboBoxModel<ShoeTypes>(ShoeTypes.values()));
                    // JComboBox<ShoeTypes> subTypeList = new JComboBox(ShoeTypes.values());
                }
                else{
                    JComboBox subTypeList = new JComboBox();
                }
            }
        } );

        // creates labels
        typeLabel = new JLabel("Type");
        subTypeLabel = new JLabel("Subtype");
        colorLabel = new JLabel("Color");
        patternLabel = new JLabel("Pattern");
        seasonLabel = new JLabel("Season");

        // save selections
        saveButton = new JButton("Save");

        // add dropdowns & labels to frame
        panel.add(typeLabel);
        panel.add(typeList);

        panel.add(subTypeLabel);
        panel.add(subTypeList);

        panel.add(colorLabel);
        panel.add(colorList);

        panel.add(patternLabel);
        panel.add(patternList);

        panel.add(seasonLabel);
        panel.add(seasonList);

        panel.add(saveButton);

        add(panel);
    }
}
