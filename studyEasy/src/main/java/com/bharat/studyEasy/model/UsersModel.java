package com.bharat.studyEasy.model;

import com.bharat.studyEasy.config.DatabseConfig;
import com.bharat.studyEasy.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersModel {
    public List<User> listuser() throws SQLException, ClassNotFoundException {
        List <User> listuser = new ArrayList<User>();
        // step one connection object init
        Connection connect = DatabseConfig.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        // Step 2: creat the DB query
        String query = "Select * from users";
        try {
            stmt = connect.createStatement();

            //step 3: execute of stament
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listuser.add(new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    public void addUser (User newUser) {
        Connection connect = null;
        PreparedStatement statement = null;
        try {
            connect = DatabseConfig.getConnection();
            String username = newUser.getUsername();
            String email = newUser.getEmail();
            String query = "insert into users (username,email) values (?,?)";
            statement = connect.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2,email);
            statement.execute();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateUser (User updateUser) {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = DatabseConfig.getConnection();
            int userId = updateUser.getUser_id();
            String username = updateUser.getUsername();
            String email = updateUser.getEmail();
            String  query = "update users set username = ?, email = ? where user_id=?";
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setInt(3, userId);
            statement.execute();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser (int userId) {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect =DatabseConfig.getConnection();
            String query = "delete from users where user_id = ?";
            statement = connect.prepareStatement(query);
            statement.setInt(1, userId);
            statement.execute();

        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
