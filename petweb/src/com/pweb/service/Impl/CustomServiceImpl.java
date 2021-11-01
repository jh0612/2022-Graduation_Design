package com.pweb.service.Impl;

import com.pweb.dao.CustomerDAO;
import com.pweb.dao.Impl.CustomerDAOImpl;
import com.pweb.pojo.Customer;
import com.pweb.service.CustomService;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-30  18:53
 * petweb
 */
public class CustomServiceImpl implements CustomService {
    //操作数据库
    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void registCustom(Customer customer) {
        customerDAO.insert(customer);
    }

    @Override
    public Customer loginCustom(Customer customer) {
        return customerDAO.queryUserByUsernameAndPassword(customer.getcustname(), customer.getcustpassword());
    }

    @Override
    public boolean existsCustname(String custname) {
        if (customerDAO.queryUserByUsername(custname) == null){
            return false;
        } else {
            return true;
        }
    }
}
