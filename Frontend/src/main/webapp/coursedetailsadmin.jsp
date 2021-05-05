<%--
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
--%>

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
            <nav class="navbar">

                <div class="brand-title">CursosLibres.com</div>

                <div class="navbar-links">
                    <ul>  
                    <%
                        try {

                            GenericUser user = (GenericUser) request.getSession(false).getAttribute("user");
                            String name = user.getLastName1() + " " + user.getLastName2() + ", " + user.getName();

                            out.print("<li>");
                            out.print("<form action=\"PanelService\">");
                            out.print(String.format("<button >%s</button>", name));
                            out.print("</form>");
                            out.print("</li>");

                        } catch (Exception e) {
                            out.print("<li>");
                            out.print("<form action=\"signup.jsp\">");
                            out.print("<button >Registrarse</button>");
                            out.print("</form>");
                            out.print("</li>");
                        }
                    %>

                </ul>
            </div>
        </nav>

        <div class="home">
            <div class="max-width">
                <div class="box">
                    <h1>HORARIOS Y GRUPOS </h1>
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
            </div>
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
