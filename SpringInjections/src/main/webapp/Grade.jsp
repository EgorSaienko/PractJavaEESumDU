<%-- 
    Document   : Grade
    Created on : 21 груд. 2023 р., 12:28:16
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.springinjections.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade</title>
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
        <c:if test="${not empty sessionScope.marks}">
            <div id="page">
                <h1>Grades</h1>
                <table class="list">
                    <thead>
                        <tr>
                            <th>Discipline</th>
                            <th>ECTS</th>
                            <th>Mark</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.marks}" var="s">
                            <tr>
                                <td><c:out value="${s.title}" /></td>
                                <td><c:out value="${s.mark_let}" /></td>
                                <td><c:out value="${s.mark_num}" /></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>