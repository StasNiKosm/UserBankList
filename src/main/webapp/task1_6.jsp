<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.03.2021
  Time: 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>task1.6</title>
</head>
<body>
<h2>Select user by its id</h2>
<form method="post" action="">
    Enter id<br/>
    <label>
        <input type="number" name="id"/>
    </label>
</form>
<c:if test="${requestScope.user != null}">
    <c:out value="${requestScope.user}"/>
</c:if>
<c:if test="${requestScope.user == null && requestScope.id != null}">
    <c:out value="There ins't user with id ${requestScope.id}"/>
</c:if>
<c:if test="${requestScope.emptyStr != null}">
    <c:out value="You hadn't written a number"/>
</c:if>
<hr/>
<h2>All accounts</h2>
<form method="get" action="">
    <button type="submit" name="getAccounts" value="true">View all accounts</button><br/>
    <c:forEach var="account" items="${requestScope.accounts}">
        <c:out value="${account}"/><br/>
    </c:forEach>
</form>
</body>
</html>
