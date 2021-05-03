<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Modificar cursos</title>
    </head>
    <body>
        <jsp:useBean id="idCourseM" class="java.lang.String" scope="request"></jsp:useBean>
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
                Modificar Curso:
            </h2>
            <div id="contents">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Descripción</th>
                            <th>Area temática</th>
                            <th>Guardar cambios</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${project:specificCourse(idCourseM)}
                    </tbody>
                    <tfoot></tfoot>
                </table>
            </div> 
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
