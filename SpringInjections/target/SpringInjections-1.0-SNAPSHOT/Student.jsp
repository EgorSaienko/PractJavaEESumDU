<%-- 
    Document   : Student
    Created on : 21 груд. 2023 р., 12:25:38
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
    <title>Student</title>
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
        <form method="post" action="NewServlet">
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
        <tr>
            <td><label for="group">Group</td>
            <td><input id="group" type="text" name="group"></td>
        </tr>
        <tr>
            <td><label for="faculty">Faculty</td>
            <td><input id="faculty" type="text" name="faculty"></td>
        </tr>
    </tbody>
    </table>
            <input type="submit" name="send" value="Send">
        </form>
    <c:if test="${students.size() > 2}">
    <form action="calculateStats">
        <input type="submit" name="send2" value="Statistics">
    </form>
    </c:if>

    <div id="content">
        <c:if test="${not empty students}">
            
                <table class="list">
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Group</th>
                        <th>Faculty</th>
                    </tr>
                    <c:forEach items="${students}" var="s">
                        <tr>
                            <td><c:out value="${s.name}" /></td>
                            <td><c:out value="${s.surname}" /></td>
                            <td><c:out value="${s.email}" /></td>
                            <td><c:out value="${s.group}" /></td>
                            <td><c:out value="${s.faculty}" /></td>
                            <td><a href="GradesServlet?id=${s.id}">View Grades</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>