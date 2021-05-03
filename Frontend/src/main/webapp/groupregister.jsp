<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/project.tld" prefix="project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/default.css" rel="stylesheet" type="text/css"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
        <title>Registro de grupos</title>
    </head>
    <body>
        <jsp:useBean id="idCourse" class="java.lang.String" scope="request"></jsp:useBean>
        <div>
            <header>
                
            </header>
            <div>
                <div>
                    <form action="RegisterGroupService" method="POST">
                        <input id="professor" type="hidden" name="idCourse" value="${idCourse}"/>
                        <label for="professor">Seleccione un profesor:&nbsp;</label>
                        <select name="professor">
                            ${project:areaProfessorsOption(idCourse)}
                        </select>
                        
                        <p>Hora</p>
                        <input type="radio" id="7" name="hour" value="7" checked>
                        <label for="7">7:00 AM</label><br>
                        <input type="radio" id="8" name="hour" value="8">
                        <label for="8">8:00 AM</label><br>
                         <input type="radio" id="9" name="hour" value="9">
                        <label for="9">9:00 AM</label><br>
                         <input type="radio" id="10" name="hour" value="10">
                        <label for="10">10:00 AM</label><br>
                         <input type="radio" id="11" name="hour" value="11">
                        <label for="11">11:00 AM</label><br>
                         <input type="radio" id="13" name="hour" value="13">
                        <label for="13">13:00 PM</label><br>
                        <input type="radio" id="14" name="hour" value="14">
                        <label for="14">14:00 PM</label><br>
                        <input type="radio" id="15" name="hour" value="15">
                        <label for="15">15:00 PM</label><br>
                        <input type="radio" id="16" name="hour" value="16">
                        <label for="16">16:00 PM</label><br>
                        <input type="radio" id="17" name="hour" value="17">
                        <label for="17">17:00 PM</label><br>
                        
                        <p>Dia</p>      
                         <input type="radio" id="1" name="day" value="1" checked>
                        <label for="1">Lunes</label><br>
                        <input type="radio" id="2" name="day" value="2">
                        <label for="2">Martes</label><br>
                         <input type="radio" id="3" name="day" value="3">
                        <label for="3">Miercoles</label><br>
                         <input type="radio" id="4" name="day" value="4">
                        <label for="4">Jueves</label><br>
                         <input type="radio" id="5" name="day" value="5">
                        <label for="5">Viernes</label><br>
                        
                        <input class="input" type="number" name="groupNumber" placeholder="Numero de grupo" title="Debe ingresar número de grupo" required>
                        
                        <button class="button">Registrar</button>
                        
                    </form>
                </div>
            </div>
            <footer>
                
            </footer>
        </div>
    </body>
</html>
