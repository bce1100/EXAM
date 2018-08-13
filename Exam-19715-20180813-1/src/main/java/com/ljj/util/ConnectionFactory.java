package com.ljj.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class ConnectionFactory {
    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private static ConnectionFactory factory = new ConnectionFactory();

    private static Connection conn;

    static {
        Properties prop = new Properties();
        try {
            InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            prop.load(is);
        } catch (Exception e) {
            System.out.println("配置文件读取错误");
        }
        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    private ConnectionFactory() {

    }

    public static ConnectionFactory getInstance() {
        return factory;
    }

    public static void closeConnection(Connection connection, PreparedStatement pstmt){
        try {
            if(pstmt!=null){
                pstmt.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection makeConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
