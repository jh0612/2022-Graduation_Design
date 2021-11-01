package com.pweb.web;

import com.pweb.pojo.Customer;
import com.pweb.service.CustomService;
import com.pweb.service.Impl.CustomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 已完成简单注册页
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-31  21:04
 * petweb
 */
@WebServlet("/RegistCustServlet")//解决乱码第一步[1]
public class RegistCustServlet extends HttpServlet {
    private final CustomService customService = new CustomServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //更改编码(绝不可少否则出乱码)
        resp.setContentType("text/html; charset=UTF-8");//[2]
        req.setCharacterEncoding("UTF-8");//[3]
        //获取
        String custname = req.getParameter("name");
        String custpassword = req.getParameter("password");
        String custsex = req.getParameter("sex");
        String custemail = req.getParameter("email");
        String custdate = req.getParameter("date");
        String custaddress = req.getParameter("address");//为何获取的是乱码，在那里的字符集出错了？
        String custcode = req.getParameter("code");

        //插入数据库时，存入当前日期，需要格式转换
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String格式的数据转化成Date格式
        Date date = null;
        try {
            date = dateFormat.parse(custdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //验证码
        if ("reiwaxr".equals(custcode)){
            if ( customService.existsCustname(custname) ){
                //回显信息
                  req.setAttribute("msg","ユーザーネームが存在する");
                  req.setAttribute("custemail",custemail);
                  req.setAttribute("custdate",custdate);
                  req.setAttribute("custaddress",custaddress);

//                System.out.println("ユーザーネーム「"+ custname +"」が既に存在しています");
                req.getRequestDispatcher("/pages/custom/regist.jsp").forward(req,resp);
            } else {
                //这里要是不行回来改
                customService.registCustom(new Customer(null,custname,custpassword,custsex,custemail,custaddress, date));
                req.getRequestDispatcher("/pages/custom/regist.jsp").forward(req,resp);
            }
        } else {
            //回显信息
            req.setAttribute("msg","確認コードがちがい");
            req.setAttribute("custemail",custemail);
            req.setAttribute("custdate",custdate);
            req.setAttribute("custaddress",custaddress);
            //返回
//            System.out.println("確認コードが違いますので、もう一度確認して下さい-->" + custcode);
            req.getRequestDispatcher("/pages/custom/regist.jsp").forward(req,resp);
        }
    }
}
