<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Profesores</title>
    </head>
    <body>
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
                    <table>
                        <thead>
                            <tr>
                                <th>Identificacion</th>
                                <th>Nombre</th>
                                <th>E-mail</th>
                                <th>Teléfono</th>
                            </tr>
                        </thead>
                        <tbody>
                            ${project:professors()}
                        </tbody>
                        <tfoot>

                        </tfoot>
                    </table>
                </div>
                <div>
                    <form action="professorregister.jsp">
                        <button class="button">Registrar profesor</button>
                    </form>
                </div>
            </div>
            <footer>

            </footer>
        </div>
    </body>
</html>
