/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncronizerdemo.ui;

import java.util.Comparator;
import syncronizerdemo.db.model.Category;

/**
 *
 * @author dutchman
 */
public class CategoryComparator implements Comparator<Category>{

    @Override
    public int compare(Category cat1, Category cat2) {
        return cat1.getId() - cat2.getId();
    }
    
}
