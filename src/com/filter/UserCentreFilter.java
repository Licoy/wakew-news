package com.filter;


import com.beans.User;
import com.dao.UserDao;
import com.utils.CookieUtils;
import com.utils.Tools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Created by Licoy on 2016/12/20 0020.
 */
public class UserCentreFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Object id = request.getSession().getAttribute("id");
        if(id!=null && !"".equals(id)){
            User user = new UserDao().selectUserById(Integer.parseInt(id+""));
            servletRequest.setAttribute("user",user);
            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            response.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
