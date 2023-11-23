package com.mycompany.lab_4;

/**
 *
 * @author Admin
 */
public class Student {
    int id;
    static int nextid = 0;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String group_;
    private String faculty;
            
    
    public Student(String name, String surname,int age, String email, String group_, String faculty) {
        this.id = nextid++;
        this.name = name;
        this.surname = surname;
        this.age=age;
        this.email = email;
        this.group_ = group_;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGroup_() {
        return group_;
    }

    public void setGroup_(String group_) {
        this.group_ = group_;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }  
    
}
