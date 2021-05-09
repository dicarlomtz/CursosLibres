<%--
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
--%>

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
        <jsp:useBean id="searchParameter" class="model.beans.SearchFilter" scope="request">
        </jsp:useBean>
        <nav class="navbar">

            <div class="brand-title">CursosLibres.com</div>

            <div class="navbar-links">
                <ul>
                    <li>
                        <form action="FilterAllCoursesAdminService" method="GET">
                            <input class="nav-buscar" placeholder="Escriba aquí para buscar..." required/>
                            <button type="submit">Buscar</button>
                        </form>
                    </li>
                    <li>      
                        <form action="GoIndex">
                            <button >Página principal</button>  
                        </form>
                    </li>
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
                            <button class="btn-normal " style="margin-top: 25px" >Agregar curso</button>
                        </form>
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
