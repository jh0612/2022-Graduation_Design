package com.pweb.dao.Impl;

import com.pweb.dao.BaseDAO;
import com.pweb.dao.PetsDAO;
import com.pweb.pojo.Pets;
import com.pweb.utils.JDBCBlob;

import java.sql.Connection;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  11:44
 * petweb
 */
public class PetsDAOImpl extends BaseDAO<Pets> implements PetsDAO {
    @Override
    public Pets getPetsById(Connection conn, Integer id) {
        String sql = "select id,petsname,species,amount,instruction from pets where id = ?";
        return queryForOne(Pets.class,sql,id);
    }

    @Override
    public List<Pets> getAllBySpecies(Connection conn, String species) {
        String sql = "select id,petsname,species,amount,instruction from pets where species = ?";
        return getForList(conn,sql,species);
    }

    @Override
    public void insert(Connection conn, Pets pets) {
            String sql = "insert into pets(petsname,species,amount,instruction,picture)values(?,?,?,?,?)";
            update(sql,pets.getpetsname(),pets.getSpecies(),pets.getAmount(),pets.getInstruction(),pets.getFis());
    }

    @Override
    public void deleteById(Connection conn, Integer id) {
        String sql = "delete from pets where id = ?";
        update(sql,id);
    }

    @Override
    public void updateById(Connection conn, Pets pets) {
        String sql = "update pets set petsname = ?,species = ?,amount = ?,instruction = ?,picture = ? where id = ?";
        update(sql,pets.getpetsname(),pets.getSpecies(),pets.getAmount(),pets.getInstruction(),pets.getFis(),pets.getId());
    }

    @Override
    public void petpicDownl(Connection conn, Integer id) {
        String sql = "select id,petsname,species,amount,instruction,picture from pets where id = ?";
        JDBCBlob.imgblobdonload(sql,id);
    }
}
