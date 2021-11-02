<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>

<!-- WEB-INF下的所有页面资源，不能直接访问，只能通过请求跳转访问 -->

<body>
    <h2>登录页面</h2>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名: <input type="text" name="username">
        密&nbsp;码<input type="password" name="password">
        <input type="submit" value="登录">
    </form>
</body>
</html>
