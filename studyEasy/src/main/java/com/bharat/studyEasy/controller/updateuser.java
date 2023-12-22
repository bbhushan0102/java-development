//package com.bharat.studyEasy.controller;
//
//import com.bharat.studyEasy.entity.User;
//import com.bharat.studyEasy.model.UsersModel;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@WebServlet(name = "updateuser", value = "/updateuser")
//public class updateuser extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String page = request.getParameter("page").toLowerCase();
//        switch (page) {
//
//            case "listusers":
//                try {
//                    listusers(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "updateuser" :
//                updateuser(request, response);
//                break;
//            default:
//                request.setAttribute("title", "Error");
//                request.getRequestDispatcher("error.jsp").forward(request, response);
//                break;
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User updateUser = new User(Integer.parseInt(request.getParameter("user_id")),request.getParameter("username"), request.getParameter("email"));
//        new UsersModel().updateUser(updateUser);
//
//    }
//
//
//
//    private void listusers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        List<User> users = new ArrayList<>();
//        users = new UsersModel().listuser();
//        request.setAttribute("listusers", users);
//        request.setAttribute("title", "List User");
//        request.getRequestDispatcher("listusers.jsp").forward(request, response);
//    }
//
//    private void updateuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("title", "updateuser");
//        request.getRequestDispatcher("updateuser.jsp").forward(request, response);
//
//    }
//}
