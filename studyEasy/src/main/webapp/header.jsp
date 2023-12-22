<%--
  Created by IntelliJ IDEA.
  User: bharat
  Date: 16/12/2023
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <%
        if (request.getAttribute("title") == null) {
            out.print("<title>  HomePage  </title>");
        } else {
            out.print("<title>" + request.getAttribute("title") + "</title>");
        }
    %>
    <meta name="description" content="website description"/>
    <meta name="keywords" content="website keywords, website keywords"/>
    <meta http-equiv="content-type" content="text/html; charset=windows-1252"/>
    <link rel="stylesheet" type="text/css" href="./simplestyle_horizon/style/style.css"/>
</head>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <!-- class="logo_colour", allows you to change the colour of the text -->
                <h1><a href="index.html">simple<span class="logo_colour">style_horizon</span></a></h1>
                <h2>Simple. Contemporary. Website Template.</h2>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">
                <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
                <li><a href="<%= request.getContextPath() %>/home?page=home">Home</a></li>
                <li><a href="<%= request.getContextPath() %>/site?page=listusers">List Users</a></li>
                <li><a href="<%= request.getContextPath() %>/site?page=adduser">Add User</a></li>
                <%--        <li><a href="<%= request.getContextPath() %>/site?page=updateuser">update User</a></li>--%>
                <li class="selected"><a href="contact.html">Contact Us</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
