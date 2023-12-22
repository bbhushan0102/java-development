<
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>


<jsp:include page="header.jsp"></jsp:include>
<form action="<%=request.getContextPath()%>/site" method="post">
    <br/>
    User Name: <input type="text" name="username" required="required"/><br/>
    Email : <input type="email" name="email" required="required"/><br/>
    <input type="hidden" name="form" required="addUserOperation"/><br/>
    <input type="submit" value="Add User">
</form>


<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
