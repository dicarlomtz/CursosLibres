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
        <title>Registro</title>
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
                        <h1>PORFAVOR INGRESA TUS DATOS CORRECTAMENTE</h1>
                        <div id="sign-form">

                            <form action="SignUpService" method="POST">
                                <div class="form-sign">
                                    <div>
                                        <input class="input-form" type="number" name="identification" placeholder="Identificación" min="100000000" max="999999999" title="Debe ingresar el formato: XXXXXXXXX" required>
                                    </div>
                                    <div>
                                        <input class="input-form" type="text" name="lastName1" placeholder="Primer apellido" pattern="[a-zA-Z]+" title="Solo puede ingresar letras" required>
                                    </div>
                                    <div>
                                        <input class="input-form" type="text" name="lastName2" placeholder="Segundo apellido" pattern="[a-zA-Z]+" title="Solo puede ingresar letras" required>
                                    </div>
                                    <div>
                                        <input class="input-form" type="text" name="name" placeholder="Nombre" pattern="[a-zA-Z]+" title="Solo puede ingresar letras" required>
                                    </div>
                                    <div>
                                        <input class="input-form" type="number" name="telephoneNumber" placeholder="Número telefónico" min="10000000" max="99999999" title="Debe ingresar el formato: XXXXXXXX" required>
                                    </div>
                                    <div>
                                        <input class="input-form" type="email" name="email" placeholder="E-mail" required>
                                    </div>
                                    <div>
                                        <input class="input-form" type="text" name="userName" placeholder="Usuario" required>
                                    </div>
                                    <button class="btn-normal" style="margin-left: 2px" type="submit">Registrarme</button>
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