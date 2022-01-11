package com.pweb.test;

import com.pweb.dao.Impl.PetsDAOImpl;
import com.pweb.dao.PetsDAO;
import com.pweb.pojo.Pets;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  11:49
 * petweb
 */
class PetsDAOImplTest {
    PetsDAO pd = new PetsDAOImpl();

    @Test
    void queryDogOrCatForPageTotalCount(){
        Integer cat = pd.queryDogOrCatForPageTotalCount("cat");
        System.out.println("当前共有猫-------->" + cat);
        Integer dog = pd.queryDogOrCatForPageTotalCount("dog");
        System.out.println("当前共有狗-------->" + dog);
    }

    @Test
    void getPetsById() {
        Pets pets = pd.getPetsById(1);
        System.out.println(pets);
    }

    @Test
    void getAllBySpecies() {
        List<Pets> petsList = pd.getAllBySpecies("cat");
        petsList.forEach(System.out::println);
    }

    @Test
    void insert() {
//        try {
            //图片这样应该只能放一张需要给文件地址，配置文件使用？？
//            FileInputStream fis = new FileInputStream("/Users/jh/ideaworkspace/jdbc/src/1.jpeg");
            pd.insert(new Pets(null, "ワンちゃん1", "dog", 5, "かわいい", "http://cdn.reiwaxr.club/typora/20211102131542.jpg"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void deleteById() {
        pd.deleteById(2);
    }

    @Test
    void updateById() {
            pd.updateById(new Pets(null, "ワンちゃん", "dog", 5, "かわいい", null));
    }

    @Test
    void petpicDownl() {
        pd.petpicDownl(2);
    }
}