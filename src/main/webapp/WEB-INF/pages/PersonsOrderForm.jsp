<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Нове замовлення</title>
</head>
<body>
<div align="center">
    <h1>Замовлення</h1>
    <form:form action="savePersonsOrder" method="get" modelAttribute="person">
        <table border="1">
            <th></th>
            <th>Товар</th>
            <th>Ціна</th>
            <c:forEach var="toy" items="${toys}">

                <tr>
                    <td><input type="checkbox" name="selected" value="${toy.name}"></td>
                    <td>${toy.name}</td>
                    <td>${toy.price}</td>
                </tr>

            </c:forEach>
        </table>
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Ім'я:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Імейл:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Адреса:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Телефон:</td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Зберегти"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>