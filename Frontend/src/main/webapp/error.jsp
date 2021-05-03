<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <jsp:useBean id="message" class="java.lang.String" scope="request"></jsp:useBean>
            <div>
                <header>

                </header>
                <div>
                ${message}
            </div>
            <footer>

            </footer>
        </div>
    </body>
</html>
