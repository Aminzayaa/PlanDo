<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="tel"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-button {
            display: block;
            width: 100%;
            background-color: #007BFF;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }

        .form-button:hover {
            background-color: #0056b3;
        }

        .return-button {
            display: block;
            width: 100%;
            background-color: #6c757d;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
        }

        .return-button:hover {
            background-color: #5a6268;
        }

        .message {
            text-align: center;
            margin-top: 15px;
            color: #ff0000;
            font-weight: bold;
        }

        .success {
            color: #28a745;
        }

    </style>
</head>

<body>
    <div class="container">
        <h1>Profile Information</h1>
        
        <form:form action="${pageContext.request.contextPath}/editUser" method="post" modelAttribute="userForm">
            <label for="loginId">LoginId:</label>
            <form:input path="login_id" id="loginId" />
            
            <label for="name">Name:</label>
            <form:input path="name" id="name" />
            
            <label for="password">Password:</label>
            <form:input path="password" id="password" type="password"/>
            
            <label for="email">Email:</label>
            <form:input path="email" id="email" type="email"/>
            
            <label for="phone">Phone Number:</label>
            <form:input path="phone_number" id="phone" type="tel"/>
            
            <button type="submit" class="form-button">Confirm Edit</button>
        </form:form>

        <a href="${pageContext.request.contextPath}/menu" class="return-button">Return to Menu</a>

        <div class="message ${not empty successMsg ? 'success' : ''}">
            <c:if test="${not empty errMsg}">
                ${errMsg}
            </c:if>
            <c:if test="${not empty successMsg}">
                ${successMsg}
            </c:if>
        </div>
    </div>
</body>

</html>