package com.pweb.dao;

import com.pweb.pojo.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:36
 * petweb
 */
public interface CustomerDAO {
    /**
    * 将customer对象添加进数据库中
    * @param conn
    * @param customer
    * @author jh
    * @Date:  2021/10/25  20:38
    */
    void insert(Connection conn, Customer customer);
    /**
    * 指定id删除数据
    * @param conn
    * @param custid
    * @return
    * @author jh
    * @Date:  2021/10/25  20:46
    */
    void deleteById(Connection conn,Integer custid);
    /**
    * 指定id修改数据
    * @param conn
    * @param custid
    * @return
    * @author jh
    * @Date:  2021/10/25  20:47
    */
    void updateById(Connection conn ,Integer custid);
    /**
    * 使用custid查到指定对象(一条数据)
    * @param conn
    * @param custid
    * @return Customer
    * @author jh
    * @Date:  2021/10/25  20:48
    */
    Customer getCustomerById(Connection conn,Integer custid);
    /**
     * 查询所有数据构成的集合(多条数据)
     * @param conn
     * @param custid
     * @return list<Customer>
     * @author jh
     * @Date:  2021/10/25  20:42
     */
    List<Customer> getAll(Connection conn, Integer custid);
    /**
    * 返回数据表中的数据的条数
    * @param conn
    * @return list<Customer>
    * @author jh
    * @Date:  2021/10/25  20:42
    */
    Long getCount(Connection conn);
    /**
    * 返回岁数最小的
    * @param conn
    * @return Date
    * @author jh
    * @Date:  2021/10/25  20:41
    */
    Date getMixBirth(Connection conn);

}
