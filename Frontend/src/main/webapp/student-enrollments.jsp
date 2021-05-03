<%@page import="model.FreeCourses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="id" class="java.lang.String" scope="session"></jsp:useBean>
            <div>
                <header>

                </header>
                <div>
                    <h2>
                        Lista de cursos:
                    </h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID estudiante</th>
                                <th>ID curso</th>
                                <th>Descripción</th>
                                <th>Número de grupo</th>
                                <th>Estado</th>
                                <th>Nota</th>
                            </tr>
                        </thead>
                        <tbody>
                        ${project:enrollments(id)}
                    </tbody>
                    <tfoot></tfoot>
                </table>
                <form style="margin-top: 10px;" action="GenerateConstancyService">
                    <button class="button" name="idStudent" value="${id}" >Generar constancia</button>
                </form>
            </div>
            <footer>

            </footer>
        </div>
    </body>
</html>
