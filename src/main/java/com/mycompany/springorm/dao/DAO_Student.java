/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springorm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycompany.springorm.model.Student;
import java.util.List;
import java.util.Optional;

@Repository("DAO_Student")
public interface DAO_Student extends JpaRepository<Student, Integer> {
    
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer studentId);
    Student updateStudent(Student student);
    void deleteStudent(Integer studentId);
    public Student getOne(int parseInt);

    public void deleteById(Integer StudentId);

    public Student save(Student student);

    Optional<Student> findById(Integer studentId);
}