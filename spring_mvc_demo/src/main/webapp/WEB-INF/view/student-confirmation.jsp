<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
       The student is confirmed : ${student.firstName} ${student.lastName}
       <br><br>
       Country : ${student.country}
       <br><br>
       Favorite Language : ${student.favoriteLanguage}
       <br><br>
       Operating Systems :
       <ul>
            <c:forEach var="temp" items="${student.operatingSystem}">
                <li>${temp}</li>
            </c:forEach>
       </ul>
    </body>
</html>