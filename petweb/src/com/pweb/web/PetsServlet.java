package com.pweb.web;

import com.pweb.pojo.Page;
import com.pweb.pojo.Pets;
import com.pweb.service.Impl.PetsServiceImpl;
import com.pweb.service.PetsService;
import com.pweb.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-11  14:10
 * petweb
 */
public class PetsServlet extends BaseServlet{
    private final PetsService petsService = new PetsServiceImpl();






    /**
     * 分类为dog或cat标签的所有项跳转页面并展示(page方法统一)<br/>现在不与使用
     * @author jh
     * @Date:  2021/11/11  19:30
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String dogorcat = req.getParameter("dogorcat");
//        System.out.println("------>" + dogorcat);
        if (req.getParameter("dogorcat").equals("cat")){
            List<Pets> petsListCat = petsService.getPets("cat");

            //获取请求的参数 pageNo 和 pageSize
            int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
            int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

            //调用BookService.page(pageNo,PageSize);返回Page对象
            Page<Pets> page = petsService.pagecat(petsListCat,pageNo,pageSize);
            //保存Page对象到request域中
            req.setAttribute("page",page);
            req.setAttribute("pets",petsListCat);//cat_show50行要和保存的key一致
        } else {
            List<Pets> petsListDog = petsService.getPets("dog");

            //获取请求的参数 pageNo 和 pageSize
            int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
            int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

            //调用BookService.page(pageNo,PageSize);返回Page对象
            Page<Pets> page = petsService.pagedog(petsListDog,pageNo,pageSize);
            //保存Page对象到request域中
            req.setAttribute("page",page);
            req.setAttribute("pets",petsListDog);//dog_show50行要和保存的key一致
        }
        //请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/showcase/dog_show.jsp").forward(req,resp);
    }

    /**
    * 分类为dog标签的所有项(page方法统一)<br/>现在不与使用
    * @author jh
    * @Date:  2021/11/11  19:30
    */
    protected void listFordog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pets> petsListDog = petsService.getPets("dog");
        req.setAttribute("pets",petsListDog);//dog_show50行要和保存的key一致
        req.getRequestDispatcher("/pages/showcase/dog_show.jsp").forward(req,resp);
    }

    /**
    * 分类为cat标签的所有项(page方法统一)<br/>现在不与使用
    * @author jh
    * @Date:  2021/11/11  19:29
    */
    protected void listForcat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pets> petsListCat = petsService.getPets("cat");
        req.setAttribute("pets",petsListCat);//cat_show50行要和保存的key一致
        req.getRequestDispatcher("/pages/showcase/cat_show.jsp").forward(req,resp);
    }
}
