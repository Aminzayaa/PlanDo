<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .registration-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        .registration-container h1 {
            font-size: 1.8em;
            margin-bottom: 20px;
            color: #333333;
            text-align: center;
        }

        .registration-container label {
            font-size: 0.9em;
            color: #555555;
            display: block;
            margin-bottom: 5px;
        }

        .registration-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #cccccc;
        }

        .registration-container button {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: none;
            background-color: #007BFF;
            color: white;
            font-size: 1em;
            cursor: pointer;
        }

        .registration-container button:hover {
            background-color: #0056b3;
        }

        .return-button {
            display: block;
            text-align: center;
            margin-top: 20px;
        }

        .return-button button {
            background-color: #6c757d;
        }

        .return-button button:hover {
            background-color: #5a6268;
        }

        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <div class="registration-container">
        <h1>Create a New User</h1>
        <!-- Registration form -->
        <form:form action="user" method="post" modelAttribute="userForm">
            <label for="loginId">Login ID:</label>
            <form:input path="login_id" id="loginId" />

            <label for="name">Name:</label>
            <form:input path="name" id="name" />

            <label for="password">Password:</label>
            <form:input path="password" type="password" id="password" />

            <label for="email">Email:</label>
            <form:input path="email" type="email" id="email" />

            <label for="phoneNumber">Phone Number:</label>
            <form:input path="phone_number" id="phoneNumber" />

            <!-- Register button -->
            <button type="submit">Register</button>
        </form:form>

        <!-- Return button -->
        <div class="return-button">
            <form action="${pageContext.request.contextPath}/menu" method="get">
                <button type="submit">Return to Menu</button>
            </form>
        </div>

        <!-- Display error message if any -->
        <p class="error-message">${errMsg}</p>
    </div>
</body>

</html>

