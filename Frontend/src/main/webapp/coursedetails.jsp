<%@page import="model.FreeCourses"%>
<%@page import="model.beans.GenericUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Horarios</title>
    </head>
    <body>
        <jsp:useBean id="idCourse" class="java.lang.String" scope="request"></jsp:useBean>
            <nav class="navbar">

                <div class="brand-title">CursosLibres.com</div>

                <div class="navbar-links">
                    <ul>  
                        <li>      
                            <form action="index.jsp">
                                <button >Página principal</button>  
                            </form>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="home">
                <div class="max-width">
                    <div class="box">
                        <h1>HORARIOS Y GRUPOS DISPONIBLES</h1>
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
            </div>
        </div>
        <footer>
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>
    </body>
</html>
