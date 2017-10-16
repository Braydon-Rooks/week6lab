<%-- 
    Document   : login
    Created on : Oct 2, 2017, 8:11:11 AM
    Author     : 671978
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="sait" %>
<%@taglib uri="/WEB-INF/tlds/sait.tld" prefix="tagHandle" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <tagHandle:Debug>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}

            
        </tagHandle:Debug>
       
        <sait:login></sait:login>
         
        
    </body>
</html>
