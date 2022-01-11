package com.pweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-10  22:19
 * petweb
 */
public class CustFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object cust = httpServletRequest.getSession().getAttribute("cust");
        if (cust == null){
            httpServletRequest.getRequestDispatcher("/pages/custom/login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
