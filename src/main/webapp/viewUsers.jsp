<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Registered Users</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>View Registered Users</h1>
        <form action="ViewUsersServlet" method="post">
            <button type="submit" class="btn btn-primary">Click here to see all registered users</button>
        </form>
        
        <%-- Display registered users data here --%>
        <div id="registeredUsers">
            <%-- Display fetched users data here dynamically --%>
            <%@ include file="displayUsers.jsp" %>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies (if needed) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
