package com.pweb.dao.Impl;

import com.pweb.dao.BaseDAO;
import com.pweb.dao.CompanyDAO;
import com.pweb.pojo.Company;

import java.sql.Connection;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  10:15
 * petweb
 */
public class CompanyDAOImpl extends BaseDAO<Company> implements CompanyDAO {
    @Override
    public Company queryUserByUsernameAndPassword(String compusername, String comppassword) {
        String sql = "select compid,compusername,comppassword,compemail from company where compusername = ? and comppassword = ?";
        return queryForOne(Company.class,sql,compusername,comppassword);
    }

    @Override
    public Company queryUserByUsername(String compusername) {
        String sql = "select compid,compusername,compname,comppassword,compemail,compaddress from company where compusername = ?";
        return getInstance(sql,compusername);
    }

    @Override
    public void insert(Connection conn, Company Company) {
        String sql = "insert into company(compusername,compname,comppassword,compemail,compaddress,legalname)values(?,?,?,?,?,?)";
        update(sql,Company.getCompusername(),Company.getCompname(),Company.getComppassword(),Company.getCompemail(),Company.getCompaddress(), Company.getLegalname());
    }

    @Override
    public void deleteById(Connection conn, Integer compid) {
        String sql = "delete from company where compid = ?";
        update(sql,compid);
    }

    @Override
    public void updateById(Connection conn, Company Company) {
        String sql = "update company set compusername = ?,compname = ?,comppassword = ?,compemail = ?,compaddress = ?,legalname = ? where compid = ?";
        update(sql,Company.getCompusername(),Company.getCompname(),Company.getComppassword(),Company.getCompemail(),Company.getCompaddress(), Company.getLegalname(),Company.getCompid());
    }

    @Override
    public Company getCompanyById(Connection conn, Integer compid) {
        String sql = "select compid,compusername,comppassword,compname,compemail,compaddress,legalname from company where compid = ?";
//        Company Company = getInstance(conn, sql,compid);
        return getInstance(sql,compid);
    }


    @Override
    public List<Company> getAll(Connection conn, Integer compid) {
        String sql = "select compid,compusername,comppassword,compname,compemail,compaddress,legalname from company";
//        List<Company> list = getForList(conn, sql);
        return getForList(conn, sql);
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from company";
        return getValue(conn,sql);
    }
}
