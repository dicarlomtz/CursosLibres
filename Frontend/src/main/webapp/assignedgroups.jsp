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
        <link rel="stylesheet" type="text/css" href="styles/default.css">
        <title>Grupos asignados</title>
    </head>
    <body>
        <jsp:useBean id="user" class="model.beans.GenericUser" scope="session"></jsp:useBean>
            <nav class="navbar">

                <div class="brand-title">CursosLibres.com</div>

                <div class="navbar-links">
                    <ul>  

                        <li>      
                            <form action="GoIndex">
                                <button >Página principal</button>  
                            </form>
                        </li>
                    </ul>
                </div>
            </nav>
            <<div class="home">
                <div class="max-width">
                    <div class="box" >
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
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
