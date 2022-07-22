//package com.example.SpringRESTAPILBD.filters;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(0)
//public class BeforeAuthorizationStudentFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        Logger logger = LoggerFactory.getLogger(BeforeAuthorizationStudentFilter.class);
//
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        filterChain.doFilter(servletRequest, servletResponse);
//        stopWatch.stop();
//        logger.info("Time between request and response: " + stopWatch.getLastTaskTimeMillis() + "ms");
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
