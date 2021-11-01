<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>

    <script>
        function checkThis() {
            $.post({
                url:"${pageContext.request.contextPath}/checkU",
                data:{"username":$("#username").val()/*,"password":$("#password").val()*/},
                success:function (data) {
                    if (data === "OK"){
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfo").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            });
        }
        function checkThis2() {
            $.post({
                url:"${pageContext.request.contextPath}/checkU",
                data:{"username":$("#username").val()/*,"password":$("#password").val()*/},
                success:function (data) {
                    $("#pswInfo").html(data);
                }
            });
        }
    </script>

</head>
<body>
    <p>
        用户名: <input type="text" id="username" onblur="checkThis()">
        <span id="userInfo"></span>
    </p>
    <p>
        密码: <input type="text" id="password" onblur="checkThis2()">
        <span id="pswInfo"></span>
    </p>
</body>
</html>
