package com.task.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.dao.UserDao;
import com.task.model.UserModel;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userDao = new UserDao();
        List<UserModel> users = userDao.getAllUsers();
        
        // Set fetched users as attribute in request scope
        request.setAttribute("users", users);
        
        // Forward to displayUsers.jsp to render the users
        request.getRequestDispatcher("/displayUsers.jsp").forward(request, response);
    }
}
