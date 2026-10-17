
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Person Information</title>
</head>
<body>

    <h1>Person Information</h1>

    <jsp:useBean id="person"
                  class="isep.lab1.bean.Person"
                  scope="request" />

    <jsp:setProperty name="person" property="*" />

    <p>First Name:
        <jsp:getProperty name="person" property="firstName" />
    </p>

    <p>Last Name:
        <jsp:getProperty name="person" property="lastName" />
    </p>

    <p>Birth Date:
        <jsp:getProperty name="person" property="birthDay" />
    </p>

    <p>Sex:
        <jsp:getProperty name="person" property="sex" />
    </p>

</body>
</html>
