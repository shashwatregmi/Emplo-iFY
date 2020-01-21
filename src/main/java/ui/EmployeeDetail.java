/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.*;


/**
 *
 * @author Regmi
 */
public class EmployeeDetail extends javax.swing.JFrame {
    Employee employee;
    ArrayList<Department> departmentsList = new ArrayList<>();
    ArrayList<String> empType = new ArrayList<>();
    ArrayList<String> payType = new ArrayList<>();
    ArrayList<Employee> employeeList = new ArrayList<>();
    private int deptindex;
    int maxID;
    int mode;
    
    /**
     * Creates new form EmployeeDetail
     * @param emp
     */
    public EmployeeDetail(Employee emp, int mode) {
        initComponents();
        this.mode = mode;
        DataBase database = new DataBase();
        try {
            ResultSet myrs = database.getStatement().executeQuery("select * from department");
            Department tableDepartment;
            while (myrs.next()){
                tableDepartment = new Department(myrs.getInt("department_id"), 
                myrs.getString("name"), myrs.getInt("num_employees"));
                departmentsList.add(tableDepartment);
            }
        } catch (Exception e){
            System.out.println("Error");
        }
        
        jComboBoxDep.removeAllItems();
        for (int i = 0; i < departmentsList.size(); i++) {
             jComboBoxDep.addItem(departmentsList.get(i).getName());
             if (mode == 2) {
                if (emp.getDepID() == departmentsList.get(i).getID()){
                    deptindex = i;
                }
                
             }
        }
        
        empType.add("Full Time");
        empType.add("Part Time");
        empType.add("Contractor");
        empType.add("Intern");
        
        jComboBoxEmpType.removeAllItems();
        for (int i = 0; i < empType.size(); i++) {
             jComboBoxEmpType.addItem(empType.get(i));
        }
        
        payType.add("Annually");
        payType.add("Hourly");
        payType.add("Other");
        jComboBoxPayType.removeAllItems();
        for (int i = 0; i < payType.size(); i++) {
             jComboBoxPayType.addItem(payType.get(i));
        }
        
        if (mode == 2) { // edit mode
            loadData(emp);
        } else if (mode == 1) { //new entry mode
            getMaxPMKey();
            jTextempid.setText(Integer.toString(maxID));
        }
        
        jTextfirstname.grabFocus();
    }
    
    private void getMaxPMKey() {
        DataBase database_empload = new DataBase();
            try {
               ResultSet myrs = database_empload.getStatement().executeQuery("select MAX(employee_id) from employee_detail");
               myrs.next();
               maxID = Integer.parseInt(myrs.getObject(1).toString()) + 1;
            } catch (Exception e){
                System.out.println(e);
            }
    }
    
    private void loadData(Employee emp){
            employee = emp; 
            jTextempid.setText(Integer.toString(emp.getID()));
            jTextfirstname.setText(emp.getFirstName());
            jTextlastname.setText(emp.getLastName());
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String dob = df.format(emp.getDob());
            jTextdob.setText(dob);
            jTextsin.setText(Integer.toString(emp.getSin()));
            jComboBoxDep.setSelectedIndex(deptindex);
            jTextphone.setText(Long.toString(emp.getPhone()));
            jtextEmail.setText(emp.getEmail());
            if (emp.isMon() == 1) jCheckBoxmon.setSelected(rootPaneCheckingEnabled);
            if (emp.isTues()== 1) jCheckBoxtues.setSelected(rootPaneCheckingEnabled);
            if (emp.isWeds()== 1) jCheckBoxweds.setSelected(rootPaneCheckingEnabled);
            if (emp.isThurs()== 1) jCheckBoxthurs.setSelected(rootPaneCheckingEnabled);
            if (emp.isFri()== 1) jCheckBoxfri.setSelected(rootPaneCheckingEnabled);
            if (emp.isSat()== 1) jCheckBoxsat.setSelected(rootPaneCheckingEnabled);
            if (emp.isSun()== 1) jCheckBoxsun.setSelected(rootPaneCheckingEnabled);
            if (emp.isRemote()== 1) jCheckBoxcall.setSelected(rootPaneCheckingEnabled);
            jTextFieldgender.setText(emp.getGender());
            if (emp.getEmp_type()== 0) { // full time
                jComboBoxEmpType.setSelectedIndex(0);
            } else if (emp.getEmp_type()== 1) { // part time
                jComboBoxEmpType.setSelectedIndex(1);
            } else if (emp.getEmp_type()== 2) { //contract
                jComboBoxEmpType.setSelectedIndex(2);
            } else if (emp.getEmp_type()== 3) { //intern
                jComboBoxEmpType.setSelectedIndex(3);
            }
            jTextFielddesign.setText(emp.getDesignation());
            if (emp.getPay_type()== 0) { // annual
                jComboBoxPayType.setSelectedIndex(0);
            } else if (emp.getPay_type()== 1) { // hour
                jComboBoxPayType.setSelectedIndex(1);
            } else if (emp.getPay_type()== 2) { //other
                jComboBoxPayType.setSelectedIndex(2);
            } 
            jTextFieldpay.setText(Double.toString(emp.getPay_amt()));
            DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
            String hire = df.format(emp.getHireDate());
            jTextFieldhire.setText(hire);
            jTextFieldsick.setText(Integer.toString(emp.getSick_days()));
            jTextAreanote.setText(emp.getNote());
            if (emp.isFire() == 1) jRadioButtonfire.setSelected(rootPaneCheckingEnabled);
            if (emp.isResign()== 1) jRadioButtonresign.setSelected(rootPaneCheckingEnabled);
            
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextempid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextfirstname = new javax.swing.JTextField();
        jTextlastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextdob = new javax.swing.JTextField();
        jTextsin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextphone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtextEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCheckBoxmon = new javax.swing.JCheckBox();
        jCheckBoxweds = new javax.swing.JCheckBox();
        jCheckBoxfri = new javax.swing.JCheckBox();
        jCheckBoxsun = new javax.swing.JCheckBox();
        jCheckBoxtues = new javax.swing.JCheckBox();
        jCheckBoxthurs = new javax.swing.JCheckBox();
        jCheckBoxsat = new javax.swing.JCheckBox();
        jCheckBoxcall = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldgender = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFielddesign = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldpay = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldhire = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldsick = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreanote = new javax.swing.JTextArea();
        jRadioButtonresign = new javax.swing.JRadioButton();
        jRadioButtonfire = new javax.swing.JRadioButton();
        jComboBoxDep = new javax.swing.JComboBox<>();
        jComboBoxEmpType = new javax.swing.JComboBox<>();
        jComboBoxPayType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jLabel20.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("PropSheet.selectionBackground"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonSave.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/save.png")); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Mukta Mahee", 0, 24)); // NOI18N
        jLabel2.setText("Create/Edit Employee Record");

        jLabel3.setText("Employee ID:");

        jTextempid.setEnabled(false);

        jLabel4.setText("First Name:");

        jLabel5.setText("Last Name:");

        jLabel6.setText("Date of Birth:");

        jTextdob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextdobActionPerformed(evt);
            }
        });

        jLabel7.setText("SIN:");

        jLabel8.setText("Department:");

        jLabel9.setText("Phone:");

        jLabel10.setText("Email:");

        jLabel11.setText("Working Days:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCheckBoxmon.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxmon.setText("Monday");

        jCheckBoxweds.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxweds.setText("Wednesday");

        jCheckBoxfri.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxfri.setText("Friday");

        jCheckBoxsun.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxsun.setText("Sunday");

        jCheckBoxtues.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxtues.setText("Tuesday");

        jCheckBoxthurs.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxthurs.setText("Thursday");

        jCheckBoxsat.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxsat.setText("Saturday");

        jCheckBoxcall.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jCheckBoxcall.setText("On-call");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxmon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxsun, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxfri)
                    .addComponent(jCheckBoxweds))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxthurs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxtues, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxsat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxcall, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxmon, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxtues, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxweds, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxthurs, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxfri, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxsat, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxsun, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxcall, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel12.setText("Gender:");

        jLabel13.setText("Emp. Type:");

        jLabel14.setText("Designation:");

        jLabel15.setText("Pay Type:");

        jLabel16.setText("Pay Amount:");

        jLabel17.setText("Hire Date:");

        jLabel18.setText("Sick Days Left:");

        jLabel19.setText("Inactive:");

        jButtonBack.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/exit.png")); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });

        jLabel21.setText("Note:");

        jTextAreanote.setColumns(20);
        jTextAreanote.setRows(5);
        jTextAreanote.setBorder(null);
        jScrollPane1.setViewportView(jTextAreanote);

        jRadioButtonresign.setText("Resigned/Other");

        jRadioButtonfire.setText("Fired");

        jComboBoxDep.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepActionPerformed(evt);
            }
        });
        jComboBoxDep.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxDepPropertyChange(evt);
            }
        });

        jComboBoxEmpType.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEmpType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxPayType.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxPayType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(584, 584, 584)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldgender)
                                    .addComponent(jTextFielddesign)
                                    .addComponent(jTextFieldpay)
                                    .addComponent(jTextFieldhire)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jRadioButtonfire)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextlastname, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextdob, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextfirstname, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                                    .addComponent(jTextempid))))
                                        .addGap(120, 120, 120)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel21)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextsin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtextEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(214, 214, 214)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldsick)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxEmpType, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxPayType, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jRadioButtonresign))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextempid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextfirstname)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxEmpType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextlastname)
                    .addComponent(jLabel14)
                    .addComponent(jTextFielddesign))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextdob)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxPayType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextsin)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldpay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel17)
                        .addComponent(jTextFieldhire))
                    .addComponent(jComboBoxDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextphone)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldsick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtextEmail)
                    .addComponent(jLabel19)
                    .addComponent(jRadioButtonresign)
                    .addComponent(jRadioButtonfire))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane1))
                .addGap(33, 33, 33)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBack)
                .addGap(14, 14, 14))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/Regmi/Employee Manager/employeeManager/src/main/resources/thinking.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jButtonSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveMouseClicked
        DataBase database = new DataBase();
        if (mode == 2) {
            String sql = "UPDATE employee_detail SET name = ?, last_name = ?, gender = ?, date_of_birth = ?,"
                    + "sin = ?, link = ?, pay_type = ?, dep_id = ?, pay = ?, designation = ?, monday = ?,"
                    + "tuesday = ?, wednesday = ?, thursday = ?, friday = ?, saturday = ?, sunday = ?, hire_date = ?,"
                    + "sickdays_aval = ?, fired = ?, resigned = ?, emp_type = ?, note = ?, remote = ?, phone = ?"
                    + " WHERE employee_id = ?";  
            Department empDept = departmentsList.get(deptindex);
            empDept.setNumEmployees(empDept.getNumEmployees()-1);
            String sqldep = "update department " + " set num_employees = " + empDept.getNumEmployees() + "" 
                    + " where department_id = " + empDept.getID();
            try {
                database.getStatement().execute(sqldep);
            } catch (Exception e) {
                System.out.println(e);
            }
            updateTable(sql, database);
            JOptionPane.showMessageDialog(null, "Employee Data Updated Sucessfully", "Sucess!", JOptionPane.INFORMATION_MESSAGE);
            jButtonBackMouseClicked(evt);
        } else if (mode == 1){
            String sql = "INSERT into employee_detail (name, last_name, gender, date_of_birth,"
                    + "sin, link, pay_type, dep_id, pay, designation, monday,"
                    + "tuesday, wednesday, thursday, friday, saturday, sunday, hire_date,"
                    + "sickdays_aval, fired, resigned, emp_type, note, remote, phone, employee_id)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";  
            updateTable(sql, database);
            JOptionPane.showMessageDialog(null, "New Employee Created!", "Sucess!", JOptionPane.INFORMATION_MESSAGE);
            jButtonBackMouseClicked(evt);
        }
    }//GEN-LAST:event_jButtonSaveMouseClicked

   private void updateTable(String sql, DataBase database) {
       try {
            PreparedStatement update = database.getconn().prepareStatement(sql);
            getData(update);
            update.executeUpdate();
            int chosendep = jComboBoxDep.getSelectedIndex();
            Department newChoice = departmentsList.get(chosendep);
            newChoice.setNumEmployees(newChoice.getNumEmployees()+1);
            String sqldep = "update department " + " set num_employees = " + newChoice.getNumEmployees() + "" 
                    + " where department_id = " + newChoice.getID();
            try {
                database.getStatement().execute(sqldep);
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
   
   private void getData(PreparedStatement update) throws Exception {
        update.setString(1, jTextfirstname.getText());
        update.setString(2, jTextlastname.getText());
        update.setString(3, jTextFieldgender.getText());
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/YYYY");
        java.util.Date date = sdf1.parse(jTextdob.getText());
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        update.setDate(4, sqlStartDate);
        update.setInt(5, Integer.parseInt(jTextsin.getText()));
        update.setString(6, jtextEmail.getText());
        update.setInt(7, jComboBoxPayType.getSelectedIndex());
        int chosendep = jComboBoxDep.getSelectedIndex();
        Department newChoice = departmentsList.get(chosendep);
        update.setInt(8, newChoice.getID());
        update.setDouble(9, Double.parseDouble(jTextFieldpay.getText()));
        update.setString(10, jTextFielddesign.getText());
        if (jCheckBoxmon.isSelected()) update.setInt(11, 1); else update.setInt(11, 0);
        if (jCheckBoxtues.isSelected()) update.setInt(12, 1); else update.setInt(12, 0);
        if (jCheckBoxweds.isSelected()) update.setInt(13, 1); else update.setInt(13, 0);
        if (jCheckBoxthurs.isSelected()) update.setInt(14, 1); else update.setInt(14, 0);
        if (jCheckBoxfri.isSelected()) update.setInt(15, 1); else update.setInt(15, 0);
        if (jCheckBoxsat.isSelected()) update.setInt(16, 1); else update.setInt(16, 0);
        if (jCheckBoxsun.isSelected()) update.setInt(17, 1); else update.setInt(17, 0);
        sdf1 = new SimpleDateFormat("MM/dd/YYYY");
        date = sdf1.parse(jTextFieldhire.getText());
        sqlStartDate = new java.sql.Date(date.getTime());
        update.setDate(18, sqlStartDate);
        update.setInt(19, Integer.parseInt(jTextFieldsick.getText()));
        if (jRadioButtonfire.isSelected()) update.setInt(20, 1); else update.setInt(20, 0);
        if (jRadioButtonresign.isSelected()) update.setInt(21, 1); else update.setInt(21, 0);
        update.setInt(22, jComboBoxEmpType.getSelectedIndex());
        update.setString(23, jTextAreanote.getText());
        if (jCheckBoxcall.isSelected()) update.setInt(24, 1); else update.setInt(24, 0);
        update.setLong(25, Long.parseLong(jTextphone.getText()));
        update.setInt(26, Integer.parseInt(jTextempid.getText()));
   }
    
    private void jTextdobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextdobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextdobActionPerformed

    private void jComboBoxDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepActionPerformed

    }//GEN-LAST:event_jComboBoxDepActionPerformed

    private void jComboBoxDepPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxDepPropertyChange

    }//GEN-LAST:event_jComboBoxDepPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDetail(null, 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxcall;
    private javax.swing.JCheckBox jCheckBoxfri;
    private javax.swing.JCheckBox jCheckBoxmon;
    private javax.swing.JCheckBox jCheckBoxsat;
    private javax.swing.JCheckBox jCheckBoxsun;
    private javax.swing.JCheckBox jCheckBoxthurs;
    private javax.swing.JCheckBox jCheckBoxtues;
    private javax.swing.JCheckBox jCheckBoxweds;
    private javax.swing.JComboBox<String> jComboBoxDep;
    private javax.swing.JComboBox<String> jComboBoxEmpType;
    private javax.swing.JComboBox<String> jComboBoxPayType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonfire;
    private javax.swing.JRadioButton jRadioButtonresign;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreanote;
    private javax.swing.JTextField jTextFielddesign;
    private javax.swing.JTextField jTextFieldgender;
    private javax.swing.JTextField jTextFieldhire;
    private javax.swing.JTextField jTextFieldpay;
    private javax.swing.JTextField jTextFieldsick;
    private javax.swing.JTextField jTextdob;
    private javax.swing.JTextField jTextempid;
    private javax.swing.JTextField jTextfirstname;
    private javax.swing.JTextField jTextlastname;
    private javax.swing.JTextField jTextphone;
    private javax.swing.JTextField jTextsin;
    private javax.swing.JTextField jtextEmail;
    // End of variables declaration//GEN-END:variables
}
