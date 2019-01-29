/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncronizerdemo.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import syncronizerdemo.db.model.Category;

/**
 *
 * @author dutchman
 */
public class CategoryTableModel extends AbstractTableModel {

    private List<Category> categories;
    private String[] columns;
    
    public CategoryTableModel(List<Category> categories){
        this.categories = categories;
        columns = new String[]{
            "Id",
            "Name",
            "Type",
            "Item Id"
        };
    }
    
    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Category category = categories.get(rowIndex);
        
        switch(columnIndex){
            case 0: return category.getId();
            case 1: return category.getName();
            case 2: return category.getType();
            case 3: return category.getItemId();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int col){
        return columns[col];
    }
    
}
