    <%@ page language="java" pageEncoding="UTF-8"%>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <html>
    <head>
        <title>Person Management Screen</title>
        <link rel="stylesheet"
              href="/resources/styles.css"
              type="text/css"/>
    </head>
    <body>
    <div align="center">


        <h1 class="title">Add an Order</h1>




        <h1>
            <a href="/newPersonsOrder">New Order Register</a><br>
            <a href="/newPizza">New Pizza Register</a>
        </h1>

        <h1 class="title">List of Orders</h1>

        <table border="1">

            <th>Order number</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Order</th>
            <th>Total</th>
            <th>Action</th>
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
                                    <c:forEach var="pizza" items="${order.pizzas}">
                                    <td>
                                            ${pizza.name}
                                    </td>
                                    </c:forEach>
                                </tr>

                        </table>
                    </td>
                    <td>
                        ${order.total}
                    </td>
                    <td>
                        <a href="deleteOrder?id=${order.orderId}&id2=${order.person.id}">Delete Order</a>
                    </td>


                </tr>
            </c:forEach>






    </div>
    </body>
    </html>