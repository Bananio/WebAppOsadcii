<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Order</title>
    <link rel="stylesheet"
          href="/resources/styles.css"
          type="text/css"/>
</head>
<body>
<div align="center">
    <h1>New Order</h1>
    <form:form action="savePersonsOrder" method="get" modelAttribute="person">
        <table border="1">
            <th></th>
            <th>Pizza</th>
            <th>Price</th>
            <c:forEach var="pizza" items="${pizzas}">

                <tr>
                    <td><input type="checkbox" name="selected" value="${pizza.name}"></td>
                    <td>${pizza.name}</td>
                    <td>${pizza.price}</td>
                </tr>

            </c:forEach>
        </table>
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>