<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2020/6/15
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       String requestValue = (String)request.getAttribute("requestKey");
       String sessionValue = (String)session.getAttribute("sessionKey");
   %>
   <h1><%=requestValue%></h1>
   <h1><%=sessionValue%></h1>

   <h2>${requestScope.requestKey}</h2>
   <h2>${sessionScope.sessionKey}</h2>
</body>
</html>
