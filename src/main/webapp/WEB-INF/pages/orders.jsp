    <%@ page language="java" pageEncoding="UTF-8"%>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <html>
    <head>
        <title>Іграшковий магазин</title>
    </head>
    <body>

    <div align="center">
        <table border="1">

            <th>Номер</th>
            <th>Ім'я</th>
            <th>Імейл</th>
            <th>Адреса</th>
            <th>Телефон</th>
            <th>Замовлення</th>
            <th>Всього</th>
            <th>Операція</th>
            <c:forEach var="order" items="${orders}">
                <tr>

                    <td>${order.orderId}</td>
                    <td>${order.person.name}</td>
                    <td>${order.person.email}</td>
                    <td>${order.person.address}</td>
                    <td>${order.person.telephone}</td>

                    <td>
                        <table border="1">

                                <tr>
                                    <c:forEach var="toy" items="${order.toys}">
                                    <td>
                                            ${toy.name}
                                    </td>
                                    </c:forEach>
                                </tr>

                        </table>
                    </td>
                    <td>
                        ${order.total}
                    </td>
                    <td>
                        <a href="deleteOrder?id=${order.orderId}&id2=${order.person.id}">видалити</a>
                    </td>


                </tr>
            </c:forEach>

            <div class="text">
                <h1 class="title">Управління контентом</h1>




                <h2>
                    <a href="/newPersonsOrder">Додати нове замовлення</a><br>
                    <a href="/newToy">Додати новий товар</a>
                </h2>
            </div>





    </div>
    </body>
    </html>