<%--
  Created by IntelliJ IDEA.
  User: 西邮陈冠希
  Date: 2018/12/12
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>更新学生信息</title>

    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript" src="jquery-3.2.1/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<h3>更新学生信息</h3>
<form method="post" action="ServletUpdate">
    <input type="hidden" name="sid" value="${student.sid}">
    <table border="1" class="table table-hover text-left">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="sname" value="${student.sname}">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男" <c:if test="${student.gender == '男'}">checked</c:if>>男
                <input type="radio" name="gender" value="女" <c:if test="${student.gender == '女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="tel" name="phone" value="${student.phone}"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="date" name="birthday" value="${student.birthday}"></td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <%--因为爱好有很多个，  里面存在包含的关系--%>
                <input type="checkbox" name="hobby" value="睡觉" <c:if test="${fn:contains(student.hobby, '睡觉')}">checked</c:if>>睡觉
                <input type="checkbox" name="hobby" value="王者荣耀" <c:if test="${fn:contains(student.hobby, '王者荣耀')}">checked</c:if>>王者荣耀
                <input type="checkbox" name="hobby" value="撸代码" <c:if test="${fn:contains(student.hobby, '撸代码')}">checked</c:if>>撸代码
                <input type="checkbox" name="hobby" value="看电影" <c:if test="${fn:contains(student.hobby, '看电影')}">checked</c:if>>看电影
                <input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(student.hobby, '游泳')}">checked</c:if>>游泳
                <input type="checkbox" name="hobby" value="约会" <c:if test="${fn:contains(student.hobby, '约会')}">checked</c:if>>约会
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea style="width: 240px; height: 60px" name="info">${student.info}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="btn btn-primary" type="submit" value="更新">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
