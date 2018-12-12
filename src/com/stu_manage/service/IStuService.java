package com.stu_manage.service;

import com.stu_manage.model.PageBean;
import com.stu_manage.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: IStuService
 * @Description: 服务层-接口
 * @Author: 杨朝阳
 * @Date: 2018/12/11 20:45
 * @Version: V1.0
 **/
public interface IStuService {
    List<Student> findAll() throws SQLException;
    void insert(Student student) throws SQLException;
    Student findStudentById(int sid) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(int sid) throws SQLException;
    List<Student> searchStudent(String sname, String gender) throws SQLException;
    PageBean findStudentByPage(int currentPage) throws SQLException;
}
