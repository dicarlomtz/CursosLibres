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
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/default.css">
        <title>Agregar curso</title>
    </head>
    <body>

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

        <div class="home">
            <div class="max-width">
                <div class="box">
                    <h2>
                        Agregar Curso:
                    </h2>
                    <div>
                        <form action="AddCourseService" method="POST">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Descripción</th>
                                        <th>Area temática</th>
                                        <th>Agregar curso</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input class="input-form" style="height: 25px" type="number" placeholder="Identificación" min="1" title="Solo puede ingresar números mayores a 1" name="idCourse" required/></td>
                                        <td><input class="input-form" style="height: 25px" type="text" placeholder="Descripción" title="Debe completar los espacios" name="description" required/></td>
                                        <td><select name="thematicArea">${project:thematicAreas()}</select></td>
                                        <td><button class= "bn-table">Agregar curso</button></td>
                                    </tr>
                                </tbody>
                                <tfoot></tfoot>
                            </table>
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
