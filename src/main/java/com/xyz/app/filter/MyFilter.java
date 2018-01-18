package com.xyz.app.filter;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类: MyFilter <br>
 * 描述: 过滤器<br>
 * 作者: gaoxugang <br>
 * 时间: 2018年01月17日 10:43
 */
@Order(1)
@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter{

    private static final Logger logger = Logger.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info("filter URL "+request.getRequestURL());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
