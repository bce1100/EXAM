package com.ljj.dbtest;

import com.ljj.dao.CustomerDao;
import com.ljj.dao.CustomerDaoImpl;
import com.ljj.dao.FilmDao;
import com.ljj.dao.FilmDaoImpl;
import com.ljj.entity.Film;
import com.ljj.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.ljj.util.ModelConvert.convertList;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = ConnectionFactory.getInstance();
        Connection conn = cf.makeConnection();
//        FilmDao f = new FilmDaoImpl();
//        List<Map<String, Object>> list = f.getAllFilm(conn);
//        for (int i = 0; i < list.size(); i++) {
//            Map<String, Object> map = list.get(i);
//            // 以下将获得每个查询出来的字段的值
//            System.out.print(map.get("film_id") + "\t");
//            System.out.print(map.get("title") + "\t");
//            System.out.print(map.get("description") + "\t");
//            System.out.println(map.get("name") + "\t");
//        }

        CustomerDao d = new CustomerDaoImpl();
        Map<String, Object> customer = d.getCustomer(conn, "luo");
        System.out.println(customer.size());
    }
}
