/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springinjections;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tanka
 */
@WebServlet(name = "ScoresServlet", urlPatterns = {"/ScoresServlet"})
public class ScoresServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3311/university";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Отримати з'єднання з бази даних
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Отримати ID студента з параметра запиту
            int studentId = Integer.parseInt(request.getParameter("id"));

            // Виконати запит до бази даних для отримання даних студента
            ps = conn.prepareStatement("SELECT * FROM student_grade WHERE stud_id = ?");
            ps.setInt(1, studentId);
            rs = ps.executeQuery();

            // Створити список об'єктів Content для зберігання оцінок
            List<Content> cont = new LinkedList<>();

            // Заповнити список об'єктів Content даними з бази даних
            while (rs.next()) {
                Content ctn = new Content();
                ctn.setId(rs.getInt("id"));
                ctn.setStud_id(rs.getInt("stud_id"));
                ctn.setTitle(rs.getString("title"));
                ctn.setMark_num(rs.getInt("mark_num"));  
                ctn.setMark_let(rs.getString("mark_let"));
                cont.add(ctn);
            }

            // Зберегти список оцінок у сесії;
            HttpSession session = request.getSession();
            session.setAttribute("marks", cont);

            // Переадресувати на сторінку для відображення оцінок
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Grade.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        } finally {
            // Закрити ресурси
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}