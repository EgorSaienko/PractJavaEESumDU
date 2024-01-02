/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springorm.dao;
/**
 *
 * @author Admin
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mycompany.springorm.model.Content;
import com.mycompany.springorm.model.Student;



@Repository
public interface DAO_Content extends JpaRepository<Student, Integer>{
    @Query("from disciplines where student_id = id")
    List<Content> getMarksByStId(@Param("id") int id);

    public List<Content> getScoresByStId(int id);
}