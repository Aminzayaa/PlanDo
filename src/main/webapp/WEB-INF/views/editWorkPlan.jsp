<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Work Plan</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: auto;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input, select, textarea, button {
            margin-bottom: 15px;
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }
        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .back-link {
            text-align: center;
        }
        .back-link a {
            text-decoration: none;
            color: #007BFF;
        }
        .back-link a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit Work Plan</h2>
        <form action="/workPlan/update" method="post">
            <input type="hidden" name="plan_id" value="${plan.plan_id}">

            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${plan.title}" required>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${plan.description}</textarea>
        
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" value="${plan.startDate}" required>
        
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" value="${plan.endDate}" required>
        
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Pending" ${plan.status == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="Ongoing" ${plan.status == 'Ongoing' ? 'selected' : ''}>Ongoing</option>
                <option value="Completed" ${plan.status == 'Completed' ? 'selected' : ''}>Completed</option>
            </select>
        
            <button type="submit">Save</button>
        </form>

        <div class="back-link">
            <a href="${pageContext.request.contextPath}/workPlan">Back to Work Plan</a>
        </div>
    </div>
</body>
</html>
