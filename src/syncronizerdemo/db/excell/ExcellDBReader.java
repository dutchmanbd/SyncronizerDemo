/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncronizerdemo.db.excell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import syncronizerdemo.db.model.Category;
import syncronizerdemo.db.model.Item;

/**
 *
 * @author dutchman
 */
public class ExcellDBReader {
    
    private static final String FILE_CATEGORY = "/home/dutchman/Documents/items/category.xlsx";
    private static final String FILE_ITEM = "/home/dutchman/Documents/items/item.xlsx";
    
    public List<Category> getCategories(){
        
        List<Category> categories = new ArrayList<>();
        
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_CATEGORY));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            iterator.next();
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                int cellIndex = 0;
                Category category = new Category();
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        category.setName(currentCell.getStringCellValue());
                        //System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        if(cellIndex == 0){     // id
                            category.setId((int)currentCell.getNumericCellValue());
                        } else if(cellIndex == 1){
                            category.setType(currentCell.getNumericCellValue());
                        } else if(cellIndex == 2){
                             category.setItemId((int)currentCell.getNumericCellValue());
                        }
                        cellIndex++;
                        //System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                
                if(category != null && category.getId() > 0)
                    categories.add(category);
                //System.out.println();

            }
            
            return categories;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return Collections.EMPTY_LIST;
    }
    
//    public List<Item> getItems(){
//        
//    }
    
}
