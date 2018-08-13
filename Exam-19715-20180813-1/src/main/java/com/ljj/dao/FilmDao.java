package com.ljj.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public interface FilmDao {
    List<Map<String, Object>> getAllFilm(Connection connection);

    Map<String,Object> getFilm(Connection connection, short filmId);

    int updateFilm(Connection connection, short filmId, String title, String description, byte languageId);

    int deleteFilm(Connection connection, short filmId);

    void deleteFilmAll(Connection connection, List<Short> del_ids);

    int addFilm(Connection connection, String title, String description, byte languageId);
}
