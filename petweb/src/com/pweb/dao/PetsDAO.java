package com.pweb.dao;

import com.pweb.pojo.Pets;

import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:37
 * petweb
 */
public interface PetsDAO {

    /**
     * 由于分页所增加的需求:<br/>通过species查对应种类的数量
     * @param species 种类dog 或者 cat
     * @return Integer
     * @author jh
     * @Date:  2021/11/13  01:36
     */
    Integer queryDogOrCatForPageTotalCount(String species);

    /**
     * 由于分页所增加的需求:<br/>通过species查对应种类的所有JavaBean
     * @param species 种类dog 或者 cat
     * @return Integer
     * @author jh
     * @Date:  2021/11/13  01:36
     */
    List<Pets> queryForPageItems(String species,int begin, int pageSize);
/*
按价格分等需要再新建数据库，并且为已有的pets数据库添加属性

 */
    /**
    * 需求1:通过id查找宠物
    * @param id 按id分用equeal
    * @return Pet单个实例
    * @author jh
    * @Date:  2021/10/26  11:32
    */
    Pets getPetsById(Integer id);
    /**
    * 需求2:通过类别species查找指定类别宠物
    * @param species 种类分用equeal
    * @return list
    * @author jh
    * @Date:  2021/10/26  11:32
    */
    List<Pets> getAllBySpecies(String species);


    //--------------------------------


    /**
     * 需求3---将Pets对象添加进数据库中,添加商品用
     * @param pets 用户对象
     * @author jh
     * @Date:  2021/10/25  20:38
     */
    void insert( Pets pets);

    /**
     * 指定id删除商品数据
     * @param id id
     * @author jh
     * @Date:  2021/10/25  20:46
     */
    void deleteById(Integer id);

    /**
     * 指定id修改商品数据
     * @param pets 用户对象
     * @author jh
     * @Date:  2021/10/25  20:47
     */
    void updateById(Pets pets);

    //---------------download-----------------
    /**
    * 指定id下载图片
    * @param id 用户id
    * @author jh
    * @Date:  2021/10/26  13:42
    */
    void petpicDownl(Integer id);
}
