<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Customer Registration Form</title>
        <style>
            .error{
                color:red
            }
        </style>
    </head>
    <body>
    <i>Fill out the form. Asterisk (*) means required.</i>
        <form:form action="processForm" modelAttribute="customer">
            First Name : <form:input path="firstName"/>
            <br><br>
            Last Name (*):<form:input path="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
            <br><br>
            Free pass(*):
            <form:input path="freePass"/>
            <form:errors path="freePass" cssClass="error"/>
            <br><br>
            Postal Code:
            <form:input path="postalCode"/>
            <form:errors path="postalCode" cssClass="error"/>

            <br><br>
            Course Code:
            <form:input path="courseCode"/>
            <form:errors path="courseCode" cssClass="error"/>
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>