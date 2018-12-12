<%--
  Created by IntelliJ IDEA.
  User: 西邮陈冠希
  Date: 2018/12/11
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>

    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript" src="jquery-3.2.1/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<h3>添加学生信息</h3>
<form method="post" action="ServletAdd">
    <table border="1" class="table table-hover text-left">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="sname">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男">男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="tel" name="phone"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="睡觉">睡觉
                <input type="checkbox" name="hobby" value="王者荣耀">王者荣耀
                <input type="checkbox" name="hobby" value="撸代码">撸代码
                <input type="checkbox" name="hobby" value="看电影">看电影
                <input type="checkbox" name="hobby" value="游泳">游泳
                <input type="checkbox" name="hobby" value="约会">约会
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea style="width: 240px; height: 60px" name="info"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="btn btn-primary" type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
