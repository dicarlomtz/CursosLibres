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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/default.css">
        <title>ERROR</title>
    </head>
    <body>    
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
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
                    <div class="box" style="display: -webkit-inline-box;">
                        <h1 style="font-size: 100px">Oops!</h1>
                    ${message}
                </div>
            </div>
        </div>

        <footer>

            <footer>
                <p>
                    Todos los derechos reservados &copy; 2021
                </p>
            </footer>
    </body>
</html>
