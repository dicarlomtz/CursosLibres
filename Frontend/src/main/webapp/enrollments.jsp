<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Matriculas</title>
    </head>
    <body>
        <jsp:useBean id="group" class="model.beans.CourseGroup" scope="request"></jsp:useBean>
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
                        <form action="AssignGradesService" method="GET">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Identificacion</th>
                                        <th>Nombre</th>
                                        <th>Notas</th>
                                    </tr>
                                </thead>
                                <tbody>
                                ${project:groupEnrollments(group)}
                            </tbody>
                            <tfoot>

                            </tfoot>

                        </table>
                            <section style="margin-top: 25px">
                            <input class="btn-normal" type="submit" value="Asignar notas">
                        </section>
                    </form>
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
