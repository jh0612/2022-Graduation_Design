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
    public Customer queryUserByUsernameAndPassword(String custname, String custpassword) {
        String sql = "select custid,custname,custpassword,custemail from customer where custname = ? and custpassword = ?";
        return queryForOne(Customer.class,sql,custname,custpassword);
    }

    @Override
    public Customer queryUserByUsername(String custname) {
        String sql = "select custid,custname,custpassword,custsex,custemail,custaddress,custbirth from customer where custname = ?";
        return queryForOne(Customer.class,sql,custname);
    }

    @Override
    public void insert( Customer customer) {
        String sql = "insert into customer(custid,custname,custpassword,custsex,custemail,custaddress,custbirth)values(?,?,?,?,?,?,?)";
        update(sql,customer.getcustid(),customer.getcustname(),customer.getcustpassword(),customer.getcustsex(),
                customer.getcustemail(),customer.getcustaddress(),customer.getcustbirth());
    }

    @Override
    public void deleteById(Connection conn, Integer custid) {
        String sql = "delete from customer where id = ?";
        update(sql,custid);
    }

    @Override
    public void updateById(Connection conn, Customer customer) {
        String sql = "update customer set custname = ?,custpassword = ?,custsex = ?,custemail = ?,custaddress = ?,custbirth = ? where custid = ?";
        update(sql,customer.getcustname(),customer.getcustpassword(),customer.getcustsex(),
                customer.getcustemail(),customer.getcustaddress(),customer.getcustbirth(),customer.getcustid());
    }

    @Override
    public Customer getCustomerById(Connection conn, Integer custid) {
        String sql = "select custid,custname,custpassword,custsex,custemail,custaddress,custbirth from customer where custid = ?";
//        Customer customer = getInstance(conn, sql,custid);
        return getInstance(sql,custid);
    }

    @Override
    public List<Customer> getAll(Connection conn, Integer custid) {
        String sql = "select custid,custname,custpassword,custsex,custemail,custaddress,custbirth from customer";
//        List<Customer> list = getForList(conn, sql);
        return getForList(conn, sql);
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customer";
        return getValue(conn, sql);
    }

    @Override
    public Date getMixBirth(Connection conn) {
        String sql = "select max(custbirth) from customer";
        return getValue(conn, sql);
    }
}