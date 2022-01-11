package com.pweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EnCodeFilter
 */
//@WebFilter("/*")
//public class EnCodeFilter implements Filter {
//
//  /**
//   * Default constructor.
//   */
//  public EnCodeFilter() {
//
//  }
//
//  /**
//   * @see Filter#destroy()
//   */
//  @Override
//  public void destroy() {
//
//  }
//
//  /**
//   * @see Filter#doFilter(ServletRequest, ServletResponse,
//   *      FilterChain)
//   */
//  @Override
//  public void doFilter(ServletRequest request,
//      ServletResponse response, FilterChain chain)
//      throws IOException, ServletException {
//
//    // place your code here
//    String encoding = "UTF-8";
//    request.setCharacterEncoding(encoding);
//    response.setContentType("text/html; charset="
//        + encoding);
//    // pass the request along the filter chain
//    chain.doFilter(request, response);
//  }
//
//  /**
//   * @see Filter#init(FilterConfig)
//   */
//  @Override
//  public void init(FilterConfig fConfig) {
//
//  }
//
//}
