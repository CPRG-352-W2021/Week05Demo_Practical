<%-- 
    Document   : average
    Created on : Feb 8, 2021, 11:00:53 AM
    Author     : dyadlows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average Calculator</title>
    </head>
    <body>
        <h1>Average Calculator</h1>
        <form method="get" action="average">
            <label>Enter a Number:</label>
            <input type="number" name="input_number">
            <br>
            <input type="submit" value="Calculate">
        </form>
        
        <div>
            <p>Average: ${average}</p>
        </div>
        
    </body>
</html>
