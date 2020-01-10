/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Regmi
 */
public class Department {
    String name;
    int numEmployees;
    
    public Department(String name, int numEmployees) {
        this.name = name;
        this.numEmployees = numEmployees;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumEmployees() {
        return numEmployees;
    }
    
}
