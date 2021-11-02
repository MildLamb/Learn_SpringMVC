<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
      <form action="${pageContext.request.contextPath}/upload2" method="post" enctype="multipart/form-data">
          <input type="file" name="MyFile">
          <input type="submit" value="Upload">
      </form>

      <a href="${pageContext.request.contextPath}/upload/kindred.jpg">下载图片</a>
  </body>
</html>
