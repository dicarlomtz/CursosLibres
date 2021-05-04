<%@page import="model.FreeCourses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="project" uri="/WEB-INF/tlds/project" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/default.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Panel de Estudiantes</title>
    </head>
    <body>
        <jsp:useBean id="user" class="model.beans.GenericUser" scope="session"></jsp:useBean>
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
                    <div class="box" style="display: -webkit-inline-box;">
                    ${project:userInfo(user)}
                    <form style="margin-top: 10px;" action="StudentEnrollmentsService">
                        <button class="btn-normal" style="height: 30px  ">Ver matriculas</button>
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