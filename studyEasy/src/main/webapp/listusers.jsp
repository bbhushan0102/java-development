<%--
  Created by IntelliJ IDEA.
  User: bharat
  Date: 16/12/2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.bharat.studyEasy.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private Object User;
    private Object List;
%>
<jsp:include page="header.jsp"></jsp:include>
<h1>
    List Users
    <table border="1">
        <thead>
        <th>Use id</th>
        <th>Username</th>
        <th>Emails</th>
        <th>Operation(s)</th>
        </thead>

        <%
            List<User> listusers = (java.util.List) request.getAttribute("listusers");
            for (User _user : listusers) {
                out.print("<tr>");
                out.print("<td>" + _user.getUser_id() + "</td>");
                out.print("<td>" + _user.getUsername() + "</td>");
                out.print("<td>" + _user.getEmail() + "</td>");
                out.print("<td><a href=" + request.getContextPath() + "/site?page=updateuser&user_id=" + _user.getUser_id() + "" +
                        "&username=" + _user.getUsername() + "&email=" + _user.getEmail() +
                        ">Update(Not working)</a>");
                out.print("|");
                out.print("<a href=" + request.getContextPath() + "/site?page=deleteuser&user_id=" + _user.getUser_id() +
                        ">Delete</a></td>");
                out.print("</tr>");
            }
        %>
    </table>
</h1>


<jsp:include page="footer.jsp"></jsp:include>
