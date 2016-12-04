package com.closetbot.view;

import com.closetbot.controller.UIController;
import com.closetbot.model.ClothingArticle;
import com.closetbot.model.Outfit;
import com.closetbot.model.OutfitCloset;
import com.closetbot.model.OutfitIterator;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.*;

/**
 * Created by Owner on 11/18/2016.
 */
public class JViewOutfitClosetPanel extends JPanel {

    private JTable                               table;
    private JButton                              deleteItem;
    private JButton                              next;
    private JTextField                           filterText;
    private JTextField                           statusText;
    private TableRowSorter<ViewClosetTableModel> sorter;
    private Outfit                               selected;
    private OutfitIterator                       closetIterator;
    private static UIController uiController = UIController.getUIController();

    public JViewOutfitClosetPanel() {
        super();
        OutfitCloset closet = uiController.getOutfitCloset();
        if (closet != null) {
            closetIterator = closet.iterator();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ViewOutfitClosetTableModel tableModel = new ViewOutfitClosetTableModel();
        nextOutfit(closetIterator, tableModel);

        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(
                event -> {
                    int viewRow = table.getSelectedRow();
                    if (viewRow < 0) {
                        //Selection got filtered away.
                        statusText.setText("");
                    } else {
                        int modelRow =
                                table.convertRowIndexToModel(viewRow);
                        statusText.setText(String.format("Selected Row in view: %d. " + "Selected Row in model: %d.", viewRow, modelRow));
                    }
                }
        );

        JScrollPane tablePane = new JScrollPane(table);
        add(tablePane);

        JPanel form = new JPanel(new SpringLayout());

        deleteItem = new JButton();
        deleteItem.setText("Delete");

        next = new JButton();
        next.setText("Next");

        deleteItem.addActionListener(actionEvent -> {
            uiController.removeOutfit(selected);//delete and then if there is a next object, go to it
            nextOutfit(closetIterator, tableModel);
        });

        next.addActionListener(actionEvent -> {
            nextOutfit(closetIterator, tableModel);
        });

        form.add(deleteItem);
        form.add(next);
        SpringUtilities.makeCompactGrid(form, 2, 1, 6, 6, 6, 6);
        add(form);

    }

    private void newFilter() {
        RowFilter<ViewClosetTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private boolean nextOutfit(OutfitIterator it, ViewOutfitClosetTableModel model) {

        if (closetIterator != null && closetIterator.hasNext()) {
            selected = (Outfit) closetIterator.next();
            ArrayList<ClothingArticle> clothes = (ArrayList<ClothingArticle>) selected.getClothingArticle();
            Object[][]                 data    = new Object[clothes.size()][4];
            int                        i       = 0;
            for (ClothingArticle cl : clothes) {
                Object[] toAdd = new Object[5];
                toAdd[0] = cl.getType().name();
                toAdd[1] = cl.getColor().name();
                toAdd[2] = cl.getPattern().name();
                toAdd[3] = cl.getSeason().name();
                toAdd[4] = cl;
                data[i++] = toAdd;
            }
            model.setData(data);
            model.fireTableDataChanged();
            return true;
        }
        return false;
    }
}
