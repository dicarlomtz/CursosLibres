<%@page import="model.FreeCourses"%>
<%@page import="model.beans.GenericUser"%>
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
        <header>
            <h1>
                CursosLibres.com
            </h1>
            <%
                try {

                    GenericUser user = (GenericUser) request.getSession(false).getAttribute("user");
                    String name = user.getLastName1() + " " + user.getLastName2() + ", " + user.getName();

                    out.print("<form action=\"PanelService\">");
                    out.print(String.format("<button class=\"button\">%s</button>", name));
                    out.print("</form>");

                } catch (Exception e) {

                    out.print("<form action=\"signup.jsp\">");
                    out.print("<button class=\"button\" style=\"padding: 10px 30px;\">Registrarse</button>");
                    out.print("</form>");
                }
            %>
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
                        <th>Matricular</th>
                    </tr>
                </thead>
                <tbody>
                    ${project:schedules(idCourse)}
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
