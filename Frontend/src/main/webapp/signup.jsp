<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Registro</title>
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
                        <h1>PORFAVOR INGRESA TUS DATOS CORRECTAMENTE</h1>
                        <div id="sign-form">
                       
                        <form action="SignUpService" method="POST">
                            <div class="form-sign">
                            <div>
                                <input class="input-form" type="number" name="identification" placeholder="Identificación" pattern="[1-9]{9}" title="Debe ingresar el formato: XXXXXXXXX" required="required">
                            </div>
                            <div>
                                <input class="input-form" type="text" name="lastName1" placeholder="Primer apellido" title="Solo puede ingresar letras" required="required">
                            </div>
                            <div>
                                <input class="input-form" type="text" name="lastName2" placeholder="Segundo apellido" title="Solo puede ingresar letras" required="required">
                            </div>
                            <div>
                                <input class="input-form" type="text" name="name" placeholder="Nombre" title="Solo puede ingresar letras" required="required">
                            </div>
                            <div>
                                <input class="input-form" type="number" name="telephoneNumber" placeholder="Número telefónico" pattern="[1-9]{8}" title="Debe ingresar el formato: XXXXXXXX" required="required">
                            </div>
                            <div>
                                <input class="input-form" type="email" name="email" placeholder="E-mail" required="required">
                            </div>
                            <div>
                                <input class="input-form" type="text" name="userName" placeholder="Usuario" required="required">
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