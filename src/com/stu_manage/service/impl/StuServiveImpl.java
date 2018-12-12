package com.stu_manage.service.impl;

import com.stu_manage.dao.IStudentDao;
import com.stu_manage.dao.impl.StudentDaoImpl;
import com.stu_manage.model.PageBean;
import com.stu_manage.model.Student;
import com.stu_manage.service.IStuService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: StuServiveImpl
 * @Description: 服务层-具体实现类
 * @Author: 杨朝阳
 * @Date: 2018/12/11 20:47
 * @Version: V1.0
 **/
public class StuServiveImpl implements IStuService {
    @Override
    public List<Student> findAll() throws SQLException {
        IStudentDao studentDao = new StudentDaoImpl();

        return studentDao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        IStudentDao studentDao = new StudentDaoImpl();
        studentDao.insert(student);
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        IStudentDao studentDao = new StudentDaoImpl();

        return studentDao.findStudentById(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        IStudentDao studentDao = new StudentDaoImpl();
        studentDao.update(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        IStudentDao studentDao = new StudentDaoImpl();
        studentDao.delete(sid);
    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        IStudentDao studentDao = new StudentDaoImpl();

        return studentDao.searchStudent(sname, gender);
    }

    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {
        /**
         * @param: [currentPage]
         * @return: com.stu_manage.model.PageBean
         * @date: 2018/12/12
         * @Description: 这里处理分页的业务逻辑，处理Dao层从数据库中取出的数据，
         */
        //封装分页的该页数据
        PageBean<Student> pageBean = new PageBean<>();

        int pageSize = IStudentDao.PAGE_SIZE;
        pageBean.setPageSize(pageSize); // 设置每页显示多少条记录
        pageBean.setCurrentPage(currentPage);   // 设置当前页

        IStudentDao studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.findStudentByPage(currentPage);
        pageBean.setList(list); //设置这一页的学生数据

        //总的记录数， 总的页数。
        int count = studentDao.findCount();
        pageBean.setTotalSize(count);   //设置总的记录数
        // 设置总的页数
        pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1);

        return pageBean;
    }
}
