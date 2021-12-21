<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
    <body>
        <form:form action="processForm" modelAttribute="student">
        First name : <form:input path = "firstName"/>
        <br><br>
        LastName : <form:input path = "lastName"/>
        <br><br>
        Country :
        <form:select path="country">
                <form:options items="${student.countryOptions}"/>

        </form:select>
        <br><br>
        Favorite Languages:
        <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
        <br><br>
        Operating Systems:
        Linux<form:checkbox path="operatingSystem" value="Linux"/>
        Mac OS<form:checkbox path="operatingSystem" value="Mac OS"/>
        Windows <form:checkbox path="operatingSystem" value="Windows"/>
        <br><br>
        <input type = "submit" value = "Submit"/>
        </form:form>
    </body>
</html>