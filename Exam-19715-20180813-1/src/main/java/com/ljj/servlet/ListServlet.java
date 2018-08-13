package com.ljj.servlet;

import com.ljj.dao.FilmDao;
import com.ljj.service.FilmService;
import com.ljj.service.FilmServiceImpl;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class ListServlet extends javax.servlet.http.HttpServlet {
    private FilmService filmService = new FilmServiceImpl();

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Map<String, Object>> allFilm = filmService.getAllFilm();
//        Collections.sort(allFilm, (o1, o2) -> {
//            short film_Id1 =(short)o1.get("film_Id");
//            short film_Id2= (short)o2.get("film_Id");
//            return film_Id1-film_Id2;
//        });
        request.setAttribute("allFilm",allFilm);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
