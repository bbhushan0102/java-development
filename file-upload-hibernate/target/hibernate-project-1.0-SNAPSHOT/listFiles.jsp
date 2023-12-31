<%--
  Created by IntelliJ IDEA.
  User: bharat
  Date: 31/12/2023
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Listing Images</title>
  </head>
  <body>
  Listing images

  <%= request.getAttribute("files")%>
  </body>
</html>
