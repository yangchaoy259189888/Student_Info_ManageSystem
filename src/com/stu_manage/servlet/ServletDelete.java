package com.stu_manage.servlet;

import com.stu_manage.service.IStuService;
import com.stu_manage.service.impl.StuServiveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDelete", urlPatterns = "/ServletDelete")
public class ServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 接收要删除的学生id
            int sid = Integer.parseInt(request.getParameter("sid"));

            // 到数据库删除这个学生信息
            IStuService stuService = new StuServiveImpl();
            stuService.delete(sid);

            request.getRequestDispatcher("ServletStuList").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
