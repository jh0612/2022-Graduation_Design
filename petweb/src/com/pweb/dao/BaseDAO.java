package com.pweb.dao;

import com.pweb.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用方法
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:30
 * petweb
 */
public abstract class BaseDAO<T> {
    //使用DButils操作数据库
    private final QueryRunner queryRunner = new QueryRunner();
    private final Class<T> clazz;
    {
        //获取当前BaseDAO的子类继承的父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        Type[] typeArguments = paramType.getActualTypeArguments();//获取了父类的泛型参数
        clazz = (Class<T>) typeArguments[0];//泛型的第一个参数

    }

    // 通用的查询操作，用于返回数据表中的一条记录（version 2.0：考虑上事务）
    public T getInstance(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);

        }

        return null;
    }
    /**
     * 查询特殊值的方法
     * @param sql sql
     * @param args 可变型参
     * @return E
     * @author jh
     * @Date:  2021/10/25  20:24
     */
    public <E> E getValue(String sql,Object...args){
        Connection conn = JDBCUtils.getConnectionDruid();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);

            }

            rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(null, ps, rs);

        }
        return null;

    }


    /**
     * 查多行数据，不能处理事务
     * @param sql sql语句
     * @param args 可变形惨
     * @return java.util.List<T>
     * @author jh
     * @Date:  2021/11/11  19:37
     */
    public List<T> getForList(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnectionDruid();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            // 创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);
                    // 获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, rs);
        }
        return null;
    }


    /**
     * 查一行数据静态的-->确定用户名是否重复
     * @param clazz pojo中的类
     * @param sql sql语句
     * @param args 可变形惨
     * @return T T类型的
     * @author jh
     * @Date:  2021/10/25  19:29
     */
    public static <T>T PreparedStatementSelect(Class<T> clazz, String sql, Object... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd;
        try {
            conn = JDBCUtils.getConnectionDruid();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();//得到列数
            if (rs.next()){
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object obj = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,obj);
                }
                return t;
            }
            conn.commit();
        } catch (SQLException | NoSuchMethodException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (NoSuchFieldException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }

    /**
     * 查一行数据非静态的-->确定用户名是否重复
     * @param clazz pojo中的类
     * @param sql sql语句
     * @param args 可变形惨
     * @return T T类型的
     * @author jh
     * @Date:  2021/10/25  19:29
     */
    public <T> T queryForOne(Class<T> clazz,String sql,Object...args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            return queryRunner.query(conn,sql,new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
        return null;
    }

    /**
     * 增删改
     * @param sql sql语句
     * @param args 可变型参
     * @author jh
     * @Date:  2021/10/25  19:17
     */
    public static void update(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            conn.setAutoCommit(false);//start
            ps = conn.prepareStatement(sql);
            //填充？
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            int update = ps.executeUpdate();//改动几条for server
            System.out.println(update);//可不要
            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,null);
        }
    }


    /**
     * 增删改(带图片)
     * @param sql sql语句
     * @param args 可变型参
     * @author jh
     * @Date:  2021/10/25  19:17
     */
    public static void updateForPets(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream fis = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            conn.setAutoCommit(false);//start
            ps = conn.prepareStatement(sql);
            fis = new FileInputStream("/Users/jh/ideaworkspace/jdbc/src/1.jpeg");
            //填充？
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            int update = ps.executeUpdate();//改动几条for server
            System.out.println(update);//可不要
            conn.commit();
        } catch (SQLException | FileNotFoundException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,null);
        }
    }

//    /**
//     * 执行返回一行一列的sql语句
//     * @param sql 执行的sql语句
//     * @param args sql对应的参数值
//     * @return Object
//     * @author jh
//     * @Date:  2021/11/11  17:42
//     */
//
//    public Object queryForSingleValue(String sql,Object...args){
//        Connection con = JDBCUtils.getConnectionDruid();
//        try {
//            return queryRunner.query(con,sql,new ScalarHandler(),args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
}