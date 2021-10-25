package com.pweb.dao;

import com.pweb.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
    /**
     * 查询特殊值的方法
     * @param sql
     * @param args 可变型参
     * @return E
     * @author jh
     * @Date:  2021/10/25  20:24
     */
    public static <E> E getvalue(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }


    /**
     * 查多行数据，不能处理事务
     * @param clazz pojo中的类
     * @param sql sql语句
     * @param args 可变形惨
     * @return java.util.List<T>
     * @author jh
     * @Date:  2021/10/25  19:37
     */
    public static <T> List<T> PreparedStatementSelectForList(Class<T> clazz, String sql, Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd;
        try {
            conn = JDBCUtils.getConnectionDruid();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();//得到列数

            ArrayList<T> list = new ArrayList<>();

            while (rs.next()){
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object obj = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,obj);
                }
                list.add(t);
            }
            return list;
        } catch (SQLException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }


    /**
     * 查一行数据
     * @param clazz pojo中的类
     * @param sql sql语句
     * @param args 可变形惨
     * @return T T类型的
     * @author jh
     * @Date:  2021/10/25  19:29
     */
    public static <T>T PreparedStatementSelect(Class<T> clazz,String sql,Object...args){
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

}
