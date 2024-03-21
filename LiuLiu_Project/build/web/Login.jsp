<%-- 
    Document   : Login.jsp
    Created on : Mar 4, 2024, 9:23:28 AM
    Author     : lecha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="css/Login.css">

    </head>
    <body>
        <div class="login-container">
            <h2>
               <a href="Home.jsp" class="logo" style="width: 100px">
                <img src="./img/Logo_1.png" alt="" width="200" height="70">
            </a> 
            </h2>
            
            <h2>Login</h2>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Email:</label>
                    <input type="text" id="mail" name="mail" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="pass" name="pass" required>
                </div>
                <button type="submit" name="login">Login</button>
            </form>
        </div>
    </body>
</html>
