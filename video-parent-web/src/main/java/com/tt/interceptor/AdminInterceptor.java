package com.tt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userName = session.getAttribute("userName");
        if (null != userName) {
            response.sendRedirect(request.getContextPath() + "/video/list");
            return false;
        } else {
            return true;
        }
    }
}
