package com.task.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.task.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginId = request.getParameter("loginid"); 
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        boolean isValid = userDao.isValidUser(loginId, password);

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("loginId", loginId);
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }

        // For debugging purposes, print to console
        PrintWriter out = response.getWriter();
        out.println("Login ID: " + loginId);
        out.println("Password: " + password);
        out.println("Validation Result: " + isValid);
    }
}
