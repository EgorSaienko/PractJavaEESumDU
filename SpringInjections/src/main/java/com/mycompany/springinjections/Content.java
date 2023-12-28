/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springinjections;

/**
 *
 * @author Admin
 */
public class Content {
    private int id;
    private int stud_id;
    private String title;
    private int mark_num;
    private String mark_let;

    // Конструктор ініціалізації та інші методи

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMark_num() {
        return mark_num;
    }

    public void setMark_num(int mark_num) {
        this.mark_num = mark_num;
    }

    public String getMark_let() {
        return mark_let;
    }

    public void setMark_let(String mark_let) {
        this.mark_let = mark_let;
    }    
}
