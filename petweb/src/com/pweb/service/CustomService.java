package com.pweb.service;

import com.pweb.pojo.Customer;

/**
 * 功能业务层(一一对应)
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-30  18:46
 * petweb
 */
public interface CustomService {
    /**
    * regist注册
    * @param customer 新增insert
    * @author jh
    * @Date:  2021/10/30  18:49
    */
    void registCustom(Customer customer);
    /**
     * login登录
     * @param customer 查queryUserByUsernameAndPassword
     * @return Customer null登录失败反之成功
     * @author jh
     * @Date:  2021/10/30  18:49
     */
    Customer loginCustom(Customer customer);
    /**
     * 看用户名是否存在(存在即为不可用)
     * @param custname 查existsCustomname
     * @return true:用户名已存在；false：用户名可用
     * @author jh
     * @Date:  2021/10/30  18:49
     */
    boolean existsCustname(String custname);
}
