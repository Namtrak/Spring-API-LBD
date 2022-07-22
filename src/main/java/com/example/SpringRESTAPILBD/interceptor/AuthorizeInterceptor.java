package com.example.SpringRESTAPILBD.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizeInterceptor implements HandlerInterceptor {
    @Autowired
    AuthorizationService authorizationService;

    private static Logger log = LoggerFactory.getLogger(AuthorizeInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isAuthorized = authorizationService.isAuthorized(request.getRequestURI(), request.getHeader("role"));

        if (isAuthorized) {
            return true;
        } else {
            response.setStatus(401);
            response.getWriter().write("{\"errorMessage\":\"User unauthorized!\"}");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[postHandle][" + request + "]");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null)
            ex.printStackTrace();

        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizeInterceptor());
    }
}
