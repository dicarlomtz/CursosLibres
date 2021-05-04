<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/getin.css" rel="stylesheet" type="text/css"/>
        <title>Registro de profesores</title>
    </head>
    <body>
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
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
                        <h2>
                            COMPLETA EL FORMULARIO:
                        </h2>
                        <form action="RegisterProfessorService" method="GET">
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
                            
                            <div >
                                  ${project:thematicAreasProfessorOptions()}
                            </div>
                            
                        <button class="btn-normal"  style="margin-top: 25px" type="submit">Registrarme</button>
                    </form>
                    <span class="message">${message}</span>
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