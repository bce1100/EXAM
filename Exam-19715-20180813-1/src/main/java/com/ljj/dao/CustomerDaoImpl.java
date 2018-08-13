package com.ljj.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import static com.ljj.util.ConnectionFactory.closeConnection;
import static com.ljj.util.ModelConvert.convertMap;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class CustomerDaoImpl implements CustomerDao {
    public CustomerDaoImpl(){}
    @Override
    public Map<String, Object> getCustomer(Connection connection,String customerName) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("SELECT first_name from CUSTOMER WHERE first_name = ?");
            pstmt.setString(1,customerName);
            Map<String, Object> customer = convertMap(pstmt.executeQuery());
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            closeConnection(connection,pstmt);
        }
        return null;
    }
}
