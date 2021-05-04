<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Iniciar sesión</title>
    </head>
    <body>
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
            <nav class="navbar">
                <div class="links-login">
                    <a class="btn-normal" href = "signin.jsp">Iniciar Sesión</a>
                    <a class="btn-normal" href = "signup.jsp">Crear cuenta</a>
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