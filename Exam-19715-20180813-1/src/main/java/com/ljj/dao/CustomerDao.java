package com.ljj.dao;

import java.sql.Connection;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public interface CustomerDao {
    Map<String, Object> getCustomer(Connection connection,String customerName);
}
