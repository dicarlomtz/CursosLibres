<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="styles/default.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Profesores</title>
    </head>
    <body>
        
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
                        Lista de cursos:
                    </h2>

                    <div>

                        <p style="font-style: italic;"> Buscando por:<strong>${searchParameter}</strong></p>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Identificacion</th>
                                    <th>Nombre</th>
                                    <th>E-mail</th>
                                    <th>Teléfono</th>
                                </tr>
                            </thead>
                            <tbody>
                            ${project:professors()}
                        </tbody>
                        <tfoot>

                        </tfoot>
                    </table>
                </div>
                <div>
                    <form action="professorregister.jsp">
                        <button class="btn-normal" style="margin-top: 25px">Registrar profesor</button>
                    </form>
                </div>
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
