<%-- 
    Document   : index
    Created on : 26/09/2021, 20:36:05
    Author     : E7440
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Montserrat&display=swap" rel="stylesheet">
        <title>idream</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <div class="content">
            <img src="img/fondo_login.png" alt="fondo"/>
            <a href="/" class="i_logo">
                <img src="img/logo_idream_blanco.png" alt="logo"/>
            </a>
            <p class="text-base">welcome</p>
            <form action="login_servlet?action=login" class="login-form" method="post">
                <div class="form_div">
                    <input type="text" name="username" id="username" class="form_input" placeholder="username" required>
                </div>
                <div class="form_div">
                    <input type="password" name="password" id="password" class="form_input" placeholder="password" required>
                </div>
                <button type="submit" name="login" value="login" class="form_button">log in</button>
                <div class="message">
                    <p>${msje}</p>
                </div>
            </form>
        </div> 
    </body>
</html>