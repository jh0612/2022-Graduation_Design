package com.pweb.dao;

import com.pweb.pojo.Company;

import java.sql.Connection;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:37
 * petweb
 */
public interface CompanyDAO {
    /**
     * 需求1---验证用户名是否有效<br/>根据用户名查询用户信息
     * @param compname 用户名
     * @return 返回null说明没有此用户，反之就是用户存在
     * @author jh
     * @Date:  2021/10/25  20:54
     */
    Company queryUserByUsername(String compname);

    /**
     * 需求2---根据用户名和密码查询用户信息(用户登录操作用)
     * @param compname 用户名
     * @param comppassword 密码
     * @return 返回null说明用户名或密码错误，反之就可以登录
     * @author jh
     * @Date:  2021/10/25  23:56
     */
    Company queryUserByUsernameAndPassword(String compname,String comppassword);

    /**
     * 需求3---将Company对象添加进数据库中,注册用
     * @param conn 连接
     * @param Company 用户对象
     * @author jh
     * @Date:  2021/10/25  20:38
     */
    void insert(Connection conn, Company Company);

    /**
     * 指定id删除数据
     * @param conn 连接
     * @param compid id
     * @author jh
     * @Date:  2021/10/25  20:46
     */
    void deleteById(Connection conn,Integer compid);

    /**
     * 指定id修改数据
     * @param conn 连接
     * @param Company 用户对象
     * @author jh
     * @Date:  2021/10/25  20:47
     */
    void updateById(Connection conn ,Company Company);

    /**
     * 使用compid查到指定对象(一条数据)
     * @param conn 连接
     * @param compid id
     * @return Company
     * @author jh
     * @Date:  2021/10/25  20:48
     */
    Company getCompanyById(Connection conn,Integer compid);

    /**
     * 查询所有数据构成的集合(多条数据)
     * @param conn 连接
     * @param compid id
     * @return list<Company>
     * @author jh
     * @Date:  2021/10/25  20:42
     */
    List<Company> getAll(Connection conn, Integer compid);

    /**
     * 返回数据表中的数据的条数
     * @param conn 连接
     * @return list<Company>
     * @author jh
     * @Date:  2021/10/25  20:42
     */
    Long getCount(Connection conn);
}
