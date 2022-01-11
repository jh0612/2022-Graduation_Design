package com.pweb.service;

import com.pweb.pojo.Page;
import com.pweb.pojo.Pets;

import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-11  13:14
 * petweb
 */
public interface PetsService {
    void addPet(Pets pets);

    void deletePetById(Integer id);

    void updatePets(Pets pets);

    Pets getPetById(Integer id);

    List<Pets> getPets(String species);

    //在下方添加分页效果
    Page<Pets> pagedog(List<Pets> list,int pageNo,int pageSize);
    Page<Pets> pagecat(List<Pets> list,int pageNo,int pageSize);

    Page<Pets> pageByDate(int pageNo,int pageSize,int min,int max);
}
