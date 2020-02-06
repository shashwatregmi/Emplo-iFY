/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.*;
import model.*;

/**
 *
 * @author Regmi
 */
public class Main {
    
    public static void main(String [] args){
        try { 
            DataBase database = new DataBase();
          // ResultSet myrs = database.getStatement().executeQuery("select * from department");
            Splash splashScreen = new Splash();
            splashScreen.setVisible(true);
            Home homeScreen = new Home();
            try {
                for (int i = 0; i<=100; i++){
                    Thread.sleep(30);
                }
                splashScreen.setVisible(false);
                homeScreen.setVisible(true);

            } catch (Exception e) {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            System.out.println("Database connection error!");   
        }
    }

    
}
