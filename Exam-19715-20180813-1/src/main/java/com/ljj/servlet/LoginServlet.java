package com.ljj.servlet;

import com.ljj.service.CustomerService;
import com.ljj.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        RequestDispatcher rd = null;
        if (firstName == null) {
            request.setAttribute("msg", "用户名为空");
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            Map<String, Object> customer = customerService.getCustomer(firstName);
            if (customer.size() > 0) {
                request.getSession().setAttribute("flag", "login_success");
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                request.getSession().setAttribute("flag", "login_error");
                request.setAttribute("msg", "用户名或密码错误");
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
