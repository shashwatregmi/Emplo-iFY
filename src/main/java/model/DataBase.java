/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Regmi
 */
public class DataBase {
    Connection dbConnect;
    Statement dbStat;
    
    public DataBase() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_manager", "root", "MySQL2019");
            dbStat = dbConnect.createStatement();
        } catch (Exception e) {
            System.out.println("Databse Connection Error");
        }
    }
    
    public Statement getStatement() {
        return dbStat;
    }
    
    public Connection getconn() {
        return dbConnect;
    }
}
