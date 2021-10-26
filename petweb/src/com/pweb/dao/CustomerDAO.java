package com.pweb.dao;

import com.pweb.pojo.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:36
 * petweb
 */
public interface CustomerDAO {


    /**
     * 需求1---验证用户名是否有效<br/>根据用户名查询用户信息
     * @param custname 用户名
     * @return 返回null说明没有此用户，反之就是用户存在
     * @author jh
     * @Date:  2021/10/25  20:54
     */
    Customer queryUserByUsername(String custname);

    /**
     * 需求2---根据用户名和密码查询用户信息(用户登录操作用)
     * @param custname 用户名
     * @param custpassword 密码
     * @return 返回null说明用户名或密码错误，反之就可以登录
     * @author jh
     * @Date:  2021/10/25  23:56
     */
    Customer queryUserByUsernameAndPassword(String custname,String custpassword);

    /**
    * 需求3---将customer对象添加进数据库中,注册用
    * @param conn 连接
    * @param customer 用户对象
    * @author jh
    * @Date:  2021/10/25  20:38
    */
    void insert(Connection conn, Customer customer);

    /**
    * 指定id删除数据
    * @param conn 连接
    * @param custid id
    * @author jh
    * @Date:  2021/10/25  20:46
    */
    void deleteById(Connection conn,Integer custid);

    /**
    * 指定id修改数据
    * @param conn 连接
    * @param customer 用户对象
    * @author jh
    * @Date:  2021/10/25  20:47
    */
    void updateById(Connection conn ,Customer customer);

    /**
    * 使用custid查到指定对象(一条数据)
    * @param conn 连接
    * @param custid id
    * @return Customer
    * @author jh
    * @Date:  2021/10/25  20:48
    */
    Customer getCustomerById(Connection conn, Integer custid);

    /**
     * 查询所有数据构成的集合(多条数据)
     * @param conn 连接
     * @param custid id
     * @return list<Customer>
     * @author jh
     * @Date:  2021/10/25  20:42
     */
    List<Customer> getAll(Connection conn, Integer custid);

    /**
    * 返回数据表中的数据的条数
    * @param conn 连接
    * @return list<Customer>
    * @author jh
    * @Date:  2021/10/25  20:42
    */
    Long getCount(Connection conn);

    /**
    * 返回岁数最小的
    * @param conn 连接
    * @return Date
    * @author jh
    * @Date:  2021/10/25  20:41
    */
    Date getMixBirth(Connection conn);

}