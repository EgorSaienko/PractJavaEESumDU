/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.lab3_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
@WebServlet(name = "StudentAdd", urlPatterns = {"/StudentAdd"})
public class StudentAdd extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession();
                List<Student> students = (List<Student>)session.getAttribute("students");

                if (students == null) {
                    students = new LinkedList<>();
                    session.setAttribute("students", students);
                }

                if (request.getParameter("name") != "" || request.getParameter("surname") != "") {
                    Student student = new Student (request.getParameter("name"),
                                                   request.getParameter("surname"),
                                                   request.getParameter("email"),
                                                   request.getParameter("group"),
                                                   request.getParameter("faculty"));
                    students.add(student);
                }

                response.sendRedirect("student.jsp");

                }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


