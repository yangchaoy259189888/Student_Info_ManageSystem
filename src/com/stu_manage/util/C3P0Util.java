package com.stu_manage.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @ClassName: DruidUtil
 * @Description: 使用c3p0数据库连接池
 * @Author:
 * @Date: 2018/12/11 17:23
 * @Version: V1.0
 **/
public class C3P0Util {
    static ComboPooledDataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
