<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Matriculas</title>
    </head>
    <body>
        <jsp:useBean id="group" class="model.beans.CourseGroup" scope="request"></jsp:useBean>
            <div>
                <header>
                    <h1>
                        CursosLibres.com
                    </h1>
                    <form action="index.jsp">
                        <button class="button">Página principal</button>
                    </form>
                </header>
                <div>
                    <div>
                        <form action="AssignGradesService" method="GET">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Identificacion</th>
                                        <th>Nombre</th>
                                        <th>Notas</th>
                                    </tr>
                                </thead>
                                <tbody>
                                ${project:groupEnrollments(group)}
                            </tbody>
                            <tfoot>

                            </tfoot>

                        </table>
                        <section>
                            <input class="button" type="submit" value="Asignar notas">
                        </section>
                    </form>
                </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
