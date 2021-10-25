package com.pweb.test;

import com.pweb.dao.CustomerDAO;
import com.pweb.dao.Impl.CustomerDAOImpl;
import com.pweb.pojo.Customer;
import com.pweb.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  23:01
 * petweb
 */
class CustomerDAOTest {
    CustomerDAO cd = new CustomerDAOImpl();
    @Test
    void queryUserByUsernameAndPassword() {
        if (cd.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登录成功/查询成功");
        }
    }
    @Test
    void queryCustomerByCustname(){
        if (cd.queryUserByUsername("admin") != null) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }
    }

    @Test
    void insert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            cd.insert(conn,new Customer(null,"simokawa","123456","1","simokawa@gmail.com","東京都中央区1-1-1",new Date()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void deleteById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            cd.deleteById(conn, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void updateById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            cd.updateById(conn, new Customer(2,"simokawa","123456","1","simokawa@gmail.com","東京都中央区1-2-1",new Date()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getCustomerById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            Customer customer = cd.getCustomerById(conn, 2);
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            List<Customer> customerList = cd.getAll(conn, 3);
            customerList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getCount() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            Long count = cd.getCount(conn);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getMixBirth() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            Date mixBirth = cd.getMixBirth(conn);
            System.out.println("最小的生日为" + mixBirth);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }
}