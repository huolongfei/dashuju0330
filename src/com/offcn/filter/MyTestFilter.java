package com.offcn.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")  // 过滤器默认过滤的是请求
//@WebFilter(value="/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class MyTestFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("MyTestFilter**********************************");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
