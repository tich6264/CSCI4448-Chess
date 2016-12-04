package com.closetbot.view;

import com.closetbot.controller.UIController;
import com.closetbot.model.ClothingArticle;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created by Owner on 11/18/2016.
 */
public class JViewClosetPanel extends JPanel {

    private JTable table;
    private JButton deleteItem ;
    private JButton editItem ;
    private JTextField filterText;
    private JTextField statusText;
    private TableRowSorter<ViewClosetTableModel> sorter;
    private Object selected;
    private static UIController uiController = UIController.getUIController();

    public JViewClosetPanel(){
        super();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS ));

        ViewClosetTableModel tableModel = new ViewClosetTableModel(uiController.getClosetData());

        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500,70));
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
                        selected = ((ViewClosetTableModel)table.getModel()).getValueAt(modelRow);
                    }
                }
        );
        JScrollPane tablePane = new JScrollPane(table);
        add(tablePane);

        JPanel form = new JPanel(new SpringLayout());

        deleteItem = new JButton();
        deleteItem.setText("Delete");

        editItem = new JButton();
        editItem.setText("Edit");

        deleteItem.addActionListener(actionEvent -> {
            System.out.println("Deleting : " + selected.toString());
            uiController.removeClothingArticle((ClothingArticle) selected);
            tableModel.setData(uiController.getClosetData());
            tableModel.fireTableDataChanged();
        });

        editItem.addActionListener(actionEvent -> {
            //TODO UIController edit item
            System.out.println("Editing ; " + selected.toString());

            // switch to Edit Clothing Article panel
            remove(tablePane);
            remove(form);

            add(new JEditClothingArticlePanel());

            repaint();
            revalidate();
        });

        form.add(deleteItem);
        form.add(editItem);
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
}
