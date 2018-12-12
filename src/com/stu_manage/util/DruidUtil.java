package com.stu_manage.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: DruidUtil
 * @Description: 使用druid数据库连接池
 * @Author:
 * @Date: 2018/12/11 17:23
 * @Version: V1.0
 **/
public class DruidUtil {
    private static DruidDataSource ds = null;

    // 初始化，只执行一次
    static {
        try {
//        创建一个属性配置对象
            Properties properties = new Properties();
//        使用类加载器，去读取资源文件
            InputStream inputStream = DruidUtil.class.getClassLoader().
                    getResourceAsStream("druid.properties");

//        导入输入流
            properties.load(inputStream);
            // 加载properties文件，创建数据源
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDruidDataSource() {
        return ds;
    }
}