<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<jsp:include page="header.jsp"></jsp:include>
<h1>
    <a href="hello-servlet">Hello Servlet</a>
    <a href="<%= request.getContextPath()%>/login"><h1>Login</h1></a>
</h1>



<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>