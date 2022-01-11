package com.pweb.web;

import com.pweb.pojo.Customer;
import com.pweb.service.CustomService;
import com.pweb.service.Impl.CustomServiceImpl;
import com.pweb.utils.WebUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * Customer功能
 * 目前(登录与注册)
 * <br/>将来得空可优化修改cust信息，改密码，绑手机，绑邮箱等等进行完善
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-01  1:10
 * petweb
 */
@WebServlet("/CustomerServlet")//解决乱码[1]
public class CustomerServlet extends BaseServlet {
    private final CustomService customService = new CustomServiceImpl();








    /**
    * 登录
    * @param req 1
    * @param resp 2
    * @author jh
    * @Date:  2021/11/01  1:23
    */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取方式二
        String custname = req.getParameter("custname");
        String custpassword = req.getParameter("custpassword");

        Customer loginCustom = customService.loginCustom(new Customer(null, custname, custpassword, null, null, null, null));
        if (loginCustom == null){
            //回显信息
            req.setAttribute("msg","パスワードがちがい");
            req.setAttribute("custname",custname);
            req.getRequestDispatcher("/pages/custom/login.jsp").forward(req,resp);
        } else {
            //保存用户信息到Session会话中
            req.getSession().setAttribute("cust",loginCustom);
            //跳转到成功界面
            req.getRequestDispatcher("/pages/custom/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 注册
     * @param req 1
     * @param resp 2
     * @author jh
     * @Date:  2021/11/01  1:23
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //获取方式一,不可少(前提表单中不只有String类型的时候如下有Date类型)
        ConvertUtils.register((type, value) -> {
               if(value==null){
                   return null;
               }
               String str = (String) value;
               if(str.trim().equals("")){
                   return null;
               }

               SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
               try {
                   return df.parse(str);
               } catch (ParseException e) {
                   throw new RuntimeException(e);
               }
           }, Date.class);
        String custcode = req.getParameter("code");
        String custname = req.getParameter("custname");
        //注入
        Customer customer = WebUtils.copyParamToBean(req.getParameterMap(),new Customer());

        //插入数据库时，存入当前日期，需要格式转换
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String格式的数据转化成Date格式
        Date date = null;
        try {
            date = dateFormat.parse(String.valueOf(customer.getcustbirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //验证码
        if (token != null && token.equalsIgnoreCase(custcode)){
            if ( customService.existsCustname(custname) ){
                //回显信息
                Date getcustbirth = customer.getcustbirth();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String bir = sdf.format(getcustbirth);
                req.setAttribute("msg","ユーザーネームが存在する");
                req.setAttribute("custemail",customer.getcustemail());
                req.setAttribute("custbirth",bir);
                req.setAttribute("custaddress",customer.getcustaddress());

                req.getRequestDispatcher("/pages/custom/regist.jsp").forward(req,resp);
            } else {
                //这里要是不行回来改
                customService.registCustom(new Customer(null,customer.getcustname(),customer.getcustpassword(),customer.getcustsex(),customer.getcustemail(),customer.getcustaddress(), customer.getcustbirth()));
                req.getRequestDispatcher("/pages/custom/regist.jsp").forward(req,resp);
            }
        } else {
            //回显信息(转换Date类型为String)
            Date getcustbirth = customer.getcustbirth();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bir = sdf.format(getcustbirth);
            req.setAttribute("msg","確認コードがちがい");
            req.setAttribute("custemail",customer.getcustemail());
            req.setAttribute("custbirth",bir);
            req.setAttribute("custaddress",customer.getcustaddress());
            //返回
            req.getRequestDispatcher("/pages/custom/regist.jsp").forward(req,resp);
        }
    }
}
