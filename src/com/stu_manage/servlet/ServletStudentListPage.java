package com.stu_manage.servlet;

import com.stu_manage.model.PageBean;
import com.stu_manage.service.IStuService;
import com.stu_manage.service.impl.StuServiveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletStudentListPage", urlPatterns = "/ServletStudentListPage")
public class ServletStudentListPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1. 获取需要显示的页码数
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            //2. 根据指定的页数，去获取该页的数据回来
            IStuService stuService = new StuServiveImpl();
            PageBean pageBean = stuService.findStudentByPage(currentPage);
            request.setAttribute("pageBean", pageBean);
            //3. 跳转界面。
            request.getRequestDispatcher("list_page.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
