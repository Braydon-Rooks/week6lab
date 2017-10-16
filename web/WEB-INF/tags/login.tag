<%-- 
    Document   : login
    Created on : Oct 16, 2017, 8:08:32 AM
    Author     : 671978
--%>

<%@tag description="login" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h1>Remember Me Login Page</h1>
        ${test}
        <form method="post" action="Login">
            Username: <input type="text" name="user" value = ${oldUser}> <br>
            Password: <input type="text" name="password"><br>
            <input type="submit" value="Login"><br>
            <input type="checkbox" name ="remember" value="test"> Remember me
        </form>
        ${check}
        ${notFull}
        ${loggedOut}
        ${incorrectLogin}