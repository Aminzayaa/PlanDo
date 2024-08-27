<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Personal Plan</title>
</head>

<body>
    <p>Register </p>
    
    <!--  form -->
    <form:form action="registerPlan" method="post" modelAttribute="planForm">
        <label>PlanId:</label>
        <form:input path="plan_id" />
        <br>
        
        <label>Title:</label>
        <form:input path="title" />
        <br>
        
        <label>Description:</label>
        <form:input path="description" />
        <br>
        
        <label>Start Date:</label>
        <form:input path="start_date" />
        <br>
        
        <label>End Date:</label>
        <form:input path="end_date" />
        <br>
        <label>Status:</label>
        <form:input path="status" />
        
        <br>
        <!-- Register button -->
        <form:button>Insert new plan</form:button>
        <br>
    </form:form>

    <!-- Return button -->
    <form action="${pageContext.request.contextPath}/perplan" method="get">
        <button type="submit">Return to menu</button>
    </form>

    <!-- Display error message if any -->
    <p>${errMsg}</p>
    
</body>

</html>