package com.ljj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
@WebFilter(filterName = "PermissionFilter")
public class PermissionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        String flag = (String) session.getAttribute("flag");
        if (servletPath != null && (servletPath.endsWith(".js")) || (servletPath.endsWith(".css")) || (servletPath.equals("/index.jsp") || servletPath.equals("/login.jsp") || servletPath.equals("/login"))) {
            chain.doFilter(request, response);
        } else {
            if (flag != null && flag.equals("login_success")) {
                chain.doFilter(request, response);
            } else if (flag != null && flag.equals("login_error")) {
                req.setAttribute("msg", "登陆失败请重新登陆</br>");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("msg", "尚未登陆</br>");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.forward(req, resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
