package com.closetbot.view;

import com.closetbot.controller.UIController;
import com.closetbot.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by Owner on 11/18/2016.
 */
public class JGenerateOutfitPanel extends JPanel {
    private static UIController uiController = UIController.getUIController();

    private Iterator<Outfit> generatedOutfits;
    private Outfit currentOutfit = null;

    public JGenerateOutfitPanel() {
        this.setLayout(new BorderLayout());

        JComboBox<Season> seasonList = new JComboBox<>(Season.values());
        JPanel seasonPanel = new JPanel();
        JLabel seasonLabel = new JLabel("Season");
        JButton generate = new JButton("Generate!");

        JLabel top = new JLabel();
        JLabel bottom = new JLabel();
        JLabel shoes = new JLabel();
        JLabel accessories = new JLabel();

        generate.addActionListener((e)->
        {
            generatedOutfits = uiController.getCloset().generateOutfits((Season) seasonList.getSelectedItem()).iterator();
            if(generatedOutfits.hasNext()){
                currentOutfit = generatedOutfits.next();
                List clothes = currentOutfit.getClothingArticle();
                Top t = (Top) clothes.stream().filter((x) -> x instanceof Top).toArray()[0];
                Bottom b = (Bottom) clothes.stream().filter((x) -> x instanceof Bottom).toArray()[0];
                Shoes s = (Shoes) clothes.stream().filter((x) -> x instanceof Shoes).toArray()[0];
                Accessories a = (Accessories) clothes.stream().filter((x) -> x instanceof Accessories).toArray()[0];

                top.setText(t.getPattern().name() + " " + t.getColor().name() + " " + t.getType().name());
                bottom.setText(b.getPattern().name() + " " + b.getColor().name() + " " + b.getType().name());
                shoes.setText(s.getPattern().name() + " " + s.getColor().name() + " " + s.getType().name());
                accessories.setText(a.getPattern().name() + " " + a.getColor().name() + " " + a.getType().name());
            }
        });

        seasonPanel.add(seasonLabel);
        seasonPanel.add(seasonList);
        seasonPanel.add(generate);

        //Title
        JPanel topPanel  = new JPanel();
        topPanel.add(new JLabel("Your Generated Outfit!"));

        //Clothes Data
        JPanel middlepanel = new JPanel();
        middlepanel.setLayout(new BoxLayout(middlepanel, BoxLayout.Y_AXIS));

        middlepanel.add(new JLabel("Top:"));
        middlepanel.add(top);
        middlepanel.add(new JLabel(" "),"span, grow"); //create space
        middlepanel.add(new JLabel("Bottom:"));
        middlepanel.add(bottom);
        middlepanel.add(new JLabel(" "),"span, grow"); //create space
        middlepanel.add(new JLabel("Shoes:"));
        middlepanel.add(shoes);
        middlepanel.add(new JLabel(" "),"span, grow"); //create space
        middlepanel.add(new JLabel("Accessories:"));
        middlepanel.add(accessories);

        JButton nextOutfit = new JButton("Next");
        nextOutfit.addActionListener((e)->{
            if(generatedOutfits.hasNext()){
                currentOutfit = generatedOutfits.next();
                List clothes = currentOutfit.getClothingArticle();
                Top t = (Top) clothes.stream().filter((x) -> x instanceof Top).toArray()[0];
                Bottom b = (Bottom) clothes.stream().filter((x) -> x instanceof Bottom).toArray()[0];
                Shoes s = (Shoes) clothes.stream().filter((x) -> x instanceof Shoes).toArray()[0];
                Accessories a = (Accessories) clothes.stream().filter((x) -> x instanceof Accessories).toArray()[0];

                top.setText(t.getType().name());
                bottom.setText(b.getType().name());
                shoes.setText(s.getType().name());
                accessories.setText(a.getType().name());
            }
        });

        seasonPanel.add(nextOutfit,BorderLayout.EAST);

        //Save Button
        JPanel bottomPanel = new JPanel();
        JButton saveButton;
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(saveButton = new JButton("Save"));

        saveButton.addActionListener(actionEvent -> {
            System.out.println("Saving outfit");
            uiController.saveOutfit(currentOutfit);
        });

        //Add Components to frame
        this.add(seasonPanel, BorderLayout.BEFORE_FIRST_LINE);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlepanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}
