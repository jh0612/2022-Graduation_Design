package com.pweb.dao.Impl;

import com.pweb.dao.BaseDAO;
import com.pweb.dao.PetsDAO;
import com.pweb.pojo.Pets;
import com.pweb.utils.JDBCBlob;

import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  11:44
 * petweb
 */
public class PetsDAOImpl extends BaseDAO<Pets> implements PetsDAO {
    @Override
    public Integer queryDogOrCatForPageTotalCount(String species) {
        String sql = "select count(*) from pets where species=?";
//        Number number = (Number) queryForSingleValue(sql,species);
        Number number = getValue(sql,species);
        //Number类型转为int类型
        return number.intValue();
    }


    @Override
    public List<Pets> queryForPageItems(String species,int begin, int pageSize) {
        String sql = "select id,petsname,species,amount,instruction,picture from pets WHERE species = ? limit ?,?";
        List<Pets> forList = getForList(sql, species, begin, pageSize);
        return forList;
    }

    @Override
    public Pets getPetsById(Integer id) {
        String sql = "select id,petsname,species,amount,instruction,picture from pets where id = ?";
        Pets pets = queryForOne(Pets.class, sql, id);
        return pets;
    }

    @Override
    public List<Pets> getAllBySpecies(String species) {
        String sql = "select id,petsname,species,amount,instruction,picture from pets where species = ?";
        List<Pets> forList = getForList(sql, species);
        return forList;
    }

    @Override
    public void insert(Pets pets) {
            String sql = "insert into pets(petsname,species,amount,instruction,picture)values(?,?,?,?,?)";
            update(sql,pets.getPetsname(),pets.getSpecies(),pets.getAmount(),pets.getInstruction(),pets.getPicture());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from pets where id = ?";
        update(sql,id);
    }

    @Override
    public void updateById(Pets pets) {
        String sql = "update pets set petsname = ?,species = ?,amount = ?,instruction = ?,picture = ? where id = ?";
        update(sql,pets.getPetsname(),pets.getSpecies(),pets.getAmount(),pets.getInstruction(),pets.getPicture(),pets.getId());
    }

    @Override
    public void petpicDownl(Integer id) {
        String sql = "select id,petsname,species,amount,instruction,picture from pets where id = ?";
        JDBCBlob.imgblobdonload(sql,id);
    }
}
