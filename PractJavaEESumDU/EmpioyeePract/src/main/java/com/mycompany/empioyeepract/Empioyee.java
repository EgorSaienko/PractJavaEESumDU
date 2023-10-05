/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empioyeepract;

/**
 *
 * @author Admin
 */
public class Empioyee {
    private int id;
    private static int nextid=1;
    private String name;
    private double salary;

    public Empioyee(String name) throws FieldLengthLimitException{
        this.id = nextid++;
        if(name.length()>15){
            throw new FieldLengthLimitException("Too much sumbols is name!");
        }
        else {this.name = name;}
    }
    public Empioyee(double salary) throws IncorrectSalaryException{
        this.id = nextid++;
        if(salary < 0 ){
            throw new IncorrectSalaryException("Salary cannot be negative!");
        }
        else {this.salary = salary;}
    }
    void nameYourself() {
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    void youSalary() {
        System.out.println(salary);
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
