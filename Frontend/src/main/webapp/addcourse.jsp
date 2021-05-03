<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Agregar curso</title>
    </head>
    <body>
        <header>
            <h1>
                CursosLibres.com
            </h1>
            <form action="listcourses.jsp">
                <button class="button">Ver lista de cursos</button>
            </form>
        </header>
        <div id="wrapper">
            <h2>
                Agregar Curso:
            </h2>
            <div id="contents">
                <form action="AddCourseService" method="GET">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Descripción</th>
                                <th>Area temática</th>
                                <th>Agregar curso</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input name="idCourse"/></td>
                                <td><input name="description"/></td>
                                <td><select name="thematicArea">${project:thematicAreas()}</select></td>
                                <td><button class="button">Agregar curso</button></td>
                            </tr>
                        </tbody>
                        <tfoot></tfoot>
                    </table>
                </form>
            </div>
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
