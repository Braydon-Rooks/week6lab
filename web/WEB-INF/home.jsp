<%-- 
    Document   : home
    Created on : Oct 2, 2017, 8:11:18 AM
    Author     : 671978
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        Hello ${loggedInUser}.<br>
        <a href="Login?action=logout">Log Out</a>
        
    </body>
</html>
