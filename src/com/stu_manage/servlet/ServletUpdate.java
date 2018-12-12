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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "ServletUpdate", urlPatterns = "/ServletUpdate")
public class ServletUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            int sid = Integer.parseInt(request.getParameter("sid"));
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String[] hobbys = request.getParameterValues("hobby");
            String info = request.getParameter("info");

            // 把birthday的string类型转化为Date类型
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
            // hobbys为一个字符串数组，需要转化为string类型
            String s = Arrays.toString(hobbys);             //[王者荣耀, 看电影, 游泳]
            String hobby = s.substring(1, s.length()-1);    //王者荣耀, 看电影, 游泳

            Student student = new Student(sid, sname, gender, phone, date, hobby, info);
            IStuService stuService = new StuServiveImpl();
            stuService.update(student);

            request.getRequestDispatcher("ServletStuList").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
