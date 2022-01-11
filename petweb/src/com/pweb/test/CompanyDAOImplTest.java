package com.pweb.test;

import com.pweb.dao.CompanyDAO;
import com.pweb.dao.Impl.CompanyDAOImpl;
import com.pweb.pojo.Company;
import org.junit.jupiter.api.Test;

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
        if (cd.queryUserByUsernameAndPassword("admin", "admin") == null) {
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
        cd.insert(new Company(null, "daimaru1", "admin", "大丸貨店", "daimaru@gmail.com", "大丸次郎", "新宿御苑1-3-33"));
    }

    @Test
    void deleteById() {
        cd.deleteById(2);
    }

    @Test
    void updateById() {
        cd.updateById(new Company(2, "daimaru", "admin", "大丸貨店", "daimaru@gmail.com", "大丸次郎", "新宿御苑4-3-33"));
    }

    @Test
    void getCompanyById() {
        Company company = cd.getCompanyById(2);
        System.out.println(company);
    }

    @Test
    void getAll() {
        List<Company> companyList = cd.getAll(3);
        companyList.forEach(System.out::println);

    }

    @Test
    void getCount() {
        Long count = cd.getCount();
        System.out.println(count);
    }
}