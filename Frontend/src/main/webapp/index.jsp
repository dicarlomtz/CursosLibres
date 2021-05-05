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
        <link rel="stylesheet" type="text/css" href="styles/default.css">
        <title>Búsqueda de cursos</title>
    </head>
    <body>
        <jsp:useBean id="searchParameter" class="model.beans.SearchFilter" scope="request">
        </jsp:useBean>

        <nav class="navbar">

            <div class="brand-title">CursosLibres.com</div>

            <div class="navbar-links">
                <ul>
                    <li>
                        <form action="FilterAllCoursesService" method="POST">
                            <input class="nav-buscar" name="parameter"  placeholder="Escriba aquí para buscar..." required/>
                            <button type="submit">Buscar</button>

                        </form>
                    </li>
                    <%
                        try {
                            HttpServletRequest r = request;
                            HttpSession sessin = r.getSession(true);
                            GenericUser user = (GenericUser) sessin.getAttribute("user");

                            String name = user.getLastName1() + " " + user.getLastName2() + ", " + user.getName();
                            out.print("<li>");
                            out.print("<form action=\"PanelService\">");
                            out.print(String.format("<button >%s</button>", name));
                            out.print("</form>");
                            out.print("</li>");
                            
                            out.print("<li>");
                            out.print("<form action=\"SignOutService\">");
                            out.print("<button >Cerrar sesión</button>");
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
                    <h2>
                        Lista de cursos:
                    </h2>

                    <div>

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
            </div>
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
