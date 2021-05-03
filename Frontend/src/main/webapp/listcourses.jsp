<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Lista de cursos</title>
    </head>
    <body>
        <jsp:useBean id="searchParameter" class="model.beans.SearchFilter" scope="request"></jsp:useBean>
        <jsp:useBean id="user" class="model.beans.GenericUser" scope="session"></jsp:useBean>
        <header>
            <h1>
                CursosLibres.com
            </h1>
            <form action="FilterAllCoursesAdminService" method="GET" style="width: 50%;">
                <input class="input" name="busqueda" value="" style="width: 75%; padding: 10px 30px;" placeholder="Escriba aquí para buscar..." required="required"/>
                <button class="button" type="submit">Buscar</button>
            </form>
            <form action="PanelService">
                <button class="button">${project:CompleteName(user)}</button>
            </form>
        </header>
        <div id="wrapper">
            <h2>
                Lista de cursos:
            </h2>
            <div id="contents">
                <p style="font-style: italic;">Buscando por: <strong>${searchParameter}</strong></p>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Descripción</th>
                            <th>Area temática</th>
                            <th>Horarios</th>
                            <th>Agregar grupos</th>
                            <th>Modificar curso</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${project:coursesAdmin(searchParameter)}
                    </tbody>
                    <tfoot></tfoot>
                </table>
                <form action="addcourse.jsp">
                    <button class="button">Agregar curso</button>
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
