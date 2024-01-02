/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springorm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.springorm.model.Student;

import java.util.List;
import java.util.Optional; // Додайте цей імпорт

@Service
@Transactional
public class TransactionManager {
    private final DAO_Student userRepository;

    @Autowired
    public TransactionManager(DAO_Student userRepository) {
        this.userRepository = userRepository;
    }

    public Student addStudent(Student student) {
        return userRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return userRepository.findAll();
    }

    public Student getStudentById(Integer studentId) {
        return userRepository.findById(studentId).orElse(null);
    }

    public Student updateStudent(Student student) {
        return userRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        userRepository.deleteById(studentId);
    }
}
