<%--
  Created by IntelliJ IDEA.
  User: 西邮陈冠希
  Date: 2018/12/11
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生列表</title>

    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript" src="jquery-3.2.1/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <script type="text/javascript">
        function doDelete(sid) {
            var flag = confirm("真的要删除吗？？？");
            console.log(flag);
            if (flag) {
                location.href = "ServletDelete?sid=" + sid;
            }
        }
    </script>
</head>
<body>
<h2>欢迎使用学生信息管理系统</h2>
<form action="ServletSearchStudent" method="post">
    <table border="1" class="table table-bordered table table-hover table table-condensed text-center">
        <tr>
            <td colspan="8">
                <span class="glyphicon glyphicon-home">按姓名查询:&nbsp;</span>
                <input type="text" name="sname">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="glyphicon glyphicon-user">按性别查询:&nbsp;</span>
                <select name="gender" class="btn btn-default dropdown-toggle">
                            <option value="">--请选择--</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                &nbsp;&nbsp;&nbsp;
                <input class="btn btn-primary" type="submit" value="查询">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-primary" href="add.jsp">添加</a>
            </td>
        </tr>

        <tr align="center">
            <td><b>编号</b></td>
            <td><b>姓名</b></td>
            <td><b>性别</b></td>
            <td><b>电话</b></td>
            <td><b>生日</b></td>
            <td><b>爱好</b></td>
            <td><b>简介</b></td>
            <td><b>操作</b></td>
        </tr>

        <c:forEach items="${studentList}" var="stu">
            <tr align="center">
                <td>${stu.sid}</td>
                <td>${stu.sname}</td>
                <td>${stu.gender}</td>
                <td>${stu.phone}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hobby}</td>
                <td>${stu.info}</td>
                <td><a class="btn btn-primary" href="ServletFindOneStu?sid=${stu.sid}">更新</a>  <a class="btn btn-primary" onclick="doDelete(${stu.sid})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
