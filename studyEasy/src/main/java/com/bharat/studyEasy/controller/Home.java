package com.bharat.studyEasy.controller;

import com.bharat.studyEasy.entity.User;
import com.bharat.studyEasy.model.UsersModel;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class Home extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page = request.getParameter("page").toLowerCase();
        switch (page) {
            case "home": {
                request.setAttribute("title", "Home");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            }
            case "listusers": {
                List<User> users = new ArrayList<>();
                try {
                    users = new UsersModel().listuser();
                    request.setAttribute("listusers", users);
                    request.setAttribute("title", "List User");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                request.getRequestDispatcher("listusers.jsp").forward(request, response);
            }
            default:
                request.setAttribute("title", "Error");
                request.getRequestDispatcher("error.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}