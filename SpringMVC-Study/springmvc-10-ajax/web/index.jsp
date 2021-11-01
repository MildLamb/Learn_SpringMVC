<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>

      function fun(){
        $.post({
          url:"${pageContext.request.contextPath}/a",
          data:{"dataName":$("#username").val()},
          success:function (data,status) {
            alert(data);
            console.log("status => " + status);
          }
        })
      }
    </script>
  </head>
  <body>
    <!-- 失去焦点的时候，发起一个请求到后台 -->
    用户名:<input type="text" id="username" onblur="fun()">
  </body>
</html>
