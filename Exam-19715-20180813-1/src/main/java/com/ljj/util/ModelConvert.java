package com.ljj.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class ModelConvert {
    /* 用于将rs查询结果封装为List<Map<String, Object>>对象
    *
    * @param rs数据库查询结果
    * @return 返回list map封装后的结果
    */
    public static List<Map<String, Object>> convertList(ResultSet rs) {
        // 新建一个map list集合用于存放多条查询记录
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            // 结果集(rs)的结构信息，比如字段数、字段名等。
            ResultSetMetaData md = rs.getMetaData();
            // 取得查询出来的字段个数
            int columnCount = md.getColumnCount();
            // 迭代rs
            while (rs.next()) {
                // 新建一个map集合 将查询出内容按照字段名：值 的键值对形式存储在map集合中
                Map<String, Object> rowData = new HashMap<String, Object>(16);
                // 循环所有查询出字段
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                    // getColumnName(i) 获取第i个列名
                    // getObject(i) 获取第i个对象的值
                }
                // 将map放入list集合中
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {// 关闭连接
            try {
                if (rs != null){
                    rs.close();}
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }



    /*
     * 用于将rs查询结果封装为Map<String, Object>对象（适合于只有一条查询记录）
     *
     * @param rs数据库查询结果
     * @return 返回map封装后 字段名：值 的键值对结果
     */
    public static Map<String, Object> convertMap(ResultSet rs) {
        Map<String, Object> map = new TreeMap<String, Object>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    map.put(md.getColumnName(i), rs.getObject(i));
                }
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
