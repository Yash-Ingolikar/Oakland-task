<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession currentSession = request.getSession(false);
    if (currentSession != null) {
        currentSession.invalidate(); // Invalidate the session
    }
    response.sendRedirect("login.jsp"); // Redirect to the login page
%>
