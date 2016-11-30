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
    private OutfitCloset                         closet;
    private OutfitIterator                       closetIterator;
    private static UIController uiController = UIController.getUIController();


    public JViewOutfitClosetPanel() {
        super();
        closet = UIController.getOutfitCloset();
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
            uiController.removeOutfit(selected);
            System.out.println("Deleting : " + selected.toString());
        });

        next.addActionListener(actionEvent -> {
            System.out.println("Next item ; " + selected.toString());
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

        if (closetIterator.hasNext()) {
            selected = (Outfit) closetIterator.next();
            ArrayList<ClothingArticle> clothes = (ArrayList<ClothingArticle>) selected.getClothingArticle();
            Object[][]                 data    = new Object[4][clothes.size()];
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

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableFilterDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JViewClosetPanel newContentPane = new JViewClosetPanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
