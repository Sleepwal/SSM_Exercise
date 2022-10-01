package com.exception;

import com.pojo.Auser;
import com.pojo.Buser;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @package: com.exception
 * @className: HandlerExceptionResolver
 * @author: SleepWalker
 * @description: 统一异常处理
 * @date: 8:56
 * @version: 1.0
 */
public class MyExceptionHandler implements org.springframework.web.servlet.HandlerExceptionResolver {
    /**
     * @param request:
     * @param response:
     * @param handler:
     * @param ex:
     * @return ModelAndView
     * @author SleepWalker
     * @description TODO
     * @date  12:13
     */

    @ExceptionHandler
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("ex", ex);

        //根据不同错误转向不同页面
        if(ex instanceof AdminLoginNoException) {
            //登录页面需要auser对象
            request.setAttribute("auser", new Auser());
            request.setAttribute("msg", "您没有登录, 请登录!");

            return new ModelAndView("/admin/login", model);
        } else if(ex instanceof UserLoginNoException) {
            request.setAttribute("buser", new Buser());
            request.setAttribute("msg", "你没有登录, 请登录!");

            return new ModelAndView("/before/login", model);
        } else {
            return new ModelAndView("/error/error", model);
        }
    }
}
