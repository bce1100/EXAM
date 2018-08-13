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
import java.util.ArrayList;
import java.util.List;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
@WebServlet(name = "DeleteFilmServlet")
public class DeleteFilmServlet extends HttpServlet {
    private FilmService filmService = new FilmServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sId = request.getParameter("filmId");
        if(sId.contains("-")){
            List<Short> del_ids = new ArrayList<>();
            String[] str_ids = sId.split("-");
            //组装id的集合
            for(String string : str_ids){
                del_ids.add(Short.parseShort(string));
            }
            filmService.deleteFilmAll(del_ids);
        }else{
            short filmId = Short.parseShort(sId);
            int flag = filmService.deleteFilm(filmId);
            PrintWriter out = response.getWriter();
            if(flag==1){
                out.write("delete_success");
            }else if(flag!=1){
                out.write("delete_error");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
