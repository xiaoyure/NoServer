package com.cont.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lq
 * @description 描述
 * @create 2017/5/5 0005
 * @Version 1.0
 */
public class ServiceHandlerInterceptor implements HandlerInterceptor {

    private static final String LOGIN_URL = "http://localhost:81/login.html";
    private static final String SESSION_USER = "user";

    /**
     * @author Klin
     * @date 2017/5/5 0005
     * @parm
     * @result
     * @description
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /**
         * 校验登陆 Session
         */
//        Object users = httpServletRequest.getSession().getAttribute(SESSION_USER);
//        if (users != null) {
////            UserModel user = (UserModel) users;
////            if (user.getPkRole() == 1) {
//            return true;
////            }
//        } else {
//            httpServletResponse.sendRedirect(LOGIN_URL);
//        }
//        return false;
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
