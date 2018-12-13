package com.stu_manage.servlet;

import com.stu_manage.model.Student;
import com.stu_manage.service.IStuService;
import com.stu_manage.service.impl.StuServiveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletStuList", urlPatterns = "/ServletStuList")
public class ServletStuList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 查询出所有学生
            IStuService stuService = new StuServiveImpl();
            List<Student> studentList = stuService.findAll();

            // 把数据存储到作用域中
            request.setAttribute("studentList", studentList);

            // 跳转
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
