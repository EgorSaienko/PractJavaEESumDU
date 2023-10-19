<%-- 
    Document   : student
    Created on : 16 жовт. 2023 р., 18:21:16
    Author     : Admin
--%>
<%@page import="java.util.*"%>
<%@page import="com.mycompany.lab3_1.Student"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%-- <%@ taglib uri="jakarta.tags.core" prefix="c" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            #page {
                background-color: #fff;
                margin: 20px auto;
                padding: 20px;
                width: 80%;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                color: #333;
            }

            table {
                width: 100%;
            }

            td {
                padding: 10px;
            }

            label {
                font-weight: bold;
                color: #555; /* Колір тексту для label */
            }

            input[type="text"] {
                width: 100%;
                padding: 8px;
                margin-top: 5px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            input[type="submit"] {
                background-color: #4caf50;
                color: white;
                border: none;
                padding: 10px 20px;
                text-decoration: none;
                margin-top: 10px;
                cursor: pointer;
                border-radius: 4px;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            /* Додано стиль для заголовка h1 */
            h1 {
                background-color: #4caf50;
                color: white;
                padding: 10px;
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div id="page">
        <h1>Student Form</h1>
        <form>
            <table>
                <tbody>
                    <tr>
                        <td><label for="name">Name</td>
                        <td><input id="name" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><label for="surname">Surname</td>
                        <td><input id="surname" type="text" name="surname"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</td>
                        <td><input id="email" type="email" name="email"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="send" value="Send">
        </form>

            <% List<Student> students= (List<Student>)application.getAttribute("students"); %>
            <c:if test="${not empty param.send }">
            <%
                if(students ==null){
                    students= new LinkedList<Student>();
                    application.setAttribute("students",students);
                }
                if(request.getParameter("name")!=""&&request.getParameter("surname")!=""){
                    Student student=new Student();
                    student.setName(request.getParameter("name"));
                    student.setSurname(request.getParameter("surname"));
                    student.setEmail(request.getParameter("email"));
                    students.add(student);
                }
                response.sendRedirect("student.jsp");
            %>

            </c:if>

            <%
                if(students != null){
                    out.println("<table class=\"list\"><tr><th>Name</th><th>Surname</th><th>Email</th></tr>");
                    for(Student s:students){
                        out.println("<tr><td>"+s.getName()+"</td><td>"+s.getSurname()+"</td><td>"+s.getEmail()+"</td></tr>");
                    }
                    out.println("</table>");
                }
            %>

        </>
</body> 
</html>
