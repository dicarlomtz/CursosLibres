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
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <title>Iniciar sesión</title>
    </head>
    <body>
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
            <nav class="navbar">
                <div class="links-login">
                    <a class="btn-normal" href = "signin.jsp">Iniciar Sesión</a>
                    <a class="btn-normal" href = "signup.jsp">Crear cuenta</a>
                    <a class="btn-normal" href="index.jsp">Página principal</a>
                </div>
            </nav>

            <div class="home">
                <div class="max-width">
                    <div class="box">
                        <h1>BIENVENIDO, PORFAVOR INGRESA TUS CREDENCIALES</h1>
                        <div class="sign-form">


                            <form action="SignInService" method="POST">
                                <div class="form-loggin">

                                    <input class="input-form" type="number" name="identification" placeholder="Identificación" title="Debe ingresar el formato: XXXXXXXXX" required>
                                    <input class="input-form" type="password" name="password" placeholder="Contraseña" required>
                                    <button class="btn-normal" type="submit">Iniciar sesión</button>
                                </div>
                            </form>

                            <span class="message">${message}</span>

                    </div>
                </div>
            </div>
        </div>
        <footer >
            <p>
                Todos los derechos reservados &copy; 2021
            </p>
        </footer>   
    </body>
</html>