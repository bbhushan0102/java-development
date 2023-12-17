<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<h1>
  <a href="<%= request.getContextPath()%>/error"><h1>Error</h1></a>
</h1>



<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
