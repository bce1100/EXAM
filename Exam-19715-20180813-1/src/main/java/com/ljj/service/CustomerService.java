package com.ljj.service;

import java.sql.Connection;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public interface CustomerService {
    /**
     * 获取指定name的customer
     * @param customerName
     * @return
     */
    Map<String, Object> getCustomer(String customerName);
}
