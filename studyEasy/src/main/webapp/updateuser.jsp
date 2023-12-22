<%--
  Created by IntelliJ IDEA.
  User: bharat
  Date: 17/12/2023
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"></jsp:include>
<form action="<%=request.getContextPath()%>/site" method="post">
    <br/>
    User Name: <input type="text" name="username" value="${param.username}" required="required"/><br/>
    Email : <input type="email" name="email" value="${param.email}" required="required"/><br/>
    <input type="int" name="id" value="${param.user_id}" required="required" readonly="readonly/><br/>
  <input type=" text" name="form " required="updateUserOperation"/><br/>
    <input type="submit" value="Update User">
</form>


<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>