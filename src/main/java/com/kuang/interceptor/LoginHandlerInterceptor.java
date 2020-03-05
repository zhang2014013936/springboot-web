package com.kuang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 判断是否拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
            System.out.println("LoginHandlerInterceptor");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
