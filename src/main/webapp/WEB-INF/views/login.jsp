<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        h2 {
            color: #555;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            text-align: left;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button, .form-button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007BFF;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover, .form-button:hover {
            background-color: #0056b3;
        }

        .form-button {
            margin-top: 20px;
            background-color: #28a745;
        }

        .form-button:hover {
            background-color: #218838;
        }

        p {
            color: red;
            font-weight: bold;
        }
    </style>
</head>

<body>
    <div class="login-container">
        <h1>Welcome to Plan Do</h1>
        <h2>User Login</h2>
        
        <form:form action="login" method="post" modelAttribute="loginForm">
            <label>Login Id:</label>
            <form:input path="login_id" type="text"/>
            <br/>
            <label>Password:</label>
            <form:input path="password" type="password"/>
            <br/>
            <button type="submit">Login</button>
        </form:form>
        
        <!-- Separate form for Register button -->
        <form action="${pageContext.request.contextPath}/register" method="get">
            <button type="submit" class="form-button">Don't have an account? Register now!</button>
        </form>

        <p>${errMsg}</p>
    </div>
</body>
</html>

