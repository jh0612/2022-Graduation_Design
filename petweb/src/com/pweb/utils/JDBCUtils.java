package com.pweb.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  18:53
 * petweb
 */
public abstract class JDBCUtils {
    private static DataSource source;
    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("petdb.properties");
            properties.load(resourceAsStream);
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sql连接
     * @return conn
     * @author jh
     * @Date:  2021/10/25  18:54
     */
    public static Connection getConnectionDruid() throws SQLException {
        return source.getConnection();
    }

    /**
    * 关闭资源
    * @param conn 连接对象
    * @param stmt 操作sql对象
    * @param rs   结果集合
    * @author jh
    * @Date:  2021/10/25  19:02
    */
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
