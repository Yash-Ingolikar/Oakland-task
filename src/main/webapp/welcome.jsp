<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
    }
    .container {
        margin-top: 80px;
        max-width: 600px;
        background-color: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .button-container {
        display: flex;
        justify-content: space-between;
        margin-top: 20px; /* Adjust spacing as needed */
    }
</style>
</head>
<body>
    <div class="container">
        <%
            // Retrieve the current session object
            HttpSession currentSession = request.getSession(false);

            // Check if the session is not null and the loginId attribute is set
            if (currentSession != null && currentSession.getAttribute("loginId") != null) {
                // Get the loginId from the session
                String loginId = (String) currentSession.getAttribute("loginId");
        %>

        <h1>Welcome, <%= loginId %>!</h1>

        <!-- Button container-->
        <div class="button-container">
            <!-- Logout button -->
            <form action="logout.jsp" method="post">
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>
            
            <!-- Button to view all registered users -->
            <form action="ViewUsersServlet" method="post">
                <button type="submit" class="btn btn-primary">View All Registered Users</button>
            </form>
        </div>

        <%
            } else {
                // Redirect to the login page if the session is not valid
                response.sendRedirect("login.jsp");
            }
        %>
    </div>

    <!-- Bootstrap JS and dependencies (if needed) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
