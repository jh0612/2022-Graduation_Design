package com.pweb.test;

import com.pweb.dao.CompanyDAO;
import com.pweb.dao.Impl.CompanyDAOImpl;
import com.pweb.pojo.Company;
import com.pweb.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  10:57
 * petweb
 */
class CompanyDAOImplTest {
        CompanyDAO cd = new CompanyDAOImpl();
    @Test
    void queryUserByUsernameAndPassword() {
        if (cd.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登录成功/查询成功");
        }
    }

    @Test
    void queryUserByUsername() {
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
            cd.insert(conn,new Company(null,"daimaru1","admin","大丸貨店","daimaru@gmail.com","大丸次郎","新宿御苑1-3-33"));
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
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void updateById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            cd.updateById(conn,new Company(2,"daimaru","admin","大丸貨店","daimaru@gmail.com","大丸次郎","新宿御苑4-3-33"));
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getCompanyById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            Company company = cd.getCompanyById(conn, 2);
            System.out.println(company);
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            List<Company> companyList = cd.getAll(conn, 3);
            companyList.forEach(System.out::println);
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
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }
}