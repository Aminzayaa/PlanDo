<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Work Plan</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }
        .plan-card {
            background-color: #fff;
            border-radius: 5px;
            margin: 15px 0;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .plan-card h2 {
            margin: 0;
            padding: 0;
            color: #007BFF;
        }
        .plan-card p {
            margin: 10px 0;
            line-height: 1.6;
        }
        .plan-card .dates, .plan-card .status {
            font-weight: bold;
            color: #555;
        }
        .actions {
            text-align: right;
        }
        .actions button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 3px;
            cursor: pointer;
        }
        .actions button:hover {
            background-color: #0056b3;
        }
        .add-plan {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .add-plan form {
            display: inline-block;
        }
        .add-plan input, .add-plan select, .add-plan button {
            margin: 5px;
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }
        .add-plan button {
            background-color: #28a745;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .add-plan button:hover {
            background-color: #218838;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
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
    <h1>Work Plan</h1>

    <c:forEach items="${workPlanList}" var="workPlan">
        <div class="plan-card">
            <h2>${fn:escapeXml(workPlan.title)}</h2>
            <p>${fn:escapeXml(workPlan.description)}</p>
            <p class="dates">Start Date: ${fn:escapeXml(workPlan.startDate)} | End Date: ${fn:escapeXml(workPlan.endDate)}</p>
            <div class="status">Status: ${fn:escapeXml(workPlan.status)}</div>
            <div class="actions">
                <form action="${pageContext.request.contextPath}/workPlan/edit" method="post" style="display: inline;">
                    <input type="hidden" name="plan_id" value="${workPlan.plan_id}">
                    <button type="submit">Edit</button>
                </form>
                <form action="${pageContext.request.contextPath}/workPlan/delete" method="post" style="display: inline;" onsubmit="return confirm('Are you sure you want to delete this plan?');">
                    <input type="hidden" name="plan_id" value="${workPlan.plan_id}">
                    <button type="submit">Delete</button>
                </form>
            </div>
        </div>
    </c:forEach>

    <div class="add-plan">
        <form action="${pageContext.request.contextPath}/workPlan/addPlan" method="post">
            <input type="text" name="title" placeholder="Title" required>
            <input type="text" name="description" placeholder="Description" required>
            <input type="date" name="startDate" required>
            <input type="date" name="endDate" required>
            <select name="status" required>
                <option value="Pending">Pending</option>
                <option value="Ongoing">Ongoing</option>
                <option value="Completed">Completed</option>
            </select>
            <input type="hidden" name="user_id" value="1"> <!-- Adjust the value as needed -->
            <button type="submit">Add Plan</button>
        </form>
    </div>

    <div class="back-link">
        <a href="${pageContext.request.contextPath}/menu">Back to Menu</a>
    </div>
</div>
</body>
</html>
