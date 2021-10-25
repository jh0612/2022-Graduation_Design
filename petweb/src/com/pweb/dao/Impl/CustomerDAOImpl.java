package com.pweb.dao.Impl;

import com.pweb.dao.BaseDAO;
import com.pweb.dao.CustomerDAO;
import com.pweb.pojo.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:51
 * petweb
 */
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {
    @Override
    public void insert(Connection conn, Customer customer) {

    }

    @Override
    public void deleteById(Connection conn, Integer custid) {

    }

    @Override
    public void updateById(Connection conn, Integer custid) {

    }

    @Override
    public Customer getCustomerById(Connection conn, Integer custid) {
        return null;
    }

    @Override
    public List<Customer> getAll(Connection conn, Integer custid) {
        return null;
    }

    @Override
    public Long getCount(Connection conn) {
        return null;
    }

    @Override
    public Date getMixBirth(Connection conn) {
        return null;
    }
}
