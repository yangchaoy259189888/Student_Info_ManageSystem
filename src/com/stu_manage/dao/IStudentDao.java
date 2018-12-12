package com.stu_manage.dao;

import com.stu_manage.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: IStudentDao
 * @Description: 数据访问层-接口
 * @Author: 杨朝阳
 * @Date: 2018/12/11 20:11
 * @Version: V1.0
 **/
public interface IStudentDao {
    int PAGE_SIZE = 2;

    List<Student> findAll() throws SQLException;
    void insert(Student student) throws SQLException;
    Student findStudentById(int sid) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(int sid) throws SQLException;
    List<Student> searchStudent(String sname, String gender) throws SQLException;
    List<Student> findStudentByPage(int currentPage) throws SQLException;
    int findCount() throws SQLException;
}
