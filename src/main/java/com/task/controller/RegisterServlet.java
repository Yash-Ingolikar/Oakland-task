package com.task.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.dao.UserDao;
import com.task.model.UserModel;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public RegisterServlet() {
        super();
        userDao = new UserDao(); // Initialize UserDao
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String loginId = request.getParameter("login_id"); 
        String password = request.getParameter("password");

        UserModel user = new UserModel();
        user.setName(name);
        user.setDob(dob);
        user.setGender(gender);
        user.setAddress(address);
        user.setCity(city);
        user.setState(state);
        user.setLoginId(loginId); 
        user.setPassword(password);

        try {
            int result = userDao.registerUser(user);
            if (result == 1) {
                // Registration successful
                response.sendRedirect("login.jsp?registration=success");
            } else {
                // Registration failed
                response.sendRedirect("register.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception
            response.sendRedirect("register.jsp?error=1");
        }
    }
}
