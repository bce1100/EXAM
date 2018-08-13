package com.ljj.servlet;

import com.ljj.service.FilmService;
import com.ljj.service.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
@WebServlet(name = "AddFilmServlet")
public class AddFilmServlet extends HttpServlet {
    private FilmService filmService = new FilmServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String name = request.getParameter("language");
        PrintWriter out = response.getWriter();
        byte languageId;
        switch (name){
            case "English":languageId = 1;break;
            case "Italian":languageId = 2;break;
            case "Japanese":languageId = 3;break;
            case "Mandarin":languageId = 4;break;
            case "French":languageId = 5;break;
            case "German":languageId = 6;break;
            default:languageId=1;break;
        }
        int flag = filmService.addFilm(title,description,languageId);
        if(flag==1){
            out.write("insert_success");
        }else{
            out.write("insert_error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
