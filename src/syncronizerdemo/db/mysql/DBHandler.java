/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncronizerdemo.db.mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import syncronizerdemo.db.model.Category;

/**
 *
 * @author dutchman
 */
public class DBHandler {
    
    private static DBHandler dbHandler;
    private Connection conn;
    
    
    private DBHandler(){
        createConnection();
    }
    
    public static DBHandler getInstance(){
        if(dbHandler == null)
            dbHandler = new DBHandler();
        
        return dbHandler;
    }
    
    private void createConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            conn = (Connection) DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/ShopManagement","root","");  
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public List<Category> getCategories(){
        
        if(conn == null){
            System.out.println("Conn is null");
            return null;
        }
        
        List<Category> categories = new ArrayList<>();
        
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from category");
            
            while(rs.next()){
                
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double type = rs.getDouble(3);
                int itemId = rs.getInt(4);
                
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setType(type);
                category.setItemId(itemId);
                
                categories.add(category);
            }
            rs.close();
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        
        return categories;
    }
    
}
