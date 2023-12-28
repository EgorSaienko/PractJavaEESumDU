<%-- 
    Document   : Grade
    Created on : 21 груд. 2023 р., 12:28:16
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="sumdu.edu.ua.webstudent.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <c:forEach items="${students}" var="user">
        <c:if test="${not empty students}">
        <h1>Scores of <c:out value ="${user.getId()}"/> <c:out value ="${user.getName()}"/> <c:out value ="${user.getSurname()}"/></h1>
        </c:if>
        </c:forEach>
        <div id="grades">
                <table class = "list">
                    <tr>
                        <th>Discipline</th>
                        <th>Grade</th>
                        <th>ECTS</th>
                    </tr>
                    <c:forEach items="${grades}" var="s">
                        <tr>
                            <td><c:out value ="${s.getTitle()}"/></td>
                            <td><c:out value ="${s.getGrade()}"/></td>
                            <td><c:out value ="${s.getGrade_let()}"/></td>
                        </tr>
                    </c:forEach>
                </table>

        </div>
        
    </body>
</html>