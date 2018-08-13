package com.ljj.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public interface FilmService {
    /**
     * 获取所有电影的列表
     * @return
     */
    List<Map<String, Object>> getAllFilm();

    /**
     * 根据film_id获取指定电影
     * @param filmId
     * @return
     */
    Map<String,Object> getFilm(short filmId);

    /**
     * 编辑电影事项
     * @param filmId
     * @param title
     * @param description
     * @param languageId
     * @return
     */
    int updateFilm(short filmId, String title, String description, byte languageId);

    /**
     * 根据filmId删除一条电影事项
     * @param filmId
     * @return
     */
    int deleteFilm(short filmId) ;

    /**
     * 根据del_ids批量删除
     * @param del_ids
     */
    void deleteFilmAll(List<Short> del_ids);

    /**
     * 增添一条电影事项
     * @param title
     * @param description
     * @param languageId
     * @return
     */
    int addFilm(String title, String description, byte languageId);
}
