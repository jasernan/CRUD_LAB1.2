<%-- 
    Document   : cursosInfo
    Created on : 7/04/2023, 10:03:50 PM
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Curso</title>
    </head>
    <body>
        <h1>Informacion Curso</h1>
        <form action="./CursosServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo curso</td>
                    <td><input type="text" name="Codigo curso" value="${curso.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre del curso</td>
                    <td><input type="text" name="Nombre del curso" value="${curso.nombreDelcurso}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="Creditos" value="${curso.creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="Semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Estudiantes admitidos</td>
                    <td><input type="text" name="Estudiantes admitidos" value="${curso.estudiantesAdmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Codigo curso</th>
            <th>Nombre del curso</th>
            <th>Creditos</th>
            <th>Semestre</th>
            <th>Estudiantes admitidos</th>
                <c:forEach items="${allCursos}" var="cursos">
                <tr>
                    <td>${cursos.codigoCurso}</td>
                    <td>${cursos.nombreDelcurso}</td>
                    <td>${cursos.creditos}</td>
                    <td>${cursos.semestre}</td>
                    <td>${cursos.estudiantesAdmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
