package com.pweb.test;

import com.pweb.pojo.Customer;
import com.pweb.service.CustomService;
import com.pweb.service.Impl.CustomServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-30  19:13
 * petweb
 */
class CustomServiceTest {
    CustomService customService = new CustomServiceImpl();
    @Test
    void registCustom() {
        customService.registCustom(new Customer(null,"中井","666666"
                ,"0","nakai@gmail","東京-品川",new Date()));//"2001-02-02"
    }

    @Test
    void loginCustom() {
        System.out.println(customService.loginCustom(new Customer(null,"simokawa"
                ,"123456",null,null,null,null)));
    }

    @Test
    void existsCustomname() {
        if (customService.existsCustname("simokawa")){
            System.out.println("用户名已存在,不可使用");
        } else {
            System.out.println("用户名不存在，可以使用");
        }
    }
}