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
                                <input class="input" type="number" name="identification" placeholder="Identificación" min="100000000" max="999999999" title="Debe ingresar el formato: XXXXXXXXX" required>
                            </div>
                            <div>
                                <input class="input" type="text" name="lastName1" placeholder="Primer apellido" pattern="[A-Za-z]" title="Solo puede ingresar letras" required>
                            </div>
                            <div>
                                <input class="input" type="text" name="lastName2" placeholder="Segundo apellido" pattern="[A-Za-z]" title="Solo puede ingresar letras" required>
                            </div>
                            <div>
                                <input class="input" type="text" name="name" placeholder="Nombre" pattern="[A-Za-z]" title="Solo puede ingresar letras" required>
                            </div>
                            <div>
                                <input class="input" type="number" name="telephoneNumber" placeholder="Número telefónico" min="10000000" max="99999999" title="Debe ingresar el formato: XXXXXXXX" required>
                            </div>
                            <div>
                                <input class="input" type="email" name="email" placeholder="E-mail" required>
                            </div>
                            <div>
                                <input class="input" type="text" name="userName" placeholder="Usuario" required>
                            </div>
                            <button class="button" type="submit">Registrarme</button>
                        </form>
                        <span class="message">${message}</span>
                </div>
            </div>
        </div>
    </body>
</html>