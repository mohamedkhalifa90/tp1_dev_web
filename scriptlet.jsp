<html>
<head>
    <title>JSP Scriptlet</title>
</head>
<body>

    <h1>Server Information</h1>

    <%
        java.util.Date date = new java.util.Date();
        String host = request.getRemoteHost();
    %>

    <p>Current time: <%= date %></p>

    <p>Server IP address: <%= host %></p>

</body>
</html>
