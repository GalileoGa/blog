package com.ning.blog.filter;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Nicholas-Ning
 * @Description //TODO 用于检验是否进行过登陆
 * @Date 16:43 2018/10/5
 * @Param
 * @return
 **/
public class SessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //不过滤的url
        List<String> notFilter = new ArrayList<>();
        notFilter.add("/index");//首页
        notFilter.add("/login");//登陆
        notFilter.add("/logout");//等出
        //请求uri
        String requestURI = request.getRequestURI();
        //是否过滤
        boolean doFilter = true;
        for (String url : notFilter) {//包含则不过滤
            if (notFilter.indexOf(url) != -1) {
                doFilter = false;
                break;
            }
        }
        if (doFilter) {
            //执行过滤
            //从Session中过去登陆者实体
            Object loginUser = request.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                boolean isAjaxRequest = isAjaxRequest(request);
                if (isAjaxRequest) {
                    response.setCharacterEncoding("UTF-8");
                    //设置返回错误信息：您已经太长时间没有刷新页面
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有刷新页面，请刷新页面。");
                    return;
                }
                response.sendRedirect("");
                return;
            } else {
                //如果已经登陆过了，则继续
                filterChain.doFilter(request, response);
            }
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Request-With");
        if (header != null && "XMLHttpRequest".equals(request))
            return true;
        else
            return false;
    }
}