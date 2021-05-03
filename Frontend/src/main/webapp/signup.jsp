<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/getin.css" rel="stylesheet" type="text/css"/>
        <title>Registro</title>
    </head>
    <body>
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
            <div id="main-wrapper">
                <header>
                    <h1>
                        CursosLibres.com
                    </h1>
                    <form action="index.jsp">
                        <button class="button">Página principal</button>
                    </form>
                </header>
                <div id="main-contents-wrapper">
                    <div id="sign-form">
                        <nav>
                            <a class="button" href = "signin.jsp">Iniciar Sesión</a>
                            <a class="button" href = "signup.jsp">Crear cuenta</a>
                        </nav>
                        <form action="SignUpService" method="POST">
                            <div>
                                <input class="input" type="number" name="identification" placeholder="Identificación" pattern="[1-9]{9}" title="Debe ingresar el formato: XXXXXXXXX" required="required">
                            </div>
                            <div>
                                <input class="input" type="text" name="lastName1" placeholder="Primer apellido" title="Solo puede ingresar letras" required="required">
                            </div>
                            <div>
                                <input class="input" type="text" name="lastName2" placeholder="Segundo apellido" title="Solo puede ingresar letras" required="required">
                            </div>
                            <div>
                                <input class="input" type="text" name="name" placeholder="Nombre" title="Solo puede ingresar letras" required="required">
                            </div>
                            <div>
                                <input class="input" type="number" name="telephoneNumber" placeholder="Número telefónico" pattern="[1-9]{8}" title="Debe ingresar el formato: XXXXXXXX" required="required">
                            </div>
                            <div>
                                <input class="input" type="email" name="email" placeholder="E-mail" required="required">
                            </div>
                            <div>
                                <input class="input" type="text" name="userName" placeholder="Usuario" required="required">
                            </div>
                            <button class="button" type="submit">Registrarme</button>
                        </form>
                        <span class="message">${message}</span>
                </div>
            </div>
        </div>
    </body>
</html>