<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .menu-container {
            background-color: white;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }

        h3 {
            color: #333;
            margin-bottom: 20px;
        }

        h1 {
            color: #555;
            margin-bottom: 30px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin: 10px 0;
        }

        a {
            text-decoration: none;
            color: #007BFF;
            font-size: 18px;
        }

        a:hover {
            text-decoration: underline;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #FF6347;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
        }

        button:hover {
            background-color: #e5533c;
        }
    </style>
</head>
<body>

    <div class="menu-container">
        <h1>Menu</h1>
        <h3>Welcome ${sessionScope.loggedInUser}</h3>
        
        <ul>
            <!-- <li><a href="register">Register</a></li> -->
            <li><a href="profile">Profile</a></li>
            <li><a href="workPlan">Work Plan</a></li>
            <li><a href="perPlan">Personal Plan</a></li>
        </ul>

        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>

</body>
</html>
