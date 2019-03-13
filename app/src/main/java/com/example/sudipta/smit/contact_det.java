package com.example.sudipta.smit;

public class contact_det {
    private String dept,designation,email,emp_id,emp_name,number;


    public contact_det(String dept, String designation, String email, String emp_id, String emp_name, String number) {

        this.dept = dept;
        this.designation = designation;
        this.email = email;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.number = number;
    }
    public String getDept() {
        return dept;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getNumber() {
        return number;
    }

}
