package com.pweb.test;

import com.pweb.dao.Impl.PetsDAOImpl;
import com.pweb.dao.PetsDAO;
import com.pweb.pojo.Company;
import com.pweb.pojo.Customer;
import com.pweb.pojo.Pets;
import com.pweb.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  11:49
 * petweb
 */
class PetsDAOImplTest {
    PetsDAO pd = new PetsDAOImpl();
    @Test
    void getPetsById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            Pets pets = pd.getPetsById(conn, 1);
            System.out.println(pets);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void getAllBySpecies() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            List<Pets> petsList = pd.getAllBySpecies(conn, "cat");
            petsList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void insert() {
        Connection conn = null;
        try {
            //图片这样应该只能放一张需要给文件地址，配置文件使用？？
            FileInputStream fis = new FileInputStream("/Users/jh/ideaworkspace/jdbc/src/1.jpeg");
            conn = JDBCUtils.getConnectionDruid();
            pd.insert(conn,new Pets(null,"ワンちゃん","dog",5,"かわいい",fis));
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void deleteById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            pd.deleteById(conn, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void updateById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnectionDruid();
            FileInputStream fis = new FileInputStream("/Users/jh/ideaworkspace/jdbc/src/1.jpeg");

            pd.updateById(conn, new Pets(null,"ワンちゃん","dog",5,"かわいい",fis));
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,null,null);
        }
    }

    @Test
    void petpicDownl(){
        try {
            Connection conn = JDBCUtils.getConnectionDruid();
            pd.petpicDownl(conn,2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}