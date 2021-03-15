<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<h1>HOME</h1>
<hr/>
<form method="get" action="${pageContext.request.contextPath}/task1.6">
    <button type="submit"> Look at specified user or whole the list of accounts </button>
</form>
<form method="get" action="${pageContext.request.contextPath}/task1.8">
    <button type="submit"> Look at the richest user or the sum of all accounts </button>
</form>
<hr/>
</body>
</html>
