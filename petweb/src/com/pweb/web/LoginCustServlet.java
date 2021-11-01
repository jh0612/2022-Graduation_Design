package com.pweb.web;

import com.pweb.pojo.Customer;
import com.pweb.service.CustomService;
import com.pweb.service.Impl.CustomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 完成用户登录功能
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-31  21:10
 * petweb
 */
public class LoginCustServlet extends HttpServlet {
    private final CustomService customService = new CustomServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custname = req.getParameter("custname");
        String custpassword = req.getParameter("custpassword");

        Customer loginCustom = customService.loginCustom(new Customer(null, custname, custpassword, null, null, null, null));
        if (loginCustom == null){//失败再次登录所以还是本界面
            //回显信息
            req.setAttribute("msg","パスワードがちがい");
            req.setAttribute("custname",custname);
//            System.out.println("ユーザーネームまたはパスワードが違いました。ご確認ください");
            req.getRequestDispatcher("/pages/custom/login.jsp").forward(req,resp);
        } else {
            //跳转到成功界面
            req.getRequestDispatcher("/pages/custom/login_success.jsp").forward(req,resp);
        }
    }
}
