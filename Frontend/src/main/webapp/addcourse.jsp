<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/default.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Agregar curso</title>
    </head>
    <body>

        <nav class="navbar">

            <div class="brand-title">CursosLibres.com</div>

            <div class="navbar-links">
                <ul>
                    <form action="listcourses.jsp">
                        <button class="button">Ver lista de cursos</button>
                    </form>
                </ul>
            </div>
        </nav>


        <div class="home">
            <div class="max-width">
                <div class="box">
                    <h2>
                        Agregar Curso:
                    </h2>
                    <div>
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
                                        <td><input class="input-form" style="height: 25px" name="idCourse"/></td>
                                        <td><input class="input-form" style="height: 25px" name="description"/></td>
                                        <td><select name="thematicArea">${project:thematicAreas()}</select></td>
                                        <td><button class= "bn-table">Agregar curso</button></td>
                                    </tr>
                                </tbody>
                                <tfoot></tfoot>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
