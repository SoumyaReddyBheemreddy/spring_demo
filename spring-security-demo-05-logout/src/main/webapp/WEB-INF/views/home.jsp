<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h2>Home Page - Yohoo</h2>
        <hr>
        <p>
            Welcome to the company
        </p>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type = "submit" value="Logout" />
        </form:form>
    </body>
</html>