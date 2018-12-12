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

@WebServlet(name = "ServletSearchStudent", urlPatterns = "/ServletSearchStudent")
public class ServletSearchStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");

            IStuService stuService = new StuServiveImpl();
            List<Student> studentList = stuService.searchStudent(sname, gender);

            request.setAttribute("studentList", studentList);

            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
