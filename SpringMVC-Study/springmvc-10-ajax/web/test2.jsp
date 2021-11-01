<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                $.post({
                    url:"${pageContext.request.contextPath}/userList",
                    data:undefined,
                    success:function (data) {
                        let html = "";
                        // console.log(data);
                        for (let i = 0; i < data.length; i++) {
                            html += "<tr>" +
                                "<td>" + data[i].name +"</td>" +
                                "<td>" + data[i].age +"</td>" +
                                "<td>" + data[i].sex +"</td>" +
                                "</tr>"
                        }
                        $("#content").html(html);
                    }
                });
            })
        })
    </script>

</head>
<body>
<input type="button" value="查询数据" id="btn">
    <table>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
        </tr>
        <tbody id="content">

        </tbody>
    </table>
</body>
</html>
