package com.pweb.test;

import com.pweb.dao.CustomerDAO;
import com.pweb.dao.Impl.CustomerDAOImpl;
import com.pweb.pojo.Customer;
import org.junit.jupiter.api.Test;

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
        if (cd.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登录成功/查询成功");
        }
    }

    @Test
    void queryCustomerByCustname() {
        if (cd.queryUserByUsername("admin") != null) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }
    }

    @Test
    void insert() {
        cd.insert(new Customer(null, "simokawa", "123456"
                , "1", "simokawa@gmail.com", "東京都中央区1-1-1", new Date()));//"1996-09-23"
    }

    @Test
    void deleteById() {
        cd.deleteById(2);
    }

    @Test
    void updateById() {
        cd.updateById(new Customer(2, "simokawa", "123456", "1"
                , "simokawa@gmail.com", "東京都中央区1-2-1", new Date()));//"1996-09-23"
    }

    @Test
    void getCustomerById() {
        Customer customer = cd.getCustomerById(2);
        System.out.println(customer);
    }

    @Test
    void getAll() {
        List<Customer> customerList = cd.getAll();
        customerList.forEach(System.out::println);
    }

    @Test
    void getCount() {
        Long count = cd.getCount();
        System.out.println(count);
    }

    @Test
    void getMixBirth() {
        Date mixBirth = cd.getMixBirth();
        System.out.println("最小的生日为" + mixBirth);
    }
}