package com.offcn.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/SessionTest7Servlet")
public class BFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("BFilter###begin###");
        chain.doFilter(req, resp);
        System.out.println("BFilter###end###");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
