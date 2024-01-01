/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvc.Controlles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mycompany.springmvc.Content;
import com.mycompany.springmvc.Student;

/**
 *
 * @author artem
 */

@Controller
public class ControllContent {
    @RequestMapping(value = "UserContent", method=RequestMethod.GET)
    public ModelAndView formContent(@RequestParam("id2") String id2,Model m,HttpServletRequest request,HttpServletResponse response)
            throws IOException, SQLException{ 
        ModelAndView modelNview = new ModelAndView();
        modelNview.setViewName("mark");
        response.setCharacterEncoding("UTF-8");
        ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");
        PrintWriter pw=null;
        try{
            pw=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace(pw);
            pw.print(ex.getMessage());
        }

        Connection conn=null;
        conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3311/university?useUnicode=true&characterEncoding=UTF-8","root","root");

        PreparedStatement ps= (PreparedStatement) conn.prepareStatement("SELECT * FROM student where ID=?;");
            ps.setString(1, id2);
        ResultSet rs=ps.executeQuery();
        Student student =null;
        {
        if(rs.next()){
            student = new Student(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3), Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
        }
        modelNview.addObject("user",student);
        }

        ps= (PreparedStatement) conn.prepareStatement("SELECT * FROM disciplines where student_id=?;");
            ps.setString(1, id2);
        rs=ps.executeQuery();
        List<Content> cont = new LinkedList<Content>();
        while(rs.next()){
            Content ctn = (Content)factory.getBean("Content");
            ctn.setId(Integer.parseInt(rs.getString(1)));
            ctn.setStud_id(Integer.parseInt(rs.getString(2)));
            ctn.setTitle(rs.getString(3));
            ctn.setMark_num(Integer.parseInt(rs.getString(5)));
            ctn.setMark_let(rs.getString(4));

            cont.add(ctn);
            modelNview.addObject("marks",cont);

        }
        rs.close();
        ps.close();
        return modelNview;
    }
}