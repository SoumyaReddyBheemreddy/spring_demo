<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
        <hr>
            <!-- display user name and role -->
            <p>
                User: <security:authentication property="principal.username"/>
                <br><br>
                Role(s): <security:authentication property="principal.authorities"/>
            </p>
        </hr>
        <!-- Only enabling tag for specific roles  -->
        <security:authorize access="hasRole('MANAGER')">
            <!-- Add a link to point /leaders ... this is for the managers -->
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
                (only for Manager peeps)
            </p>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
                <!-- Add a link to point /systems ... this is for the admins -->
                <p>
                    <a href="${pageContext.request.contextPath}/systems">Leadership Meeting</a>
                    (only for Admin peeps)
                </p>
        </security:authorize>
        <!-- Add a logout button-->
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type = "submit" value="Logout" />
        </form:form>
    </body>
</html>