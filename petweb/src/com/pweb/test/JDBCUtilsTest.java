package com.pweb.test;

import com.pweb.dao.BaseDAO;
import com.pweb.pojo.Customer;
import com.pweb.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  19:49
 * petweb
 */
public class JDBCUtilsTest {
    @Test
    public void testForConnection(){
        Connection conn;
        conn = JDBCUtils.getConnectionDruid();
        System.out.println(conn);//说明已获得连接com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl@32115b28
        String sql = "select custid,custname,custpassword,custsex,custemail,custaddress,custbirth from customer where custid = ?";
        Customer customer = BaseDAO.PreparedStatementSelect(Customer.class, sql, 1);
        System.out.println(customer);
    }
}
