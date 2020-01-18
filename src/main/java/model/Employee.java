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
    Date dob;
    int sin;
    int dep_id;
    int phone;
    String email;
    boolean mon, tues, weds, thurs, fri, sat, sun, remote;
    String gender;
    String emp_type;
    String designation;
    String pay_type;
    int pay_amt;
    Date hire_date;
    int sick_days;
    boolean resign;
    boolean fire;
    String note;
    
    public Employee(int id, String first_name, String last_name, int dep_id, Date hire_date){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dep_id = dep_id;
        this.hire_date = hire_date;
    }
    
    public Employee(int id, String first_name, String last_name, Date dob, int sin, int dep_id, int phone,
    String email, boolean mon, boolean tues, boolean weds, boolean thurs, boolean fri, boolean sat, boolean sun, boolean remote,
    String gender, String emp_type, String designation, String pay_type, int pay_amt, Date hire_date, int sick_days,
    boolean resign, boolean fire, String note) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.sin = sin;
        this.dep_id = dep_id;
        this.phone = phone;
        this.email = email;
        this.mon = mon;
        this.tues = tues;
        this.weds = weds;
        this.thurs = thurs;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.remote = remote;
        this.gender = gender;
        this.emp_type = emp_type;
        this.designation = designation;
        this.pay_type = pay_type;
        this.pay_amt = pay_amt;
        this.hire_date = hire_date;
        this.sick_days = sick_days;
        this.resign = resign;
        this.fire = fire;
        this.note = note;
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


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getSin() {
        return sin;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }


    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTues() {
        return tues;
    }

    public void setTues(boolean tues) {
        this.tues = tues;
    }

    public boolean isWeds() {
        return weds;
    }

    public void setWeds(boolean weds) {
        this.weds = weds;
    }

    public boolean isThurs() {
        return thurs;
    }

    public void setThurs(boolean thurs) {
        this.thurs = thurs;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public int getPay_amt() {
        return pay_amt;
    }

    public void setPay_amt(int pay_amt) {
        this.pay_amt = pay_amt;
    }


    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public int getSick_days() {
        return sick_days;
    }

    public void setSick_days(int sick_days) {
        this.sick_days = sick_days;
    }

    public boolean isResign() {
        return resign;
    }

    public void setResign(boolean resign) {
        this.resign = resign;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
