package com.stu_manage.servlet;

import com.stu_manage.model.Student;
import com.stu_manage.service.IStuService;
import com.stu_manage.service.impl.StuServiveImpl;
import com.sun.org.glassfish.gmbal.Description;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletFindOneStu", urlPatterns = "/ServletFindOneStu")
public class ServletFindOneStu extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int sid = Integer.parseInt(request.getParameter("sid"));

            IStuService stuService = new StuServiveImpl();
            Student student = stuService.findStudentById(sid);

            request.setAttribute("student", student);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
