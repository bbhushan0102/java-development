<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="<%=request.getContextPath() %>/ImageUpload" method="post" enctype="multipart/form-data">
    Select images <input type="file" name="files" multiple />
    <input type="submit" value="upload" />
</form>
</body>
</html>