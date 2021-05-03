<%@page import="model.FreeCourses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="project" uri="/WEB-INF/tlds/project" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Panel de Estudiantes</title>
    </head>
    <body>
        <jsp:useBean id="user" class="model.beans.GenericUser" scope="session"></jsp:useBean>
            <header>
                <h1>
                    CursosLibres.com
                </h1>
                <form action="index.jsp">
                    <button class="button">Página principal</button>
                </form>
            </header>
            <div id="wrapper">
                <div id="contents">
                ${project:userInfo(user)}
                <form style="margin-top: 10px;" action="StudentEnrollmentsService">
                    <button class="button">Ver matriculas</button>
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