package com.pweb.service.Impl;

import com.pweb.dao.Impl.PetsDAOImpl;
import com.pweb.dao.PetsDAO;
import com.pweb.pojo.Page;
import com.pweb.pojo.Pets;
import com.pweb.service.PetsService;

import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-11  13:17
 * petweb
 */
public class PetsServiceImpl implements PetsService {
    private final PetsDAO petsDAO = new PetsDAOImpl();

    @Override
    public void addPet(Pets pets) {
        petsDAO.insert(pets);
    }

    @Override
    public void deletePetById(Integer id) {
        petsDAO.deleteById(id);
    }

    @Override
    public void updatePets(Pets pets) {
        petsDAO.updateById(pets);
    }

    @Override
    public Pets getPetById(Integer id) {
        return petsDAO.getPetsById(id);
    }

    @Override
    public List<Pets> getPets(String species) {
        return petsDAO.getAllBySpecies(species);
    }

    //最后再弄，可有可无，数据量不大差别不大
    @Override
    public Page<Pets> pagedog(List pets, int pageNo, int pageSize) {
        Page<Pets> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求的总记录数
        Integer pageTotalCount = petsDAO.queryDogOrCatForPageTotalCount("dog");
        //通过上方求得后进行设置
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Pets> items = petsDAO.queryForPageItems("dog", begin, pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Pets> pagecat(List pets, int pageNo, int pageSize) {
        Page<Pets> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求的总记录数
        Integer pageTotalCount = petsDAO.queryDogOrCatForPageTotalCount("cat");
        //通过上方求得后进行设置
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Pets> items = petsDAO.queryForPageItems("cat", begin, pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Pets> pageByDate(int pageNo, int pageSize, int min, int max) {
        return null;
    }
}
