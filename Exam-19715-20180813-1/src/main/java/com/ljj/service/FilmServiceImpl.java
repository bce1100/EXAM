package com.ljj.service;

import com.ljj.dao.FilmDao;
import com.ljj.dao.FilmDaoImpl;
import com.ljj.util.ConnectionFactory;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class FilmServiceImpl implements FilmService {
    public FilmDao filmDao= new FilmDaoImpl();
    private Connection connection = ConnectionFactory.getInstance().makeConnection();

    @Override
    public List<Map<String, Object>> getAllFilm() {
        return filmDao.getAllFilm(connection);
    }

    @Override
    public Map<String, Object> getFilm(short filmId) {
        return filmDao.getFilm(connection,filmId);
    }

    @Override
    public int updateFilm(short filmId, String title, String description, byte languageId) {
        return filmDao.updateFilm(connection,filmId,title,description,languageId);
    }

    @Override
    public int deleteFilm(short filmId) {
        return filmDao.deleteFilm(connection,filmId);
    }

    @Override
    public void deleteFilmAll(List<Short> del_ids) {
        filmDao.deleteFilmAll(connection,del_ids);
    }

    @Override
    public int addFilm(String title, String description, byte languageId) {
        return filmDao.addFilm(connection,title,description,languageId);
    }
}
