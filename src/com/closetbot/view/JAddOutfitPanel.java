package com.closetbot.view;

import com.closetbot.model.Color;
import com.closetbot.model.Pattern;
import com.closetbot.model.Season;
import com.closetbot.model.Type;

import javax.swing.*;

/**
 * Created by Owner on 11/18/2016.
 */
public class JAddOutfitPanel extends JPanel {
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

        // add dropdowns to frame
        panel.add(typeList);
        panel.add(colorList);
        panel.add(patternList);
        panel.add(seasonList);

        add(panel);
    }
}
