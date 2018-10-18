<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Додати товар</title>
</head>
<body>
<div align="center">
    <h1>Новий товар</h1>
    <form:form action="saveToy" method="post" modelAttribute="toy">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Назва:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Ціна</td>
                <td><form:input path="price"/></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Зберегти"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>