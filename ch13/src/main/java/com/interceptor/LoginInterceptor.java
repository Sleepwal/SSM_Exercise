package com.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();
        //login.jsp或登录请求放行, 不拦截
        if(url.contains("/toLogin") || url.contains("/login")) {
            return true;
        }

        //获取session
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");
        if(object != null) {
            return true;
        }

        //没有登录且不是登录页面, 转发到登录页面
        request.setAttribute("msg", "还没登录, 请先登录!");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        /*返回TRUE表示继续向下执行, false表示中断后续操作*/
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion方法");
    }
}
