package com.pweb.dao;

import com.pweb.pojo.Pets;

import java.sql.Connection;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  20:37
 * petweb
 */
public interface PetsDAO {
/*
按价格分等需要再新建数据库，并且为已有的pets数据库添加属性

 */
    /**
    * 需求1:通过id查找宠物
    * @param conn 连接
    * @param id 按id分用equeal
    * @return Pet单个实例
    * @author jh
    * @Date:  2021/10/26  11:32
    */
    Pets getPetsById(Connection conn,Integer id);
    /**
    * 需求2:通过类别species查找指定类别宠物
    * @param conn 连接
    * @param species 种类分用equeal
    * @return list
    * @author jh
    * @Date:  2021/10/26  11:32
    */
    List<Pets> getAllBySpecies(Connection conn,String species);


    //--------------------------------


    /**
     * 需求3---将Pets对象添加进数据库中,添加商品用
     * @param conn 连接
     * @param pets 用户对象
     * @author jh
     * @Date:  2021/10/25  20:38
     */
    void insert(Connection conn, Pets pets);

    /**
     * 指定id删除商品数据
     * @param conn 连接
     * @param id id
     * @author jh
     * @Date:  2021/10/25  20:46
     */
    void deleteById(Connection conn,Integer id);

    /**
     * 指定id修改商品数据
     * @param conn 连接
     * @param pets 用户对象
     * @author jh
     * @Date:  2021/10/25  20:47
     */
    void updateById(Connection conn ,Pets pets);

    //---------------download-----------------
    /**
    * 指定id下载图片
    * @param conn 连接
    * @param id 用户id
    * @author jh
    * @Date:  2021/10/26  13:42
    */
    void petpicDownl(Connection conn , Integer id);
}
