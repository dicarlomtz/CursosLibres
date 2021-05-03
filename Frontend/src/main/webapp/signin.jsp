<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/getin.css" rel="stylesheet" type="text/css"/>
        <title>Iniciar sesión</title>
    </head>
    <body>
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
            <div>
                <header>
                    <h1>
                        CursosLibres.com
                    </h1>
                    <form action="index.jsp">
                        <button class="button">Página principal</button>
                    </form>
                </header>
                <div id="sign-form">
                    <nav>
                        <a class="button" href = "signin.jsp">Iniciar Sesión</a>
                        <a class="button" href = "signup.jsp">Crear cuenta</a>
                    </nav>
                    <form action="SignInService" method="POST">
                        <div>
                            <input class="input" type="number" name="identification" placeholder="Identificación" title="Debe ingresar el formato: XXXXXXXXX" required="required">
                        </div>
                        <div>
                            <input class="input" type="password" name="password" placeholder="Contraseña"  required="required">
                        </div>  
                        <button class="button" type="submit">Iniciar sesión</button>
                    </form>
                    <span class="message">${message}</span>
            </div>
        </div>
    </body>
</html>