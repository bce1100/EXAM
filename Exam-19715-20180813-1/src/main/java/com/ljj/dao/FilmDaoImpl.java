package com.ljj.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.ljj.util.ConnectionFactory.closeConnection;
import static com.ljj.util.ModelConvert.convertList;
import static com.ljj.util.ModelConvert.convertMap;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class FilmDaoImpl implements FilmDao{
    public FilmDaoImpl(){}
    @Override
    public List<Map<String, Object>> getAllFilm(Connection connection) {
        PreparedStatement pstmt = null;
        try {
             pstmt = connection.prepareStatement(
                    "SELECT film_id,title,description,name " +
                            "FROM FILM f,LANGUAGE L WHERE f.language_id = L.language_id order by film_id" );
            List<Map<String, Object>> filmList = convertList(pstmt.executeQuery());
            return filmList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            closeConnection(connection,pstmt);
        }
        return null;
    }

    @Override
    public Map<String, Object> getFilm(Connection connection, short filmId) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(
                    "SELECT title,description,L.name " +
                            "FROM FILM f,LANGUAGE L WHERE f.film_id = ? and f.language_id = L.language_id" );
            pstmt.setShort(1,filmId);
            Map<String, Object> film = convertMap(pstmt.executeQuery());
            return film;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            closeConnection(connection,pstmt);
        }
        return null;
    }

    @Override
    public int updateFilm(Connection connection, short filmId, String title, String description, byte languageId) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(
                    "UPDATE FILM SET language_id = ?,title = ? ,description = ? WHERE  film_id = ?" );
            pstmt.setByte(1,languageId);
            pstmt.setString(2,title);
            pstmt.setString(3,description);
            pstmt.setShort(4,filmId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteFilm(Connection connection, short filmId) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(
                    "DELETE FROM FILM  WHERE  film_id = ?" );
            pstmt.setShort(1,filmId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void deleteFilmAll(Connection connection, List<Short> del_ids) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(
                    "DELETE FROM FILM  WHERE  film_id = ?" );
            for(short filmId:del_ids){
                pstmt.setShort(1,filmId);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addFilm(Connection connection, String title, String description, byte languageId) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(
                    "INSERT INTO FILM (title,description,language_id) values(?,?,?)" );
            pstmt.setString(1,title);
            pstmt.setString(2,description);
            pstmt.setByte(3,languageId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
