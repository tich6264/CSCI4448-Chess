package com.closetbot.view;

import com.closetbot.model.*;

import javax.swing.table.AbstractTableModel;

/**
 * Created by joey on 11/18/16.
 */
public class ViewOutfitClosetTableModel extends AbstractTableModel{
        private boolean DEBUG = true;
        private String[] columnNames = {"Type",
                                        "Color",
                                        "Pattern",
                                        "Season"};
        private Object[][] data = {
        {"Shoes", "BLUE",
         "CHECKERED", "FALL", new Shoes(ShoeTypes.BOOTS)}, //TODO have final element be clothingarticle
        {"Top", "RED",
                "STRIPED", "SUMMER", new Top(TopTypes.CARDIGAN)},
        {"Bottom", "PINK",
                "NONE", "SPRING", new Bottom(BottomTypes.CAPRIS)}
        };

    public ViewOutfitClosetTableModel(Object[][] data) {
        if(data != null)
            this.data = data;
    }

    public ViewOutfitClosetTableModel() {

    }

    public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public void setData(Object[][] newData){
            data = newData;
            fireTableDataChanged();
        }
        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

}
