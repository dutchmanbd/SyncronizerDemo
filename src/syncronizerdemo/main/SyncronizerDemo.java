/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncronizerdemo.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import syncronizerdemo.db.excell.ExcellDBReader;
import syncronizerdemo.db.model.Category;
import syncronizerdemo.db.mysql.DBHandler;
import syncronizerdemo.ui.HomePageUi;

/**
 *
 * @author dutchman
 */
public class SyncronizerDemo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//       ExcellDBReader reader = new ExcellDBReader();
//       List<Category> categoriesFromExcel = reader.getCategories();
//       
//       DBHandler handler = DBHandler.getInstance();
//       List<Category> categoriesFromDB = handler.getCategories();
//       
//       System.out.println("From Excell");
//       System.out.println(categoriesFromExcel);
//       System.out.println("From DB");
//       System.out.println(categoriesFromDB);
//        
        HomePageUi homepage = new HomePageUi();
        homepage.setVisible(true);
    }
    
}
