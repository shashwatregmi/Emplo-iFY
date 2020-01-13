/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Regmi
 */
public class Employee {
    int id;
    String first_name;
    String last_name;
    int dep_id;
    Date hire_date;
    
    public Employee(int id, String first_name, String last_name, int dep_id, Date hire_date){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dep_id = dep_id;
        this.hire_date = hire_date;
    }
    
    public int getID() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public int getDepID() {
        return dep_id;
    }

    public Date getHireDate() {
        return hire_date;
    }
    
}
