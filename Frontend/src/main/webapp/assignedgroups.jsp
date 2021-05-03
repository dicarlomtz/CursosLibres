<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Grupos asignados</title>
    </head>
    <body>
        <jsp:useBean id="user" class="model.beans.GenericUser" scope="session"></jsp:useBean>
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
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Grupo</th>
                                    <th>Curso</th>
                                    <th>Notas</th>
                                </tr>
                            </thead>
                            <tbody>
                            ${project:professorGroups(user)}
                        </tbody>
                        <tfoot>

                        </tfoot>
                    </table>
                </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
