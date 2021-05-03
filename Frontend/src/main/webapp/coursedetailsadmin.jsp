<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Horarios</title>
    </head>
    <body>
        <jsp:useBean id="idCourse" class="java.lang.String" scope="request"></jsp:useBean>
        <jsp:useBean id="user" class="model.beans.GenericUser" scope="session"></jsp:useBean>
        <header>
            <h1>
                CursosLibres.com
            </h1>
            <form action="PanelService">
                <button class="button">${project:CompleteName(user)}</button>
            </form>
        </header>
        <div id="wrapper">
            <h2>
                Lista de horarios:
            </h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Número de grupo</th>
                        <th>Día</th>
                        <th>Hora</th>
                    </tr>
                </thead>
                <tbody>
                    ${project:schedulesAdmin(idCourse)}
                </tbody>
                <tfoot></tfoot>
            </table>
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
