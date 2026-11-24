<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="person" type="lab.mvc.model.Person" scope="request" />

<h2>Old Person</h2>

First Name: <jsp:getProperty name="person" property="firstName" /><br>
Last Name: <jsp:getProperty name="person" property="lastName" /><br>
Birth Day: <jsp:getProperty name="person" property="birthDay" /><br>
Sex: <jsp:getProperty name="person" property="sex" /><br>