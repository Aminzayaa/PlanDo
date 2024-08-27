<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Plan</title>
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
        input, select, button {
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
        <h2>Edit Plan</h2>
        <form action="/update" method="post">
            <input type="hidden" name="plan_id" value="${plan.plan_id}">
            <label>Title:</label>
            <input type="text" name="title" value="${plan.title}">
            
            <label>Description:</label>
            <textarea name="description">${plan.description}</textarea>
        
            <label>Start Date:</label>
            <input type="date" name="startDate" value="${plan.startDate}">
        
            <label>End Date:</label>
            <input type="date" name="endDate" value="${plan.endDate}">
        
            <label>Status:</label>
            <select name="status" required>
                <option value="Pending" ${plan.status == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="Ongoing" ${plan.status == 'Ongoing' ? 'selected' : ''}>Ongoing</option>
                <option value="Completed" ${plan.status == 'Completed' ? 'selected' : ''}>Completed</option>
            </select>
        
            <button type="submit">Save</button>
        </form>

        <div class="back-link">
            <a href="${pageContext.request.contextPath}/perPlan">Back to Plans</a>
        </div>
    </div>
</body>
</html>