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
        <title>Búsqueda de cursos</title>
    </head>
    <body>
        <jsp:useBean id="searchParameter" class="model.beans.SearchFilter" scope="request">
        </jsp:useBean>
        <header>
            <h1>
                CursosLibres.com
            </h1>
            <form action="FilterAllCoursesService" method="GET" style="width: 50%;">
                <input class="input" name="parameter" style="width: 75%; padding: 10px 30px;" placeholder="Escriba aquí para buscar..." required="required"/>
                <button class="button" type="submit">Buscar</button>
            </form>
            <%
                try {
                    HttpServletRequest r = request;
                    HttpSession sessin = r.getSession(true);
                    GenericUser user = (GenericUser) sessin.getAttribute("user");

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
                Lista de cursos:
            </h2>
            <div id="contents">

                <p style="font-style: italic;"> Buscando por:<strong>${searchParameter}</strong></p>

                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Descripción</th>
                            <th>Area temática</th>
                            <th>Horarios</th>
                        </tr>
                    </thead>
                    <tbody>    
                        ${project:courses(searchParameter)}
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
