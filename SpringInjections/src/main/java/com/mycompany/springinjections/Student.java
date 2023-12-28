/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springinjections;
import java.util.List;
/**
 *
 * @author Admin
 */

public class Student {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String group_name;
    private String faculty;
   /* private List<studentMark> mark;*/

    public Student() {}
    public Student(int id,String name, String surname, String email, String group_name, String faculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group_name = group_name;
        this.faculty = faculty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    // Геттери і сеттери тут

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getFaculty() {
        return faculty;
    }
    
  
}