package com.stu_manage.dao.impl;

import com.stu_manage.dao.IStudentDao;
import com.stu_manage.model.Student;
import com.stu_manage.util.C3P0Util;
import com.stu_manage.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StudentDaoImpl
 * @Description: 数据访问层-具体实现类
 * @Author: 杨朝阳
 * @Date: 2018/12/11 20:18
 * @Version: V1.0
 **/
public class StudentDaoImpl implements IStudentDao {
    @Override
    public List<Student> findAll() throws SQLException {
        /**
         * @param: []
         * @return: java.util.List<com.stu_manage.model.Student>
         * @date: 2018/12/11
         * @Description: 查询所有学生信息
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());

        return queryRunner.query("select * from stu",
                new BeanListHandler<Student>(Student.class));
    }

    @Override
    public void insert(Student student) throws SQLException {
        /**
         * @param: [student]
         * @return: void
         * @date: 2018/12/12
         * @Description: 插入一条学生信息
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());
        queryRunner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo());
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        /**
         * @param: [sid]
         * @return: com.stu_manage.model.Student
         * @date: 2018/12/12
         * @Description: 根据sid查找一个学生的信息
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());

        return queryRunner.query("select * from stu where sid = ?",
                new BeanHandler<Student>(Student.class), sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        /**
         * @param: [student]
         * @return: void
         * @date: 2018/12/12
         * @Description: 更新学生信息
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());
        queryRunner.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid());
    }

    @Override
    public void delete(int sid) throws SQLException {
        /**
         * @param: [sid]
         * @return: void
         * @date: 2018/12/12
         * @Description: 删除一个学生信息
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());
        queryRunner.update("delete from stu where sid=?", sid);
    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        /**
         * @param: [sname, gender]
         * @return: java.util.List<com.stu_manage.model.Student>
         * @date: 2018/12/12
         * @Description: 这里的查询应该是模糊查询
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());

        /*
         * 这里要分析一下：
         * 	如果只有姓名 ，select * from stu where sname like ? ;
         * 	如果只有性别 ， select * from stu where gender = ?
         *
         * 如果两个都有 select * from stu where sname like ? and gender=?
         *
         * 如果两个都没有就查询所有。
         *
         */

        String sql = "select * from stu where 1=1";
        List<String> list = new ArrayList<>();

        //判断有没有姓名， 如果有，就组拼到sql语句里面
        if (!sname.isEmpty()) {
            sql = sql + " and sname like ?";
            list.add("%" + sname + "%");
        }
        //判断有没有性别，有的话，就组拼到sql语句里面。
        if (!gender.isEmpty()) {
            sql = sql + " and gender = ?";
            list.add(gender);
        }

        return queryRunner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
    }

    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        /**
         * @param: [currentPage]
         * @return: java.util.List<com.stu_manage.model.Student>
         * @date: 2018/12/12
         * @Description: 根据页号查找学生信息---分页
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());
        //第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
        //5 0 --- 第一页 (1-1)*5
        //5 5  --- 第二页 (2-1)*5
        //5 10  --- 第三页
        return queryRunner.query("select * from stu limit ? offset ?",
                new BeanListHandler<Student>(Student.class),
                PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
    }

    @Override
    public int findCount() throws SQLException {
        /**
         * @param: []
         * @return: int
         * @date: 2018/12/12
         * @Description: 从数据库查找共有多少记录
         */
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDruidDataSource());

        //ScalarHandler用于处理平均值、总的个数。
        Long result = (Long) queryRunner.query("select count(*) from stu", new ScalarHandler());

        return result.intValue();
    }
}
