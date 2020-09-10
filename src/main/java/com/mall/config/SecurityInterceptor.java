package com.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class SecurityInterceptor  extends HandlerInterceptorAdapter {

    public final static String SESSION_KEY="username";

    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    public void  addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");
        addInterceptor.excludePathPatterns("/user**");
        addInterceptor.excludePathPatterns("/user");
        addInterceptor.addPathPatterns("/**");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
       // 判断是否已有该用户登录的session
        if(session.getAttribute(SESSION_KEY) != null){
            return true;
        }

        // 跳转到登录页
        String url = "/login/login";
        response.sendRedirect(url);
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
