package com.pweb.test;

import com.pweb.pojo.Page;
import com.pweb.pojo.Pets;
import com.pweb.service.Impl.PetsServiceImpl;
import com.pweb.service.PetsService;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-12  1:14
 * petweb
 */
public class PetsServletTest {
    private final PetsService petsService = new PetsServiceImpl();

    @Test
    public void pagedog(){
        List<Pets> dog = petsService.getPets("dog");
        Page<Pets> page = petsService.pagedog(dog,1, Page.PAGE_SIZE);
        System.out.println("PageNo = " + page.getPageNo());
        System.out.println("PageTotal = " + page.getPageTotal());
        System.out.println("PageSize = " + page.getPageSize());
        System.out.println("PageTotalCount = " + page.getPageTotalCount());
        List<Pets> items = page.getItems();
        items.forEach(System.out::println);
    }
    @Test
    public void pagecat(){
        List<Pets> cat = petsService.getPets("cat");
        Page<Pets> page = petsService.pagecat(cat,1, Page.PAGE_SIZE);
        System.out.println("PageNo = " + page.getPageNo());
        System.out.println("PageTotal = " + page.getPageTotal());
        System.out.println("PageSize = " + page.getPageSize());
        System.out.println("PageTotalCount = " + page.getPageTotalCount());
        List<Pets> items = page.getItems();
        items.forEach(System.out::println);
    }
}
