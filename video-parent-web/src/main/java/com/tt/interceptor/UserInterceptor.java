package com.tt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userAccount = session.getAttribute("userAccount");
        if (null == userAccount) {
            response.sendRedirect(request.getContextPath());
            return false;
        } else {
            return true;
        }
    }
}
