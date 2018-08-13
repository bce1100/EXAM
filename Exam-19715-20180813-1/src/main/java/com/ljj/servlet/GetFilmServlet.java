package com.ljj.servlet;

import com.ljj.service.FilmService;
import com.ljj.service.FilmServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
@WebServlet(name = "GetFilmServlet")
public class GetFilmServlet extends HttpServlet {
    private FilmService filmService = new FilmServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        short filmId = Short.parseShort(request.getParameter("filmId"));
        Map<String, Object> film = filmService.getFilm(filmId);
        PrintWriter out  = response.getWriter();
        out.write(JSON.toJSONString(film));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
