package com.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task.model.UserModel;
import com.task.util.DatabaseConnection;

public class UserDao {

    public int registerUser(UserModel user) {
        String INSERT_USER_SQL = "INSERT INTO employees" +
                " (name, dob, gender, address, city, state, login_id, password) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?)";

        int result = 0;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            // Set parameters for the query
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getDob());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setString(6, user.getState());
            preparedStatement.setString(7, user.getLoginId());
            preparedStatement.setString(8, user.getPassword());

            // Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            printSQLException(e);
        }
        return result;
    }

    public boolean isValidUser(String loginId, String password) {
        String query = "SELECT * FROM employees WHERE login_id = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, loginId);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void printSQLException(Exception ex) {
        if (ex instanceof SQLException) {
            SQLException sqlEx = (SQLException) ex;
            while (sqlEx != null) {
                System.err.println("SQLState: " + sqlEx.getSQLState());
                System.err.println("Error Code: " + sqlEx.getErrorCode());
                System.err.println("Message: " + sqlEx.getMessage());
                sqlEx = sqlEx.getNextException();
            }
        } else {
            ex.printStackTrace();
        }
    }
    
    
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        String SELECT_ALL_USERS = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                UserModel user = new UserModel();
//                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDob(resultSet.getString("dob"));
                user.setGender(resultSet.getString("gender"));
                user.setAddress(resultSet.getString("address"));
                user.setCity(resultSet.getString("city"));
                user.setState(resultSet.getString("state"));
                user.setLoginId(resultSet.getString("login_id"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            printSQLException(e);
        }
        return users;
    }

}
